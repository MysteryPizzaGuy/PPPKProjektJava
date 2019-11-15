package Database;

public class DataWorker {
    public static Database get_database() {
        return _database;
    }

    protected static Database _database =null;

    public DataWorker() {
            _database = DatabaseFactory.CreateDatabase();

    }
}
