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
            readCoureRooms();
            readLabRooms();

            // read classes of every day of the week and create the schedule; it started with Monday and then continue
            readClasses("MONDAY");

        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect to database!", e);
        }
    }

    private void readClasses(String day) {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            if(day.equals(daysOfWeek[0]))
            {
                System.out.println("Pe luni:");

                Statement readClasses = connection.createStatement();
                ResultSet resultClasses = readClasses.executeQuery("select * from classes where DAYOFWEEK LIKE '%MONDAY%' order by STARTTIME");
                System.out.println("\n\nMonday classes: \n");
                int totalClasses = 0;
                while (resultClasses.next()) {
                    aClass = new Class(resultClasses.getInt("ID"), resultClasses.getString("NAME"), resultClasses.getString("TEACHER"), resultClasses.getString("isCOURSE"), resultClasses.getString("DAYOFWEEK"), resultClasses.getInt("STARTTIME"), resultClasses.getString("SERIE"), resultClasses.getString("GROUP"));
                    totalClasses++;
                    allClasses.add(aClass);
                }
                System.out.println("Total classes identified: " + totalClasses);
                for(int index = 0; index < totalClasses; index++)
                    System.out.println(allClasses.get(index).toString());

                for(int index = 0; index < allClasses.size() - 1; index++) {
                    if(allClasses.get(index).getStartTime() == allClasses.get(index+1).getStartTime())
                    {
                        // same hour
                        //check what room to attribute
                        System.out.println("Same hour, different class");

                    }
                    else{
                        //stil same hour, but the next class wil be at another hour
                        //check what room to attribute

                        //if(index == allClases.size() -2)
                        //facem si pt index == allClasses.size()-1
                        System.out.println("A class at another hour will start from the next one");
                    }
                }

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

    private void readCoureRooms() {
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
}
