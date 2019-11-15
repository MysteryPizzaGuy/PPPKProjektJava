package Database;

import com.microsoft.sqlserver.jdbc.SQLServerDriver;

public class DatabaseFactory {
    public static String connectionstring= "jdbc:sqlserver://ANDROMEDA\\SQLEXPRESS;databaseName=VehicleControl;user=sa;password=SQL;";
    public DatabaseFactory() {

    }
    public static Database CreateDatabase(){
        Database base = new SQLServerDatabase();
        SQLServerDatabase.connstring=connectionstring;
        return base;
    }
}
