package dao.MySQLImpl;

import binary.MeetingTime;
import dao.inter.DAOException;
import dao.inter.IMeetingTimeDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MeetingTimeDAOImpl implements IMeetingTimeDAO {


    private ArrayList<MeetingTime> meetingTimes;

    final String INSERT = "INSERT INTO meetingtime02(id,time) VALUES (?,?)";
    final String GETALL = "SELECT id, time FROM id";
    final String GETONE = "SELECT id, time FROM meetingtime WHERE id";

    private Connection conn;

    public MeetingTimeDAOImpl(Connection conn){this.conn = conn;}

    public MeetingTimeDAOImpl(){}

    private MeetingTime result (ResultSet rs) throws SQLException {
        String id = rs.getString("id");
        String time = rs.getString("time");
        MeetingTime meetingTime = new MeetingTime(id,time);
        return meetingTime;


    }
    public void ins () throws SQLException, DAOException {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/database2", "root", "admin");
            IMeetingTimeDAO dao = new MeetingTimeDAOImpl(conn);

            MeetingTime M1 = new MeetingTime();
            M1.setId("M1");
            M1.setTime("Monday 08:00 - 9:30");
            dao.insert(M1);

            MeetingTime M2 = new MeetingTime();
            M2.setId("M2");
            M2.setTime("Monday 09:30 - 11:00");
            dao.insert(M2);

            MeetingTime M3 = new MeetingTime();
            M3.setId("M3");
            M3.setTime("Monday 11:30 - 13:00");
            dao.insert(M3);

            MeetingTime T1 = new MeetingTime();
            T1.setId("T1");
            T1.setTime("Tuesday 08:00 - 9:30");
            dao.insert(T1);

            MeetingTime T2 = new MeetingTime();
            T2.setId("T2");
            T2.setTime("Tuesday 09:30 - 11:00");
            dao.insert(T2);

            MeetingTime T3 = new MeetingTime();
            T3.setId("T3");
            T3.setTime("Tuesday 11:30 - 13:00");
            dao.insert(T3);

            MeetingTime W1 = new MeetingTime();
            W1.setId("W1");
            W1.setTime("Wednesday 08:00 - 9:30");
            dao.insert(W1);

            MeetingTime W2 = new MeetingTime();
            W2.setId("W2");
            W2.setTime("Wednesday 09:30 - 11:00");
            dao.insert(W2);

            MeetingTime W3 = new MeetingTime();
            W3.setId("W3");
            W3.setTime("Wednesday 11:30 - 13:00");
            dao.insert(W3);

            MeetingTime TH1 = new MeetingTime();
            TH1.setId("TH1");
            TH1.setTime("Thursday 08:00 - 9:30");
            dao.insert(TH1);

            MeetingTime TH2 = new MeetingTime();
            TH2.setId("TH2");
            TH2.setTime("Thursday 09:30 - 11:00");
            dao.insert(TH2);

            MeetingTime TH3 = new MeetingTime();
            TH3.setId("TH3");
            TH3.setTime("Thursday 11:30 - 13:00");
            dao.insert(TH3);

            MeetingTime F1 = new MeetingTime();
            F1.setId("F1");
            F1.setTime("Friday 08:00 - 9:30");
            dao.insert(F1);

            MeetingTime F2 = new MeetingTime();
            F2.setId("F2");
            F2.setTime("Friday 09:30 - 11:00");
            dao.insert(F2);

            MeetingTime F3 = new MeetingTime();
            F3.setId("F3");
            F3.setTime("Friday 11:30 - 13:00");
            dao.insert(F3);

        } finally {
            if (conn != null) {
                conn.close();
            }

        }
    }
    @Override
    public void insert(MeetingTime b) throws DAOException {
        PreparedStatement stat = null;
        ResultSet rs = null;
        try {
            stat = conn.prepareStatement(INSERT);
            stat.setString(1, b.getId());
            stat.setString(2, b.getTime());
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
    public List<MeetingTime> getall() throws DAOException {
        return null;
    }

    @Override
    public MeetingTime getone(Integer id) throws DAOException {
        return null;
    }
}
