package br.com.manager.tasks.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.manager.tasks.model.Database;

public class ListTasks implements Action{

	@Override
	public String executes(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Database database = new Database();
		request.setAttribute("tasks", database.getTasks());
		return "forward:listTasks.jsp";
	}

}
