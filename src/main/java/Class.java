public class Class {
    int id;
    String teacher;
    String isCourse;
    String dayOfWeek;
    String timeOfWeek;
    int startTime;
    String serie;
    String group;

    public Class(int id, String teacher, String isCourse, String dayOfWeek, String timeOfWeek, int startTime, String serie, String group) {
        this.id = id;
        this.teacher = teacher;
        this.isCourse = isCourse;
        this.dayOfWeek = dayOfWeek;
        this.timeOfWeek = timeOfWeek;
        this.startTime = startTime;
        this.serie = serie;
        this.group = group;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIsCourse() {
        return isCourse;
    }

    public void setIsCourse(String isCourse) {
        this.isCourse = isCourse;
    }

    public String getTimeOfWeek() {
        return timeOfWeek;
    }

    public void setTimeOfWeek(String timeOfWeek) {
        this.timeOfWeek = timeOfWeek;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    @Override
    public String toString() {
        return "Class{" +
                "id=" + id +
                ", teacher='" + teacher + '\'' +
                ", isCourse='" + isCourse + '\'' +
                ", dayOfWeek='" + dayOfWeek + '\'' +
                ", timeOfWeek='" + timeOfWeek + '\'' +
                ", startTime=" + startTime +
                ", serie='" + serie + '\'' +
                ", group='" + group + '\'' +
                '}';
    }
}
