/*
 * This file is generated by jOOQ.
 */
package de.kittybot.kittybot.database.jooq.tables;


import de.kittybot.kittybot.database.jooq.Keys;
import de.kittybot.kittybot.database.jooq.Public;
import de.kittybot.kittybot.database.jooq.tables.records.ReactiveMessagesRecord;
import org.jooq.Record;
import org.jooq.*;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;

import java.util.Arrays;
import java.util.List;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({"all", "unchecked", "rawtypes"})
public class ReactiveMessages extends TableImpl<ReactiveMessagesRecord>{

	/**
	 * The reference instance of <code>public.reactive_messages</code>
	 */
	public static final ReactiveMessages REACTIVE_MESSAGES = new ReactiveMessages();
	private static final long serialVersionUID = -356953133;
	/**
	 * The column <code>public.reactive_messages.channel_id</code>.
	 */
	public final TableField<ReactiveMessagesRecord, String> CHANNEL_ID = createField(DSL.name("channel_id"), org.jooq.impl.SQLDataType.VARCHAR(18).nullable(false), this, "");
	/**
	 * The column <code>public.reactive_messages.message_id</code>.
	 */
	public final TableField<ReactiveMessagesRecord, String> MESSAGE_ID = createField(DSL.name("message_id"), org.jooq.impl.SQLDataType.VARCHAR(18).nullable(false), this, "");
	/**
	 * The column <code>public.reactive_messages.user_id</code>.
	 */
	public final TableField<ReactiveMessagesRecord, String> USER_ID = createField(DSL.name("user_id"), org.jooq.impl.SQLDataType.VARCHAR(18).nullable(false), this, "");
	/**
	 * The column <code>public.reactive_messages.guild_id</code>.
	 */
	public final TableField<ReactiveMessagesRecord, String> GUILD_ID = createField(DSL.name("guild_id"), org.jooq.impl.SQLDataType.VARCHAR(18).nullable(false), this, "");
	/**
	 * The column <code>public.reactive_messages.command_id</code>.
	 */
	public final TableField<ReactiveMessagesRecord, String> COMMAND_ID = createField(DSL.name("command_id"), org.jooq.impl.SQLDataType.VARCHAR(18).nullable(false), this, "");
	/**
	 * The column <code>public.reactive_messages.command</code>.
	 */
	public final TableField<ReactiveMessagesRecord, String> COMMAND = createField(DSL.name("command"), org.jooq.impl.SQLDataType.VARCHAR(18).nullable(false), this, "");
	/**
	 * The column <code>public.reactive_messages.allowed</code>.
	 */
	public final TableField<ReactiveMessagesRecord, String> ALLOWED = createField(DSL.name("allowed"), org.jooq.impl.SQLDataType.VARCHAR(18).nullable(false), this, "");

	/**
	 * Create a <code>public.reactive_messages</code> table reference
	 */
	public ReactiveMessages(){
		this(DSL.name("reactive_messages"), null);
	}

	private ReactiveMessages(Name alias, Table<ReactiveMessagesRecord> aliased){
		this(alias, aliased, null);
	}

	private ReactiveMessages(Name alias, Table<ReactiveMessagesRecord> aliased, Field<?>[] parameters){
		super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
	}

	/**
	 * Create an aliased <code>public.reactive_messages</code> table reference
	 */
	public ReactiveMessages(String alias){
		this(DSL.name(alias), REACTIVE_MESSAGES);
	}

	/**
	 * Create an aliased <code>public.reactive_messages</code> table reference
	 */
	public ReactiveMessages(Name alias){
		this(alias, REACTIVE_MESSAGES);
	}

	public <O extends Record> ReactiveMessages(Table<O> child, ForeignKey<O, ReactiveMessagesRecord> key){
		super(child, key, REACTIVE_MESSAGES);
	}

	@Override
	public ReactiveMessages as(String alias){
		return new ReactiveMessages(DSL.name(alias), this);
	}

	@Override
	public Schema getSchema(){
		return Public.PUBLIC;
	}

	@Override
	public UniqueKey<ReactiveMessagesRecord> getPrimaryKey(){
		return Keys.REACTIVE_MESSAGES_PKEY;
	}

	@Override
	public List<UniqueKey<ReactiveMessagesRecord>> getKeys(){
		return Arrays.<UniqueKey<ReactiveMessagesRecord>>asList(Keys.REACTIVE_MESSAGES_PKEY);
	}

	@Override
	public ReactiveMessages as(Name alias){
		return new ReactiveMessages(alias, this);
	}

	/**
	 * Rename this table
	 */
	@Override
	public ReactiveMessages rename(String name){
		return new ReactiveMessages(DSL.name(name), null);
	}

	/**
	 * Rename this table
	 */
	@Override
	public ReactiveMessages rename(Name name){
		return new ReactiveMessages(name, null);
	}

	/**
	 * The class holding records for this type
	 */
	@Override
	public Class<ReactiveMessagesRecord> getRecordType(){
		return ReactiveMessagesRecord.class;
	}

	// -------------------------------------------------------------------------
	// Row7 type methods
	// -------------------------------------------------------------------------

	@Override
	public Row7<String, String, String, String, String, String, String> fieldsRow(){
		return (Row7) super.fieldsRow();
	}

}
