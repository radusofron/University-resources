import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

public class VersionTwoAlgorithm {
    String url = "jdbc:mysql://localhost:3306/university_resources_v_two";
    String username = "radu";
    String password = "mysqlradu";
    int[] startTimes = new int[]{8, 10, 12, 14,16,18};
    String[] daysOfWeek = new String[]{"MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY"};

    public VersionTwoAlgorithm() {
        System.out.println("Starting the algorithm...");
    }

    public void startAlgorithm(){


            Random random = new Random();
            int startTimesIndex;
            int daysOfWeekIndex;
            boolean isOkay = true;

            // algorithm
            for(int index = 0; index < VersionTwoMenuPanel.rows.size(); index++)
            {
                do {
                    isOkay = true;
                    startTimesIndex = random.nextInt(6);
                    daysOfWeekIndex = random.nextInt(5);

                    VersionTwoMenuPanel.rows.get(index).setDayOfWeek(daysOfWeek[daysOfWeekIndex]);
                    VersionTwoMenuPanel.rows.get(index).setStartTime(startTimes[startTimesIndex]);

                    for(int index2 = 0; index2 < VersionTwoMenuPanel.rows.size(); index2++)
                    {
                        // if are not the same row
                        if(VersionTwoMenuPanel.rows.get(index).getId() != VersionTwoMenuPanel.rows.get(index2).getId())
                        {
                            // if are at the same hour in the same day and is the same teacher, or the same group
                            if((VersionTwoMenuPanel.rows.get(index2).getStartTime() == startTimes[startTimesIndex]
                                    && VersionTwoMenuPanel.rows.get(index2).getDayOfWeek().equals(daysOfWeek[daysOfWeekIndex]))
                            && (VersionTwoMenuPanel.rows.get(index2).getTeacher().equals(VersionTwoMenuPanel.rows.get(index).getTeacher()) == true
                            || VersionTwoMenuPanel.rows.get(index2).getGroup().equals(VersionTwoMenuPanel.rows.get(index).getGroup()) == true))
                            {
                                isOkay = false;
                            }
                        }
                    }
                }while(isOkay == false);
                System.out.println("Random start time: " + startTimes[startTimesIndex]);
                System.out.println("Random day: " + daysOfWeek[daysOfWeekIndex]);
            }
            addToJTable();
           //writeClassesToDatabase(); -> didn't work
           VersionTwoBottomControlPanel.createBtn.setEnabled(false);
    }

    // add data to JTable
    private void addToJTable() {
        for (int index = 0; index < VersionTwoMenuPanel.rows.size(); index++)
            VersionTwoScheduleOutputPanel.model.addRow(new Object[]{VersionTwoMenuPanel.rows.get(index).getSubject(), VersionTwoMenuPanel.rows.get(index).getTeacher(), VersionTwoMenuPanel.rows.get(index).getDayOfWeek(), VersionTwoMenuPanel.rows.get(index).getStartTime(), VersionTwoMenuPanel.rows.get(index).getSerie(), VersionTwoMenuPanel.rows.get(index).getGroup()});
    }

    // write schedule to database
    private void writeClassesToDatabase() {
        System.out.println("Connecting to database...");
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Database connection has been established!");

            String insertRoom = "insert into mytable (ID, NAME, TEACHER, isCourse, DAYOFWEEK, STARTTIME, SERIE, GROUP)" + " values(?, ?, ?, ?, ?, ?, ?, ?)";
            for(int index = 0; index < VersionTwoMenuPanel.rows.size(); index++)
            {
                // put those attributes in a MySQL statement in order to be written in that database
                PreparedStatement statementToBeWritten = connection.prepareStatement(insertRoom);
                statementToBeWritten.setInt(1, VersionTwoMenuPanel.rows.get(index).getId());
                statementToBeWritten.setString(2, VersionTwoMenuPanel.rows.get(index).getSubject());
                statementToBeWritten.setString(3, VersionTwoMenuPanel.rows.get(index).getTeacher());
                statementToBeWritten.setInt(4, VersionTwoMenuPanel.rows.get(index).getIsCourse());
                statementToBeWritten.setString(5, VersionTwoMenuPanel.rows.get(index).getDayOfWeek());
                statementToBeWritten.setInt(6, VersionTwoMenuPanel.rows.get(index).getStartTime());
                statementToBeWritten.setString(7, VersionTwoMenuPanel.rows.get(index).getSerie());
                statementToBeWritten.setString(8, VersionTwoMenuPanel.rows.get(index).getGroup());

                statementToBeWritten.execute();
            }

        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect to database!", e);
        }
    }
}
