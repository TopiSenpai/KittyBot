/*
 * This file is generated by jOOQ.
 */
package de.kittybot.kittybot.database.jooq;


import org.jooq.Sequence;
import org.jooq.impl.Internal;


/**
 * Convenience access to all sequences in public
 */
@SuppressWarnings({"all", "unchecked", "rawtypes"})
public class Sequences{

	/**
	 * The sequence <code>public.self_assignable_role_groups_group_id_seq</code>
	 */
	public static final Sequence<Integer> SELF_ASSIGNABLE_ROLE_GROUPS_GROUP_ID_SEQ = Internal.createSequence("self_assignable_role_groups_group_id_seq", Public.PUBLIC, org.jooq.impl.SQLDataType.INTEGER.nullable(false), null, null, null, null, false, null);

}
