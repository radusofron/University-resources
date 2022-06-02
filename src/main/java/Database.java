import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Database {
    String url = "jdbc:mysql://localhost:3306/university_resources_v_one";
    String username = "radu";
    String password = "mysqlradu";

    public Database(Room[] roomsFromInput){
        System.out.println("Connecting to the database...");
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Database connection has been established!");

            String insertRoom = "insert into rooms (Name, Capacity, isBusy)" + " values(?, ?, ?)";
            for(int index = 0; index < VersionOneConfigurationPanel.numberOfRooms; index++)
            {
                System.out.println(roomsFromInput[index]);
                System.out.println(roomsFromInput[index]);
                System.out.println(roomsFromInput[index]);

                // put those attributes in a MySQL statement in order to be written in that database
                PreparedStatement statementToBeWritten = connection.prepareStatement(insertRoom);
                System.out.println(insertRoom);
                statementToBeWritten.setString(1, roomsFromInput[index].getRoomName());
                statementToBeWritten.setInt(2, roomsFromInput[index].getRoomCapacity());
                statementToBeWritten.setInt(3, roomsFromInput[index].getRoomIsBusy());

                statementToBeWritten.execute();
            }

        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect to the database!", e);
        }
    }
}
