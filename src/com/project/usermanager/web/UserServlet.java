package com.project.usermanager.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.usermanager.dao.UserDAO;
import com.project.usermanager.model.User;

@WebServlet("/")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UserDAO userDAO;

    public UserServlet() {
        this.userDAO = new UserDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String action = request.getServletPath();

        try {
            switch (action) {
                case "/new":
                    showNewForm(request, response);
                    break;
                case "/insert":
                   createUser(request, response);
                    break;
                case "/delete":
                    deleteUser(request, response);
                    break;
                case "/edit":
                    showEditForm(request, response);
                    break;
                case "/update":
                    updateUser(request, response);
                    break;
                default:
                    listUser(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

	
	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
		    throws ServletException, IOException {
		        RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
		        dispatcher.forward(request, response);
		    }
	
	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, ServletException, IOException {
				Integer id = Integer.parseInt(request.getParameter("id"));
		        User existingUser = userDAO.findUser(id);
		        RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
		        request.setAttribute("user", existingUser);
		        dispatcher.forward(request, response);

		    }
	
	private void listUser(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException, ServletException {
		        List < User > listUser = userDAO.findAllUsers();
		        request.setAttribute("listUser", listUser);
		        RequestDispatcher dispatcher = request.getRequestDispatcher("user-list.jsp");
		        dispatcher.forward(request, response);
		    }
	
	private void createUser(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException {
		        String name = request.getParameter("name");
		        String cpf = request.getParameter("cpf");
		        String email = request.getParameter("email");
		        String country = request.getParameter("country");
		        User newUser = new User(name,cpf, email, country);
		        userDAO.createUser(newUser);
		        response.sendRedirect("list");
		    }
	
	private void updateUser(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException {
		        int id = Integer.parseInt(request.getParameter("id"));
		        String name = request.getParameter("name");
		        String cpf = request.getParameter("cpf");
		        String email = request.getParameter("email");
		        String country = request.getParameter("country");

		        User book = new User(id,name,cpf, email, country);
		        userDAO.updateUser(book);
		        response.sendRedirect("list");
		    }

	private void deleteUser(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
				Integer id = Integer.parseInt(request.getParameter("id"));
			    userDAO.deleteUser(id);
			    response.sendRedirect("list");
	
	}

}
