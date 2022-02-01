package dao.MySQLImpl;

import binary.Instructor;
import dao.inter.DAOException;
import dao.inter.IInstructorDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InstructorDAOImpl implements IInstructorDAO {

    private ArrayList<Instructor> instructor;

    final String INSERT = "INSERT INTO instructors02(id_instructor,name) VALUES (?,?)";
    final String GETALL = "SELECT id_instructors, name FROM instructors";
    final String GETONE = "SELECT id_instructors, name FROM instructors WHERE id_instructors";

    private Connection conn;

    public InstructorDAOImpl(Connection conn){
        this.conn = conn;
    }

    public InstructorDAOImpl() {

    }

    private Instructor result (ResultSet rs) throws SQLException {
        String id_instructors = rs.getString("id_instructor");
        String name = rs.getString("name");
        Instructor instructor = new Instructor(id_instructors,name);
        return instructor;
    }

    public void ins () throws SQLException, DAOException {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/database2","root","admin");
            IInstructorDAO dao = new InstructorDAOImpl(conn);

            Instructor instructor1 = new Instructor();
            instructor1.setId("I1");
            instructor1.setName("Romina Alegre");
            dao.insert(instructor1);


            Instructor instructor2 = new Instructor();
            instructor2.setId("I2");
            instructor2.setName("Diego Alegre");
            dao.insert(instructor2);

            Instructor instructor3 = new Instructor();
            instructor3.setId("I3");
            instructor3.setName("Camila Kusnier");
            dao.insert(instructor3);

            Instructor instructor4 = new Instructor();
            instructor4.setId("I4");
            instructor4.setName("Nicolas Costurie");
            dao.insert(instructor4);

            Instructor instructor5 = new Instructor();
            instructor5.setId("I5");
            instructor5.setName("Pablo Perez");
            dao.insert(instructor5);

            Instructor instructor6 = new Instructor();
            instructor6.setId("I6");
            instructor6.setName("Walter Acevedo");
            dao.insert(instructor6);

            Instructor instructor7 = new Instructor();
            instructor7.setId("I7");
            instructor7.setName("Carlos Gonzalez");
            dao.insert(instructor7);


            instructor = new ArrayList<Instructor>(Arrays.asList(instructor1,instructor2,instructor3,instructor4,instructor5));

        } finally {
            if(conn != null){
                conn.close();
            }

        }

    }



    @Override
    public void insert(Instructor a) throws DAOException {


        PreparedStatement stat = null;
        ResultSet rs = null;
        try {
            stat = conn.prepareStatement(INSERT);
            stat.setString(1, a.getId());
            stat.setString(2, a.getName());
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
    public List<Instructor> getall() throws DAOException {
        return null;
    }

    @Override
    public Instructor getone(String id) throws DAOException {
        return null;
    }
}
