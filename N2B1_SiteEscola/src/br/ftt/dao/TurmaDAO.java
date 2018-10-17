package br.ftt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import br.ftt.util.DbUtil;
import br.ftt.model.Turma;

public class TurmaDAO {

	private Connection connection;
	
	public TurmaDAO() {
		connection = DbUtil.getConnection();
	}
	
	
	public void addTurma(Turma turma) {
		
		try {
			PreparedStatement preparedStatement = connection
            .prepareStatement("INSERT INTO TURMA (ID, Descricao, ProfessorID ) VALUES (?, ?, ?)");
			
			// Parameters start with 1
			preparedStatement.setString(1, turma.getDescricao());
			preparedStatement.setInt(2, turma.getProfessorId());
						
			System.out.println("Turma salva com sucesso !");
		}
		catch (SQLException e) {
			e.printStackTrace();
			throw new ArithmeticException("TurmaDAO: addTurma: " + e.getMessage());
		}
	}// inserir turma

	public Turma getTurmaID(String id) {
			 
	    	Turma t = new Turma();
	    	
	    	try {
	            PreparedStatement preparedStatement = connection.
	                    prepareStatement("SELECT * FROM TURMA WHERE ID=?");
	            
	            preparedStatement.setString(1,id); // envia id como string
	            ResultSet rs = preparedStatement.executeQuery();

	            if (rs.next()) {
	                t.setTurmaId(rs.getString("ID"));
	                t.setDescricao(rs.getString("Descricao"));	              
	                t.setProfessorId(rs.getString("ProfessorID"));
	            }
	            	            
	        } catch (SQLException e) {
	            e.printStackTrace();
	            throw new ArithmeticException("TurmaDAO: getTurma: " + e.getMessage());
	        }
	    	return t;
		}//retorna pesquisa turma pelo id
}
