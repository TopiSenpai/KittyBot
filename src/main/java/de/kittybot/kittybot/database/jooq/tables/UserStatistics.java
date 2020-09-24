/*
 * This file is generated by jOOQ.
 */
package de.kittybot.kittybot.database.jooq.tables;


import de.kittybot.kittybot.database.jooq.Keys;
import de.kittybot.kittybot.database.jooq.Public;
import de.kittybot.kittybot.database.jooq.tables.records.UserStatisticsRecord;
import org.jooq.*;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;

import java.util.Arrays;
import java.util.List;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({"all", "unchecked", "rawtypes"})
public class UserStatistics extends TableImpl<UserStatisticsRecord>{

	/**
	 * The reference instance of <code>public.user_statistics</code>
	 */
	public static final UserStatistics USER_STATISTICS = new UserStatistics();
	private static final long serialVersionUID = -1763511363;
	/**
	 * The column <code>public.user_statistics.user_id</code>.
	 */
	public final TableField<UserStatisticsRecord, String> USER_ID = createField(DSL.name("user_id"), org.jooq.impl.SQLDataType.VARCHAR(18).nullable(false), this, "");
	/**
	 * The column <code>public.user_statistics.guild_id</code>.
	 */
	public final TableField<UserStatisticsRecord, String> GUILD_ID = createField(DSL.name("guild_id"), org.jooq.impl.SQLDataType.VARCHAR(18).nullable(false), this, "");
	/**
	 * The column <code>public.user_statistics.xp</code>.
	 */
	public final TableField<UserStatisticsRecord, Integer> XP = createField(DSL.name("xp"), org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");
	/**
	 * The column <code>public.user_statistics.level</code>.
	 */
	public final TableField<UserStatisticsRecord, Integer> LEVEL = createField(DSL.name("level"), org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");
	/**
	 * The column <code>public.user_statistics.bot_calls</code>.
	 */
	public final TableField<UserStatisticsRecord, Integer> BOT_CALLS = createField(DSL.name("bot_calls"), org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");
	/**
	 * The column <code>public.user_statistics.voice_time</code>.
	 */
	public final TableField<UserStatisticsRecord, Integer> VOICE_TIME = createField(DSL.name("voice_time"), org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");
	/**
	 * The column <code>public.user_statistics.message_count</code>.
	 */
	public final TableField<UserStatisticsRecord, Integer> MESSAGE_COUNT = createField(DSL.name("message_count"), org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");
	/**
	 * The column <code>public.user_statistics.emote_count</code>.
	 */
	public final TableField<UserStatisticsRecord, Integer> EMOTE_COUNT = createField(DSL.name("emote_count"), org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");
	/**
	 * The column <code>public.user_statistics.last_active</code>.
	 */
	public final TableField<UserStatisticsRecord, String> LAST_ACTIVE = createField(DSL.name("last_active"), org.jooq.impl.SQLDataType.VARCHAR(20).nullable(false), this, "");

	/**
	 * Create a <code>public.user_statistics</code> table reference
	 */
	public UserStatistics(){
		this(DSL.name("user_statistics"), null);
	}

	private UserStatistics(Name alias, Table<UserStatisticsRecord> aliased){
		this(alias, aliased, null);
	}

	private UserStatistics(Name alias, Table<UserStatisticsRecord> aliased, Field<?>[] parameters){
		super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
	}

	/**
	 * Create an aliased <code>public.user_statistics</code> table reference
	 */
	public UserStatistics(String alias){
		this(DSL.name(alias), USER_STATISTICS);
	}

	/**
	 * Create an aliased <code>public.user_statistics</code> table reference
	 */
	public UserStatistics(Name alias){
		this(alias, USER_STATISTICS);
	}

	public <O extends Record> UserStatistics(Table<O> child, ForeignKey<O, UserStatisticsRecord> key){
		super(child, key, USER_STATISTICS);
	}

	@Override
	public UserStatistics as(String alias){
		return new UserStatistics(DSL.name(alias), this);
	}

	@Override
	public Schema getSchema(){
		return Public.PUBLIC;
	}

	@Override
	public UniqueKey<UserStatisticsRecord> getPrimaryKey(){
		return Keys.USER_STATISTICS_PKEY;
	}

	@Override
	public List<UniqueKey<UserStatisticsRecord>> getKeys(){
		return Arrays.<UniqueKey<UserStatisticsRecord>>asList(Keys.USER_STATISTICS_PKEY);
	}

	@Override
	public UserStatistics as(Name alias){
		return new UserStatistics(alias, this);
	}

	/**
	 * Rename this table
	 */
	@Override
	public UserStatistics rename(String name){
		return new UserStatistics(DSL.name(name), null);
	}

	/**
	 * Rename this table
	 */
	@Override
	public UserStatistics rename(Name name){
		return new UserStatistics(name, null);
	}

	/**
	 * The class holding records for this type
	 */
	@Override
	public Class<UserStatisticsRecord> getRecordType(){
		return UserStatisticsRecord.class;
	}

	// -------------------------------------------------------------------------
	// Row9 type methods
	// -------------------------------------------------------------------------

	@Override
	public Row9<String, String, Integer, Integer, Integer, Integer, Integer, Integer, String> fieldsRow(){
		return (Row9) super.fieldsRow();
	}

}
