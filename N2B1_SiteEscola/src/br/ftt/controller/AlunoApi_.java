package br.ftt.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

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
 * Servlet implementation class AlunoApi_
 */
@WebServlet("/AlunoApi_")
public class AlunoApi_ extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String JSON_ERRO_PARAMETERS = "{\"Status\" : \"Erro, Parametros Invalidos\"}";  
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlunoApi_() {
        super();
        // TODO Auto-generated constructor stub
    }
    
 private boolean isValidNumber(HttpServletRequest request) {
    	
    	if(request.getParameter("id") == null)//Se for nulo
			return false;
		else if(request.getParameter("id").equals(""))//Ou se for vazio
			return false;
		else {//Ou senão for número
			try {
				long val = Long.parseLong(request.getParameter("id"));
			}catch(Exception e) {
				return false;
			}
		}
    	return true;
    }
    
    private boolean isValidParameters(HttpServletRequest request, boolean validId)//Se for para validar o id passar true
    {
    	boolean retorno = true;
    	if(request.getParameter("alunoID") == null)
			return false;
    	else if(request.getParameter("alunoID").equals(""))
    		return false;
    	
    	if(request.getParameter("alunoName") == null)
			return false;
    	else if(request.getParameter("alunoName").equals(""))
    		return false;

		if(request.getParameter("cpf") == null)
			return false;
		else if(request.getParameter("cpf").equals(""))
			return false;

		if(request.getParameter("turmaID") == null)
			return false;
		else if(request.getParameter("turmaID").equals(""))
			return false;
		
		if(validId) {
			retorno = isValidNumber(request);
		}
		    	
    	return retorno;    	
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		AlunoDAO alunoDAO = new AlunoDAO(); // objeto retorno do DAO
		Aluno alunoVO = alunoDAO.getAlunoId(request.getParameter("id")); // VO recebendo DAO
		
		Gson alunoGson = new GsonBuilder().create(); //cria objeto Gson
		response.getWriter().append(alunoGson.toJson(alunoVO, Aluno.class));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Aluno a = new Aluno();		
		a.setId(request.getParameter("0"));
		a.setNomeAluno(request.getParameter("alunoName"));
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

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(isValidParameters(request,true)) {
			
			Aluno aluno = new Aluno(
				request.getParameter("alunoID"),
				request.getParameter("alunoName"),
				request.getParameter("turmaID"),
				request.getParameter("cpf"));
			
			String now = String.valueOf(new Date());
			
			AlunoDAO alunoDAO = new AlunoDAO();
			
			try {
				alunoDAO.updateAluno(aluno);
			} catch (Exception e) {
				System.err.println(now +  " - Ops!! - " + e.getMessage());
				System.err.println(now +  " - Ops!! - " + aluno);
				throw new ArithmeticException("Update Aluno: " + e.getMessage());
			}
		}
		else {
			response.getWriter().print(JSON_ERRO_PARAMETERS);
		}
		response.flushBuffer();
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		AlunoDAO aluno = new AlunoDAO(); // objeto retorno do DAO
		aluno.deletarAluno(request.getParameter("id")); // VO recebendo DAO
	}

}
