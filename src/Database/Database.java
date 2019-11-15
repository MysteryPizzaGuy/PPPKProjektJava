package Database;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class Database {
    public static String connstring;
    public abstract Connection CreateConnection() throws SQLException;



}
