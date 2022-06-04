import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class Algorithm {
    String url = "jdbc:mysql://localhost:3306/university_resources_v_one";
    String username = "radu";
    String password = "mysqlradu";
    String[] daysOfWeek = new String[]{"MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY"};
    Map<String, Integer> associateClassToRoom = new HashMap<>();
    Map<Integer, Boolean> roomNotUsedInAlgorithm = new HashMap<>();

    public Algorithm(){
        System.out.println("Am creat o instanta a clasei Algorithm.");
    }

    public void startAlgorithm() {
        System.out.println("Connecting to database...");
        try (Connection connection = DriverManager.getConnection(url, username, password)) {

            System.out.println("Database connection has been established!");

            // read from rooms only rooms which are laboratory
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select id, name, capacity from rooms where capacity <= 40");
            while (resultSet.next()) {
                System.out.println("\n");
                System.out.println(resultSet.getInt("id"));
                System.out.println(resultSet.getString("name"));
                System.out.println(resultSet.getInt("capacity"));
            }

            // daysOfWeek string is properly displayed - all good

            //read from courses just to see if it is working
            Statement readClasses = connection.createStatement();
            ResultSet resultClasses = readClasses.executeQuery("select id, name from classes where dayofweek LIKE 'MONDAY'");
            while (resultClasses.next()) {
                System.out.println("\nClasses:");
                System.out.println(resultClasses.getString("id"));
                System.out.println(resultClasses.getString("name"));
            }

//            //delete rooms after
//            Statement deleteRooms = connection.createStatement();
//            statement.executeQuery("TRUNCATE university_resources_v_one.rooms;");
        }
        catch (SQLException e) {
            throw new IllegalStateException("Cannot connect to database!", e);
        }
    }
}
