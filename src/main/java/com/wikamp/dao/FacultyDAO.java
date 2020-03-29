package com.wikamp.dao;

import com.wikamp.charts.Faculty;
import com.wikamp.oracle.ConnectionProvider;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FacultyDAO {
    static Connection connection;
    static PreparedStatement preparedStatement;
    ResultSet resultSet;

    public ArrayList<Faculty> getFaculties() {
        ArrayList<Faculty> facultyList = new ArrayList<>();

        try {
            connection = ConnectionProvider.getConnection();
            preparedStatement = connection.prepareStatement("select wydzialy.nazwa, count(studenci.numer_indeksu) from studenci inner join kierunki on studenci.kierunek_id = kierunki.kierunek_id\n" +
                    "inner join wydzialy on kierunki.wydzial_id = wydzialy.wydzial_id\n" +
                    "group by wydzialy.nazwa");
            resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                String facultyName = resultSet.getString(1);
                int studNo = resultSet.getInt(2);

                facultyList.add(new Faculty(facultyName,studNo));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return facultyList;
    }
}
