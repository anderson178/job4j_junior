package ru.job4j.tracker.sql;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionRollback {
    public static final Logger LOG = LoggerFactory.getLogger(TrackerSQL.class.getName());

    /**
     * Create connection with autocommit=false mode and rollback call, when conneciton is closed.
     *
     * @param connection connection.
     * @return Connection object.
     * @throws SQLException possible exception.
     */
    public static Connection create(Connection connection) {
        try {
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
        return (Connection) Proxy.newProxyInstance(
                ConnectionRollback.class.getClassLoader(),
                new Class[]{Connection.class},
                (proxy, method, args) -> {
                    Object rsl = null;
                    if ("close".equals(method.getName())) {
                        connection.rollback();
                        connection.close();
                    } else {
                        rsl = method.invoke(connection, args);
                    }
                    return rsl;
                }
        );
    }
}
