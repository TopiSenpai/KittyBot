/*
 * This file is generated by jOOQ.
 */
package de.kittybot.kittybot.database.jooq;


import de.kittybot.kittybot.database.jooq.tables.Guilds;
import de.kittybot.kittybot.database.jooq.tables.ReactiveMessages;
import de.kittybot.kittybot.database.jooq.tables.SelfAssignableRoles;
import de.kittybot.kittybot.database.jooq.tables.Sessions;
import de.kittybot.kittybot.database.jooq.tables.UserStatistics;
import de.kittybot.kittybot.database.jooq.tables.records.GuildsRecord;
import de.kittybot.kittybot.database.jooq.tables.records.ReactiveMessagesRecord;
import de.kittybot.kittybot.database.jooq.tables.records.SelfAssignableRolesRecord;
import de.kittybot.kittybot.database.jooq.tables.records.SessionsRecord;
import de.kittybot.kittybot.database.jooq.tables.records.UserStatisticsRecord;

import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.Internal;


/**
 * A class modelling foreign key relationships and constraints of tables in 
 * public.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<GuildsRecord> GUILDS_PKEY = Internal.createUniqueKey(Guilds.GUILDS, DSL.name("guilds_pkey"), new TableField[] { Guilds.GUILDS.GUILD_ID }, true);
    public static final UniqueKey<ReactiveMessagesRecord> REACTIVE_MESSAGES_PKEY = Internal.createUniqueKey(ReactiveMessages.REACTIVE_MESSAGES, DSL.name("reactive_messages_pkey"), new TableField[] { ReactiveMessages.REACTIVE_MESSAGES.MESSAGE_ID, ReactiveMessages.REACTIVE_MESSAGES.USER_ID, ReactiveMessages.REACTIVE_MESSAGES.GUILD_ID }, true);
    public static final UniqueKey<SelfAssignableRolesRecord> SELF_ASSIGNABLE_ROLES_PKEY = Internal.createUniqueKey(SelfAssignableRoles.SELF_ASSIGNABLE_ROLES, DSL.name("self_assignable_roles_pkey"), new TableField[] { SelfAssignableRoles.SELF_ASSIGNABLE_ROLES.ROLE_ID, SelfAssignableRoles.SELF_ASSIGNABLE_ROLES.GUILD_ID }, true);
    public static final UniqueKey<SessionsRecord> SESSIONS_PKEY = Internal.createUniqueKey(Sessions.SESSIONS, DSL.name("sessions_pkey"), new TableField[] { Sessions.SESSIONS.USER_ID }, true);
    public static final UniqueKey<UserStatisticsRecord> USER_STATISTICS_PKEY = Internal.createUniqueKey(UserStatistics.USER_STATISTICS, DSL.name("user_statistics_pkey"), new TableField[] { UserStatistics.USER_STATISTICS.USER_ID, UserStatistics.USER_STATISTICS.GUILD_ID }, true);
}
