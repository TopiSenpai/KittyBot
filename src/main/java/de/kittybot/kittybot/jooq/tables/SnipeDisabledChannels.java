/*
 * This file is generated by jOOQ.
 */
package de.kittybot.kittybot.jooq.tables;


import de.kittybot.kittybot.jooq.Keys;
import de.kittybot.kittybot.jooq.Public;
import de.kittybot.kittybot.jooq.tables.records.SnipeDisabledChannelsRecord;
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
public class SnipeDisabledChannels extends TableImpl<SnipeDisabledChannelsRecord>{

	/**
	 * The reference instance of <code>public.snipe_disabled_channels</code>
	 */
	public static final SnipeDisabledChannels SNIPE_DISABLED_CHANNELS = new SnipeDisabledChannels();
	private static final long serialVersionUID = 1L;
	/**
	 * The column <code>public.snipe_disabled_channels.snipe_disabled_channel_id</code>.
	 */
	public final TableField<SnipeDisabledChannelsRecord, Long> SNIPE_DISABLED_CHANNEL_ID = createField(DSL.name("snipe_disabled_channel_id"), SQLDataType.BIGINT.nullable(false).identity(true), this, "");
	/**
	 * The column <code>public.snipe_disabled_channels.guild_id</code>.
	 */
	public final TableField<SnipeDisabledChannelsRecord, Long> GUILD_ID = createField(DSL.name("guild_id"), SQLDataType.BIGINT.nullable(false), this, "");
	/**
	 * The column <code>public.snipe_disabled_channels.channel_id</code>.
	 */
	public final TableField<SnipeDisabledChannelsRecord, Long> CHANNEL_ID = createField(DSL.name("channel_id"), SQLDataType.BIGINT.nullable(false), this, "");

	/**
	 * Create an aliased <code>public.snipe_disabled_channels</code> table reference
	 */
	public SnipeDisabledChannels(String alias){
		this(DSL.name(alias), SNIPE_DISABLED_CHANNELS);
	}

	private SnipeDisabledChannels(Name alias, Table<SnipeDisabledChannelsRecord> aliased){
		this(alias, aliased, null);
	}

	private SnipeDisabledChannels(Name alias, Table<SnipeDisabledChannelsRecord> aliased, Field<?>[] parameters){
		super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
	}

	/**
	 * Create an aliased <code>public.snipe_disabled_channels</code> table reference
	 */
	public SnipeDisabledChannels(Name alias){
		this(alias, SNIPE_DISABLED_CHANNELS);
	}

	/**
	 * Create a <code>public.snipe_disabled_channels</code> table reference
	 */
	public SnipeDisabledChannels(){
		this(DSL.name("snipe_disabled_channels"), null);
	}

	public <O extends Record> SnipeDisabledChannels(Table<O> child, ForeignKey<O, SnipeDisabledChannelsRecord> key){
		super(child, key, SNIPE_DISABLED_CHANNELS);
	}

	@Override
	public SnipeDisabledChannels as(String alias){
		return new SnipeDisabledChannels(DSL.name(alias), this);
	}

	@Override
	public Schema getSchema(){
		return Public.PUBLIC;
	}

	@Override
	public Identity<SnipeDisabledChannelsRecord, Long> getIdentity(){
		return (Identity<SnipeDisabledChannelsRecord, Long>) super.getIdentity();
	}

	@Override
	public UniqueKey<SnipeDisabledChannelsRecord> getPrimaryKey(){
		return Keys.SNIPE_DISABLED_CHANNELS_PKEY;
	}

	@Override
	public List<UniqueKey<SnipeDisabledChannelsRecord>> getKeys(){
		return Arrays.<UniqueKey<SnipeDisabledChannelsRecord>>asList(Keys.SNIPE_DISABLED_CHANNELS_PKEY);
	}

	@Override
	public Row3<Long, Long, Long> fieldsRow(){
		return (Row3) super.fieldsRow();
	}

	@Override
	public SnipeDisabledChannels as(Name alias){
		return new SnipeDisabledChannels(alias, this);
	}

	/**
	 * Rename this table
	 */
	@Override
	public SnipeDisabledChannels rename(String name){
		return new SnipeDisabledChannels(DSL.name(name), null);
	}

	/**
	 * Rename this table
	 */
	@Override
	public SnipeDisabledChannels rename(Name name){
		return new SnipeDisabledChannels(name, null);
	}

	// -------------------------------------------------------------------------
	// Row3 type methods
	// -------------------------------------------------------------------------

	/**
	 * The class holding records for this type
	 */
	@Override
	public Class<SnipeDisabledChannelsRecord> getRecordType(){
		return SnipeDisabledChannelsRecord.class;
	}

}
