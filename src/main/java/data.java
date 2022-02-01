import binary.*;

import java.util.ArrayList;
import java.util.Arrays;

public class data {

        private ArrayList<Room> rooms;
        private ArrayList<Course> courses;
        private ArrayList<Department> depts;
        private ArrayList<Instructor> instructors;
        private ArrayList<MeetingTime> meetingTimes;
        private int numberOfClasses = 0;

        public data() {
            this.initialize();
        }

        private data initialize() {
            Room room1 = new Room("R1", 25);
            Room room2 = new Room("R2", 45);
            Room room3 = new Room("R3", 35);
            Room room4 = new Room("R4", 30);
            Room room5 = new Room("R5", 35);
            Room room6 = new Room("R6", 40);
            this.rooms = new ArrayList(Arrays.asList(room1, room2, room3, room4, room5, room6));
            MeetingTime meetingTime1 = new MeetingTime("M1", "Monday 08:00 - 9:30");
            MeetingTime meetingTime2 = new MeetingTime("M2", "Monday 9:30 - 11:00");
            MeetingTime meetingTime3 = new MeetingTime("M3", "Monday 11:30 - 13:00");
            MeetingTime meetingTime4 = new MeetingTime("T1", "Tuesday 8:00 - 9:30");
            MeetingTime meetingTime5 = new MeetingTime("M2", "Tuesday 9:30 - 11:00");
            MeetingTime meetingTime6 = new MeetingTime("T3", "Tuesday 11:30 - 13:00");
            MeetingTime meetingTime7 = new MeetingTime("W1", "Wednesday 8:00 - 9:30");
            MeetingTime meetingTime8 = new MeetingTime("W2", "Wednesday 9:30 - 11:00");
            MeetingTime meetingTime9 = new MeetingTime("W3", "Wednesday 11:30 - 13:00");
            MeetingTime meetingTime10 = new MeetingTime("TH1", "Thursday 8:00 - 9:30");
            MeetingTime meetingTime11 = new MeetingTime("TH2", "Thursday 9:30 - 11:00");
            MeetingTime meetingTime12 = new MeetingTime("TH3", "Thursday 11:30 - 13:00");
            MeetingTime meetingTime13 = new MeetingTime("F1", "Friday 8:00 - 9:30");
            MeetingTime meetingTime14 = new MeetingTime("F2", "Friday 9:30 - 11:00");
            MeetingTime meetingTime15 = new MeetingTime("F3", "Friday 11:30 - 13:00");
            this.meetingTimes = new ArrayList(Arrays.asList(meetingTime1, meetingTime2, meetingTime3, meetingTime4, meetingTime5, meetingTime6, meetingTime7, meetingTime8, meetingTime9, meetingTime10, meetingTime11, meetingTime12, meetingTime13, meetingTime14, meetingTime15));
            Instructor instructor1 = new Instructor("I1", "Diego Alegre");
            Instructor instructor2 = new Instructor("I2", "Romina Alegre");
            Instructor instructor3 = new Instructor("I3", "Camila Kusnier");
            Instructor instructor4 = new Instructor("I4", "Nicolas Costurie");
            Instructor instructor5 = new Instructor("I5", "Pablo Perez");
            Instructor instructor6 = new Instructor("I6", "Walter Acevedo");
            Instructor instructor7 = new Instructor("I7", "Carlos Gonzalez");
            this.instructors = new ArrayList(Arrays.asList(instructor1, instructor2, instructor3, instructor4, instructor5, instructor6, instructor7));
            Course course1 = new Course("C1", "325K", new ArrayList(Arrays.asList(instructor1, instructor2)), 25);
            Course course2 = new Course("C2", "319K", new ArrayList(Arrays.asList(instructor6, instructor2, instructor3)), 35);
            Course course3 = new Course("C3", "462K", new ArrayList(Arrays.asList(instructor7, instructor2)), 25);
            Course course4 = new Course("C4", "464K", new ArrayList(Arrays.asList(instructor3, instructor4)), 30);
            Course course5 = new Course("C5", "360C", new ArrayList(Arrays.asList(instructor4)), 35);
            Course course6 = new Course("C6", "303K", new ArrayList(Arrays.asList(instructor1, instructor6)), 45);
            Course course7 = new Course("C7", "303L", new ArrayList(Arrays.asList(instructor3, instructor5)), 45);
            this.courses = new ArrayList(Arrays.asList(course1, course2, course3, course4, course5, course6, course7));
            Department dept1 = new Department("MATHS    ", new ArrayList(Arrays.asList(course1, course3, course2, course4)));
            Department dept2 = new Department("GEOGRAPHY", new ArrayList(Arrays.asList(course2, course4, course5)));
            Department dept3 = new Department("SPANISH  ", new ArrayList(Arrays.asList(course6, course7)));
            Department dept4 = new Department("ART      ", new ArrayList(Arrays.asList(course3, course7, course1)));
            Department dept5 = new Department("HISTORY  ", new ArrayList(Arrays.asList(course4, course5, course3)));
            Department dept6 = new Department("MUSIC    ", new ArrayList(Arrays.asList(course1, course5, course6)));
            this.depts = new ArrayList(Arrays.asList(dept1, dept2, dept3, dept4, dept5, dept6));
            this.depts.forEach((x) -> {
                this.numberOfClasses += x.getCourses().size();
            });
            return this;
        }

        public ArrayList<Room> getRooms() {
            return this.rooms;
        }

        public ArrayList<Course> getCourses() {
            return this.courses;
        }

        public ArrayList<Department> getDepts() {
            return this.depts;
        }

        public ArrayList<Instructor> getInstructors() {
            return this.instructors;
        }

        public ArrayList<MeetingTime> getMeetingTimes() {
            return this.meetingTimes;
        }

        public int getNumberOfClasses() {
            return this.numberOfClasses;
        }
    }

