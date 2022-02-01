import java.util.ArrayList;
import binary.Department;
import binary.Course;
import binary.MeetingTime;
import binary.Instructor;
import binary.Room;
import binary.Class;

public class Schedule {
    private ArrayList<Class> classes;
    private boolean isFitnessChanged = true;
    private double fitness = -1.0D;
    private int classNumb = 0;
    private int numbOfConflicts = 0;
    private data data;

    public ArrayList<Class> getClasses() {
        return this.classes;
    }

    public data getData() {
        return this.data;
    }

    public Schedule(data data) {
        this.data = data;
        this.classes = new ArrayList(data.getNumberOfClasses());
    }

    public Schedule initialize() {
             new ArrayList<Department>(data.getDepts()).forEach((dept) -> {
                dept.getCourses().forEach((course) -> {
                Class newClass = new Class(this.classNumb++, dept, course);
                newClass.setMeetingTime((MeetingTime)this.data.getMeetingTimes().get((int)((double)this.data.getMeetingTimes().size() * Math.random())));
                newClass.setRoom((Room)this.data.getRooms().get((int)((double)this.data.getRooms().size() * Math.random())));
                newClass.setInstructor((Instructor)this.data.getInstructors().get((int)((double)course.getInstructors().size() * Math.random())));
                this.classes.add(newClass);
            });
        });
        return this;
    }

    public int getNumbOfConflicts() {
        return this.numbOfConflicts;
    }

    public double getFitness() {
        if (this.isFitnessChanged) {
            this.fitness = this.calculateFitness();
            this.isFitnessChanged = false;
        }

        return this.fitness;
    }

    private double calculateFitness() {
        this.numbOfConflicts = 0;
        this.classes.forEach((x) -> {
            if (x.getRoom().getSeatingCapacity() < x.getCourse().getMaxNumbofStudents()) {
                ++this.numbOfConflicts;
            }

            this.classes.stream().filter((y) -> {
                return this.classes.indexOf(y) >= this.classes.indexOf(x);
            }).forEach((y) -> {
                if (x.getMeetingTime() == y.getMeetingTime() && x.getId() != y.getId()) {
                    if (x.getRoom() == y.getRoom()) {
                        ++this.numbOfConflicts;
                    }

                    if (x.getInstructor() == y.getInstructor()) {
                        ++this.numbOfConflicts;
                    }
                }

            });
        });
        return 1.0D / (double)(this.numbOfConflicts + 1);
    }

    public String toString() {
        String returnValue = new String();

        for(int x = 0; x < this.classes.size() - 1; ++x) {
            returnValue = returnValue + this.classes.get(x) + ",";
        }

        returnValue = returnValue + this.classes.get(this.classes.size() - 1);
        return returnValue;
    }
}
