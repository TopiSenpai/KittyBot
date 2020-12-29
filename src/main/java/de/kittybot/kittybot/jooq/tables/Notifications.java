/*
 * This file is generated by jOOQ.
 */
package de.kittybot.kittybot.jooq.tables;


import de.kittybot.kittybot.jooq.Keys;
import de.kittybot.kittybot.jooq.Public;
import de.kittybot.kittybot.jooq.tables.records.NotificationsRecord;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row8;
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
public class Notifications extends TableImpl<NotificationsRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.notifications</code>
     */
    public static final Notifications NOTIFICATIONS = new Notifications();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<NotificationsRecord> getRecordType() {
        return NotificationsRecord.class;
    }

    /**
     * The column <code>public.notifications.notification_id</code>.
     */
    public final TableField<NotificationsRecord, Long> NOTIFICATION_ID = createField(DSL.name("notification_id"), SQLDataType.BIGINT.nullable(false).identity(true), this, "");

    /**
     * The column <code>public.notifications.guild_id</code>.
     */
    public final TableField<NotificationsRecord, Long> GUILD_ID = createField(DSL.name("guild_id"), SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>public.notifications.channel_id</code>.
     */
    public final TableField<NotificationsRecord, Long> CHANNEL_ID = createField(DSL.name("channel_id"), SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>public.notifications.message_id</code>.
     */
    public final TableField<NotificationsRecord, Long> MESSAGE_ID = createField(DSL.name("message_id"), SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>public.notifications.user_id</code>.
     */
    public final TableField<NotificationsRecord, Long> USER_ID = createField(DSL.name("user_id"), SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>public.notifications.content</code>.
     */
    public final TableField<NotificationsRecord, String> CONTENT = createField(DSL.name("content"), SQLDataType.CLOB.nullable(false), this, "");

    /**
     * The column <code>public.notifications.creation_time</code>.
     */
    public final TableField<NotificationsRecord, LocalDateTime> CREATION_TIME = createField(DSL.name("creation_time"), SQLDataType.LOCALDATETIME(6).nullable(false), this, "");

    /**
     * The column <code>public.notifications.notification_time</code>.
     */
    public final TableField<NotificationsRecord, LocalDateTime> NOTIFICATION_TIME = createField(DSL.name("notification_time"), SQLDataType.LOCALDATETIME(6).nullable(false), this, "");

    private Notifications(Name alias, Table<NotificationsRecord> aliased) {
        this(alias, aliased, null);
    }

    private Notifications(Name alias, Table<NotificationsRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>public.notifications</code> table reference
     */
    public Notifications(String alias) {
        this(DSL.name(alias), NOTIFICATIONS);
    }

    /**
     * Create an aliased <code>public.notifications</code> table reference
     */
    public Notifications(Name alias) {
        this(alias, NOTIFICATIONS);
    }

    /**
     * Create a <code>public.notifications</code> table reference
     */
    public Notifications() {
        this(DSL.name("notifications"), null);
    }

    public <O extends Record> Notifications(Table<O> child, ForeignKey<O, NotificationsRecord> key) {
        super(child, key, NOTIFICATIONS);
    }

    @Override
    public Schema getSchema() {
        return Public.PUBLIC;
    }

    @Override
    public Identity<NotificationsRecord, Long> getIdentity() {
        return (Identity<NotificationsRecord, Long>) super.getIdentity();
    }

    @Override
    public UniqueKey<NotificationsRecord> getPrimaryKey() {
        return Keys.NOTIFICATIONS_PKEY;
    }

    @Override
    public List<UniqueKey<NotificationsRecord>> getKeys() {
        return Arrays.<UniqueKey<NotificationsRecord>>asList(Keys.NOTIFICATIONS_PKEY);
    }

    @Override
    public List<ForeignKey<NotificationsRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<NotificationsRecord, ?>>asList(Keys.NOTIFICATIONS__NOTIFICATIONS_GUILD_ID_FKEY);
    }

    public Guilds guilds() {
        return new Guilds(this, Keys.NOTIFICATIONS__NOTIFICATIONS_GUILD_ID_FKEY);
    }

    @Override
    public Notifications as(String alias) {
        return new Notifications(DSL.name(alias), this);
    }

    @Override
    public Notifications as(Name alias) {
        return new Notifications(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Notifications rename(String name) {
        return new Notifications(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Notifications rename(Name name) {
        return new Notifications(name, null);
    }

    // -------------------------------------------------------------------------
    // Row8 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row8<Long, Long, Long, Long, Long, String, LocalDateTime, LocalDateTime> fieldsRow() {
        return (Row8) super.fieldsRow();
    }
}
