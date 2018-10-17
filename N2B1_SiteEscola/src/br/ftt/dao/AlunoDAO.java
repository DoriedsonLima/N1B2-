package br.ftt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.ftt.util.DbUtil;
import br.ftt.model.Aluno;

public class AlunoDAO {
	
	private	Connection conexao;

	public AlunoDAO() {
		conexao = DbUtil.getConnection();
	}
	
	public void insereAluno(Aluno aluno) throws SQLException {
						
		try {
			PreparedStatement p = conexao.prepareStatement("INSERT INTO ALUNO (NomeAluno, CPFAluno, DataNascimentoAluno, TurmaID ) VALUES (?, ?, ?, ?)");
			
			// Parameters start with 1
			p.setString(1, aluno.getNomeAluno());
			p.setString(2, aluno.getCpfAluno());
			p.setDate(3, new java.sql.Date(aluno.getDataNasc().getTime()));
			p.setInt(4, aluno.getTurmaId());
				
			p.execute();
			p.close();
			
			System.out.println("Aluno salvo com sucesso !");
		}
		catch (SQLException e) {
			e.printStackTrace();
			conexao.close();
			throw new ArithmeticException("AlunoDAO: addAluno: " + e.getMessage());
		}
	}// inserir aluno
	
	public Aluno getAlunoId(String id) {
		 
    	Aluno ap = new Aluno();
    	
    	try {
            PreparedStatement preparedStatement = 
            conexao.prepareStatement("SELECT * FROM ALUNO WHERE ID=?");
            
            preparedStatement.setString(1,id); // envia id como string
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                ap.setId(rs.getString("ID"));
                ap.setNomeAluno(rs.getString("NomeAluno"));
                ap.setCpfAluno(rs.getString("CPFAluno"));
                ap.setDataNasc(rs.getDate("DataNascimentoAluno"));
                ap.setTurmaId(rs.getString("TurmaID"));
            }
            	            
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ArithmeticException("AlunoDAO: getAluno: " + e.getMessage());
        }
       
    	return ap;
    } //retorna pesquisa do aluno por id
 
	
	 public void deletarAluno(String id) {
	        try {
	            
	        	PreparedStatement p = 
	        	conexao.prepareStatement("DELETE FROM ALUNO WHERE ID=?");
	            
	            // Parameters start with 1
	            p.setInt(1, Integer.parseInt(id));
	            p.execute();
	            p.close();
	            
	            System.out.println("Dados do aluno deletados !");

	        } catch (SQLException e) {
	            e.printStackTrace();
	            throw new ArithmeticException("AlunoDAO: deleteAluno: " + e.getMessage());	            
	        }
	    } //delete aluno
	
	 
	 public void updateAluno(Aluno aluno) {
	        try {
	            PreparedStatement preparedStatement = 
	            conexao.prepareStatement("UPDATE ALUNO SET NomeAluno=?, " 
	                    		                          + "CPFAluno=?, " 
	                    		                          + "DataNascimentoAluno=?, "
	                    		                          + "TurmaID"	                    		                          	                    		                          + "VALUE=? " 
	                                               + "WHERE ID=?");
	            
	            // Parameters start with 1
	         	preparedStatement.setString(1, aluno.getNomeAluno());
				preparedStatement.setString(2, aluno.getCpfAluno());
				preparedStatement.setDate(3, new java.sql.Date(aluno.getDataNasc().getTime()));
				preparedStatement.setInt(4, aluno.getTurmaId());;
	      	            
	            preparedStatement.executeUpdate();

	        } catch (SQLException e) {
	            //e.printStackTrace();
	        	throw new ArithmeticException("AlunoDAO: updateAluno: " + e.getMessage());
	            
	        }
	    } //update aluno
	 
}
