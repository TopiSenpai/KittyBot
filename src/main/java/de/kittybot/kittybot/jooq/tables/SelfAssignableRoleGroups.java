/*
 * This file is generated by jOOQ.
 */
package de.kittybot.kittybot.jooq.tables;


import de.kittybot.kittybot.jooq.Keys;
import de.kittybot.kittybot.jooq.Public;
import de.kittybot.kittybot.jooq.tables.records.SelfAssignableRoleGroupsRecord;
import org.jooq.*;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;

import java.util.Arrays;
import java.util.List;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({"all", "unchecked", "rawtypes"})
public class SelfAssignableRoleGroups extends TableImpl<SelfAssignableRoleGroupsRecord>{

	/**
	 * The reference instance of <code>public.self_assignable_role_groups</code>
	 */
	public static final SelfAssignableRoleGroups SELF_ASSIGNABLE_ROLE_GROUPS = new SelfAssignableRoleGroups();
	private static final long serialVersionUID = 1L;
	/**
	 * The column <code>public.self_assignable_role_groups.self_assignable_role_group_id</code>.
	 */
	public final TableField<SelfAssignableRoleGroupsRecord, Long> SELF_ASSIGNABLE_ROLE_GROUP_ID = createField(DSL.name("self_assignable_role_group_id"), SQLDataType.BIGINT.nullable(false).identity(true), this, "");
	/**
	 * The column <code>public.self_assignable_role_groups.guild_id</code>.
	 */
	public final TableField<SelfAssignableRoleGroupsRecord, Long> GUILD_ID = createField(DSL.name("guild_id"), SQLDataType.BIGINT.nullable(false), this, "");
	/**
	 * The column <code>public.self_assignable_role_groups.group_name</code>.
	 */
	public final TableField<SelfAssignableRoleGroupsRecord, String> GROUP_NAME = createField(DSL.name("group_name"), SQLDataType.VARCHAR(255).nullable(false), this, "");

	/**
	 * Create an aliased <code>public.self_assignable_role_groups</code> table reference
	 */
	public SelfAssignableRoleGroups(String alias){
		this(DSL.name(alias), SELF_ASSIGNABLE_ROLE_GROUPS);
	}

	private SelfAssignableRoleGroups(Name alias, Table<SelfAssignableRoleGroupsRecord> aliased){
		this(alias, aliased, null);
	}

	private SelfAssignableRoleGroups(Name alias, Table<SelfAssignableRoleGroupsRecord> aliased, Field<?>[] parameters){
		super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
	}

	/**
	 * Create an aliased <code>public.self_assignable_role_groups</code> table reference
	 */
	public SelfAssignableRoleGroups(Name alias){
		this(alias, SELF_ASSIGNABLE_ROLE_GROUPS);
	}

	/**
	 * Create a <code>public.self_assignable_role_groups</code> table reference
	 */
	public SelfAssignableRoleGroups(){
		this(DSL.name("self_assignable_role_groups"), null);
	}

	public <O extends Record> SelfAssignableRoleGroups(Table<O> child, ForeignKey<O, SelfAssignableRoleGroupsRecord> key){
		super(child, key, SELF_ASSIGNABLE_ROLE_GROUPS);
	}

	@Override
	public SelfAssignableRoleGroups as(String alias){
		return new SelfAssignableRoleGroups(DSL.name(alias), this);
	}

	@Override
	public Schema getSchema(){
		return Public.PUBLIC;
	}

	@Override
	public Identity<SelfAssignableRoleGroupsRecord, Long> getIdentity(){
		return (Identity<SelfAssignableRoleGroupsRecord, Long>) super.getIdentity();
	}

	@Override
	public UniqueKey<SelfAssignableRoleGroupsRecord> getPrimaryKey(){
		return Keys.SELF_ASSIGNABLE_ROLE_GROUPS_PKEY;
	}

	@Override
	public List<UniqueKey<SelfAssignableRoleGroupsRecord>> getKeys(){
		return Arrays.<UniqueKey<SelfAssignableRoleGroupsRecord>>asList(Keys.SELF_ASSIGNABLE_ROLE_GROUPS_PKEY);
	}

	@Override
	public Row3<Long, Long, String> fieldsRow(){
		return (Row3) super.fieldsRow();
	}

	@Override
	public SelfAssignableRoleGroups as(Name alias){
		return new SelfAssignableRoleGroups(alias, this);
	}

	/**
	 * Rename this table
	 */
	@Override
	public SelfAssignableRoleGroups rename(String name){
		return new SelfAssignableRoleGroups(DSL.name(name), null);
	}

	/**
	 * Rename this table
	 */
	@Override
	public SelfAssignableRoleGroups rename(Name name){
		return new SelfAssignableRoleGroups(name, null);
	}

	// -------------------------------------------------------------------------
	// Row3 type methods
	// -------------------------------------------------------------------------

	/**
	 * The class holding records for this type
	 */
	@Override
	public Class<SelfAssignableRoleGroupsRecord> getRecordType(){
		return SelfAssignableRoleGroupsRecord.class;
	}

}
