package br.com.manager.tasks.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.manager.tasks.action.Action;

/**
 * Servlet implementation class HomeServlet
 */
@WebServlet("/home")
public class ControllerFilter extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest servletRequest, HttpServletResponse servletResponse)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		System.out.println("Controller filter");

		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;

		String paramAction = request.getParameter("action");

		String className = "br.com.manager.tasks.action." + paramAction;
		System.out.println(paramAction);
		String name;

		try {
			Class classe = Class.forName(className);
			Action action = (Action) classe.newInstance();
			name = action.executes(request, response);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			throw new ServletException(e);
		}

		String[] typeAdress = name.split(":");
		if (typeAdress[0].equals("forward")) {
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/" + typeAdress[1]);
			rd.forward(request, response);
		} else {
			response.sendRedirect(typeAdress[1]);
		}
	}
}
