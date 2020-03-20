package com.wikamp.dao;

import com.wikamp.oracle.ConnectionProvider;
import com.wikamp.users.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentDAO {
    static Connection connection;
    static PreparedStatement preparedStatement;
    ResultSet resultSet;

    public Student getStudent(int numer_indeksu, String password) throws SQLException {
        Student student = new Student();

        try {
            connection = ConnectionProvider.getConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM STUDENCI WHERE NUMER_INDEKSU=? AND PASSWORD_ACC=?");
            preparedStatement.setInt(1, numer_indeksu);
            preparedStatement.setString(2, password);

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                student.setNUMER_INDEKSU(resultSet.getInt(1));
                student.setPASSWORD_ACC(resultSet.getString(2));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        resultSet.close();
        connection.close();
        return student;
    }
}
