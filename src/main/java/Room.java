public class Room {
    String roomName;
    int roomCapacity;
    int roomIsBusy;

    public Room() {
        this.roomName = "hello";
        this.roomCapacity = 0;
        this.roomIsBusy = 0; // by default it's not busy
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

    @Override
    public String toString() {
        return "Room{" +
                "roomName='" + roomName + '\'' +
                ", roomCapacity=" + roomCapacity +
                ", roomIsBusy=" + roomIsBusy +
                '}';
    }
}
