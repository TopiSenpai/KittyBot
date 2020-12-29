/*
 * This file is generated by jOOQ.
 */
package de.kittybot.kittybot.jooq;


import org.jooq.Sequence;
import org.jooq.impl.Internal;
import org.jooq.impl.SQLDataType;


/**
 * Convenience access to all sequences in public.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Sequences {

    /**
     * The sequence <code>public.bot_disabled_channels_bot_disabled_channel_id_seq</code>
     */
    public static final Sequence<Long> BOT_DISABLED_CHANNELS_BOT_DISABLED_CHANNEL_ID_SEQ = Internal.createSequence("bot_disabled_channels_bot_disabled_channel_id_seq", Public.PUBLIC, SQLDataType.BIGINT.nullable(false), null, null, null, null, false, null);

    /**
     * The sequence <code>public.bot_ignored_users_bot_ignored_user_id_seq</code>
     */
    public static final Sequence<Long> BOT_IGNORED_USERS_BOT_IGNORED_USER_ID_SEQ = Internal.createSequence("bot_ignored_users_bot_ignored_user_id_seq", Public.PUBLIC, SQLDataType.BIGINT.nullable(false), null, null, null, null, false, null);

    /**
     * The sequence <code>public.guild_invite_roles_guild_invite_role_id_seq</code>
     */
    public static final Sequence<Long> GUILD_INVITE_ROLES_GUILD_INVITE_ROLE_ID_SEQ = Internal.createSequence("guild_invite_roles_guild_invite_role_id_seq", Public.PUBLIC, SQLDataType.BIGINT.nullable(false), null, null, null, null, false, null);

    /**
     * The sequence <code>public.guild_invites_guild_invite_id_seq</code>
     */
    public static final Sequence<Long> GUILD_INVITES_GUILD_INVITE_ID_SEQ = Internal.createSequence("guild_invites_guild_invite_id_seq", Public.PUBLIC, SQLDataType.BIGINT.nullable(false), null, null, null, null, false, null);

    /**
     * The sequence <code>public.guild_tags_tag_id_seq</code>
     */
    public static final Sequence<Long> GUILD_TAGS_TAG_ID_SEQ = Internal.createSequence("guild_tags_tag_id_seq", Public.PUBLIC, SQLDataType.BIGINT.nullable(false), null, null, null, null, false, null);

    /**
     * The sequence <code>public.notifications_notification_id_seq</code>
     */
    public static final Sequence<Long> NOTIFICATIONS_NOTIFICATION_ID_SEQ = Internal.createSequence("notifications_notification_id_seq", Public.PUBLIC, SQLDataType.BIGINT.nullable(false), null, null, null, null, false, null);

    /**
     * The sequence <code>public.reactive_messages_reactive_message_id_seq</code>
     */
    public static final Sequence<Long> REACTIVE_MESSAGES_REACTIVE_MESSAGE_ID_SEQ = Internal.createSequence("reactive_messages_reactive_message_id_seq", Public.PUBLIC, SQLDataType.BIGINT.nullable(false), null, null, null, null, false, null);

    /**
     * The sequence <code>public.requests_request_id_seq</code>
     */
    public static final Sequence<Long> REQUESTS_REQUEST_ID_SEQ = Internal.createSequence("requests_request_id_seq", Public.PUBLIC, SQLDataType.BIGINT.nullable(false), null, null, null, null, false, null);

    /**
     * The sequence <code>public.self_assignable_role_groups_self_assignable_role_group_id_seq</code>
     */
    public static final Sequence<Long> SELF_ASSIGNABLE_ROLE_GROUPS_SELF_ASSIGNABLE_ROLE_GROUP_ID_SEQ = Internal.createSequence("self_assignable_role_groups_self_assignable_role_group_id_seq", Public.PUBLIC, SQLDataType.BIGINT.nullable(false), null, null, null, null, false, null);

    /**
     * The sequence <code>public.self_assignable_roles_self_assignable_role_id_seq</code>
     */
    public static final Sequence<Long> SELF_ASSIGNABLE_ROLES_SELF_ASSIGNABLE_ROLE_ID_SEQ = Internal.createSequence("self_assignable_roles_self_assignable_role_id_seq", Public.PUBLIC, SQLDataType.BIGINT.nullable(false), null, null, null, null, false, null);

    /**
     * The sequence <code>public.snipe_disabled_channels_snipe_disabled_channel_id_seq</code>
     */
    public static final Sequence<Long> SNIPE_DISABLED_CHANNELS_SNIPE_DISABLED_CHANNEL_ID_SEQ = Internal.createSequence("snipe_disabled_channels_snipe_disabled_channel_id_seq", Public.PUBLIC, SQLDataType.BIGINT.nullable(false), null, null, null, null, false, null);

    /**
     * The sequence <code>public.stream_user_events_steam_user_event_id_seq</code>
     */
    public static final Sequence<Long> STREAM_USER_EVENTS_STEAM_USER_EVENT_ID_SEQ = Internal.createSequence("stream_user_events_steam_user_event_id_seq", Public.PUBLIC, SQLDataType.BIGINT.nullable(false), null, null, null, null, false, null);

    /**
     * The sequence <code>public.stream_users_stream_user_id_seq</code>
     */
    public static final Sequence<Long> STREAM_USERS_STREAM_USER_ID_SEQ = Internal.createSequence("stream_users_stream_user_id_seq", Public.PUBLIC, SQLDataType.BIGINT.nullable(false), null, null, null, null, false, null);

    /**
     * The sequence <code>public.user_statistics_user_statistic_id_seq</code>
     */
    public static final Sequence<Long> USER_STATISTICS_USER_STATISTIC_ID_SEQ = Internal.createSequence("user_statistics_user_statistic_id_seq", Public.PUBLIC, SQLDataType.BIGINT.nullable(false), null, null, null, null, false, null);
}
