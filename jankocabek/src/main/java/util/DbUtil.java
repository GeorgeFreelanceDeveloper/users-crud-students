package util;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DbUtil {
    private static DataSource dataSource;

    public static Connection getConnection() throws SQLException {
        return getInstance().getConnection();
    }

    private static DataSource getInstance(){
        if (dataSource == null){
            try {
                final Context initContext = new InitialContext();
                final Context envContext = (Context) initContext.lookup("java:comp/env");
                dataSource = (DataSource) envContext.lookup("jdbc/users");
            } catch (final NamingException e) {
                e.printStackTrace(System.err);
            }
        }
        return dataSource;
    }
}

