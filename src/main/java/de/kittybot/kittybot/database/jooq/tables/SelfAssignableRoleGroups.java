/*
 * This file is generated by jOOQ.
 */
package de.kittybot.kittybot.database.jooq.tables;


import de.kittybot.kittybot.database.jooq.Keys;
import de.kittybot.kittybot.database.jooq.Public;
import de.kittybot.kittybot.database.jooq.tables.records.SelfAssignableRoleGroupsRecord;

import java.util.Arrays;
import java.util.List;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row4;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class SelfAssignableRoleGroups extends TableImpl<SelfAssignableRoleGroupsRecord> {

    private static final long serialVersionUID = -897961518;

    /**
     * The reference instance of <code>public.self_assignable_role_groups</code>
     */
    public static final SelfAssignableRoleGroups SELF_ASSIGNABLE_ROLE_GROUPS = new SelfAssignableRoleGroups();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<SelfAssignableRoleGroupsRecord> getRecordType() {
        return SelfAssignableRoleGroupsRecord.class;
    }

    /**
     * The column <code>public.self_assignable_role_groups.group_id</code>.
     */
    public final TableField<SelfAssignableRoleGroupsRecord, Integer> GROUP_ID = createField(DSL.name("group_id"), org.jooq.impl.SQLDataType.INTEGER.nullable(false).defaultValue(org.jooq.impl.DSL.field("nextval('self_assignable_role_groups_group_id_seq'::regclass)", org.jooq.impl.SQLDataType.INTEGER)), this, "");

    /**
     * The column <code>public.self_assignable_role_groups.guild_id</code>.
     */
    public final TableField<SelfAssignableRoleGroupsRecord, String> GUILD_ID = createField(DSL.name("guild_id"), org.jooq.impl.SQLDataType.VARCHAR(18).nullable(false), this, "");

    /**
     * The column <code>public.self_assignable_role_groups.group_name</code>.
     */
    public final TableField<SelfAssignableRoleGroupsRecord, String> GROUP_NAME = createField(DSL.name("group_name"), org.jooq.impl.SQLDataType.VARCHAR(18).nullable(false), this, "");

    /**
     * The column <code>public.self_assignable_role_groups.max_roles</code>.
     */
    public final TableField<SelfAssignableRoleGroupsRecord, Integer> MAX_ROLES = createField(DSL.name("max_roles"), org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * Create a <code>public.self_assignable_role_groups</code> table reference
     */
    public SelfAssignableRoleGroups() {
        this(DSL.name("self_assignable_role_groups"), null);
    }

    /**
     * Create an aliased <code>public.self_assignable_role_groups</code> table reference
     */
    public SelfAssignableRoleGroups(String alias) {
        this(DSL.name(alias), SELF_ASSIGNABLE_ROLE_GROUPS);
    }

    /**
     * Create an aliased <code>public.self_assignable_role_groups</code> table reference
     */
    public SelfAssignableRoleGroups(Name alias) {
        this(alias, SELF_ASSIGNABLE_ROLE_GROUPS);
    }

    private SelfAssignableRoleGroups(Name alias, Table<SelfAssignableRoleGroupsRecord> aliased) {
        this(alias, aliased, null);
    }

    private SelfAssignableRoleGroups(Name alias, Table<SelfAssignableRoleGroupsRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    public <O extends Record> SelfAssignableRoleGroups(Table<O> child, ForeignKey<O, SelfAssignableRoleGroupsRecord> key) {
        super(child, key, SELF_ASSIGNABLE_ROLE_GROUPS);
    }

    @Override
    public Schema getSchema() {
        return Public.PUBLIC;
    }

    @Override
    public Identity<SelfAssignableRoleGroupsRecord, Integer> getIdentity() {
        return Keys.IDENTITY_SELF_ASSIGNABLE_ROLE_GROUPS;
    }

    @Override
    public UniqueKey<SelfAssignableRoleGroupsRecord> getPrimaryKey() {
        return Keys.SELF_ASSIGNABLE_ROLE_GROUPS_PKEY;
    }

    @Override
    public List<UniqueKey<SelfAssignableRoleGroupsRecord>> getKeys() {
        return Arrays.<UniqueKey<SelfAssignableRoleGroupsRecord>>asList(Keys.SELF_ASSIGNABLE_ROLE_GROUPS_PKEY);
    }

    @Override
    public SelfAssignableRoleGroups as(String alias) {
        return new SelfAssignableRoleGroups(DSL.name(alias), this);
    }

    @Override
    public SelfAssignableRoleGroups as(Name alias) {
        return new SelfAssignableRoleGroups(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public SelfAssignableRoleGroups rename(String name) {
        return new SelfAssignableRoleGroups(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public SelfAssignableRoleGroups rename(Name name) {
        return new SelfAssignableRoleGroups(name, null);
    }

    // -------------------------------------------------------------------------
    // Row4 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row4<Integer, String, String, Integer> fieldsRow() {
        return (Row4) super.fieldsRow();
    }
}
