package model;

public class Aluno {
	
	private String nome;
	private String matricula;
	private Projeto projeto;
	private int periodo;

	
	
	public void setNome(String nome) {
		this.nome = nome;
		
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public void setPeriodo(int periodo) {
		this.periodo = periodo;
		
	}
	
	

	public int getPeriodo() {
		return this.periodo;
	}


	public String getMatricula() {
		return this.matricula;
	}


	public String getNome() {
		
		return this.nome;
	}


}
