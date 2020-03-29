package com.wikamp.dao;

import com.wikamp.oracle.ConnectionProvider;
import com.wikamp.users.Lecturer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LecturerDAO {
    static Connection connection;
    static PreparedStatement preparedStatement;
    ResultSet resultSet;

    public Lecturer getLecturer(int numer_wykladowcy, String password) throws SQLException {
        Lecturer lecturer = new Lecturer();

        try {
            connection = ConnectionProvider.getConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM LECTURER WHERE NUMER_WYKLADOWCY=? AND PASSWORD_ACC=?");
            preparedStatement.setInt(1, numer_wykladowcy);
            preparedStatement.setString(2, password);

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                lecturer.setNUMER_WYKLADOWCY(resultSet.getInt(1));
                lecturer.setPASSWORD_ACC(resultSet.getString(2));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        resultSet.close();
        connection.close();
        return lecturer;
    }
}

