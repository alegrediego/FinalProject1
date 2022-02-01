package binary;

public class Room {
    private String number;

    public void setNumber(String number) {
        this.number = number;
    }

    public void setSeatingCapacity(int seatingCapacity) {
        this.seatingCapacity = seatingCapacity;
    }

    private int seatingCapacity;

    public Room(String number, int seatingCapacity) {
        this.number = number;
        this.seatingCapacity = seatingCapacity;
    }

    public String getNumber() {
        return this.number;
    }

    public int getSeatingCapacity() {
        return this.seatingCapacity;
    }

    public Room(){};
}
