public class Class {
    int id;
    String name;
    String teacher;
    String isCourse;
    String dayOfWeek;
    int startTime;
    String serie;
    String group;
    String roomName;

    public Class(int id, String name, String teacher, String isCourse, String dayOfWeek, int startTime, String serie, String group) {
        this.id = id;
        this.name = name;
        this.teacher = teacher;
        this.isCourse = isCourse;
        this.dayOfWeek = dayOfWeek;
        this.startTime = startTime;
        this.serie = serie;
        this.group = group;
        this.roomName = "";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIsCourse() {
        return isCourse;
    }

    public void setIsCourse(String isCourse) {
        this.isCourse = isCourse;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    @Override
    public String toString() {
        return "Class{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", teacher='" + teacher + '\'' +
                ", isCourse='" + isCourse + '\'' +
                ", dayOfWeek='" + dayOfWeek + '\'' +
                ", startTime=" + startTime +
                ", serie='" + serie + '\'' +
                ", group='" + group + '\'' +
                ", roomName='" + roomName + '\'' +
                '}';
    }
}
