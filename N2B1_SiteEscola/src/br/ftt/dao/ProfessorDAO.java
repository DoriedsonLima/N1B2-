package br.ftt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.ftt.model.Professor;
import br.ftt.util.DbUtil;

public class ProfessorDAO {

	private Connection connection;

	public ProfessorDAO() {
		connection = DbUtil.getConnection();
	}

	public void addProfessor(Professor professor) {
		
		try {
			PreparedStatement preparedStatement = connection
            .prepareStatement("INSERT INTO PROFESSOR (ID, NomeProfessor, CPFProfessor, DataDeNascimentoProfessor, Registro ) VALUES (?, ?, ?, ?, ?)");
			
			// Parameters start with 1
			preparedStatement.setInt(1, professor.getId());
			preparedStatement.setString(2, professor.getNomeProfessor());
			preparedStatement.setString(3, professor.getCpfProfessor());
			preparedStatement.setDate(4, new java.sql.Date(professor.getDataNasc().getTime()));
			preparedStatement.setString(5, professor.getRegistro());
				
			preparedStatement.executeUpdate();
		}
		catch (SQLException e) {
			e.printStackTrace();
			
			throw new ArithmeticException("ProfessorDAO: addProfessor: " + e.getMessage());
		}
	}// adicionar professor
	
	
	public Professor getProfessor(String id) {
		
		Professor p = new Professor();
		
    	try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("SELECT * FROM PROFESSOR WHERE ID=?");
            
            preparedStatement.setString(1,id); // envia id como string
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                p.setId(rs.getString("ID"));
                p.setNomeProfessor(rs.getString("NomeProfessor"));
                p.setCpfProfessor(rs.getString("CPFProfessor"));
                p.setDataNasc(rs.getDate("DataDeNascimentoProfessor"));
                p.setRegistro(rs.getString("Registro"));
            }
            	            
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ArithmeticException("ProfessorDAO: getProfessor: " + e.getMessage());
        }
       
    	return p;
    } //retorna pesquisa do professor por id
		
	
	public void deleteProfessor(String id) {
	        try {
	            
	        	PreparedStatement preparedStatement = connection
	            .prepareStatement("DELETE FROM PROFESSOR WHERE ID=?");
	            
	            // Parameters start with 1
	            preparedStatement.setString(1, id);
	            preparedStatement.executeUpdate();
	            
	            System.out.println("Dados do professor deletados !");

	        } catch (SQLException e) {
	            e.printStackTrace();
	            throw new ArithmeticException("ProfessorDAO: deleteProfessor: " + e.getMessage());
	        }
	    } //delete professor
	
	
	
}
