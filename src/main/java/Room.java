public class Room {
    String roomName;
    int roomCapacity;
    int roomIsBusy;
    int id;

    public Room() {
        this.roomName = "";
        this.roomCapacity = 0;
        this.roomIsBusy = 0; // by default it's not busy
        this.id = 0;
    }

    public Room(String roomName, int roomCapacity, int roomIsBusy) {
        this.roomName = roomName;
        this.roomCapacity = roomCapacity;
        this.roomIsBusy = roomIsBusy; // by default it's not busy
        this.id = 0;
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
        return "Room{" +
                "roomName='" + roomName + '\'' +
                ", roomCapacity=" + roomCapacity +
                ", roomIsBusy=" + roomIsBusy +
                ", id=" + id +
                '}';
    }
}
