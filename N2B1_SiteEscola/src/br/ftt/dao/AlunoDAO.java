package br.ftt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import br.ftt.util.DbUtil;
import br.ftt.model.Aluno;

public class AlunoDAO {
	
	private	Connection conexao;

	public AlunoDAO() {
		conexao = DbUtil.getConnection();
	}
	
	public void insereAluno(Aluno aluno) throws SQLException {
						
		try {
			PreparedStatement p = 
			conexao.prepareStatement("INSERT INTO ALUNO (NomeAluno, CPFAluno, DataNascimentoAluno, TurmaID) VALUES (?, ?, ?, ?)");
			
			// Parameters start with 1
			p.setString(1, aluno.getNomeAluno());
			p.setString(2, aluno.getCpfAluno());
			p.setDate(3, new java.sql.Date(aluno.getDataNasc().getTime()));
			p.setInt(4, aluno.getTurmaId());
			p.execute();
			p.close();
			
			conexao.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
			conexao.close();
			throw new ArithmeticException("AlunoDAO: isereAluno: " + e.getMessage());
		}
	}// inserir aluno -- ok funcionando !
	
	public Aluno getAlunoId(String id) {
		 
    	Aluno a = new Aluno();
    	//SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    	
    	try {
            PreparedStatement preparedStatement = 
            conexao.prepareStatement("SELECT * FROM ALUNO WHERE ID=?");
            
            preparedStatement.setString(1,id); // envia id como string
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                a.setId(rs.getString("ID"));
                a.setNomeAluno(rs.getString("NomeAluno"));
                a.setCpfAluno(rs.getString("CPFAluno"));
                
                a.setDataNasc((rs.getDate("DataNascimentoAluno")));
                a.setTurmaId(rs.getString("TurmaID"));
            }
            	            
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ArithmeticException("AlunoDAO: getAluno: " + e.getMessage());
        }
       
    	return a;
    } //retorna pesquisa do aluno por id -- ok funcionando !
 
	
	 public void deletarAluno(String id) {
	        try {
	            
	        	PreparedStatement p = 
	        	conexao.prepareStatement("DELETE FROM ALUNO WHERE ID=?");
	            
	            // Parameters start with 1
	            p.setInt(1, Integer.parseInt(id));
	        	p.execute();
	            p.close();          
	           

	        } catch (SQLException e) {
	            e.printStackTrace();
	            throw new ArithmeticException("AlunoDAO: deleteAluno: " + e.getMessage());	            
	        }
	    } //delete aluno -- ok funcionando !
	
	 
	 public void updateAluno(Aluno aluno) throws SQLException {
	        try {
	            PreparedStatement p = 
	            conexao.prepareStatement("UPDATE ALUNO SET NomeAluno=?, " 
	                    		                          + "CPFAluno=?, " 
	                    		                          + "DataNascimentoAluno=?, "
	                    		                          + "TurmaID=?"	                    		                          	                    		                          + "VALUE=? " 
	                    		                          + "WHERE ID=?");
	            // Parameters start with 1
	         	p.setString(1, aluno.getNomeAluno());
				p.setString(2, aluno.getCpfAluno());
				p.setDate(3, new java.sql.Date(aluno.getDataNasc().getTime()));
				p.setInt(4, aluno.getTurmaId());
				p.setInt(5,aluno.getId());
	            p.executeUpdate();
	            p.close();
	            conexao.close();

	        } catch (SQLException e) {
	        	e.printStackTrace();
	        	throw new ArithmeticException("AlunoDAO: updateAluno: " + e.getMessage());
	        }
	    } //update aluno
	 
}
