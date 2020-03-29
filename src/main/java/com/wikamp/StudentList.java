package com.wikamp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.wikamp.charts.Student;
import com.wikamp.charts.StudentChartDAO;

public class StudentList extends HttpServlet{
    private static final long serialVersionUID = 1L;

    public StudentList(){
        super();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        doPost(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        String start = request.getParameter("start");
        String limit = request.getParameter("limit");

        PrintWriter out = response.getWriter();
        response.setContentType("text/html");

        StudentChartDAO studentChartDAO = new StudentChartDAO();
        ArrayList<Student> studentList =  studentChartDAO.getstudent(start,limit);

        Gson gson = new Gson();
        JsonArray arrayObj = new JsonArray();
        for(int i=0; i<studentList.size();i++){
            Student student = studentList.get(i);
            JsonElement studentObj = gson.toJsonTree(student);
            arrayObj.add(studentObj);
        }

        JsonObject myObj = new JsonObject();
        myObj.addProperty("success", true);
        myObj.add("studentList", arrayObj);
        myObj.addProperty("totalCount",100);

        out.println(myObj.toString());
        out.close();
    }
}
