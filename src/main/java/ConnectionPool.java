import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConnectionPool {

    private static ConnectionPool connectionPool;
    private final String DB = "database2";
    private static int contAmount = 0;
    private static final int MAX_CONNECTIONS = 5;
    private static List<Connection> connections = new ArrayList<>(MAX_CONNECTIONS);

    private ConnectionPool() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public static ConnectionPool getInstance() {
        if (connectionPool == null) {
            connectionPool = new ConnectionPool();
            return connectionPool;
        }
        return connectionPool;
    }


    public synchronized Connection getConnection() throws SQLException {
        Connection conn = null;
        if (connections.isEmpty()) {
            try {
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/database2","root","admin");
                connections.add(conn);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return connections.stream().findFirst().get();
        } else if (contAmount == MAX_CONNECTIONS) {
            for (int i = 0; i < MAX_CONNECTIONS; i++) {
                try {
                    Thread.sleep(800);
                    if (!connections.isEmpty()) {
                        return connections.stream().findFirst().get();
                    }
                } catch (InterruptedException e) {
                    // log.error("Thread error" + e.getStackTrace());
                }
            }
            throw new RuntimeException("");
        } else {
            contAmount++;
            return conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/MySQL80" + "user=root & password=admin");
        }
    }
    public synchronized void returnConnection(Connection connection) {
        connections.add(connection);
    }

    public static void getBack(Connection connection) {
        connections.add(connection);
    }

}
