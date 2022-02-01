import binary.*;
import binary.Class;
import dao.MySQLImpl.*;
import dao.inter.DAOException;
import org.apache.log4j.Logger;

import java.io.PrintStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class Main {

    private static final Logger log = Logger.getLogger(Main.class);

    private static Connection connection;
    public static final int POPULATION_SIZE = 9;
    public static final double MUTATION_RATE = 0.1D;
    public static final double CROSSOVER_RATE = 0.9D;
    public static final int TOURNAMENT_SELECTION_SIZE = 3;
    public static final int NUMB_OF_ELITE_SCHEDULES = 1;
    private int scheduleNumb = 0;
    private data data;
    private int classNumb = 1;

    public Main(Connection conn) {
        this.connection = conn;
    }

    public Main() {

    }


    public static void main(String[] args) throws SQLException, DAOException {
        try {
            Connection c = ConnectionPool.getInstance().getConnection();
            if (c != null) {
                System.out.println("Connected");
                ConnectionPool.getInstance().getConnection().close();
            } else {
                System.out.println("Not connected");
            }

        } catch (SQLException ex) {
        }

        /*InstructorDAOImpl ins = new InstructorDAOImpl();
        ins.ins();*/

        /*CourseDAOImpl ins2 = new CourseDAOImpl();
        ins2.ins();*/

        /*DepartmentDAOImpl ins3 = new DepartmentDAOImpl();
        ins3.ins();*/

        /*MeetingTimeDAOImpl ins4 = new MeetingTimeDAOImpl();
        ins4.ins();*/

        /*RoomDAOImpl ins5 = new RoomDAOImpl();
        ins5.ins();*/





        Main main = new Main();
        main.data = new data();


        int generationNumber = 0;
        main.printAvalaibleData();
        System.out.println("> Generation # "+generationNumber);
        System.out.print(" Schedule # |                                                                                ");
        System.out.print("                       Classes [dept,class,room,instructor,meeting-time]      ");
        System.out.println("                                                                                                                                                                                                                                                                                                                            |  Fitness | Conflicts");
        System.out.print("------------------------------------------------------------------------------------");
        System.out.println("------------------------------------------------------------------------------------");
        GenericAlgorithm geneticAlgorithm = new GenericAlgorithm(main.data);
        Population population = new Population(Main.POPULATION_SIZE, main.data).sortByFitness();
        population.getSchedules().forEach(schedule -> System.out.println("       "+main.scheduleNumb++ +
                "     | "+schedule+" | " +
                String.format("%.5f",schedule.getFitness())+
                " | "+schedule.getNumbOfConflicts()));
        main.printTableAsSchedule(population.getSchedules().get(0),generationNumber);
        main.classNumb = 1;

        while(population.getSchedules().get(0).getFitness()!=1.0){
            System.out.println("> Generation # "+ ++generationNumber);
            System.out.print(" Schedule # |                                           ");
            System.out.print("Classes [dept,class,room,instructor,meeting-time]      ");
            System.out.println("                                                                                                                                                                                |  Fitness | Conflicts");
            System.out.print("------------------------------------------------------------------------------------");
            System.out.println("------------------------------------------------------------------------------------");
            population = geneticAlgorithm.evolve(population).sortByFitness();
            main.scheduleNumb = 0;
            population.getSchedules().forEach(schedule -> System.out.println("       "+main.scheduleNumb++ +
                    "     | "+schedule+" | " +
                    String.format("%.5f",schedule.getFitness())+
                    " | "+schedule.getNumbOfConflicts()));
            main.printTableAsSchedule(population.getSchedules().get(0),generationNumber);
            main.classNumb = 1;
        }

    }


    private void printTableAsSchedule(Schedule schedule, int generation){
        ArrayList<Class> classes = schedule.getClasses();
        System.out.print("\n                       ");
        System.out.println("Class # | Dept | Course (number, max # of students) | Room(Capacity) |   Instructor(Id)   | Meeting Time(Id) ");
        System.out.print("                       ");
        System.out.print("------------------------------------------------------");
        System.out.println("--------------------------------------------------------------");
        classes.forEach(x->{
            int majorIndex = data.getDepts().indexOf(x.getDept());
            int coursesIndex = data.getCourses().indexOf(x.getCourse());
            int roomIndex = data.getRooms().indexOf(x.getRoom());
            int instructorIndex = data.getInstructors().indexOf(x.getInstructor());
            int meetingtimeIndex = data.getMeetingTimes().indexOf(x.getMeetingTime());
            System.out.print("                       ");
            System.out.print(String.format("  %1$02d  ",classNumb)+ "   | ");
            System.out.print(String.format("%1$4s",data.getDepts().get(majorIndex).getName())+"  |  ");
            System.out.print(String.format("%1$21s",data.getCourses().get(coursesIndex).getName()+
                    "(" +data.getCourses().get(coursesIndex).getNumber()+", "+
                    x.getCourse().getMaxNumbofStudents())+")       | ");
            System.out.print(String.format("%1$10s",data.getRooms().get(roomIndex).getNumber() +
                    " ("+x.getRoom().getSeatingCapacity())+")       | ");
            System.out.print(String.format("%1$15s",data.getInstructors().get(instructorIndex).getName()+
                    "("+data.getInstructors().get(instructorIndex).getId()+" )")+" | ");
            System.out.println(data.getMeetingTimes().get(meetingtimeIndex).getTime()+
                    " ("+data.getMeetingTimes().get(meetingtimeIndex).getId()+")");
            classNumb ++;
        });
    }

    private void printAvalaibleData(){
        //System.out.println("Avalaible Departments ==>");
        data.getDepts().forEach(x-> System.out.println("name: "+x.getName()+", courses: "+x.getCourses()));
        //System.out.println("\nAvalaible Courses ==> ");
        data.getCourses().forEach(x-> System.out.println("Course #: " +x.getNumber()+", name: "+x.getName()+", max # of students: "
                +x.getMaxNumbofStudents()+", instructors: "+x.getInstructors()));
        //System.out.println("\nAvalaible Rooms ==> ");
        data.getRooms().forEach(x-> System.out.println("room #: "+x.getNumber()+", max seating capaciity: "+x.getSeatingCapacity()));
        //System.out.println("\nAvalaible Instructors ==> ");
        data.getInstructors().forEach(x-> System.out.println("id: "+x.getId()+", name: "+x.getName()));
        //System.out.println("\nAvalaible Meeting Times ==> ");
        data.getMeetingTimes().forEach(x-> System.out.println("id: "+x.getId()+", Meeting time: "+x.getTime()));
        //System.out.print("------------------------------------------------------------------------------------");
        //System.out.println("------------------------------------------------------------------------------------");
    }

}
