package de.anteiku.kittybot.database;

import de.anteiku.kittybot.KittyBot;
import de.anteiku.kittybot.utils.Logger;
import de.anteiku.kittybot.utils.RandomKey;
import de.anteiku.kittybot.utils.ValuePair;
import net.dv8tion.jda.core.entities.Guild;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class Database{
    
    private SQL sql;
    private KittyBot main;
    
    public Database(KittyBot main){
        this.main = main;
        this.sql = SQL.newInstance(main.config.get("mysql_host"), main.config.get("mysql_port"), main.config.get("mysql_user"), main.config.get("mysql_password"));
        sql.use(main.config.get("mysql_db"));
        sql.execute("CREATE TABLE IF NOT EXISTS `guilds` (\n" + "`id` varchar(18) NOT NULL PRIMARY KEY,\n" + "`command_prefix` varchar(1) NOT NULL,\n" + "`request_channel_id` varchar(18) NOT NULL,\n" + "`requests_enabled` tinyint(1) NOT NULL,\n" + "`welcome_channel_id` varchar(18) NOT NULL,\n" + "`welcome_message` text NOT NULL,\n" + "`welcome_message_enabled` tinyint(1) NOT NULL,\n" + "`nsfw_enabled` tinyint(1) NOT NULL\n" + ")");
        sql.execute("CREATE TABLE IF NOT EXISTS `self_assignable_roles` (\n" + "`id` varchar(18) NOT NULL,\n" + "`guild_id` varchar(18) NOT NULL,\n" + "`emote_id` varchar(18) NOT NULL\n)");
        sql.execute("CREATE TABLE IF NOT EXISTS `requests` (\n" + "`id` varchar(18) NOT NULL,\n" + "`guild_id` varchar(18) NOT NULL,\n" + "`emote_id` varchar(18) NOT NULL\n)");
        //sql.execute("CREATE TABLE IF NOT EXISTS `polls` (\n" + "`id` varchar(18) NOT NULL PRIMARY KEY,\n" + "`guild_id` varchar(18) NOT NULL,\n" + "`channel_id` varchar(18) NOT NULL,\n" + "`title` text NOT NULL,\n" + "`created_by` varchar(18) NOT NULL,\n" + "`created_at` timestamp NOT NULL DEFAULT current_timestamp(),\n" + "`goes_until` timestamp NOT NULL DEFAULT current_timestamp()\n" + ")");
        //sql.execute("CREATE TABLE IF NOT EXISTS `poll_answers` (\n" + "`id` varchar(18) NOT NULL PRIMARY KEY,\n" + "`answer` text NOT NULL\n" + ")");
        //sql.execute("CREATE TABLE IF NOT EXISTS `poll_votes` (\n" + "`id` varchar(18) NOT NULL PRIMARY KEY,\n" + "`created_by` varchar(18) NOT NULL,\n" + "`created_at` timestamp NOT NULL DEFAULT current_timestamp(),\n" + "`value` varchar(18) NOT NULL\n" + ")");
        sql.execute("CREATE TABLE IF NOT EXISTS `sessions` (\n" + "`id` varchar(18) NOT NULL PRIMARY KEY,\n" + "`user_id` varchar(18) NOT NULL\n" + ")");
        init();
    }
    
    private void init(){
        for(Guild guild : main.jda.getGuilds()){
            if(! isGuildRegistered(guild)){
                registerGuild(guild);
            }
        }
    }
    
    public void close(){
        Logger.print("Closing connection to database...");
        sql.close();
    }
    
    /*
     * Guild specified methods
     */
    
    private boolean isGuildRegistered(Guild guild){
        return sql.exists("SELECT * FROM `guilds` WHERE `id` = '" + guild.getId() + "'");
    }
    
    
    private boolean registerGuild(Guild guild){
        Logger.print("Registering new guild: '" + guild.getId() + "'");
        return sql.execute("INSERT INTO `guilds` (id, command_prefix, request_channel_id, requests_enabled, welcome_channel_id, welcome_message, welcome_message_enabled, nsfw_enabled) " + "VALUES ('" + guild.getId() + "', '" + main.defaultPrefix + "', '-1', 0, '" + guild.getDefaultChannel().getId() + "', 'Welcome [username] to this server!', 1, 1)");
    }
    
    private Map<String, String> get(String guildId, String... keys){
        Map<String, String> map = new HashMap<>();
        ResultSet result = sql.query("SELECT " + String.join(", ", keys) + " FROM `guilds` WHERE `id` = '" + guildId + "'");
        try{
            if(result.absolute(1)){
                for(String key : keys){
                    map.put(key, result.getString(key));
                }
                return map;
            }
        }
        catch(SQLException e){
            Logger.error(e);
        }
        return null;
    }
    
    private String get(String guildId, String key){
        ResultSet result = sql.query("SELECT " + key + " FROM `guilds` WHERE `id` = '" + guildId + "'");
        try{
            if(result.absolute(1)){
                return result.getString(key);
            }
        }
        catch(SQLException e){
            Logger.error(e);
        }
        return null;
    }
    
    private boolean set(String guildId, String key, String value) {
        return sql.execute("UPDATE `guilds` SET `" + key + "`='" + value + "' WHERE `id` = '" + guildId + "'");
    }
    
    private boolean set(String guildId, String key, int value) {
        return sql.execute("UPDATE `guilds` SET `" + key + "`=" + value + "' WHERE `id` = '" + guildId + "'");
    }
    
    public String getCommandPrefix(String guildId){
        return get(guildId, "command_prefix");
    }
    
    public void setCommandPrefix(String guildId, String prefix){
        set(guildId, "command_prefix", prefix);
    }
    
    public Set<ValuePair<String, String>> getSelfAssignableRoles(String guildId){
        String[] keys = {"id", "guild_id", "emote_id"};
        Set<ValuePair<String, String>> set = new HashSet<>();
        ResultSet result = sql.query("SELECT " + String.join(", ", keys) + " FROM `self_assignable_roles` WHERE `guild_id` = '" + guildId + "'");
        try{
            while(result.next()){
                set.add(new ValuePair<>(result.getString("id"), result.getString("emote_id")));
            }
            return set;
        }
        catch(SQLException e){
            Logger.error(e);
        }
        return null;
    }
    
    public void addSelfAssignableRoles(String guildId, Map<String, String> roles){
        for(Map.Entry<String, String> role : roles.entrySet()) {
            sql.execute("INSERT INTO `self_assignable_roles` (id, guild_id, emote_id) VALUES ('" + role.getKey() + "', '" + guildId + "', '" + role.getValue() + "')");
        }
    }
    
    public void addSelfAssignableRole(String guildId, String role, String emote){
        addSelfAssignableRoles(guildId, new HashMap<>(Collections.singletonMap(role, emote)));
    }
    
    public void removeSelfAssignableRoles(String guildId,  Set<String> roles){
        for(String role : roles) {
            sql.execute("DELETE FROM `self_assignable_roles` WHERE `id` = '" + role + "' and `guild_id` = '" + guildId + "'");
        }
    }
    
    public void removeSelfAssignableRole(String guildId,  String role){
        removeSelfAssignableRoles(guildId, new HashSet<>(Collections.singleton(role)));
    }
    
    public String getWelcomeChannelId(String guildId){
        return get(guildId, "welcome_channel_id");
    }
    
    public void setWelcomeChannelId(String guildId, String channelId){
        set(guildId, "welcome_channel_id", channelId);
    }
    
    public String getWelcomeMessage(String guildId){
        return get(guildId, "welcome_message");
    }
    
    public void setWelcomeMessage(String guildId, String message){
        set(guildId, "welcome_message", message);
    }
    
    public boolean getWelcomeMessageEnabled(String guildId){
        return Boolean.getBoolean(get(guildId, "welcome_message_enabled"));
    }
    
    public void setWelcomeMessageEnabled(String guildId, boolean enabled){
        set(guildId, "welcome_message_enabled", enabled ? 1 : 0);
    }
    
    public boolean getNSFWEnabled(String guildId){
        return Boolean.getBoolean(get(guildId, "nsfw_enabled"));
    }
    
    public void setNSFWEnabled(String guildId, boolean enabled){
        set(guildId, "nsfw_enabled", enabled ? 1 : 0);
    }
    
    /*
     * Session specified methods
     */
    
    public boolean sessionExists(String key){
        return sql.exists("SELECT * from `sessions` WHERE `id` = '" + key + "'");
    }
    
    private String generateUniqueKey(){
        String key = RandomKey.generate(32);
        while(sessionExists(key)){
            key = RandomKey.generate(32);
        }
        return key;
    }
    
    public String addSession(String userId){
        String key = generateUniqueKey();
        sql.query("INSERT INTO `sessions` (id, user_id) VALUES ('" + key + "', '" + userId + "')");
        return key;
    }
    
    public void deleteSession(String key){
        sql.query("DELETE FROM `sessions` WHERE `id` = '" + key + "'");
    }
    
    public String getSession(String key){
        ResultSet result = sql.query("SELECT * from `sessions` WHERE `id` = '" + key + "'");
        try{
            if(result.absolute(1)){
                return result.getString("user_id");
            }
        }
        catch(SQLException e){
            Logger.error(e);
        }
        return null;
    }
    
}