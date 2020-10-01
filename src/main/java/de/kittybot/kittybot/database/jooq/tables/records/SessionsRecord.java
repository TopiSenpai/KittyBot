/*
 * This file is generated by jOOQ.
 */
package de.kittybot.kittybot.database.jooq.tables.records;


import de.kittybot.kittybot.database.jooq.tables.Sessions;

import java.time.LocalDateTime;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record5;
import org.jooq.Row5;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class SessionsRecord extends UpdatableRecordImpl<SessionsRecord> implements Record5<String, String, String, String, LocalDateTime> {

    private static final long serialVersionUID = 1673999799;

    /**
     * Setter for <code>public.sessions.session_id</code>.
     */
    public SessionsRecord setSessionId(String value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>public.sessions.session_id</code>.
     */
    public String getSessionId() {
        return (String) get(0);
    }

    /**
     * Setter for <code>public.sessions.user_id</code>.
     */
    public SessionsRecord setUserId(String value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>public.sessions.user_id</code>.
     */
    public String getUserId() {
        return (String) get(1);
    }

    /**
     * Setter for <code>public.sessions.access_token</code>.
     */
    public SessionsRecord setAccessToken(String value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>public.sessions.access_token</code>.
     */
    public String getAccessToken() {
        return (String) get(2);
    }

    /**
     * Setter for <code>public.sessions.refresh_token</code>.
     */
    public SessionsRecord setRefreshToken(String value) {
        set(3, value);
        return this;
    }

    /**
     * Getter for <code>public.sessions.refresh_token</code>.
     */
    public String getRefreshToken() {
        return (String) get(3);
    }

    /**
     * Setter for <code>public.sessions.expiration</code>.
     */
    public SessionsRecord setExpiration(LocalDateTime value) {
        set(4, value);
        return this;
    }

    /**
     * Getter for <code>public.sessions.expiration</code>.
     */
    public LocalDateTime getExpiration() {
        return (LocalDateTime) get(4);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<String> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record5 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row5<String, String, String, String, LocalDateTime> fieldsRow() {
        return (Row5) super.fieldsRow();
    }

    @Override
    public Row5<String, String, String, String, LocalDateTime> valuesRow() {
        return (Row5) super.valuesRow();
    }

    @Override
    public Field<String> field1() {
        return Sessions.SESSIONS.SESSION_ID;
    }

    @Override
    public Field<String> field2() {
        return Sessions.SESSIONS.USER_ID;
    }

    @Override
    public Field<String> field3() {
        return Sessions.SESSIONS.ACCESS_TOKEN;
    }

    @Override
    public Field<String> field4() {
        return Sessions.SESSIONS.REFRESH_TOKEN;
    }

    @Override
    public Field<LocalDateTime> field5() {
        return Sessions.SESSIONS.EXPIRATION;
    }

    @Override
    public String component1() {
        return getSessionId();
    }

    @Override
    public String component2() {
        return getUserId();
    }

    @Override
    public String component3() {
        return getAccessToken();
    }

    @Override
    public String component4() {
        return getRefreshToken();
    }

    @Override
    public LocalDateTime component5() {
        return getExpiration();
    }

    @Override
    public String value1() {
        return getSessionId();
    }

    @Override
    public String value2() {
        return getUserId();
    }

    @Override
    public String value3() {
        return getAccessToken();
    }

    @Override
    public String value4() {
        return getRefreshToken();
    }

    @Override
    public LocalDateTime value5() {
        return getExpiration();
    }

    @Override
    public SessionsRecord value1(String value) {
        setSessionId(value);
        return this;
    }

    @Override
    public SessionsRecord value2(String value) {
        setUserId(value);
        return this;
    }

    @Override
    public SessionsRecord value3(String value) {
        setAccessToken(value);
        return this;
    }

    @Override
    public SessionsRecord value4(String value) {
        setRefreshToken(value);
        return this;
    }

    @Override
    public SessionsRecord value5(LocalDateTime value) {
        setExpiration(value);
        return this;
    }

    @Override
    public SessionsRecord values(String value1, String value2, String value3, String value4, LocalDateTime value5) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached SessionsRecord
     */
    public SessionsRecord() {
        super(Sessions.SESSIONS);
    }

    /**
     * Create a detached, initialised SessionsRecord
     */
    public SessionsRecord(String sessionId, String userId, String accessToken, String refreshToken, LocalDateTime expiration) {
        super(Sessions.SESSIONS);

        set(0, sessionId);
        set(1, userId);
        set(2, accessToken);
        set(3, refreshToken);
        set(4, expiration);
    }
}
