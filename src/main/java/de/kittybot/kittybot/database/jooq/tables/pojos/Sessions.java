/*
 * This file is generated by jOOQ.
 */
package de.kittybot.kittybot.database.jooq.tables.pojos;


import java.io.Serializable;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Sessions implements Serializable {

    private static final long serialVersionUID = 1175759351;

    private final String sessionId;
    private final String userId;

    public Sessions(Sessions value) {
        this.sessionId = value.sessionId;
        this.userId = value.userId;
    }

    public Sessions(
        String sessionId,
        String userId
    ) {
        this.sessionId = sessionId;
        this.userId = userId;
    }

    public String getSessionId() {
        return this.sessionId;
    }

    public String getUserId() {
        return this.userId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Sessions (");

        sb.append(sessionId);
        sb.append(", ").append(userId);

        sb.append(")");
        return sb.toString();
    }
}
