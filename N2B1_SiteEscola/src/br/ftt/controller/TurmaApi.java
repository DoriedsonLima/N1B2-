package br.ftt.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import br.ftt.dao.TurmaDAO;
import br.ftt.model.Turma;

/**
 * Servlet implementation class TurmaApi
 */
@WebServlet("/TurmaApi")
public class TurmaApi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TurmaApi() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		TurmaDAO turmaDAO = new TurmaDAO();
		Turma turmaVO = turmaDAO.getTurmaID(request.getParameter("id"));
		
		Gson turmaGson = new GsonBuilder().create(); //cria objeto Gson
		
		response.getWriter().append("GET Turma !").append(request.getContextPath()).append("\n\n");
		response.getWriter().append(turmaGson.toJson(turmaVO,Turma.class));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("POST Turma !").append(request.getContextPath());
	}

}
