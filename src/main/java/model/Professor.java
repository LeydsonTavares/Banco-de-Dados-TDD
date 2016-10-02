package model;

import exception.ProfessorIndisponivelException;
import exception.ResponsavelNullException;

public class Professor {

	
	private boolean disponibilidade = true;

	private String nome;
	private String codigo;
	private Projeto projeto;
	public static Professor professorLogado = null;

	public boolean getDisponibilidade() {
		return disponibilidade;
	}

	public String getNome() {
		return nome;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setNome(String nome) {
		this.nome = nome;

	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;

	}

	public void setProjeto(Projeto projeto) throws ProfessorIndisponivelException, ResponsavelNullException {
		if (getDisponibilidade() == false) {
			throw new ProfessorIndisponivelException();
		}
		
		projeto.setResponsavel(this);
		this.projeto = projeto;
		this.disponibilidade = false;
		

	}

	public Projeto getProjeto() {
		return this.projeto;
	}
	@Override
	public String toString() {
		return nome;
	}
	

}
