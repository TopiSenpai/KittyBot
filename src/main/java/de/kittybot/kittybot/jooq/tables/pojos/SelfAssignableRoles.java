/*
 * This file is generated by jOOQ.
 */
package de.kittybot.kittybot.jooq.tables.pojos;


import java.io.Serializable;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({"all", "unchecked", "rawtypes"})
public class SelfAssignableRoles implements Serializable{

	private static final long serialVersionUID = 1L;

	private final Long selfAssignableRoleId;
	private final Long roleId;
	private final Long guildId;
	private final Long emoteId;
	private final Long groupId;

	public SelfAssignableRoles(SelfAssignableRoles value){
		this.selfAssignableRoleId = value.selfAssignableRoleId;
		this.roleId = value.roleId;
		this.guildId = value.guildId;
		this.emoteId = value.emoteId;
		this.groupId = value.groupId;
	}

	public SelfAssignableRoles(
			Long selfAssignableRoleId,
			Long roleId,
			Long guildId,
			Long emoteId,
			Long groupId
	){
		this.selfAssignableRoleId = selfAssignableRoleId;
		this.roleId = roleId;
		this.guildId = guildId;
		this.emoteId = emoteId;
		this.groupId = groupId;
	}

	/**
	 * Getter for <code>public.self_assignable_roles.self_assignable_role_id</code>.
	 */
	public Long getSelfAssignableRoleId(){
		return this.selfAssignableRoleId;
	}

	/**
	 * Getter for <code>public.self_assignable_roles.role_id</code>.
	 */
	public Long getRoleId(){
		return this.roleId;
	}

	/**
	 * Getter for <code>public.self_assignable_roles.guild_id</code>.
	 */
	public Long getGuildId(){
		return this.guildId;
	}

	/**
	 * Getter for <code>public.self_assignable_roles.emote_id</code>.
	 */
	public Long getEmoteId(){
		return this.emoteId;
	}

	/**
	 * Getter for <code>public.self_assignable_roles.group_id</code>.
	 */
	public Long getGroupId(){
		return this.groupId;
	}

	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder("SelfAssignableRoles (");

		sb.append(selfAssignableRoleId);
		sb.append(", ").append(roleId);
		sb.append(", ").append(guildId);
		sb.append(", ").append(emoteId);
		sb.append(", ").append(groupId);

		sb.append(")");
		return sb.toString();
	}

}
