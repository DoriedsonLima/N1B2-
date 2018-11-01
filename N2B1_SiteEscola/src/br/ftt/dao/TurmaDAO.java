package br.ftt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import br.ftt.util.DbUtil;
import br.ftt.model.Turma;

public class TurmaDAO {

	private	Connection conexao;
	
	public TurmaDAO() {
		conexao = DbUtil.getConnection();
	}
	
	// inserir turma funcionando !
	public void insereTurma(Turma turma) throws SQLException {
		
		try {
			PreparedStatement p = 
			conexao.prepareStatement("INSERT INTO TURMA (Descricao, ProfessorID ) VALUES (?, ?)");
			
			// Parameters start with 1
			p.setString(1, turma.getDescricao());
			p.setInt(2, turma.getProfessorId());
			p.execute();
			p.close();
			
			conexao.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
			conexao.close();
			throw new ArithmeticException("TurmaDAO: Insere Turma: " + e.getMessage());
		}
	}

	// get turma funcionando !
	public Turma getTurmaID(String id) {
			 
	    	Turma t = new Turma();
	    	
	    	try {
	            PreparedStatement preparedStatement = 
	            conexao.prepareStatement("SELECT * FROM TURMA WHERE ID=?");
	            
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
		}
	
	// deletar turma funcionando ! 
	public void deletarTurma(String id) {
	        try {
	            
	        	PreparedStatement p = 
	        	conexao.prepareStatement("DELETE FROM TURMA WHERE ID=?");
	            
	            // Parameters start with 1
	            p.setInt(1, Integer.parseInt(id));
	        	p.execute();
	            p.close();          
	           
	        } catch (SQLException e) {
	            e.printStackTrace();
	            throw new ArithmeticException("TurmaDAO: deleteTurma: " + e.getMessage());	            
	        }
	    } //delete turma 
}
