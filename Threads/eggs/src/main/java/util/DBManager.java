package util;

import eggs.Egg;

import java.sql.*;

public class DBManager {
    private static DBManager instance;
    private Connection connection;


    public static DBManager getInstance() {
        if(instance == null) {
            instance = new DBManager();
        }

        return instance;
    }

    private DBManager() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver not found - " + e.getMessage());
        }

        try {
            this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/easter", "root", "poli0848");
            System.out.println("We have connection.");
        } catch (SQLException e) {
            System.out.println("Connection error" + e.getMessage());
        }
    }

    public static void addEggToDB(Egg egg) {
        Connection connection = DBManager.getInstance().getConnection();
        PreparedStatement ps = null;
        try {
            String sql = "INSERT INTO eggs (type_id, is_partycolored, date, jar_id, kid_id) VALUES (?,?,?,?,?)";
            ps = connection.prepareStatement(sql);

        } catch (SQLException e) {
            System.out.println("Statement fucked up");
        }

        Date date = java.sql.Date.valueOf(egg.getDate().toLocalDate());

        try {
            ps.setInt(1,egg.getType().getId());
            ps.setBoolean(2, egg.isPartyColored());
            ps.setDate(3, date);
            ps.setInt(4, egg.getJar().getId());
            ps.setInt(5, egg.getKid().getKidId());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("E pa ne moga veche");
        }
    }

    private Connection getConnection() {
        return connection;
    }
}
