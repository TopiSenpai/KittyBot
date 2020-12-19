/*
 * This file is generated by jOOQ.
 */
package de.kittybot.kittybot.jooq.tables.records;


import de.kittybot.kittybot.jooq.tables.BotDisabledChannels;
import org.jooq.Field;
import org.jooq.Record2;
import org.jooq.Record3;
import org.jooq.Row3;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({"all", "unchecked", "rawtypes"})
public class BotDisabledChannelsRecord extends UpdatableRecordImpl<BotDisabledChannelsRecord> implements Record3<Long, Long, Long>{

	private static final long serialVersionUID = 1L;

	/**
	 * Create a detached BotDisabledChannelsRecord
	 */
	public BotDisabledChannelsRecord(){
		super(BotDisabledChannels.BOT_DISABLED_CHANNELS);
	}

	/**
	 * Create a detached, initialised BotDisabledChannelsRecord
	 */
	public BotDisabledChannelsRecord(Long botDisabledChannelId, Long guildId, Long channelId){
		super(BotDisabledChannels.BOT_DISABLED_CHANNELS);

		setBotDisabledChannelId(botDisabledChannelId);
		setGuildId(guildId);
		setChannelId(channelId);
	}

	@Override
	public Record2<Long, Long> key(){
		return (Record2) super.key();
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
		return BotDisabledChannels.BOT_DISABLED_CHANNELS.BOT_DISABLED_CHANNEL_ID;
	}

	// -------------------------------------------------------------------------
	// Primary key information
	// -------------------------------------------------------------------------

	@Override
	public Field<Long> field2(){
		return BotDisabledChannels.BOT_DISABLED_CHANNELS.GUILD_ID;
	}

	// -------------------------------------------------------------------------
	// Record3 type implementation
	// -------------------------------------------------------------------------

	@Override
	public Field<Long> field3(){
		return BotDisabledChannels.BOT_DISABLED_CHANNELS.CHANNEL_ID;
	}

	@Override
	public Long value1(){
		return getBotDisabledChannelId();
	}

	@Override
	public Long value2(){
		return getGuildId();
	}

	@Override
	public Long value3(){
		return getChannelId();
	}

	@Override
	public BotDisabledChannelsRecord value1(Long value){
		setBotDisabledChannelId(value);
		return this;
	}

	@Override
	public BotDisabledChannelsRecord value2(Long value){
		setGuildId(value);
		return this;
	}

	@Override
	public BotDisabledChannelsRecord value3(Long value){
		setChannelId(value);
		return this;
	}

	@Override
	public BotDisabledChannelsRecord values(Long value1, Long value2, Long value3){
		value1(value1);
		value2(value2);
		value3(value3);
		return this;
	}

	@Override
	public Long component1(){
		return getBotDisabledChannelId();
	}

	/**
	 * Getter for <code>public.bot_disabled_channels.bot_disabled_channel_id</code>.
	 */
	public Long getBotDisabledChannelId(){
		return (Long) get(0);
	}

	/**
	 * Setter for <code>public.bot_disabled_channels.bot_disabled_channel_id</code>.
	 */
	public BotDisabledChannelsRecord setBotDisabledChannelId(Long value){
		set(0, value);
		return this;
	}

	@Override
	public Long component2(){
		return getGuildId();
	}

	/**
	 * Getter for <code>public.bot_disabled_channels.guild_id</code>.
	 */
	public Long getGuildId(){
		return (Long) get(1);
	}

	/**
	 * Setter for <code>public.bot_disabled_channels.guild_id</code>.
	 */
	public BotDisabledChannelsRecord setGuildId(Long value){
		set(1, value);
		return this;
	}

	@Override
	public Long component3(){
		return getChannelId();
	}

	// -------------------------------------------------------------------------
	// Constructors
	// -------------------------------------------------------------------------

	/**
	 * Getter for <code>public.bot_disabled_channels.channel_id</code>.
	 */
	public Long getChannelId(){
		return (Long) get(2);
	}

	/**
	 * Setter for <code>public.bot_disabled_channels.channel_id</code>.
	 */
	public BotDisabledChannelsRecord setChannelId(Long value){
		set(2, value);
		return this;
	}

}
