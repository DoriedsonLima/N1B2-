package br.ftt.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import br.ftt.dao.AlunoDAO;
import br.ftt.model.Aluno;

/**
 * Servlet implementation class AlunoApi
 */
@WebServlet("/AlunoApi")
public class AlunoApi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlunoApi() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		AlunoDAO alunoDAO = new AlunoDAO(); // objeto retorno do DAO
		Aluno alunoVO = alunoDAO.getAlunoId(request.getParameter("id")); // VO recebendo DAO
		
		Gson alunoGson = new GsonBuilder().create(); //cria objeto Gson
				
		response.getWriter().append("GET Aluno !").append(request.getContextPath()).append("\n\n");
		response.getWriter().append(alunoGson.toJson(alunoVO, Aluno.class));
					
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		Aluno a = new Aluno();
				
		a.setId(request.getParameter("0"));
		a.setNomeAluno(request.getParameter("name"));
		a.setCpfAluno(request.getParameter("cpf"));
		a.setDataNasc(request.getParameter("DataNasc"));
		a.setTurmaId(request.getParameter("turmaID"));
				
		AlunoDAO alunoDAO = new AlunoDAO();
		
		try {
			alunoDAO.insereAluno(a);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		//retorno
		response.getWriter().println(a.getNomeAluno());
	}
	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		AlunoDAO alunoDAO = new AlunoDAO(); // objeto retorno do DAO
		alunoDAO.deletarAluno(request.getParameter("id")); // VO recebendo DAO
	}

}
