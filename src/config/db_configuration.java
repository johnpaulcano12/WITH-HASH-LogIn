/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 *
 * @author SCC COMPLAB
 */
public class db_configuration {
    
    public Connection connection;
    
    public db_configuration(){
        try{
            connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/system_db", "root", "");
            }catch(SQLException e){
                System.err.println("Cannot connect to database: " + e.getMessage());
            }
        
        
    }
    
//    public void updatePassword(String username, String password) {
//        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
//        
//        String query = "UPDATE users SET u_pword = ? WHERE u_user = ?";
//        
//        try {
//            PreparedStatement statement = connection.prepareStatement(query);
//            statement.setString(1, hashedPassword);
//            statement.setString(2, username);
//            
//            int rowsAffected = statement.executeUpdate();
//            if (rowsAffected == 1) {
//                System.out.println("Password updated successfully");
//            } else {
//                System.out.println("Username not found");
//            }
//        } catch (SQLException e) {
//            System.err.println("Error updating password: " + e.getMessage());
//        }
//    }
    

    
    
    public ResultSet getData(String sql) throws SQLException {
        Statement statement = (Statement) connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        return resultSet;
    }

 public void insertData(String sql){
     try{
         PreparedStatement pstmt = connection.prepareStatement(sql);
         pstmt.executeUpdate();
         System.out.println("Inserted Successfully");
         pstmt.close();
     }catch(SQLException e){
         System.out.println("Connection error" +e);
     
     }
 }
    public int updateData(String sql){
        int num = 0;
        try {
         
            String query = sql;
            PreparedStatement pstmt = connection.prepareStatement(query);
            int rowsUpdated = pstmt.executeUpdate();
            if(rowsUpdated > 0) {
                System.out.println("Data updated successfully!");
                num = 1;
            } else {
                System.out.println("Data update failed!");
                num = 0;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
       
        return num;
    }
      public void deleteData(int id) {
    try {
        PreparedStatement stmt = connection.prepareStatement("DELETE FROM residents WHERE res_id = ?");
        stmt.setInt(1, id);
        int rowsDeleted = stmt.executeUpdate();
        if (rowsDeleted > 0) {
            System.out.println(rowsDeleted + " rows were deleted.");
        } else {
            System.out.println("No rows were deleted.");
        }
        stmt.close();
        connection.close();
    } catch (SQLException e) {
        System.out.println("Error deleting data: " + e.getMessage());
    }
}
      
      public void deleteUser(int id) {
    try {
        PreparedStatement stmt = connection.prepareStatement("DELETE FROM users WHERE u_id = ?");
        stmt.setInt(1, id);
        int rowsDeleted = stmt.executeUpdate();
        if (rowsDeleted > 0) {
            System.out.println(rowsDeleted + " rows were deleted.");
        } else {
            System.out.println("No rows were deleted.");
        }
        stmt.close();
        connection.close();
    } catch (SQLException e) {
        System.out.println("Error deleting data: " + e.getMessage());
    }
}  public void deletePurok(int id) {
    try {
        PreparedStatement stmt = connection.prepareStatement("DELETE FROM puroks WHERE purok_id = ?");
        stmt.setInt(1, id);
        int rowsDeleted = stmt.executeUpdate();
        if (rowsDeleted > 0) {
            System.out.println(rowsDeleted + " rows were deleted.");
        } else {
            System.out.println("No rows were deleted.");
        }
        stmt.close();
        connection.close();
    } catch (SQLException e) {
        System.out.println("Error deleting data: " + e.getMessage());
    }
}
    public void deleteReport(int id) {
    try {
        PreparedStatement stmt = connection.prepareStatement("DELETE FROM reports WHERE report_id = ?");
        stmt.setInt(1, id);
        int rowsDeleted = stmt.executeUpdate();
        if (rowsDeleted > 0) {
            System.out.println(rowsDeleted + " rows were deleted.");
        } else {
            System.out.println("No rows were deleted.");
        }
        stmt.close();
        connection.close();
    } catch (SQLException e) {
        System.out.println("Error deleting data: " + e.getMessage());
    }
}
      
      
   
    
}

