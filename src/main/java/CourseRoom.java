public class CourseRoom {
    String roomName;
    int roomCapacity;
    int roomIsBusy;
    int id;

    public CourseRoom(String roomName, int roomCapacity, int roomIsBusy, int id) {
        this.roomName = roomName;
        this.roomCapacity = roomCapacity;
        this.roomIsBusy = roomIsBusy; // by default it's not busy
        this.id = id;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public int getRoomCapacity() {
        return roomCapacity;
    }

    public void setRoomCapacity(int roomCapacity) {
        this.roomCapacity = roomCapacity;
    }

    public int getRoomIsBusy() {
        return roomIsBusy;
    }

    public void setRoomIsBusy(int roomIsBusy) {
        this.roomIsBusy = roomIsBusy;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "CourseRoom{" +
                "roomName='" + roomName + '\'' +
                ", roomCapacity=" + roomCapacity +
                ", roomIsBusy=" + roomIsBusy +
                ", id=" + id +
                '}';
    }
}
