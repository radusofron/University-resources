import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class DatabaseWriteRooms {
    String url = "jdbc:mysql://localhost:3306/university_resources_v_one";
    String username = "radu";
    String password = "mysqlradu";

    public DatabaseWriteRooms(ArrayList<String> roomsName, int[] roomCapacities, int[] roomsAreBusy, int[] roomsId){
        System.out.println("Connecting to database...");
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Database connection has been established!");

            String insertRoom = "insert into rooms (Name, Capacity, isBusy, ID)" + " values(?, ?, ?, ?)";
            for(int index = 0; index < VersionOneConfigurationPanel.numberOfRooms; index++)
            {
                System.out.println(roomsName.get(index));
                System.out.println(roomCapacities[index]);
                System.out.println(roomsAreBusy[index]);
                System.out.println(roomsId[index]);

                // put those attributes in a MySQL statement in order to be written in that database
                PreparedStatement statementToBeWritten = connection.prepareStatement(insertRoom);
                statementToBeWritten.setString(1, roomsName.get(index));
                statementToBeWritten.setInt(2, roomCapacities[index]);
                statementToBeWritten.setInt(3, roomsAreBusy[index]);
                statementToBeWritten.setInt(4,roomsId[index]);

                statementToBeWritten.execute();
            }

        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect to database!", e);
        }
    }
}
