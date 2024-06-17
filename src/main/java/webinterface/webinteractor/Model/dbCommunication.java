package webinterface.webinteractor.Model;

import java.sql.*;
public class dbCommunication implements DbInterface{
    Connection con = null;

    @Override
    public boolean connect(String database, String username, String password) throws DbException {
        System.out.println(database);
        database = "library";
        String server
                = "jdbc:mysql://localhost:3306/" + database
                + "?UseClientEnc=UTF8";
        System.out.println("user: "+username);
        System.out.println("password: "+password);
        username = "client";
        password = "1234";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(server, username, password);
            this.con.setAutoCommit(false);
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e);
            throw new DbException("Error connecting to the database", e);
        }
        System.out.println("connected!");
        return true;
    }

    @Override
    public boolean disconnect(String database) throws DbException {
        try {
            if (this.con != null && !this.con.isClosed()) {
                con.close();
                return false;
            }
        } catch (SQLException e) {
            throw new DbException("Error closing connection:", e);
        }
        System.out.println("DISCONNECTED");
        return true;
    }
}
