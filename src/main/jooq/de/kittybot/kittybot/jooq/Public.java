/*
 * This file is generated by jOOQ.
 */
package de.kittybot.kittybot.jooq;


import de.kittybot.kittybot.jooq.tables.BotDisabledChannels;
import de.kittybot.kittybot.jooq.tables.BotIgnoredMembers;
import de.kittybot.kittybot.jooq.tables.GuildInviteRoles;
import de.kittybot.kittybot.jooq.tables.GuildInvites;
import de.kittybot.kittybot.jooq.tables.GuildTags;
import de.kittybot.kittybot.jooq.tables.Guilds;
import de.kittybot.kittybot.jooq.tables.MemberRoles;
import de.kittybot.kittybot.jooq.tables.Notifications;
import de.kittybot.kittybot.jooq.tables.ReactiveMessages;
import de.kittybot.kittybot.jooq.tables.Requests;
import de.kittybot.kittybot.jooq.tables.SelfAssignableRoleGroups;
import de.kittybot.kittybot.jooq.tables.SelfAssignableRoleMessages;
import de.kittybot.kittybot.jooq.tables.SelfAssignableRoles;
import de.kittybot.kittybot.jooq.tables.Sessions;
import de.kittybot.kittybot.jooq.tables.SnipeDisabledChannels;
import de.kittybot.kittybot.jooq.tables.StreamUserEvents;
import de.kittybot.kittybot.jooq.tables.StreamUsers;
import de.kittybot.kittybot.jooq.tables.UserStatistics;
import de.kittybot.kittybot.jooq.tables.Voters;

import java.util.Arrays;
import java.util.List;

