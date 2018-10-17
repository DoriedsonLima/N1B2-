package br.ftt.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Professor {
	
	int id;
	String nomeProfessor;
	String cpfProfessor;
	Date dataNasc;
	String registro;
	
	public Professor() {
		
	}
	
	
	public Professor(int id, String nomeProfessor, String cpfProfessor, Date dataNasc, String registro) {
		super();
		this.id = id;
		this.nomeProfessor = nomeProfessor;
		this.cpfProfessor = cpfProfessor;
		this.dataNasc = dataNasc;
		this.registro = registro;
	}
	
	public Professor(String id, String nomeProfessor, String cpfProfessor, Date dataNasc, String registro) {
		super();
		this.setId(id);
		this.nomeProfessor = nomeProfessor;
		this.cpfProfessor = cpfProfessor;
		this.dataNasc = dataNasc;
		this.registro = registro;
	}
	
	
	//Id
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public void setId(String id) {
		if(id!=null)
			this.id = Integer.parseInt(id);
		else
			this.id = 0;
	}
	
	//Nome
	public String getNomeProfessor() {
		return nomeProfessor;
	}
	public void setNomeProfessor(String nomeProfessor) {
		this.nomeProfessor = nomeProfessor;
	}
	
	//cpf
	public String getCpfProfessor() {
		return cpfProfessor;
	}
	public void setCpfProfessor(String cpfProfessor) {
		this.cpfProfessor = cpfProfessor;
	}
	
	//data nasc
	public Date getDataNasc() {
		return dataNasc;
	}
	
	public void setDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
	}
	
	public void setDataNasc(String dob) {
        //formato: 2018-09-20 mascara yyyy-MM-dd
		//formato: 20/09/2018 mascara dd/MM/yyyy
		//referencia: https://docs.oracle.com/javase/6/docs/api/java/text/SimpleDateFormat.html
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); 

		try { 
			this.dataNasc = formatter.parse(dob);
		} catch (Exception e) {
			System.err.println("Ops! Problema com a data: " + dob);
			e.printStackTrace();
		} //try
		
	}
	
	
	//registro
	public String getRegistro() {
		return registro;
	}
	
	public void setRegistro(String registro) {
		this.registro = registro;
	}
	

	
	
	
}
