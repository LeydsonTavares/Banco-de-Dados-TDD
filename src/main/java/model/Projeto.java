package model;

import exception.AlunolNullException;
import exception.AlunolPeriodoInvalidoException;
import exception.ProfessorIndisponivelException;
import exception.ResponsavelNullException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Projeto {

	private Professor professor;
	private Aluno aluno;
	
	private ObservableList<Aluno> equipe = FXCollections.observableArrayList();
	private ObservableList<Tecnologia> tecnologias = FXCollections.observableArrayList();
	private String dataInicio;
	private String dataConclusao;
	private String titulo;
	private String link;
	private String descricao;
	private String area;
	
	

	public void setResponsavel(Professor professor) throws ResponsavelNullException, ProfessorIndisponivelException {

		if (professor == null) {
			throw new ResponsavelNullException();
		}

		if (professor.getDisponibilidade() == false) {
			throw new ProfessorIndisponivelException();

		}

		this.professor = professor;

	}

	public Professor getResponsavel() {
		return professor;

	}

	public void setAluno(Aluno aluno) throws AlunolNullException, AlunolPeriodoInvalidoException {
		if (aluno == null) {
			throw new AlunolNullException();
		}
		if (aluno.getPeriodo() < 4) {
			throw new AlunolPeriodoInvalidoException();
		}

		this.equipe.add(aluno);

	}

	public void setDataInicio(String data) {
		this.dataInicio = data;

	}

	public void setDataConclusao(String data) {
		this.dataConclusao = data;

	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;

	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;

	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public void setTecnologia(Tecnologia tecnologia) {
		this.tecnologias.add(tecnologia);

	}

	public String getDataInicio() {
		return this.dataInicio;
	}

	public String getDataConclusao() {
		return this.dataConclusao;
	}

	public Aluno getAluno() {
		return this.aluno;
	}

	public ObservableList<Aluno> getEquipe() {
		return this.equipe;
	}

	public String getLink() {
		return link;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public ObservableList<Tecnologia> getTecnologia() {
		return this.tecnologias;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Projeto other = (Projeto) obj;
		if (professor == null) {
			if (other.professor != null)
				return false;
		} else if (!professor.equals(other.professor))
			return false;
		return true;
	}
	

}
