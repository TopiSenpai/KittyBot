/*
 * This file is generated by jOOQ.
 */
package de.kittybot.kittybot.jooq.tables.records;


import de.kittybot.kittybot.jooq.tables.GuildInviteRoles;
import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record3;
import org.jooq.Row3;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({"all", "unchecked", "rawtypes"})
public class GuildInviteRolesRecord extends UpdatableRecordImpl<GuildInviteRolesRecord> implements Record3<Long, Long, Long>{

	private static final long serialVersionUID = 1L;

	/**
	 * Create a detached GuildInviteRolesRecord
	 */
	public GuildInviteRolesRecord(){
		super(GuildInviteRoles.GUILD_INVITE_ROLES);
	}

	/**
	 * Create a detached, initialised GuildInviteRolesRecord
	 */
	public GuildInviteRolesRecord(Long guildInviteRoleId, Long guildInviteId, Long roleId){
		super(GuildInviteRoles.GUILD_INVITE_ROLES);

		setGuildInviteRoleId(guildInviteRoleId);
		setGuildInviteId(guildInviteId);
		setRoleId(roleId);
	}

	@Override
	public Record1<Long> key(){
		return (Record1) super.key();
	}

	@Override
	public Row3<Long, Long, Long> fieldsRow(){
		return (Row3) super.fieldsRow();
	}

	@Override
	public Row3<Long, Long, Long> valuesRow(){
		return (Row3) super.valuesRow();
	}

	@Override
	public Field<Long> field1(){
		return GuildInviteRoles.GUILD_INVITE_ROLES.GUILD_INVITE_ROLE_ID;
	}

	// -------------------------------------------------------------------------
	// Primary key information
	// -------------------------------------------------------------------------

	@Override
	public Field<Long> field2(){
		return GuildInviteRoles.GUILD_INVITE_ROLES.GUILD_INVITE_ID;
	}

	// -------------------------------------------------------------------------
	// Record3 type implementation
	// -------------------------------------------------------------------------

	@Override
	public Field<Long> field3(){
		return GuildInviteRoles.GUILD_INVITE_ROLES.ROLE_ID;
	}

	@Override
	public Long value1(){
		return getGuildInviteRoleId();
	}

	@Override
	public Long value2(){
		return getGuildInviteId();
	}

	@Override
	public Long value3(){
		return getRoleId();
	}

	@Override
	public GuildInviteRolesRecord value1(Long value){
		setGuildInviteRoleId(value);
		return this;
	}

	@Override
	public GuildInviteRolesRecord value2(Long value){
		setGuildInviteId(value);
		return this;
	}

	@Override
	public GuildInviteRolesRecord value3(Long value){
		setRoleId(value);
		return this;
	}

	@Override
	public GuildInviteRolesRecord values(Long value1, Long value2, Long value3){
		value1(value1);
		value2(value2);
		value3(value3);
		return this;
	}

	@Override
	public Long component1(){
		return getGuildInviteRoleId();
	}

	/**
	 * Getter for <code>public.guild_invite_roles.guild_invite_role_id</code>.
	 */
	public Long getGuildInviteRoleId(){
		return (Long) get(0);
	}

	/**
	 * Setter for <code>public.guild_invite_roles.guild_invite_role_id</code>.
	 */
	public GuildInviteRolesRecord setGuildInviteRoleId(Long value){
		set(0, value);
		return this;
	}

	@Override
	public Long component2(){
		return getGuildInviteId();
	}

	/**
	 * Getter for <code>public.guild_invite_roles.guild_invite_id</code>.
	 */
	public Long getGuildInviteId(){
		return (Long) get(1);
	}

	/**
	 * Setter for <code>public.guild_invite_roles.guild_invite_id</code>.
	 */
	public GuildInviteRolesRecord setGuildInviteId(Long value){
		set(1, value);
		return this;
	}

	@Override
	public Long component3(){
		return getRoleId();
	}

	// -------------------------------------------------------------------------
	// Constructors
	// -------------------------------------------------------------------------

	/**
	 * Getter for <code>public.guild_invite_roles.role_id</code>.
	 */
	public Long getRoleId(){
		return (Long) get(2);
	}

	/**
	 * Setter for <code>public.guild_invite_roles.role_id</code>.
	 */
	public GuildInviteRolesRecord setRoleId(Long value){
		set(2, value);
		return this;
	}

}
