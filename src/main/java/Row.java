public class Row {
    String teacher;
    String subject;
    int isCourse;
    String dayOfWeek;
    int startTime;
    String serie;
    String group;

    public Row() {
        this.teacher = "";
        this.subject = "";
        this.isCourse = 0;
        this.dayOfWeek = "";
        this.startTime = 0;
        this.serie = "";
        this.group = "";
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getIsCourse() {
        return isCourse;
    }

    public void setIsCourse(int isCourse) {
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

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return "Row{" +
                "teacher='" + teacher + '\'' +
                ", subject='" + subject + '\'' +
                ", isCourse=" + isCourse +
                ", dayOfWeek='" + dayOfWeek + '\'' +
                ", startTime=" + startTime +
                ", serie='" + serie + '\'' +
                ", group='" + group + '\'' +
                '}';
    }
}
