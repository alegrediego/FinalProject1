package dao.MySQLImpl;

import binary.Course;
import binary.Department;
import dao.inter.DAOException;
import dao.inter.IDepartmentDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DepartmentDAOImpl implements IDepartmentDAO {

    private ArrayList<Department>depts;

    final String INSERT = "INSERT INTO departments02(name,courses) VALUES (?,?)";
    final String GETALL = "SELECT name, courses FROM name";
    final String GETONE = "SELECT name, courses FROM departments2 WHERE name";

    private Connection conn;

    public DepartmentDAOImpl(Connection conn) {
        this.conn = conn;
    }

    public DepartmentDAOImpl() {
    }

    private Department result(ResultSet rs) throws SQLException {
        String name = rs.getString("name");
        String coursess = rs.getString("courses");
        Department department = new Department(name,coursess);
        return department;
    }

    public void ins() throws SQLException, DAOException {
        Connection conn = null;

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/database2", "root", "admin");
            IDepartmentDAO dao =  new DepartmentDAOImpl(conn);

            Course C1 = new Course("C1", "305", "Instructor",25);
            Course C2 = new Course("C2", "308", "Instructor",35);
            Course C3 = new Course("C3", "402", "Instructor",25);
            Course C4 = new Course("C4", "405", "Instructor",30);
            Course C5 = new Course("C5", "307", "Instructor",35);
            Course C6 = new Course("C6", "408", "Instructor",45);
            Course C7 = new Course("C7", "303", "Instructor",45);
            ArrayList<Course> course = new ArrayList<>();

            course.add(C1);
            course.add(C2);
            course.add(C3);
            course.add(C4);
            Department dept1 = new Department();
            dept1.setName("MATHS");
            dept1.setCourses(course);
            dao.insert(dept1);
            course.clear();

            course.add(C2);
            course.add(C4);
            course.add(C5);
            Department dept2 = new Department();
            dept2.setName("GEOGRAPHY");
            dept2.setCourses(course);
            dao.insert(dept2);
            course.clear();

            course.add(C6);
            course.add(C7);
            Department dept3 = new Department();
            dept3.setName("SPANISH");
            dept3.setCourses(course);
            dao.insert(dept3);
            course.clear();

            course.add(C1);
            course.add(C3);
            course.add(C7);
            Department dept4 = new Department();
            dept4.setName("ART");
            dept4.setCourses(course);
            dao.insert(dept4);
            course.clear();

            course.add(C3);
            course.add(C4);
            course.add(C5);
            Department dept5 = new Department();
            dept5.setName("HISTORY");
            dept5.setCourses(course);
            dao.insert(dept5);
            course.clear();

            course.add(C1);
            course.add(C5);
            course.add(C6);
            Department dept6 = new Department();
            dept6.setName("MUSIC");
            dept6.setCourses(course);
            dao.insert(dept6);
            course.clear();

            depts = new ArrayList<Department>(Arrays.asList(dept1,dept2,dept3,dept4,dept5,dept6));

        } finally {
            if (conn != null) {
                conn.close();
            }

        }
    }

    @Override
    public void insert(Department b) throws DAOException {

        PreparedStatement stat = null;
        ResultSet rs = null;
        try {
            stat = conn.prepareStatement(INSERT);
            stat.setString(1, b.getName());
            stat.setString(2, b.getCoursess());
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
    public List<Department> getall() throws DAOException {
        return null;
    }

    @Override
    public Department getone(String id) throws DAOException {
        return null;
    }
}
