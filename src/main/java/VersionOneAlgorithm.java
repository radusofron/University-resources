import java.awt.*;
import java.sql.*;
import java.util.ArrayList;

public class VersionOneAlgorithm {
    String url = "jdbc:mysql://localhost:3306/university_resources_v_one";
    String username = "radu";
    String password = "mysqlradu";
    CourseRoom aCourseRoom;
    LaboratoryRoom aLabRoom;
    VersionOneClass aClass;
    ArrayList<CourseRoom> allCourseRooms = new ArrayList<>();
    ArrayList<LaboratoryRoom> allLabRooms = new ArrayList<>();
    ArrayList<VersionOneClass> allClasses = new ArrayList<>();
    String[] daysOfWeek = {"MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY"};

    public VersionOneAlgorithm() {
        System.out.println("Starting the algorithm...");
    }

    public void startAlgorithm() {
        System.out.println("Connecting to database...");
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Database connection has been established!");

            // read rooms
            readCourseRooms();
            readLabRooms();

            // read classes of every day of the week and create the schedule; it started with Monday and then continue
            readClasses("MONDAY");

        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect to database!", e);
        }
    }

    // recursive function - reads classes of a day, one by one
    private void readClasses(String day) {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            if (day.equals(daysOfWeek[0])) // extract classes on Monday
            {
                Statement readClasses = connection.createStatement();
                ResultSet resultClasses = readClasses.executeQuery("select * from classes where DAYOFWEEK LIKE '%MONDAY%' order by STARTTIME");
                while (resultClasses.next()) {
                    aClass = new VersionOneClass(resultClasses.getInt("ID"), resultClasses.getString("NAME"), resultClasses.getString("TEACHER"), resultClasses.getString("isCOURSE"), resultClasses.getString("DAYOFWEEK"), resultClasses.getInt("STARTTIME"), resultClasses.getString("SERIE"), resultClasses.getString("GROUP"));
                    allClasses.add(aClass);
                }

                assignRoomsToClassesOfADay();

                addToJTable();

                // remove elements stored for this day
                for (int index = allClasses.size() - 1; index >= 0; index--)
                    allClasses.remove(index);

                readClasses("TUESDAY");
            }
            if (day.equals(daysOfWeek[1])) {
                Statement readClasses = connection.createStatement();
                ResultSet resultClasses = readClasses.executeQuery("select * from classes where DAYOFWEEK LIKE '%TUESDAY%' order by STARTTIME");
                int totalClasses = 0;
                while (resultClasses.next()) {
                    aClass = new VersionOneClass(resultClasses.getInt("ID"), resultClasses.getString("NAME"), resultClasses.getString("TEACHER"), resultClasses.getString("isCOURSE"), resultClasses.getString("DAYOFWEEK"), resultClasses.getInt("STARTTIME"), resultClasses.getString("SERIE"), resultClasses.getString("GROUP"));
                    totalClasses++;
                    allClasses.add(aClass);
                }

                assignRoomsToClassesOfADay();

                addToJTable();

                // remove elements stored for this day
                for (int index = allClasses.size() - 1; index >= 0; index--)
                    allClasses.remove(index);

                readClasses("WEDNESDAY");
            }
            if (day.equals(daysOfWeek[2])) {
                Statement readClasses = connection.createStatement();
                ResultSet resultClasses = readClasses.executeQuery("select * from classes where DAYOFWEEK LIKE '%WEDNESDAY%' order by STARTTIME");
                int totalClasses = 0;
                while (resultClasses.next()) {
                    aClass = new VersionOneClass(resultClasses.getInt("ID"), resultClasses.getString("NAME"), resultClasses.getString("TEACHER"), resultClasses.getString("isCOURSE"), resultClasses.getString("DAYOFWEEK"), resultClasses.getInt("STARTTIME"), resultClasses.getString("SERIE"), resultClasses.getString("GROUP"));
                    totalClasses++;
                    allClasses.add(aClass);
                }

                assignRoomsToClassesOfADay();

                addToJTable();

                // remove elements stored for this day
                for (int index = allClasses.size() - 1; index >= 0; index--)
                    allClasses.remove(index);
                readClasses("THURSDAY");
            }
            if (day.equals(daysOfWeek[3])) {
                Statement readClasses = connection.createStatement();
                ResultSet resultClasses = readClasses.executeQuery("select * from classes where DAYOFWEEK LIKE '%THURSDAY%' order by STARTTIME");
                int totalClasses = 0;
                while (resultClasses.next()) {
                    aClass = new VersionOneClass(resultClasses.getInt("ID"), resultClasses.getString("NAME"), resultClasses.getString("TEACHER"), resultClasses.getString("isCOURSE"), resultClasses.getString("DAYOFWEEK"), resultClasses.getInt("STARTTIME"), resultClasses.getString("SERIE"), resultClasses.getString("GROUP"));
                    totalClasses++;
                    allClasses.add(aClass);
                }

                assignRoomsToClassesOfADay();

                addToJTable();

                // remove elements stored for this day
                for (int index = allClasses.size() - 1; index >= 0; index--)
                    allClasses.remove(index);

                readClasses("FRIDAY");
            }
            if (day.equals(daysOfWeek[4])) {
                Statement readClasses = connection.createStatement();
                ResultSet resultClasses = readClasses.executeQuery("select * from classes where DAYOFWEEK LIKE '%FRIDAY%' order by STARTTIME");
                while (resultClasses.next()) {
                    aClass = new VersionOneClass(resultClasses.getInt("ID"), resultClasses.getString("NAME"), resultClasses.getString("TEACHER"), resultClasses.getString("isCOURSE"), resultClasses.getString("DAYOFWEEK"), resultClasses.getInt("STARTTIME"), resultClasses.getString("SERIE"), resultClasses.getString("GROUP"));
                    allClasses.add(aClass);
                }

                assignRoomsToClassesOfADay();

                addToJTable();

                // remove elements stored for this day
                for (int index = allClasses.size() - 1; index >= 0; index--)
                    allClasses.remove(index);

                // finally, remove rows from the database
                deleteRowsInRoomsTable();
            }
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect to database!", e);
        }
    }

    // main algorithm; uses: checkForFree(Course/Lab)Rooms() , checkIf(Course/Lab)AndAssignRoom, (course/lab)RoomsAvailableAgain()
    private void assignRoomsToClassesOfADay() {
        for (int index = 0; index < allClasses.size() - 1; index++) {
            // same hour
            if (allClasses.get(index).getStartTime() == allClasses.get(index + 1).getStartTime()) {
                // check for a free specific room to assign it to the course
                checkIfCourseAndAssignRoom(index);
                // check for a free specific room to assign it to the lab
                checkIfLabAndAssignRoom(index);

                if (index == allClasses.size() - 2) {
                    checkIfCourseAndAssignRoom(index + 1);
                    checkIfLabAndAssignRoom(index + 1);
                    courseRoomsAvilableAgain();
                    labRoomsAvailableAgain();
                }
            } //stil same hour, but the next class wil be at another hour
            else {
                // check for a free specific room to assign it to the course
                checkIfCourseAndAssignRoom(index);
                // check for a free specific room to assign it to the lab
                checkIfLabAndAssignRoom(index);
                // it will be another start time --> all the rooms will be available again
                courseRoomsAvilableAgain();
                labRoomsAvailableAgain();

                if (index == allClasses.size() - 2) {
                    checkIfCourseAndAssignRoom(index + 1);
                    checkIfLabAndAssignRoom(index + 1);
                    courseRoomsAvilableAgain();
                    labRoomsAvailableAgain();
                }
            }
        }
    }

    // add data to JTable
    private void addToJTable() {
        for (int index = 0; index < allClasses.size(); index++)
            VersionOneScheduleOutputPanel.model.addRow(new Object[]{allClasses.get(index).getName(), allClasses.get(index).getTeacher(), allClasses.get(index).getDayOfWeek(), allClasses.get(index).getStartTime(), allClasses.get(index).getSerie(), allClasses.get(index).getGroup(), allClasses.get(index).getRoomName()});
    }


    // reads every course room
    private void readCourseRooms() {
        // read course rooms
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            Statement readCourseRooms = connection.createStatement();
            ResultSet resultCourseRooms = readCourseRooms.executeQuery("select * from rooms where capacity > 40");
            int totalCourseRooms = 0;
            while (resultCourseRooms.next()) {
                aCourseRoom = new CourseRoom(resultCourseRooms.getString("NAME"), resultCourseRooms.getInt("CAPACITY"), resultCourseRooms.getInt("isBusy"), resultCourseRooms.getInt("ID"));
                totalCourseRooms++;
                allCourseRooms.add(aCourseRoom);
            }
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect to database!", e);
        }
    }

    // assigns to a course: a room
    private void checkIfCourseAndAssignRoom(int index) {
        if (allClasses.get(index).getIsCourse().equals("YES")) {
            allClasses.get(index).setRoomName(checkForFreeCourseRooms());
            if (allClasses.get(index).getRoomName().equals("")) {
                VersionOneIndicationPanel.indicationNo3.setForeground(Color.RED);
                VersionOneIndicationPanel.indicationNo3.setFont(new Font("Arial", Font.PLAIN, 17));
                VersionOneIndicationPanel.indicationNo3.setText("Error! Course rooms insufficients!");
            }
        }
    }

    // returns a course room
    private String checkForFreeCourseRooms() {
        for (int index = 0; index < allCourseRooms.size(); index++)
            if (allCourseRooms.get(index).getRoomIsBusy() == 0) {
                allCourseRooms.get(index).setRoomIsBusy(1);
                return allCourseRooms.get(index).getRoomName();
            }
        return "";
    }

    // updates every course room as 'available'
    private void courseRoomsAvilableAgain() {
        for (int index = 0; index < allCourseRooms.size(); index++)
            allCourseRooms.get(index).setRoomIsBusy(0);
    }

    // reads every lab room
    private void readLabRooms() {
        // read laboratories
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            Statement readLabs = connection.createStatement();
            ResultSet resultLabs = readLabs.executeQuery("select * from rooms where capacity <= 40");
            int totalLabRooms = 0;
            while (resultLabs.next()) {
                aLabRoom = new LaboratoryRoom(resultLabs.getString("NAME"), resultLabs.getInt("CAPACITY"), resultLabs.getInt("isBusy"), resultLabs.getInt("ID"));
                totalLabRooms++;
                allLabRooms.add(aLabRoom);
            }
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect to database!", e);
        }
    }

    // assigns to a lab: a room
    private void checkIfLabAndAssignRoom(int index) {
        if (!allClasses.get(index).getIsCourse().equals("YES")) {
            allClasses.get(index).setRoomName(checkForFreeLabRooms());
            if (allClasses.get(index).getRoomName().equals("")) {
                VersionOneIndicationPanel.indicationNo3.setForeground(Color.RED);
                VersionOneIndicationPanel.indicationNo3.setFont(new Font("Arial", Font.PLAIN, 17));
                VersionOneIndicationPanel.indicationNo3.setText("Error! Lab rooms insufficients!");
            }
        }
    }

    // returns a lab room
    private String checkForFreeLabRooms() {
        for (int index = 0; index < allLabRooms.size(); index++)
            if (allLabRooms.get(index).getRoomIsBusy() == 0) {
                allLabRooms.get(index).setRoomIsBusy(1);
                return allLabRooms.get(index).getRoomName();
            }
        return "";
    }

    // updates every lab room as 'available'
    private void labRoomsAvailableAgain() {
        for (int index = 0; index < allLabRooms.size(); index++)
            allLabRooms.get(index).setRoomIsBusy(0);
    }


    private void deleteRowsInRoomsTable() {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String query = "delete from rooms";
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.execute();
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect to database!", e);
        }

    }
}
