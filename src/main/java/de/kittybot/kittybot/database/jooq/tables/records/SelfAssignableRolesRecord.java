/*
 * This file is generated by jOOQ.
 */
package de.kittybot.kittybot.database.jooq.tables.records;


import de.kittybot.kittybot.database.jooq.tables.SelfAssignableRoles;

import org.jooq.Field;
import org.jooq.Record2;
import org.jooq.Record3;
import org.jooq.Row3;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class SelfAssignableRolesRecord extends UpdatableRecordImpl<SelfAssignableRolesRecord> implements Record3<String, String, String> {

    private static final long serialVersionUID = -738421121;

    /**
     * Setter for <code>public.self_assignable_roles.role_id</code>.
     */
    public SelfAssignableRolesRecord setRoleId(String value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>public.self_assignable_roles.role_id</code>.
     */
    public String getRoleId() {
        return (String) get(0);
    }

    /**
     * Setter for <code>public.self_assignable_roles.guild_id</code>.
     */
    public SelfAssignableRolesRecord setGuildId(String value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>public.self_assignable_roles.guild_id</code>.
     */
    public String getGuildId() {
        return (String) get(1);
    }

    /**
     * Setter for <code>public.self_assignable_roles.emote_id</code>.
     */
    public SelfAssignableRolesRecord setEmoteId(String value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>public.self_assignable_roles.emote_id</code>.
     */
    public String getEmoteId() {
        return (String) get(2);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record2<String, String> key() {
        return (Record2) super.key();
    }

    // -------------------------------------------------------------------------
    // Record3 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row3<String, String, String> fieldsRow() {
        return (Row3) super.fieldsRow();
    }

    @Override
    public Row3<String, String, String> valuesRow() {
        return (Row3) super.valuesRow();
    }

    @Override
    public Field<String> field1() {
        return SelfAssignableRoles.SELF_ASSIGNABLE_ROLES.ROLE_ID;
    }

    @Override
    public Field<String> field2() {
        return SelfAssignableRoles.SELF_ASSIGNABLE_ROLES.GUILD_ID;
    }

    @Override
    public Field<String> field3() {
        return SelfAssignableRoles.SELF_ASSIGNABLE_ROLES.EMOTE_ID;
    }

    @Override
    public String component1() {
        return getRoleId();
    }

    @Override
    public String component2() {
        return getGuildId();
    }

    @Override
    public String component3() {
        return getEmoteId();
    }

    @Override
    public String value1() {
        return getRoleId();
    }

    @Override
    public String value2() {
        return getGuildId();
    }

    @Override
    public String value3() {
        return getEmoteId();
    }

    @Override
    public SelfAssignableRolesRecord value1(String value) {
        setRoleId(value);
        return this;
    }

    @Override
    public SelfAssignableRolesRecord value2(String value) {
        setGuildId(value);
        return this;
    }

    @Override
    public SelfAssignableRolesRecord value3(String value) {
        setEmoteId(value);
        return this;
    }

    @Override
    public SelfAssignableRolesRecord values(String value1, String value2, String value3) {
        value1(value1);
        value2(value2);
        value3(value3);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached SelfAssignableRolesRecord
     */
    public SelfAssignableRolesRecord() {
        super(SelfAssignableRoles.SELF_ASSIGNABLE_ROLES);
    }

    /**
     * Create a detached, initialised SelfAssignableRolesRecord
     */
    public SelfAssignableRolesRecord(String roleId, String guildId, String emoteId) {
        super(SelfAssignableRoles.SELF_ASSIGNABLE_ROLES);

        set(0, roleId);
        set(1, guildId);
        set(2, emoteId);
    }
}
