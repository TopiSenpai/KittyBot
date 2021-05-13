/*
 * This file is generated by jOOQ.
 */
package de.kittybot.kittybot.jooq.tables.records;


import de.kittybot.kittybot.jooq.tables.UserStatistics;

import java.time.LocalDateTime;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record11;
import org.jooq.Row11;
import org.jooq.impl.UpdatableRecordImpl;
import org.jooq.types.YearToSecond;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class UserStatisticsRecord extends UpdatableRecordImpl<UserStatisticsRecord> implements Record11<Long, Long, Long, Long, Integer, YearToSecond, YearToSecond, Integer, Integer, Integer, LocalDateTime> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.user_statistics.id</code>.
     */
    public UserStatisticsRecord setId(Long value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>public.user_statistics.id</code>.
     */
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>public.user_statistics.guild_id</code>.
     */
    public UserStatisticsRecord setGuildId(Long value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>public.user_statistics.guild_id</code>.
     */
    public Long getGuildId() {
        return (Long) get(1);
    }

    /**
     * Setter for <code>public.user_statistics.user_id</code>.
     */
    public UserStatisticsRecord setUserId(Long value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>public.user_statistics.user_id</code>.
     */
    public Long getUserId() {
        return (Long) get(2);
    }

    /**
     * Setter for <code>public.user_statistics.xp</code>.
     */
    public UserStatisticsRecord setXp(Long value) {
        set(3, value);
        return this;
    }

    /**
     * Getter for <code>public.user_statistics.xp</code>.
     */
    public Long getXp() {
        return (Long) get(3);
    }

    /**
     * Setter for <code>public.user_statistics.commands_used</code>.
     */
    public UserStatisticsRecord setCommandsUsed(Integer value) {
        set(4, value);
        return this;
    }

    /**
     * Getter for <code>public.user_statistics.commands_used</code>.
     */
    public Integer getCommandsUsed() {
        return (Integer) get(4);
    }

    /**
     * Setter for <code>public.user_statistics.voice_time</code>.
     */
    public UserStatisticsRecord setVoiceTime(YearToSecond value) {
        set(5, value);
        return this;
    }

    /**
     * Getter for <code>public.user_statistics.voice_time</code>.
     */
    public YearToSecond getVoiceTime() {
        return (YearToSecond) get(5);
    }

    /**
     * Setter for <code>public.user_statistics.stream_time</code>.
     */
    public UserStatisticsRecord setStreamTime(YearToSecond value) {
        set(6, value);
        return this;
    }

    /**
     * Getter for <code>public.user_statistics.stream_time</code>.
     */
    public YearToSecond getStreamTime() {
        return (YearToSecond) get(6);
    }

    /**
     * Setter for <code>public.user_statistics.messages_sent</code>.
     */
    public UserStatisticsRecord setMessagesSent(Integer value) {
        set(7, value);
        return this;
    }

    /**
     * Getter for <code>public.user_statistics.messages_sent</code>.
     */
    public Integer getMessagesSent() {
        return (Integer) get(7);
    }

    /**
     * Setter for <code>public.user_statistics.emotes_sent</code>.
     */
    public UserStatisticsRecord setEmotesSent(Integer value) {
        set(8, value);
        return this;
    }

    /**
     * Getter for <code>public.user_statistics.emotes_sent</code>.
     */
    public Integer getEmotesSent() {
        return (Integer) get(8);
    }

    /**
     * Setter for <code>public.user_statistics.stickers_sent</code>.
     */
    public UserStatisticsRecord setStickersSent(Integer value) {
        set(9, value);
        return this;
    }

    /**
     * Getter for <code>public.user_statistics.stickers_sent</code>.
     */
    public Integer getStickersSent() {
        return (Integer) get(9);
    }

    /**
     * Setter for <code>public.user_statistics.last_active</code>.
     */
    public UserStatisticsRecord setLastActive(LocalDateTime value) {
        set(10, value);
        return this;
    }

    /**
     * Getter for <code>public.user_statistics.last_active</code>.
     */
    public LocalDateTime getLastActive() {
        return (LocalDateTime) get(10);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Long> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record11 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row11<Long, Long, Long, Long, Integer, YearToSecond, YearToSecond, Integer, Integer, Integer, LocalDateTime> fieldsRow() {
        return (Row11) super.fieldsRow();
    }

    @Override
    public Row11<Long, Long, Long, Long, Integer, YearToSecond, YearToSecond, Integer, Integer, Integer, LocalDateTime> valuesRow() {
        return (Row11) super.valuesRow();
    }

    @Override
    public Field<Long> field1() {
        return UserStatistics.USER_STATISTICS.ID;
    }

    @Override
    public Field<Long> field2() {
        return UserStatistics.USER_STATISTICS.GUILD_ID;
    }

    @Override
    public Field<Long> field3() {
        return UserStatistics.USER_STATISTICS.USER_ID;
    }

    @Override
    public Field<Long> field4() {
        return UserStatistics.USER_STATISTICS.XP;
    }

    @Override
    public Field<Integer> field5() {
        return UserStatistics.USER_STATISTICS.COMMANDS_USED;
    }

    @Override
    public Field<YearToSecond> field6() {
        return UserStatistics.USER_STATISTICS.VOICE_TIME;
    }

    @Override
    public Field<YearToSecond> field7() {
        return UserStatistics.USER_STATISTICS.STREAM_TIME;
    }

    @Override
    public Field<Integer> field8() {
        return UserStatistics.USER_STATISTICS.MESSAGES_SENT;
    }

    @Override
    public Field<Integer> field9() {
        return UserStatistics.USER_STATISTICS.EMOTES_SENT;
    }

    @Override
    public Field<Integer> field10() {
        return UserStatistics.USER_STATISTICS.STICKERS_SENT;
    }

    @Override
    public Field<LocalDateTime> field11() {
        return UserStatistics.USER_STATISTICS.LAST_ACTIVE;
    }

    @Override
    public Long component1() {
        return getId();
    }

    @Override
    public Long component2() {
        return getGuildId();
    }

    @Override
    public Long component3() {
        return getUserId();
    }

    @Override
    public Long component4() {
        return getXp();
    }

    @Override
    public Integer component5() {
        return getCommandsUsed();
    }

    @Override
    public YearToSecond component6() {
        return getVoiceTime();
    }

    @Override
    public YearToSecond component7() {
        return getStreamTime();
    }

    @Override
    public Integer component8() {
        return getMessagesSent();
    }

    @Override
    public Integer component9() {
        return getEmotesSent();
    }

    @Override
    public Integer component10() {
        return getStickersSent();
    }

    @Override
    public LocalDateTime component11() {
        return getLastActive();
    }

    @Override
    public Long value1() {
        return getId();
    }

    @Override
    public Long value2() {
        return getGuildId();
    }

    @Override
    public Long value3() {
        return getUserId();
    }

    @Override
    public Long value4() {
        return getXp();
    }

    @Override
    public Integer value5() {
        return getCommandsUsed();
    }

    @Override
    public YearToSecond value6() {
        return getVoiceTime();
    }

    @Override
    public YearToSecond value7() {
        return getStreamTime();
    }

    @Override
    public Integer value8() {
        return getMessagesSent();
    }

    @Override
    public Integer value9() {
        return getEmotesSent();
    }

    @Override
    public Integer value10() {
        return getStickersSent();
    }

    @Override
    public LocalDateTime value11() {
        return getLastActive();
    }

    @Override
    public UserStatisticsRecord value1(Long value) {
        setId(value);
        return this;
    }

    @Override
    public UserStatisticsRecord value2(Long value) {
        setGuildId(value);
        return this;
    }

    @Override
    public UserStatisticsRecord value3(Long value) {
        setUserId(value);
        return this;
    }

    @Override
    public UserStatisticsRecord value4(Long value) {
        setXp(value);
        return this;
    }

    @Override
    public UserStatisticsRecord value5(Integer value) {
        setCommandsUsed(value);
        return this;
    }

    @Override
    public UserStatisticsRecord value6(YearToSecond value) {
        setVoiceTime(value);
        return this;
    }

    @Override
    public UserStatisticsRecord value7(YearToSecond value) {
        setStreamTime(value);
        return this;
    }

    @Override
    public UserStatisticsRecord value8(Integer value) {
        setMessagesSent(value);
        return this;
    }

    @Override
    public UserStatisticsRecord value9(Integer value) {
        setEmotesSent(value);
        return this;
    }

    @Override
    public UserStatisticsRecord value10(Integer value) {
        setStickersSent(value);
        return this;
    }

    @Override
    public UserStatisticsRecord value11(LocalDateTime value) {
        setLastActive(value);
        return this;
    }

    @Override
    public UserStatisticsRecord values(Long value1, Long value2, Long value3, Long value4, Integer value5, YearToSecond value6, YearToSecond value7, Integer value8, Integer value9, Integer value10, LocalDateTime value11) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        value10(value10);
        value11(value11);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached UserStatisticsRecord
     */
    public UserStatisticsRecord() {
        super(UserStatistics.USER_STATISTICS);
    }

    /**
     * Create a detached, initialised UserStatisticsRecord
     */
    public UserStatisticsRecord(Long id, Long guildId, Long userId, Long xp, Integer commandsUsed, YearToSecond voiceTime, YearToSecond streamTime, Integer messagesSent, Integer emotesSent, Integer stickersSent, LocalDateTime lastActive) {
        super(UserStatistics.USER_STATISTICS);

        setId(id);
        setGuildId(guildId);
        setUserId(userId);
        setXp(xp);
        setCommandsUsed(commandsUsed);
        setVoiceTime(voiceTime);
        setStreamTime(streamTime);
        setMessagesSent(messagesSent);
        setEmotesSent(emotesSent);
        setStickersSent(stickersSent);
        setLastActive(lastActive);
    }
}
