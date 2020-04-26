package com.wikamp.servlets;

import com.wikamp.dao.LecturerDAO;
import com.wikamp.users.Lecturer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/LecturerLogin")
public class LecturerLogin extends HttpServlet {
    private LecturerDAO lecturerDAO;
    private Lecturer lecturer;

    private int lecturerNo;
    private String passwordAcc;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
        try {
            lecturerDAO = new LecturerDAO();

            lecturerNo = Integer.valueOf(request.getParameter("lecturerNo"));
            passwordAcc = request.getParameter("passAcc");

            lecturer = lecturerDAO.getLecturer(lecturerNo,passwordAcc);

            if (lecturer!=null && (lecturer.getWYKLADOWCA_ID()>1 && lecturer.getPASSWORD_ACC()!=null)) {
                HttpSession httpSession = request.getSession();
                httpSession.setAttribute("lecturerNo",lecturerNo);
                response.sendRedirect("LecturerDashboard.jsp?lecturerNo="+lecturerNo);
            }
            else {
                response.sendRedirect("LecturerLogin.jsp");
            }
        }
        catch (NullPointerException | SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
