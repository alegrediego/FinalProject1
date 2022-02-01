package binary;

public class MeetingTime {
    private String id;

    public void setId(String id) {
        this.id = id;
    }

    public void setTime(String time) {
        this.time = time;
    }

    private String time;

    public MeetingTime(String id, String time) {
        this.id = id;
        this.time = time;
    }

    public MeetingTime(){};

    public String getId() {
        return this.id;
    }

    public String getTime() {
        return this.time;
    }
}

