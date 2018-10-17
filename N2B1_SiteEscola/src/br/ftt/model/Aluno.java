package br.ftt.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Aluno {
	
	int id;
	int turmaId;
	String nomeAluno;
	String cpfAluno;
	Date dataNasc;
	
	public Aluno() {
		
	}
	
	public Aluno(int id, int turmaId, String nomeAluno, String cpfAluno, Date dataNasc) {
		super();
		this.id = id;
		this.turmaId = turmaId;
		this.nomeAluno = nomeAluno;
		this.cpfAluno = cpfAluno;
		this.dataNasc = dataNasc;
	}
	
	public Aluno(String id, String turmaId, String nomeAluno, String cpfAluno, String dataNasc) {
		super();
		this.setId(id);
		this.setTurmaId(turmaId);
		this.setNomeAluno(nomeAluno);
		this.setCpfAluno(cpfAluno);
		this.setDataNasc(dataNasc);
	}
	
	//Id
	public int getId() {
		return id;
	}
	
	public int getId(String idS) {
		if(idS != null) {
			this.id = Integer.parseInt(idS);
		}
		else {
			this.id = 0;
		}
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setId(String id) {
		if(id != null)
			this.id = Integer.parseInt(id);
		else
			this.id = 0;
	}
	
	//TurmaId	
	public int getTurmaId() {
		return turmaId;
	}
	
	public void setTurmaId(int turmaId) {
		this.turmaId = turmaId;
	}
	
	public void setTurmaId(String turmaId) {
		if(turmaId !=null)
			this.turmaId = Integer.parseInt(turmaId);
		else
			this.turmaId = 0;
	}
	
	//Nome
	public String getNomeAluno() {
		return nomeAluno;
	}
	public void setNomeAluno(String nomeAluno) {
		this.nomeAluno = nomeAluno;
	}
	
	//cpf
	public String getCpfAluno() {
		return cpfAluno;
	}
	public void setCpfAluno(String cpfAluno) {
		this.cpfAluno = cpfAluno;
	}
	
	//Data nascimento
	public Date getDataNasc() {
		return dataNasc;
	}
	
	public void setDataNasc(Date dob) {
		this.dataNasc = dob;
	}
			
	
	public void setDataNasc(String dob) {
        //formato: 2018-09-20 mascara yyyy-MM-dd
		//formato: 20/09/2018 mascara dd/MM/yyyy
		//referencia: https://docs.oracle.com/javase/6/docs/api/java/text/SimpleDateFormat.html
		SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-dd"); 

		try { 
			this.dataNasc = format.parse(dob);
		} 
		catch (Exception e) {
			System.err.println("Ops! Problema com a data: " + dob);
			e.printStackTrace();
		} //try
		
	}
}
