package ru.job4j;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import java.sql.*;


public class SQLStorage {

    public static final Logger LOG = LoggerFactory.getLogger(SQLStorage.class);

    public static void main(String[] args) throws SQLException {
        String url = "jdbc:postgresql://127.0.0.1:5432/car";
        String username = "postgres";
        String password = "password123";
        Connection con = null;

        try {
            con = DriverManager.getConnection(url, username, password);
            PreparedStatement ps = con.prepareStatement("select id, body_id, name from car where id in (?,?,?)");
            ps.setInt(1, 2);
            ps.setInt(2, 4);
            ps.setInt(3, 5);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                //System.out.println(rs.getInt("id") + " " + rs.getString("name") + " " + rs.getInt("body_id"));
                System.out.println(String.format("%s %s %s", rs.getInt("id"),
                        rs.getString("name"), rs.getInt("body_id")

                ));
            }
            rs.close();

            ps.close();


        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    LOG.error(e.getMessage(), e);
                }
            }
        }
    }
}
