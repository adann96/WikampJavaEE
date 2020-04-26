package com.wikamp.servlets;

import com.wikamp.charts.Faculty;
import com.wikamp.dao.AdminDAO;
import com.wikamp.dao.FacultyDAO;
import com.wikamp.users.Admin;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet("/AdminLogin")
public class AdminLogin extends HttpServlet {
    private AdminDAO adminDAO;
    private FacultyDAO facultyDAO;
    private Admin admin;
    private Faculty faculty;
    private String json;

    private int adminNo;
    private String passwordAcc;

    public void init() {
        facultyDAO = new FacultyDAO();
    }

    private void facultyList(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        HttpSession httpSession = request.getSession();
        ArrayList<Faculty> facultyList = facultyDAO.getFaculties();
        httpSession.setAttribute("facultyList", facultyList);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
        try {
            adminDAO = new AdminDAO();

            adminNo = Integer.valueOf(request.getParameter("adminNo"));
            passwordAcc = request.getParameter("passAcc");
            admin = adminDAO.getAdmin(adminNo,passwordAcc);

            if (admin!=null && (admin.getADMIN_ID()>1 && admin.getPASSWORD_ACC()!=null)) {
                HttpSession httpSession = request.getSession();
                httpSession.setAttribute("adminNo",adminNo);

                try {
                    facultyList(request,response);
                }
                catch (SQLException e) {
                    e.printStackTrace();
                }

                response.sendRedirect("AdminDashboard.jsp?adminNo="+adminNo);
            }
            else {
                response.sendRedirect("AdminLogin.jsp");
            }
        }
        catch (NullPointerException | SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