import org.jooq.Catalog;
import org.jooq.Sequence;
import org.jooq.Table;
import org.jooq.impl.SchemaImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Public extends SchemaImpl {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public</code>
     */
    public static final Public PUBLIC = new Public();

    /**
     * The table <code>public.bot_disabled_channels</code>.
     */
    public final BotDisabledChannels BOT_DISABLED_CHANNELS = BotDisabledChannels.BOT_DISABLED_CHANNELS;

    /**
     * The table <code>public.bot_ignored_members</code>.
     */
    public final BotIgnoredMembers BOT_IGNORED_MEMBERS = BotIgnoredMembers.BOT_IGNORED_MEMBERS;

    /**
     * The table <code>public.guild_invite_roles</code>.
     */
    public final GuildInviteRoles GUILD_INVITE_ROLES = GuildInviteRoles.GUILD_INVITE_ROLES;

    /**
     * The table <code>public.guild_invites</code>.
     */
    public final GuildInvites GUILD_INVITES = GuildInvites.GUILD_INVITES;

    /**
     * The table <code>public.guild_tags</code>.
     */
    public final GuildTags GUILD_TAGS = GuildTags.GUILD_TAGS;

    /**
     * The table <code>public.guilds</code>.
     */
    public final Guilds GUILDS = Guilds.GUILDS;

    /**
     * The table <code>public.member_roles</code>.
     */
    public final MemberRoles MEMBER_ROLES = MemberRoles.MEMBER_ROLES;

    /**
     * The table <code>public.notifications</code>.
     */
    public final Notifications NOTIFICATIONS = Notifications.NOTIFICATIONS;

    /**
     * The table <code>public.reactive_messages</code>.
     */
    public final ReactiveMessages REACTIVE_MESSAGES = ReactiveMessages.REACTIVE_MESSAGES;

    /**
     * The table <code>public.requests</code>.
     */
    public final Requests REQUESTS = Requests.REQUESTS;

    /**
     * The table <code>public.self_assignable_role_groups</code>.
     */
    public final SelfAssignableRoleGroups SELF_ASSIGNABLE_ROLE_GROUPS = SelfAssignableRoleGroups.SELF_ASSIGNABLE_ROLE_GROUPS;

    /**
     * The table <code>public.self_assignable_role_messages</code>.
     */
    public final SelfAssignableRoleMessages SELF_ASSIGNABLE_ROLE_MESSAGES = SelfAssignableRoleMessages.SELF_ASSIGNABLE_ROLE_MESSAGES;

    /**
     * The table <code>public.self_assignable_roles</code>.
     */
    public final SelfAssignableRoles SELF_ASSIGNABLE_ROLES = SelfAssignableRoles.SELF_ASSIGNABLE_ROLES;

    /**
     * The table <code>public.sessions</code>.
     */
    public final Sessions SESSIONS = Sessions.SESSIONS;

    /**
     * The table <code>public.snipe_disabled_channels</code>.
     */
    public final SnipeDisabledChannels SNIPE_DISABLED_CHANNELS = SnipeDisabledChannels.SNIPE_DISABLED_CHANNELS;

    /**
     * The table <code>public.stream_user_events</code>.
     */
    public final StreamUserEvents STREAM_USER_EVENTS = StreamUserEvents.STREAM_USER_EVENTS;

    /**
     * The table <code>public.stream_users</code>.
     */
    public final StreamUsers STREAM_USERS = StreamUsers.STREAM_USERS;

    /**
     * The table <code>public.user_statistics</code>.
     */
    public final UserStatistics USER_STATISTICS = UserStatistics.USER_STATISTICS;

    /**
     * The table <code>public.voters</code>.
     */
    public final Voters VOTERS = Voters.VOTERS;

    /**
     * No further instances allowed
     */
    private Public() {
        super("public", null);
    }


    @Override
    public Catalog getCatalog() {
        return DefaultCatalog.DEFAULT_CATALOG;
    }

    @Override
    public final List<Sequence<?>> getSequences() {
        return Arrays.<Sequence<?>>asList(
            Sequences.BOT_DISABLED_CHANNELS_ID_SEQ,
            Sequences.BOT_IGNORED_MEMBERS_ID_SEQ,
            Sequences.GUILD_INVITE_ROLES_ID_SEQ,
            Sequences.GUILD_INVITES_ID_SEQ,
            Sequences.GUILD_TAGS_ID_SEQ,
            Sequences.MEMBER_ROLES_ID_SEQ,
            Sequences.NOTIFICATIONS_ID_SEQ,
            Sequences.REACTIVE_MESSAGES_ID_SEQ,
            Sequences.REQUESTS_ID_SEQ,
            Sequences.SELF_ASSIGNABLE_ROLE_GROUPS_ID_SEQ,
            Sequences.SELF_ASSIGNABLE_ROLE_MESSAGES_ID_SEQ,
            Sequences.SELF_ASSIGNABLE_ROLES_ID_SEQ,
            Sequences.SESSIONS_ID_SEQ,
            Sequences.SNIPE_DISABLED_CHANNELS_ID_SEQ,
            Sequences.STREAM_USER_EVENTS_ID_SEQ,
            Sequences.STREAM_USERS_ID_SEQ,
            Sequences.USER_STATISTICS_ID_SEQ,
            Sequences.VOTERS_ID_SEQ);
    }

    @Override
    public final List<Table<?>> getTables() {
        return Arrays.<Table<?>>asList(
            BotDisabledChannels.BOT_DISABLED_CHANNELS,
            BotIgnoredMembers.BOT_IGNORED_MEMBERS,
            GuildInviteRoles.GUILD_INVITE_ROLES,
            GuildInvites.GUILD_INVITES,
            GuildTags.GUILD_TAGS,
            Guilds.GUILDS,
            MemberRoles.MEMBER_ROLES,
            Notifications.NOTIFICATIONS,
            ReactiveMessages.REACTIVE_MESSAGES,
            Requests.REQUESTS,
            SelfAssignableRoleGroups.SELF_ASSIGNABLE_ROLE_GROUPS,
            SelfAssignableRoleMessages.SELF_ASSIGNABLE_ROLE_MESSAGES,
            SelfAssignableRoles.SELF_ASSIGNABLE_ROLES,
            Sessions.SESSIONS,
            SnipeDisabledChannels.SNIPE_DISABLED_CHANNELS,
            StreamUserEvents.STREAM_USER_EVENTS,
            StreamUsers.STREAM_USERS,
            UserStatistics.USER_STATISTICS,
            Voters.VOTERS);
    }
}
