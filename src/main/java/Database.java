import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Database {
    String url = "jdbc:mysql://localhost:3306/university_resources_v_one";
    String username = "radu";
    String password = "mysqlradu";
    String roomName = "";
    int roomCapacity = 0;
    int roomIsBusy = 0;

    public Database(ArrayList<String> roomsName, int[] roomCapacities, int[] roomsAreBusy){
        System.out.println("Connecting to the database...");
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Database connection has been established!");

            String insertRoom = "insert into rooms (Name, Capacity, isBusy)" + " values(?, ?, ?)";
            for(int index = 0; index < VersionOneConfigurationPanel.numberOfRooms; index++)
            {
                // get every room attributes
                roomName = roomsName.get(index);
                roomCapacity = roomCapacities[index];
                roomIsBusy = roomsAreBusy[index];
                System.out.println(roomName);
                System.out.println(roomCapacity);
                System.out.println(roomIsBusy);

                // put those attributes in a MySQL statement in order to be written in that database
                PreparedStatement statementToBeWritten = connection.prepareStatement(insertRoom);
                System.out.println(insertRoom);
                statementToBeWritten.setString(1, roomName);
                statementToBeWritten.setInt(2, roomCapacity);
                statementToBeWritten.setInt(3, roomIsBusy);

                statementToBeWritten.execute();
            }

        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect to the database!", e);
        }
    }
}
