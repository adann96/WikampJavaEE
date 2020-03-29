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

    public Admin getAdmin(int adminNo, String password) throws SQLException {
        Admin admin = new Admin();

        try {
            connection = ConnectionProvider.getConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM WYKLADOWCY WHERE WYKLADOWCA_ID=? AND PASSWORD_ACC=? AND ISADMIN = 'yes'");
            preparedStatement.setInt(1, adminNo);
            preparedStatement.setString(2, password);

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                admin.setADMIN_ID(resultSet.getInt(1));
                admin.setPASSWORD_ACC(resultSet.getString(6));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        resultSet.close();
        connection.close();
        return admin;
    }
}
