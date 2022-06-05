public class Teacher {
    String name;
    int noOfSubjects;

    public Teacher() {
        this.name = "";
        this.noOfSubjects = 0;
    }
    public Teacher(String name, int noOfSubjects) {
        this.name = name;
        this.noOfSubjects = noOfSubjects;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNoOfSubjects() {
        return noOfSubjects;
    }

    public void setNoOfSubjects(int noOfSubjects) {
        this.noOfSubjects = noOfSubjects;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", noOfSubjects=" + noOfSubjects +
                '}';
    }
}
