/*
 * This file is generated by jOOQ.
 */
package de.kittybot.kittybot.database.jooq.tables;


import de.kittybot.kittybot.database.jooq.Keys;
import de.kittybot.kittybot.database.jooq.Public;
import de.kittybot.kittybot.database.jooq.tables.records.SelfAssignableRolesRecord;
import org.jooq.*;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;

import java.util.Arrays;
import java.util.List;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({"all", "unchecked", "rawtypes"})
public class SelfAssignableRoles extends TableImpl<SelfAssignableRolesRecord>{

	/**
	 * The reference instance of <code>public.self_assignable_roles</code>
	 */
	public static final SelfAssignableRoles SELF_ASSIGNABLE_ROLES = new SelfAssignableRoles();
	private static final long serialVersionUID = -1494643558;
	/**
	 * The column <code>public.self_assignable_roles.role_id</code>.
	 */
	public final TableField<SelfAssignableRolesRecord, String> ROLE_ID = createField(DSL.name("role_id"), org.jooq.impl.SQLDataType.VARCHAR(18).nullable(false), this, "");
	/**
	 * The column <code>public.self_assignable_roles.guild_id</code>.
	 */
	public final TableField<SelfAssignableRolesRecord, String> GUILD_ID = createField(DSL.name("guild_id"), org.jooq.impl.SQLDataType.VARCHAR(18).nullable(false), this, "");
	/**
	 * The column <code>public.self_assignable_roles.emote_id</code>.
	 */
	public final TableField<SelfAssignableRolesRecord, String> EMOTE_ID = createField(DSL.name("emote_id"), org.jooq.impl.SQLDataType.VARCHAR(18).nullable(false), this, "");

	/**
	 * Create a <code>public.self_assignable_roles</code> table reference
	 */
	public SelfAssignableRoles(){
		this(DSL.name("self_assignable_roles"), null);
	}

	private SelfAssignableRoles(Name alias, Table<SelfAssignableRolesRecord> aliased){
		this(alias, aliased, null);
	}

	private SelfAssignableRoles(Name alias, Table<SelfAssignableRolesRecord> aliased, Field<?>[] parameters){
		super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
	}

	/**
	 * Create an aliased <code>public.self_assignable_roles</code> table reference
	 */
	public SelfAssignableRoles(String alias){
		this(DSL.name(alias), SELF_ASSIGNABLE_ROLES);
	}

	/**
	 * Create an aliased <code>public.self_assignable_roles</code> table reference
	 */
	public SelfAssignableRoles(Name alias){
		this(alias, SELF_ASSIGNABLE_ROLES);
	}

	public <O extends Record> SelfAssignableRoles(Table<O> child, ForeignKey<O, SelfAssignableRolesRecord> key){
		super(child, key, SELF_ASSIGNABLE_ROLES);
	}

	@Override
	public SelfAssignableRoles as(String alias){
		return new SelfAssignableRoles(DSL.name(alias), this);
	}

	@Override
	public Schema getSchema(){
		return Public.PUBLIC;
	}

	@Override
	public UniqueKey<SelfAssignableRolesRecord> getPrimaryKey(){
		return Keys.SELF_ASSIGNABLE_ROLES_PKEY;
	}

	@Override
	public List<UniqueKey<SelfAssignableRolesRecord>> getKeys(){
		return Arrays.<UniqueKey<SelfAssignableRolesRecord>>asList(Keys.SELF_ASSIGNABLE_ROLES_PKEY);
	}

	@Override
	public SelfAssignableRoles as(Name alias){
		return new SelfAssignableRoles(alias, this);
	}

	/**
	 * Rename this table
	 */
	@Override
	public SelfAssignableRoles rename(String name){
		return new SelfAssignableRoles(DSL.name(name), null);
	}

	/**
	 * Rename this table
	 */
	@Override
	public SelfAssignableRoles rename(Name name){
		return new SelfAssignableRoles(name, null);
	}

	/**
	 * The class holding records for this type
	 */
	@Override
	public Class<SelfAssignableRolesRecord> getRecordType(){
		return SelfAssignableRolesRecord.class;
	}

	// -------------------------------------------------------------------------
	// Row3 type methods
	// -------------------------------------------------------------------------

	@Override
	public Row3<String, String, String> fieldsRow(){
		return (Row3) super.fieldsRow();
	}

}
