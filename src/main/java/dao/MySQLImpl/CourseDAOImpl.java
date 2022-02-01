package dao.MySQLImpl;

import binary.Course;
import binary.Instructor;
import dao.inter.DAOException;
import dao.inter.ICourseDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CourseDAOImpl implements ICourseDAO{

    private ArrayList<Course> courses;

    private ArrayList<Instructor> instructor;

    private ArrayList<Instructor> instructors = new ArrayList<>();

    final String INSERT = "INSERT INTO courses02(number,name,instructor,maxNumbofStudents) VALUES (?,?,?,?)";
    final String GETALL = "SELECT number time FROM number";
    final String GETONE = "SELECT number, time FROM meetingtime WHERE number";

    private Connection conn;

    public CourseDAOImpl(Connection conn) {
        this.conn = conn;
    }

    public CourseDAOImpl() {
    }

    private Course result(ResultSet rs) throws SQLException {
        String number = rs.getString("number");
        String name = rs.getString("name");
        String instructor = rs.getString("instructor");
        int maxNumbofStudents = rs.getInt("maxNumbofStudents");
        Course course = new Course();
        return course;

    }


    public void ins () throws SQLException, DAOException{

        Connection conn = null;

        try {
            Instructor instructor1 = new Instructor("I1", "Romina Alegre");
            Instructor instructor2 = new Instructor("I2", "Diego Alegre");
            Instructor instructor3 = new Instructor("I3", "Camila Kusnier");
            Instructor instructor4 = new Instructor("I4", "Julio Yedro");
            Instructor instructor5 = new Instructor("I5", "Martin Perez");

            instructor = new ArrayList<Instructor>(Arrays.asList(instructor1,instructor2,instructor3,instructor4,instructor5));

            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/database2", "root", "admin");

            ICourseDAO dao = new CourseDAOImpl(conn);
            instructors.add(instructor1);
            instructors.add(instructor2);
            Course C1 = new Course();
            C1.setNumber("C1");
            C1.setName("305");
            C1.setInstructor(instructors);
            C1.setMaxNumbofStudents(25);
            dao.insert(C1);
            instructors.clear();;

            instructors.add(instructor3);
            instructors.add(instructor4);
            Course C2 = new Course();
            C2.setNumber("C2");
            C2.setName("308");
            C2.setInstructor(instructors);
            C2.setMaxNumbofStudents(35);
            dao.insert(C2);
            instructors.clear();

            instructors.add(instructor1);
            instructors.add(instructor4);
            Course C3 = new Course();
            C3.setNumber("C3");
            C3.setName("402");
            C3.setInstructor(instructors);
            C3.setMaxNumbofStudents(25);
            dao.insert(C3);
            instructors.clear();

            instructors.add(instructor2);
            instructors.add(instructor3);
            Course C4 = new Course();
            C4.setNumber("C4");
            C4.setName("405");
            C4.setInstructor(instructors);
            C4.setMaxNumbofStudents(30);
            dao.insert(C4);
            instructors.clear();

            instructors.add(instructor1);
            instructors.add(instructor5);
            Course C5 = new Course();
            C5.setNumber("C5");
            C5.setName("307");
            C5.setInstructor(instructors);
            C5.setMaxNumbofStudents(35);
            dao.insert(C5);
            instructors.clear();

            instructors.add(instructor2);
            instructors.add(instructor4);
            Course C6 = new Course();
            C6.setNumber("C6");
            C6.setName("408");
            C6.setInstructor(instructors);
            C6.setMaxNumbofStudents(45);
            dao.insert(C6);
            instructors.clear();

            instructors.add(instructor1);
            instructors.add(instructor2);
            instructors.add(instructor5);
            Course C7 = new Course();
            C7.setNumber("C7");
            C7.setName("303");
            C7.setInstructor(instructors);
            C7.setMaxNumbofStudents(45);
            dao.insert(C7);
            instructors.clear();

            courses = new ArrayList<Course>(Arrays.asList(C1,C2,C3,C4,C5,C6,C7));

        } finally {
            if (conn != null) {
                conn.close();
            }

        }



    }

    @Override
    public void insert(Course b) throws DAOException {

        PreparedStatement stat = null;
        ResultSet rs = null;
        try {
            stat = conn.prepareStatement(INSERT);
            stat.setString(1, b.getNumber());
            stat.setString(2, b.getName());
            stat.setString(3, String.valueOf(b.getInstructor()));
            stat.setInt(4, b.getMaxNumbofStudents());
            if (stat.executeUpdate() == 0){
                throw new DAOException("not saved");
            }
                     /*if(rs.next()){
                a.setId(rs.getInt(1));
            }else{
            throw new DAOException("Not Saved");
            }*/
        } catch (SQLException ex){
            throw new DAOException("SQL Error",ex);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {

                }
            }
            if (stat != null){
                try{
                    stat.close();
                } catch (SQLException ex){
                    throw new DAOException("SQL error",ex);
                }
            }
        }
    }

    @Override
    public List<Course> getall() throws DAOException {
        return null;
    }

    @Override
    public Course getone(String id) throws DAOException {
        return null;
    }
}