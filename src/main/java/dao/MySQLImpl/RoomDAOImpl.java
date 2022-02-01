package dao.MySQLImpl;

import binary.Room;
import dao.inter.DAOException;
import dao.inter.IRoomDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RoomDAOImpl implements IRoomDAO {



    private ArrayList<Room> rooms;

    final String INSERT = "INSERT INTO rooms2(number, seatingCapacity) VALUES (?,?)";
    final String GETALL = "SELECT number, seatingCapacity FROM number";
    final String GETONE = "SELECT number, seatingCapacity FROM number WHERE number";

    private Connection conn;

    public RoomDAOImpl(Connection conn) {this.conn = conn;}

    public RoomDAOImpl() {}

    private Room result (ResultSet rs) throws SQLException {
        String number = rs.getString("number");
        int seatingCapacity = rs.getInt("seatingCapacity");
        Room room = new Room(number,seatingCapacity);
        return room;
    }
    public void ins () throws SQLException, DAOException {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/database2", "root", "admin");
            IRoomDAO dao = new RoomDAOImpl(conn);

            Room R1 = new Room();
            R1.setNumber("R1");
            R1.setSeatingCapacity(25);
            dao.insert(R1);

            Room R2 = new Room();
            R2.setNumber("R2");
            R2.setSeatingCapacity(45);
            dao.insert(R2);

            Room R3 = new Room();
            R3.setNumber("R3");
            R3.setSeatingCapacity(35);
            dao.insert(R3);

            Room R4 = new Room();
            R4.setNumber("R4");
            R4.setSeatingCapacity(30);
            dao.insert(R4);

            Room R5 = new Room();
            R5.setNumber("R5");
            R5.setSeatingCapacity(35);
            dao.insert(R5);

            Room R6 = new Room();
            R6.setNumber("R6");
            R6.setSeatingCapacity(40);
            dao.insert(R6);

            rooms = new ArrayList<Room>(Arrays.asList(R1, R2, R3, R4, R5, R6));

        } finally {
            if (conn != null) {
                conn.close();
            }

        }
    }

    @Override
    public void insert(Room b) throws DAOException {
        PreparedStatement stat = null;
        ResultSet rs = null;
        try {
            stat = conn.prepareStatement(INSERT);
            stat.setString(1, b.getNumber());
            stat.setInt(2, b.getSeatingCapacity());
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
    public List<Room> getall() throws DAOException {
        return null;
    }

    @Override
    public Room getone(Integer id) throws DAOException {
        return null;
    }
}
