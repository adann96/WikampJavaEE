package com.wikamp.dao;

import com.wikamp.oracle.ConnectionProvider;
import com.wikamp.users.Lecturer;
import com.wikamp.users.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LecturerDAO {
    static Connection connection;
    static PreparedStatement preparedStatement;
    ResultSet resultSet;

    public Lecturer getLecturer(int lecturerNo, String password) throws SQLException {
        Lecturer lecturer = new Lecturer();

        try {
            connection = ConnectionProvider.getConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM WYKLADOWCY WHERE WYKLADOWCA_ID=? AND PASSWORD_ACC=? AND ISADMIN = 'no'");
            preparedStatement.setInt(1, lecturerNo);
            preparedStatement.setString(2, password);

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                lecturer.setWYKLADOWCA_ID(resultSet.getInt(1));
                lecturer.setPASSWORD_ACC(resultSet.getString(6));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        resultSet.close();
        connection.close();
        return lecturer;
    }
}
