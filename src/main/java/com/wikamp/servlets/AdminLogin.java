package com.wikamp.servlets;

import com.wikamp.dao.AdminDAO;
import com.wikamp.dao.LecturerDAO;
import com.wikamp.users.Admin;
import com.wikamp.users.Lecturer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/AdminLogin")
public class AdminLogin extends HttpServlet {
    private AdminDAO adminDAO;
    private Admin admin;

    private int adminNo;
    private String passwordAcc;

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
                response.sendRedirect("AdminDashboard.jsp?adminNo="+adminNo);
            }
            else {
                response.sendRedirect("None");
            }
        }
        catch (NullPointerException | SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
