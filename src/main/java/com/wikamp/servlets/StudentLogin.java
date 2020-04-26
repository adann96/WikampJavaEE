package com.wikamp.servlets;

import com.wikamp.dao.StudentDAO;
import com.wikamp.users.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/StudentLogin")
public class StudentLogin extends HttpServlet {
    private StudentDAO studentDAO;
    private Student student;

    private int indexNo;
    private String passwordAcc;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
        try {
            studentDAO = new StudentDAO();

            indexNo = Integer.valueOf(request.getParameter("indexNo"));
            passwordAcc = request.getParameter("passAcc");

            student = studentDAO.getStudent(indexNo,passwordAcc);

            if (student!=null && (student.getNUMER_INDEKSU()>1000 && student.getPASSWORD_ACC()!=null)) {
                HttpSession httpSession = request.getSession();
                httpSession.setAttribute("indexNo",indexNo);
                response.sendRedirect("StudentDashboard.jsp?indexNo="+indexNo);
            }
            else {
                response.sendRedirect("StudentLogin.jsp");
            }
        }
        catch (NullPointerException | SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
