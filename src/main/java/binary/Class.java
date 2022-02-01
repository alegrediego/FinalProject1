package binary;

public class Class {
    private int id;
    private Department dept;
    private Course course;
    private Instructor instructor;
    private MeetingTime meetingTime;
    private Room room;

    public Class(int id, Department dept, Course course) {
        this.id = id;
        this.course = course;
        this.dept = dept;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public void setMeetingTime(MeetingTime meetingTime) {
        this.meetingTime = meetingTime;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public int getId() {
        return this.id;
    }

    public Department getDept() {
        return this.dept;
    }

    public Course getCourse() {
        return this.course;
    }

    public Instructor getInstructor() {
        return this.instructor;
    }

    public MeetingTime getMeetingTime() {
        return this.meetingTime;
    }

    public Room getRoom() {
        return this.room;
    }

    public String toString() {
        String var10000 = this.dept.getName();
        return "[" + var10000 + "," + this.course.getNumber() + "," + this.room.getNumber() + "," + this.instructor.getId() + "," + this.meetingTime.getId() + "]";
    }
}
