package br.ftt.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import br.ftt.dao.ProfessorDAO;
import br.ftt.model.Professor;



/**
 * Servlet implementation class ProfessorApi
 */
@WebServlet("/ProfessorApi")
public class ProfessorApi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfessorApi() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ProfessorDAO professorDAO = new ProfessorDAO();
		Professor professorVO = professorDAO.getProfessor(request.getParameter("id"));
		
		Gson professorGson = new GsonBuilder().create(); // cria objeto Gson professor
				
		response.getWriter().append(professorGson.toJson(professorVO, Professor.class));
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
					
		response.getWriter().append("POST Professor !").append(request.getContextPath());
		
		Professor p = new Professor();
		
		p.setId(request.getParameter("0")); //ID sera gerado no BD pela sequence
		p.setNomeProfessor(request.getParameter("name"));
		p.setCpfProfessor(request.getParameter("cpf"));
		p.setDataNasc(request.getParameter("DataNasc"));
		p.setRegistro(request.getParameter("Carteira"));
		
		ProfessorDAO prof = new ProfessorDAO();
		prof.addProfessor(p);
				
	}

}
