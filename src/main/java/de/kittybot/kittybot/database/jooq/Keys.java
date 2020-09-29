/*
 * This file is generated by jOOQ.
 */
package de.kittybot.kittybot.database.jooq;


import de.kittybot.kittybot.database.jooq.tables.*;
import de.kittybot.kittybot.database.jooq.tables.records.*;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.Internal;


/**
 * A class modelling foreign key relationships and constraints of tables of
 * the <code>public</code> schema.
 */
@SuppressWarnings({"all", "unchecked", "rawtypes"})
public class Keys{

	// -------------------------------------------------------------------------
	// IDENTITY definitions
	// -------------------------------------------------------------------------


	// -------------------------------------------------------------------------
	// UNIQUE and PRIMARY KEY definitions
	// -------------------------------------------------------------------------

	public static final UniqueKey<CommandsRecord> COMMANDS_PKEY = UniqueKeys0.COMMANDS_PKEY;
	public static final UniqueKey<GuildsRecord> GUILDS_PKEY = UniqueKeys0.GUILDS_PKEY;
	public static final UniqueKey<ReactiveMessagesRecord> REACTIVE_MESSAGES_PKEY = UniqueKeys0.REACTIVE_MESSAGES_PKEY;
	public static final UniqueKey<SelfAssignableRolesRecord> SELF_ASSIGNABLE_ROLES_PKEY = UniqueKeys0.SELF_ASSIGNABLE_ROLES_PKEY;
	public static final UniqueKey<SessionsRecord> SESSIONS_PKEY = UniqueKeys0.SESSIONS_PKEY;
	public static final UniqueKey<UserStatisticsRecord> USER_STATISTICS_PKEY = UniqueKeys0.USER_STATISTICS_PKEY;

	// -------------------------------------------------------------------------
	// FOREIGN KEY definitions
	// -------------------------------------------------------------------------


	// -------------------------------------------------------------------------
	// [#1459] distribute members to avoid static initialisers > 64kb
	// -------------------------------------------------------------------------

	private static class UniqueKeys0{

		public static final UniqueKey<CommandsRecord> COMMANDS_PKEY = Internal.createUniqueKey(Commands.COMMANDS, "commands_pkey", new TableField[]{Commands.COMMANDS.MESSAGE_ID, Commands.COMMANDS.GUILD_ID}, true);
		public static final UniqueKey<GuildsRecord> GUILDS_PKEY = Internal.createUniqueKey(Guilds.GUILDS, "guilds_pkey", new TableField[]{Guilds.GUILDS.GUILD_ID}, true);
		public static final UniqueKey<ReactiveMessagesRecord> REACTIVE_MESSAGES_PKEY = Internal.createUniqueKey(ReactiveMessages.REACTIVE_MESSAGES, "reactive_messages_pkey", new TableField[]{ReactiveMessages.REACTIVE_MESSAGES.MESSAGE_ID, ReactiveMessages.REACTIVE_MESSAGES.USER_ID, ReactiveMessages.REACTIVE_MESSAGES.GUILD_ID}, true);
		public static final UniqueKey<SelfAssignableRolesRecord> SELF_ASSIGNABLE_ROLES_PKEY = Internal.createUniqueKey(SelfAssignableRoles.SELF_ASSIGNABLE_ROLES, "self_assignable_roles_pkey", new TableField[]{SelfAssignableRoles.SELF_ASSIGNABLE_ROLES.ROLE_ID, SelfAssignableRoles.SELF_ASSIGNABLE_ROLES.GUILD_ID}, true);
		public static final UniqueKey<SessionsRecord> SESSIONS_PKEY = Internal.createUniqueKey(Sessions.SESSIONS, "sessions_pkey", new TableField[]{Sessions.SESSIONS.SESSION_ID}, true);
		public static final UniqueKey<UserStatisticsRecord> USER_STATISTICS_PKEY = Internal.createUniqueKey(UserStatistics.USER_STATISTICS, "user_statistics_pkey", new TableField[]{UserStatistics.USER_STATISTICS.USER_ID, UserStatistics.USER_STATISTICS.GUILD_ID}, true);

	}

}
