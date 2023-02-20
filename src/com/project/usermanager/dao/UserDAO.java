package com.project.usermanager.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.project.usermanager.model.User;

public class UserDAO {
	private String jdbcURL = "jdbc:mysql://localhost:3306/register?useSSL=false&serverTimezone=UTC";
	private String jdbcUsername = "root";
	private String jdbcPassword = "root";
	
	private static final String INSERT_USERS_SQL = "INSERT INTO users" + "  (name, cpf, email, country) VALUES " +
	        " (?, ?, ?, ?);";

    private static final String SELECT_USER_BY_ID = "select id, name, cpf, email, country from users where id =?";
    private static final String SELECT_ALL_USERS = "select * from users";
    private static final String DELETE_USERS_SQL = "delete from users where id = ?;";
    private static final String UPDATE_USERS_SQL = "update users set name = ?, cpf = ?, email= ?, country =? where id = ?;";

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            
            e.printStackTrace();
        }
        return connection;
    }
    
    public User findUser(int id) {
        User user = null;
        try (Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String name = rs.getString("name");
                String cpf = rs.getString("cpf");     
                String email = rs.getString("email");
                String country = rs.getString("country");
                user = new User(id, name, cpf, email, country);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
    
    public List<User> findAllUsers(){
    	
    	List<User> users = new ArrayList<>();
         try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);) {
             System.out.println(preparedStatement);
             ResultSet rs = preparedStatement.executeQuery();

             while (rs.next()) {
            	 Integer idUser = rs.getInt("id");
                 String name = rs.getString("name");
                 String cpf = rs.getString("cpf");
                 String email = rs.getString("email");
                 String country = rs.getString("country");
                 users.add(new User(idUser, name, cpf, email, country));
             }
         } catch (SQLException e) {
             e.printStackTrace();
         }
         return users;
     }
    
    public void createUser(User user) throws SQLException {
   
    	try (Connection connection = getConnection();
    			PreparedStatement pStmt = connection.prepareStatement(INSERT_USERS_SQL)){
			pStmt.setString(1, user.getName());
			pStmt.setString(2, user.getCpf());
			pStmt.setString(3, user.getEmail());
			pStmt.setString(4, user.getCountry());
			pStmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    }
    
    public boolean updateUser(User user) throws SQLException {
    	boolean rowUpdated;
    	
    	try (Connection connection = getConnection();
    			PreparedStatement pStmt = connection.prepareStatement(UPDATE_USERS_SQL)){
			pStmt.setString(1, user.getName());
			pStmt.setString(2, user.getCpf());
			pStmt.setString(3, user.getEmail());
			pStmt.setString(4, user.getCountry());
			pStmt.setInt(5, user.getId());
			rowUpdated = pStmt.executeUpdate() > 0;
    	}
    	return rowUpdated;
    }
    
    public boolean deleteUser(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }
    	
}
