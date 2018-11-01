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
 * Servlet implementation class TurmaApi_
 */
@WebServlet("/TurmaApi_")
public class TurmaApi_ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TurmaApi_() {
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
		response.getWriter().append(turmaGson.toJson(turmaVO,Turma.class));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Turma turma = new Turma();
		turma.setTurmaId(request.getParameter("0")); 
		turma.setProfessorId(request.getParameter("professorId")); 
		turma.setDescricao(request.getParameter("descricao")); 
		
		TurmaDAO turmaDAO = new TurmaDAO();
		
		try {
			turmaDAO.insereTurma(turma);
		}
		catch (Exception erro) {
			erro.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		TurmaDAO turma = new TurmaDAO(); // objeto retorno do DAO
		turma.deletarTurma(request.getParameter("id")); 
	}

}
