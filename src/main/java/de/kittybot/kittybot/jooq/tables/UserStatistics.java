/*
 * This file is generated by jOOQ.
 */
package de.kittybot.kittybot.jooq.tables;


import de.kittybot.kittybot.jooq.Keys;
import de.kittybot.kittybot.jooq.Public;
import de.kittybot.kittybot.jooq.tables.records.UserStatisticsRecord;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row10;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class UserStatistics extends TableImpl<UserStatisticsRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.user_statistics</code>
     */
    public static final UserStatistics USER_STATISTICS = new UserStatistics();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<UserStatisticsRecord> getRecordType() {
        return UserStatisticsRecord.class;
    }

    /**
     * The column <code>public.user_statistics.user_statistic_id</code>.
     */
    public final TableField<UserStatisticsRecord, Long> USER_STATISTIC_ID = createField(DSL.name("user_statistic_id"), SQLDataType.BIGINT.nullable(false).identity(true), this, "");

    /**
     * The column <code>public.user_statistics.user_id</code>.
     */
    public final TableField<UserStatisticsRecord, Long> USER_ID = createField(DSL.name("user_id"), SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>public.user_statistics.guild_id</code>.
     */
    public final TableField<UserStatisticsRecord, Long> GUILD_ID = createField(DSL.name("guild_id"), SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>public.user_statistics.xp</code>.
     */
    public final TableField<UserStatisticsRecord, Integer> XP = createField(DSL.name("xp"), SQLDataType.INTEGER.nullable(false).defaultValue(DSL.field("0", SQLDataType.INTEGER)), this, "");

    /**
     * The column <code>public.user_statistics.level</code>.
     */
    public final TableField<UserStatisticsRecord, Integer> LEVEL = createField(DSL.name("level"), SQLDataType.INTEGER.nullable(false).defaultValue(DSL.field("0", SQLDataType.INTEGER)), this, "");

    /**
     * The column <code>public.user_statistics.bot_calls</code>.
     */
    public final TableField<UserStatisticsRecord, Integer> BOT_CALLS = createField(DSL.name("bot_calls"), SQLDataType.INTEGER.nullable(false).defaultValue(DSL.field("0", SQLDataType.INTEGER)), this, "");

    /**
     * The column <code>public.user_statistics.voice_time</code>.
     */
    public final TableField<UserStatisticsRecord, Integer> VOICE_TIME = createField(DSL.name("voice_time"), SQLDataType.INTEGER.nullable(false).defaultValue(DSL.field("0", SQLDataType.INTEGER)), this, "");

    /**
     * The column <code>public.user_statistics.message_count</code>.
     */
    public final TableField<UserStatisticsRecord, Integer> MESSAGE_COUNT = createField(DSL.name("message_count"), SQLDataType.INTEGER.nullable(false).defaultValue(DSL.field("0", SQLDataType.INTEGER)), this, "");

    /**
     * The column <code>public.user_statistics.emote_count</code>.
     */
    public final TableField<UserStatisticsRecord, Integer> EMOTE_COUNT = createField(DSL.name("emote_count"), SQLDataType.INTEGER.nullable(false).defaultValue(DSL.field("0", SQLDataType.INTEGER)), this, "");

    /**
     * The column <code>public.user_statistics.last_active</code>.
     */
    public final TableField<UserStatisticsRecord, LocalDateTime> LAST_ACTIVE = createField(DSL.name("last_active"), SQLDataType.LOCALDATETIME(6).nullable(false), this, "");

    private UserStatistics(Name alias, Table<UserStatisticsRecord> aliased) {
        this(alias, aliased, null);
    }

    private UserStatistics(Name alias, Table<UserStatisticsRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>public.user_statistics</code> table reference
     */
    public UserStatistics(String alias) {
        this(DSL.name(alias), USER_STATISTICS);
    }

    /**
     * Create an aliased <code>public.user_statistics</code> table reference
     */
    public UserStatistics(Name alias) {
        this(alias, USER_STATISTICS);
    }

    /**
     * Create a <code>public.user_statistics</code> table reference
     */
    public UserStatistics() {
        this(DSL.name("user_statistics"), null);
    }

    public <O extends Record> UserStatistics(Table<O> child, ForeignKey<O, UserStatisticsRecord> key) {
        super(child, key, USER_STATISTICS);
    }

    @Override
    public Schema getSchema() {
        return Public.PUBLIC;
    }

    @Override
    public Identity<UserStatisticsRecord, Long> getIdentity() {
        return (Identity<UserStatisticsRecord, Long>) super.getIdentity();
    }

    @Override
    public UniqueKey<UserStatisticsRecord> getPrimaryKey() {
        return Keys.USER_STATISTICS_PKEY;
    }

    @Override
    public List<UniqueKey<UserStatisticsRecord>> getKeys() {
        return Arrays.<UniqueKey<UserStatisticsRecord>>asList(Keys.USER_STATISTICS_PKEY);
    }

    @Override
    public List<ForeignKey<UserStatisticsRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<UserStatisticsRecord, ?>>asList(Keys.USER_STATISTICS__USER_STATISTICS_GUILD_ID_FKEY);
    }

    public Guilds guilds() {
        return new Guilds(this, Keys.USER_STATISTICS__USER_STATISTICS_GUILD_ID_FKEY);
    }

    @Override
    public UserStatistics as(String alias) {
        return new UserStatistics(DSL.name(alias), this);
    }

    @Override
    public UserStatistics as(Name alias) {
        return new UserStatistics(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public UserStatistics rename(String name) {
        return new UserStatistics(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public UserStatistics rename(Name name) {
        return new UserStatistics(name, null);
    }

    // -------------------------------------------------------------------------
    // Row10 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row10<Long, Long, Long, Integer, Integer, Integer, Integer, Integer, Integer, LocalDateTime> fieldsRow() {
        return (Row10) super.fieldsRow();
    }
}
