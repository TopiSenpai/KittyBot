/*
 * This file is generated by jOOQ.
 */
package de.kittybot.kittybot.database.jooq.tables.records;


import de.kittybot.kittybot.database.jooq.tables.ReactiveMessages;
import org.jooq.Field;
import org.jooq.Record3;
import org.jooq.Record7;
import org.jooq.Row7;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class ReactiveMessagesRecord extends UpdatableRecordImpl<ReactiveMessagesRecord> implements Record7<String, String, String, String, String, String, String> {

    private static final long serialVersionUID = -1532157114;

    /**
     * Setter for <code>public.reactive_messages.channel_id</code>.
     */
    public ReactiveMessagesRecord setChannelId(String value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>public.reactive_messages.channel_id</code>.
     */
    public String getChannelId() {
        return (String) get(0);
    }

    /**
     * Setter for <code>public.reactive_messages.message_id</code>.
     */
    public ReactiveMessagesRecord setMessageId(String value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>public.reactive_messages.message_id</code>.
     */
    public String getMessageId() {
        return (String) get(1);
    }

    /**
     * Setter for <code>public.reactive_messages.user_id</code>.
     */
    public ReactiveMessagesRecord setUserId(String value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>public.reactive_messages.user_id</code>.
     */
    public String getUserId() {
        return (String) get(2);
    }

    /**
     * Setter for <code>public.reactive_messages.guild_id</code>.
     */
    public ReactiveMessagesRecord setGuildId(String value) {
        set(3, value);
        return this;
    }

    /**
     * Getter for <code>public.reactive_messages.guild_id</code>.
     */
    public String getGuildId() {
        return (String) get(3);
    }

    /**
     * Setter for <code>public.reactive_messages.command_id</code>.
     */
    public ReactiveMessagesRecord setCommandId(String value) {
        set(4, value);
        return this;
    }

    /**
     * Getter for <code>public.reactive_messages.command_id</code>.
     */
    public String getCommandId() {
        return (String) get(4);
    }

    /**
     * Setter for <code>public.reactive_messages.command</code>.
     */
    public ReactiveMessagesRecord setCommand(String value) {
        set(5, value);
        return this;
    }

    /**
     * Getter for <code>public.reactive_messages.command</code>.
     */
    public String getCommand() {
        return (String) get(5);
    }

    /**
     * Setter for <code>public.reactive_messages.allowed</code>.
     */
    public ReactiveMessagesRecord setAllowed(String value) {
        set(6, value);
        return this;
    }

    /**
     * Getter for <code>public.reactive_messages.allowed</code>.
     */
    public String getAllowed() {
        return (String) get(6);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record3<String, String, String> key() {
        return (Record3) super.key();
    }

    // -------------------------------------------------------------------------
    // Record7 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row7<String, String, String, String, String, String, String> fieldsRow() {
        return (Row7) super.fieldsRow();
    }

    @Override
    public Row7<String, String, String, String, String, String, String> valuesRow() {
        return (Row7) super.valuesRow();
    }

    @Override
    public Field<String> field1() {
        return ReactiveMessages.REACTIVE_MESSAGES.CHANNEL_ID;
    }

    @Override
    public Field<String> field2() {
        return ReactiveMessages.REACTIVE_MESSAGES.MESSAGE_ID;
    }

    @Override
    public Field<String> field3() {
        return ReactiveMessages.REACTIVE_MESSAGES.USER_ID;
    }

    @Override
    public Field<String> field4() {
        return ReactiveMessages.REACTIVE_MESSAGES.GUILD_ID;
    }

    @Override
    public Field<String> field5() {
        return ReactiveMessages.REACTIVE_MESSAGES.COMMAND_ID;
    }

    @Override
    public Field<String> field6() {
        return ReactiveMessages.REACTIVE_MESSAGES.COMMAND;
    }

    @Override
    public Field<String> field7() {
        return ReactiveMessages.REACTIVE_MESSAGES.ALLOWED;
    }

    @Override
    public String component1() {
        return getChannelId();
    }

    @Override
    public String component2() {
        return getMessageId();
    }

    @Override
    public String component3() {
        return getUserId();
    }

    @Override
    public String component4() {
        return getGuildId();
    }

    @Override
    public String component5() {
        return getCommandId();
    }

    @Override
    public String component6() {
        return getCommand();
    }

    @Override
    public String component7() {
        return getAllowed();
    }

    @Override
    public String value1() {
        return getChannelId();
    }

    @Override
    public String value2() {
        return getMessageId();
    }

    @Override
    public String value3() {
        return getUserId();
    }

    @Override
    public String value4() {
        return getGuildId();
    }

    @Override
    public String value5() {
        return getCommandId();
    }

    @Override
    public String value6() {
        return getCommand();
    }

    @Override
    public String value7() {
        return getAllowed();
    }

    @Override
    public ReactiveMessagesRecord value1(String value) {
        setChannelId(value);
        return this;
    }

    @Override
    public ReactiveMessagesRecord value2(String value) {
        setMessageId(value);
        return this;
    }

    @Override
    public ReactiveMessagesRecord value3(String value) {
        setUserId(value);
        return this;
    }

    @Override
    public ReactiveMessagesRecord value4(String value) {
        setGuildId(value);
        return this;
    }

    @Override
    public ReactiveMessagesRecord value5(String value) {
        setCommandId(value);
        return this;
    }

    @Override
    public ReactiveMessagesRecord value6(String value) {
        setCommand(value);
        return this;
    }

    @Override
    public ReactiveMessagesRecord value7(String value) {
        setAllowed(value);
        return this;
    }

    @Override
    public ReactiveMessagesRecord values(String value1, String value2, String value3, String value4, String value5, String value6, String value7) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached ReactiveMessagesRecord
     */
    public ReactiveMessagesRecord() {
        super(ReactiveMessages.REACTIVE_MESSAGES);
    }

    /**
     * Create a detached, initialised ReactiveMessagesRecord
     */
    public ReactiveMessagesRecord(String channelId, String messageId, String userId, String guildId, String commandId, String command, String allowed) {
        super(ReactiveMessages.REACTIVE_MESSAGES);

        set(0, channelId);
        set(1, messageId);
        set(2, userId);
        set(3, guildId);
        set(4, commandId);
        set(5, command);
        set(6, allowed);
    }
}
