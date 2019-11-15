package Database;

import java.sql.*;

public class SQLServerDatabase extends Database {


    @Override
    public Connection CreateConnection() throws SQLException {
        return DriverManager.getConnection(connstring);
    }

}
