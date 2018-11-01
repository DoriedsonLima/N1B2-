package br.ftt.model;

public class Turma {

	int id;
	int professorId;
	String descricao;
		
	
	public Turma() {
	}

		
	public Turma(int id, int professorId, String descricao) {
		super();
		this.id = id;
		this.professorId = professorId;
		this.descricao = descricao;
	}

	
	public Turma(String id, String professorId, String descricao) {
		super();
		this.setTurmaId(id);
		this.setProfessorId(professorId);
		this.descricao = descricao;
	}


	//Id turma
	public int getTurmaId() {
		return id;
	}
	
	public int getTurmaId(String idS) {
		if(idS != null) {
			this.id = Integer.parseInt(idS);
		}
		else {
			this.id = 0;
		}
		return id;
	}

	public void setTurmaId(int id) {
		this.id = id;
	}
	
	public void setTurmaId(String id) {
		if(id!=null)
			this.id = Integer.parseInt(id);
		else
			this.id = 0;
	}
	
	
	//Id professor
	public int getProfessorId() {
		return professorId;
	}
	
	public int getProfessorId(String idP) {
		if(idP != null) {
			this.professorId = Integer.parseInt(idP);
		}
		else {
			this.professorId = 0;
		}
		return professorId;
	}
	
	

	public void setProfessorId(int professorId) {
		this.professorId = professorId;
	}
	
	public void setProfessorId(String professorId) {
		if(professorId != null)
			this.professorId = Integer.parseInt(professorId);
		else
			this.id = 0;
	}

	//descricao
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}
