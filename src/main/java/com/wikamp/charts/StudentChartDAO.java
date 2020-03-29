package com.wikamp.charts;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class StudentChartDAO {
        Connection conn = null;
        PreparedStatement stmt = null;
        String sql = null;

        public ArrayList<Student> getstudent(String start, String limit){
            ArrayList<Student> studentList = new ArrayList<Student>();

            try {
                Context ctx = (Context) new InitialContext().lookup("java:comp/env");
                conn = ((DataSource) ctx.lookup("jdbc/oracle")).getConnection();

                sql = "SELECT * FROM Studenci order by wydzial_id desc LIMIT ?,?";
                stmt = conn.prepareStatement(sql);
                stmt.setInt(1, Integer.parseInt(start));
                stmt.setInt(2, Integer.parseInt(limit));
                ResultSet rs = stmt.executeQuery();

                while(rs.next()){
                    Student student = new Student();
                }
                rs.close();
                stmt.close();
                stmt = null;
            }
            catch (Exception e){
                System.out.println(e);
            }
            finally {
                if(stmt != null){
                    try{
                        stmt.close();
                    }catch(SQLException sqlex){

                    }
                    stmt = null;
                }
                if(conn != null){
                    try{
                        conn.close();
                    }catch (SQLException sqlex){

                    }
                    conn = null;
                }
            }
            return studentList;
        }
    }
