package model;

public class Aluno {

	private String nome;
	private String matricula;
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

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		if (matricula == null) {
			if (other.matricula != null)
				return false;
		} else if (!matricula.equals(other.matricula))
			return false;
		return true;
	}

}
