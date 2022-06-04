import java.sql.*;
import java.util.ArrayList;

public class Algorithm{
    String url = "jdbc:mysql://localhost:3306/university_resources_v_one";
    String username = "radu";
    String password = "mysqlradu";
    CourseRoom aCourseRoom;
    LaboratoryRoom aLabRoom;
    Class aClass;
    ArrayList<CourseRoom> allCourseRooms = new ArrayList<>();
    ArrayList<LaboratoryRoom> allLabRooms = new ArrayList<>();
    ArrayList<Class> allClasses = new ArrayList<>();
    String[] daysOfWeek = {"MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY"};

    public Algorithm(){
        System.out.println("Am creat o instanta a clasei Algorithm.");
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

    private void readClasses(String day) {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            if(day.equals(daysOfWeek[0])) // extract classes on Monday
            {
                Statement readClasses = connection.createStatement();
                ResultSet resultClasses = readClasses.executeQuery("select * from classes where DAYOFWEEK LIKE '%MONDAY%' order by STARTTIME");
                int totalClasses = 0;
                while (resultClasses.next()) {
                    aClass = new Class(resultClasses.getInt("ID"), resultClasses.getString("NAME"), resultClasses.getString("TEACHER"), resultClasses.getString("isCOURSE"), resultClasses.getString("DAYOFWEEK"), resultClasses.getInt("STARTTIME"), resultClasses.getString("SERIE"), resultClasses.getString("GROUP"));
                    totalClasses++;
                    allClasses.add(aClass);
                }

                System.out.println("\n\nMonday classes: \n");
                printClassesOfADay(totalClasses);

                assignRoomsToClassesOfADay();

                /* to be deleted */
                printScheduleOfADay();

                readClasses("TUESDAY");
            }
            if(day.equals(daysOfWeek[1]))
            {
                System.out.println("Pe marti:");

                readClasses("WEDNESDAY");
            }
            if(day.equals(daysOfWeek[2]))
            {
                System.out.println("Pe miercuri");

                readClasses("THURSDAY");
            }
            if(day.equals(daysOfWeek[3]))
            {
                System.out.println("Pe joi:");

                readClasses("FRIDAY");
            }
            if(day.equals(daysOfWeek[4]))
            {
                System.out.println("Pe vineri:");
            }
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect to database!", e);
        }
    }


    /* to be deleted - prints class before assigning rooms */
    private void printClassesOfADay(int totalClasses) {
        System.out.println("Total classes identified: " + totalClasses);
        for(int index = 0; index < totalClasses; index++)
            System.out.println(allClasses.get(index).toString());
    }

    // main algorithm; uses: checkForFree(Course/Lab)Rooms() , checkIf(Course/Lab)AndAssignRoom, (course/lab)RoomsAvailableAgain()
    private void assignRoomsToClassesOfADay() {
        for(int index = 0; index < allClasses.size() - 1; index++) {
            // same hour
            if(allClasses.get(index).getStartTime() == allClasses.get(index+1).getStartTime())
            {
                // check for a free specific room to assign it to the course
                checkIfCourseAndAssignRoom(index);
                // check for a free specific room to assign it to the lab
                checkIfLabAndAssignRoom(index);

                if(index == allClasses.size() - 2)
                {
                    checkIfCourseAndAssignRoom(index+1);
                    checkIfLabAndAssignRoom(index+1);
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

                if(index == allClasses.size() - 2)
                {
                    checkIfCourseAndAssignRoom(index+1);
                    checkIfLabAndAssignRoom(index+1);
                    courseRoomsAvilableAgain();
                    labRoomsAvailableAgain();
                }
            }
        }
    }

    /* to be deleted - prints class with the assigned rooms */
    private void printScheduleOfADay() {
        System.out.println("\nSchedule:");
        for(int index = 0; index < allClasses.size(); index++)
            System.out.println(allClasses.get(index).toString());
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
        if(allClasses.get(index).getIsCourse().equals("YES"))
        {
            allClasses.get(index).setRoomName(checkForFreeCourseRooms());
            if(allClasses.get(index).getRoomName().equals(""))
            {
                System.out.println("No more rooms are available. Too many courses at the same time for this room configuration");
            }
        }
    }
    // returns a course room
    private String checkForFreeCourseRooms() {
        for(int index = 0; index < allCourseRooms.size(); index++)
            if(allCourseRooms.get(index).getRoomIsBusy() == 0)
            {
                allCourseRooms.get(index).setRoomIsBusy(1);
                return allCourseRooms.get(index).getRoomName();
            }
        return "";
    }
    // updates every course room as 'available'
    private void courseRoomsAvilableAgain() {
        for(int index = 0; index < allCourseRooms.size(); index++)
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
        if(!allClasses.get(index).getIsCourse().equals("YES"))
        {
            allClasses.get(index).setRoomName(checkForFreeLabRooms());
            if(allClasses.get(index).getRoomName().equals(""))
            {
                System.out.println("No more rooms are available. Too many laboratories at the same time for this room configuation");
            }
        }
    }
    // returns a lab room
    private String checkForFreeLabRooms() {
        for(int index = 0; index < allLabRooms.size(); index++)
            if(allLabRooms.get(index).getRoomIsBusy() == 0)
            {
                allLabRooms.get(index).setRoomIsBusy(1);
                return allLabRooms.get(index).getRoomName();
            }
        return "";
    }
    // updates every lab room as 'available'
    private void labRoomsAvailableAgain() {
        for(int index = 0; index < allLabRooms.size(); index++)
            allLabRooms.get(index).setRoomIsBusy(0);
    }

}
