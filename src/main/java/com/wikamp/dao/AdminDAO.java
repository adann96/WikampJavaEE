package com.wikamp.dao;

import com.wikamp.oracle.ConnectionProvider;
import com.wikamp.users.Admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDAO {
    static Connection connection;
    static PreparedStatement preparedStatement;
    ResultSet resultSet;

    public Admin getAdmin(int numer_administratora, String password) throws SQLException {
        Admin admin = new Admin();

        try {
            connection = ConnectionProvider.getConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM ADMIN WHERE NUMER_ADMINISTRATORA=? AND PASSWORD_ACC=?");
            preparedStatement.setInt(1, numer_administratora);
            preparedStatement.setString(2, password);

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                admin.setNUMER_ADMINISTRATORA(resultSet.getInt(1));
                admin.setPASSWORD_ACC(resultSet.getString(2));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        resultSet.close();
        connection.close();
        return admin;
    }
}

