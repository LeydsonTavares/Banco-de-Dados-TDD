package data;

import java.util.LinkedList;
import java.util.List;
import exception.AlunolNullException;
import exception.AlunolPeriodoInvalidoException;
import exception.ProfessorIndisponivelException;
import exception.ResponsavelNullException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Aluno;
import model.Professor;
import model.Projeto;
import model.Tecnologia;

public class ProjetoLIST implements ProjetoDAO {

	
	private List<Projeto> projetos = new LinkedList<Projeto>();
	private List<Professor> professores = new LinkedList<Professor>();
	public ObservableList<Aluno> alunos = FXCollections.observableArrayList();
	public ObservableList<Tecnologia> tecnologias = FXCollections.observableArrayList();
	
	private ObservableList<Projeto> obsProjeto = FXCollections.observableArrayList();
	
	private static ProjetoLIST instance = new ProjetoLIST();

	
	private ProjetoLIST(){
		try {
			popularDados();
		} catch (ProfessorIndisponivelException | ResponsavelNullException | AlunolNullException
				| AlunolPeriodoInvalidoException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		
	}

	// Retorna uma única instancia da classe
	public static ProjetoLIST getInstance() {
		return instance;

	}

	// Cadastra Projeto
	public void cadastrarProjeto(Projeto projeto) {
		this.projetos.add(projeto);

	}

	// Atualiza Projeto com novos Dados
	public void atualizarProjeto(Projeto projeto) {
		for (Projeto newProjeto : projetos) {
			if (newProjeto.equals(projeto)) {
				newProjeto = projeto;
			}

		}

	}

	// Retorna Todos Projetos Cadastrados
	public List<Projeto> listarProjeto() {
		return this.projetos;
	}

	// excluir Projeto 
	public void excluirProjeto(Projeto projeto) {
		projetos.remove(projeto);

	}

	// Pesquisar por Título
	public List<Projeto> pesquisarProjetoTitulo(String titulo) {
		obsProjeto.clear();
		for (Projeto newProjeto : projetos) {
			if (newProjeto.getTitulo().equals(titulo)) {
				obsProjeto.add(newProjeto);
			}
		}
		return obsProjeto;

	}
	// Pesquisar por Responsavel
	public Projeto pesquisarProjetoResponsavel(String nomeProf) {
		Projeto projeto = null;
		for (Projeto newProjeto : projetos) {
			if (newProjeto.getResponsavel().getNome().equals(nomeProf)) {
				projeto = newProjeto;
			}

		}
		return projeto;
	}

	// Pesquisar por Data Inicio
	public List<Projeto> pesquisarProjetoDataInicio(String dataInicio) {
		obsProjeto.clear();
		for (Projeto newProjeto : projetos) {
			if (newProjeto.getDataInicio().equals(dataInicio)) {
				
				obsProjeto.add(newProjeto);
			}
		}
		return obsProjeto;
	}

	// Pesquisar por Data Conclusão
	public List<Projeto> pesquisarProjetoDataConclusao(String dataConclusao) {
		obsProjeto.clear();
		for (Projeto newProjeto : projetos) {
			if (newProjeto.getDataConclusao().equals(dataConclusao)) {
				obsProjeto.add(newProjeto);
			}
		}
		return obsProjeto;
	}

	// Pesquisar por Tecnologia
	public List<Projeto> pesquisarProjetoTecnologia(String tec) {
		obsProjeto.clear();
		for (Projeto newProjeto : projetos) {
			for (Tecnologia newTecnologia : newProjeto.getTecnologia()) {
				if(newTecnologia.getNome().equals(tec)){
					obsProjeto.add(newProjeto);
				}
			}
		}
		return obsProjeto;
	}
	
	// Inserindo Dados fake
	public void popularDados() throws ProfessorIndisponivelException, ResponsavelNullException, AlunolNullException, AlunolPeriodoInvalidoException {
		// Criando Professor
		Professor p1 = new Professor();
		Professor p2 = new Professor();
		Professor p3 = new Professor();
		Professor p4 = new Professor();
		Professor p5 = new Professor();
		
		professores.add(p1);
		professores.add(p2);
		professores.add(p3);
		professores.add(p4);
		professores.add(p5);

		// Criando Projeto

		Projeto pr1 = new Projeto();
		Projeto pr2 = new Projeto();
		Projeto pr3 = new Projeto();
		Projeto pr4 = new Projeto();
		Projeto pr5 = new Projeto();

		// Criando Tecnologia

		Tecnologia tec1 = new Tecnologia();
		Tecnologia tec2 = new Tecnologia();
		Tecnologia tec3 = new Tecnologia();
		Tecnologia tec4 = new Tecnologia();
		Tecnologia tec5 = new Tecnologia();
		
		tecnologias.add(tec1);
		tecnologias.add(tec2);
		tecnologias.add(tec3);
		tecnologias.add(tec4);
		tecnologias.add(tec5);

		// Criando Alunos

		Aluno a1 = new Aluno();
		Aluno a2 = new Aluno();
		Aluno a3 = new Aluno();
		Aluno a4 = new Aluno();
		Aluno a5 = new Aluno();
		Aluno a6 = new Aluno();
		Aluno a7 = new Aluno();
		Aluno a8 = new Aluno();
		Aluno a9 = new Aluno();
		Aluno a10 = new Aluno();
		
		alunos.add(a1);
		alunos.add(a2);
		alunos.add(a3);
		alunos.add(a4);
		alunos.add(a5);
		alunos.add(a6);
		alunos.add(a7);
		alunos.add(a8);
		alunos.add(a9);
		alunos.add(a10);
		
		

		p1.setCodigo("1010");
		p1.setNome("Adriano Santos");
		//p1.setProjeto(pr1);

		p2.setCodigo("1011");
		p2.setNome("Jemerson");
		p2.setProjeto(pr2);

		p3.setCodigo("1012");
		p3.setNome("Abella");
		p3.setProjeto(pr3);

		p4.setCodigo("1013");
		p4.setNome("Hamurabi");
		p4.setProjeto(pr4);

		p5.setCodigo("1014");
		p5.setNome("Bruno de Brito");
		p5.setProjeto(pr5);

		tec1.setNome("HTML 5");
		tec1.setTipo("Front-end");
		tec1.setLink("https://pt.wikipedia.org/wiki/HTML5");

		tec2.setNome("AngularJS");
		tec2.setTipo("Framework");
		tec2.setLink("https://angularjs.org/");

		tec3.setNome("JavaScript");
		tec3.setTipo("Programming language");
		tec3.setLink("http://www.w3schools.com/js/default.asp");

		tec4.setNome(".NET");
		tec4.setTipo("Framework");
		tec4.setLink("https://pt.wikipedia.org/wiki/Microsoft_.NET");

		tec5.setNome("Scene Builder");
		tec5.setTipo("Front-end");
		tec5.setLink("http://gluonhq.com/labs/scene-builder/");

		a1.setMatricula("1423080014");
		a1.setNome("Leydson Tavares");
		a1.setPeriodo(5);

		a2.setMatricula("1423080012");
		a2.setNome("Fernanda Mendonça");
		a2.setPeriodo(5);

		a3.setMatricula("1423080010");
		a3.setNome("Doglas Noiado");
		a3.setPeriodo(5);

		a4.setMatricula("1423080011");
		a4.setNome("Emerson Cantalice");
		a4.setPeriodo(5);

		a5.setMatricula("1423080015");
		a5.setNome("Alberto Junior");
		a5.setPeriodo(5);
		
		a6.setMatricula("1423080016");
		a6.setNome("Nesomar");
		a6.setPeriodo(5);
		
		a7.setMatricula("1423080017");
		a7.setNome("Denner ");
		a7.setPeriodo(5);
		
		a8.setMatricula("1423080018");
		a8.setNome("Arthur Martins");
		a8.setPeriodo(5);
		
		a9.setMatricula("1423080019");
		a9.setNome("Jair Cavalcante");
		a9.setPeriodo(5);
		
		a10.setMatricula("1423080020");
		a10.setNome("Bruno");
		a10.setPeriodo(5);

		pr1.setArea("Sistemas de Informação");
		pr1.setDataInicio("30/09/2016");
		pr1.setDataConclusao("06/10/2016");
		pr1.setTitulo("Projeto BD2");
		pr1.setLink("https://sites.google.com/site/adrianosantospb/facisa/disciplinas/banco-de-dados-ii");
		pr1.setDescricao(
				"manager projects é um software que possui recursos capazes de manipular as informações dos Projetos");
		pr1.setTecnologia(tec1);
		pr1.setTecnologia(tec2);
		pr1.setTecnologia(tec3);
		pr1.setAluno(a1);
		pr1.setAluno(a2);

		pr2.setArea("Sistemas de Informação");
		pr2.setDataInicio("30/09/2016");
		pr2.setDataConclusao("06/10/2016");
		pr2.setTitulo("Projeto BD2");
		pr2.setLink("https://sites.google.com/site/adrianosantospb/facisa/disciplinas/banco-de-dados-ii");
		pr2.setDescricao(
				"manager projects é um software que possui recursos capazes de manipular as informações dos Projetos");
		pr2.setTecnologia(tec1);
		pr2.setTecnologia(tec2);
		pr2.setAluno(a3);
		pr2.setAluno(a4);

		pr3.setArea("Real time");
		pr3.setDataInicio("30/09/2016");
		pr3.setDataConclusao("06/10/2016");
		pr3.setTitulo("Projeto LAB2");
		pr3.setLink("https://sites.google.com/site/adrianosantospb/facisa/disciplinas/banco-de-dados-ii");
		pr3.setDescricao(
				"manager projects é um software que possui recursos capazes de manipular as informações dos Projetos");
		pr3.setTecnologia(tec4);
		pr3.setTecnologia(tec5);
		pr3.setTecnologia(tec3);
		pr3.setAluno(a5);
		pr3.setAluno(a6);

		pr4.setArea("Jogos Digitais");
		pr4.setDataInicio("30/09/2016");
		pr4.setDataConclusao("06/10/2016");
		pr4.setTitulo("Projeto ATAL");
		pr4.setLink("https://sites.google.com/site/adrianosantospb/facisa/disciplinas/banco-de-dados-ii");
		pr4.setDescricao(
				"manager projects é um software que possui recursos capazes de manipular as informações dos Projetos");
		pr4.setTecnologia(tec1);
		pr4.setTecnologia(tec4);
		pr4.setTecnologia(tec5);
		pr4.setAluno(a7);
		pr4.setAluno(a8);

		pr5.setArea("Sistemas de Distribuidos");
		pr5.setDataInicio("30/09/2016");
		pr5.setDataConclusao("06/10/2016");
		pr5.setTitulo("Projeto Auditoria");
		pr5.setLink("https://sites.google.com/site/adrianosantospb/facisa/disciplinas/banco-de-dados-ii");
		pr5.setDescricao(
				"manager projects é um software que possui recursos capazes de manipular as informações dos Projetos");
		pr5.setTecnologia(tec5);
		pr5.setTecnologia(tec1);
		pr5.setTecnologia(tec2);
		pr5.setAluno(a9);
		pr5.setAluno(a10);
		
		
		//projetos.add(pr1);
		projetos.add(pr2);
		projetos.add(pr3);
		projetos.add(pr4);
		projetos.add(pr5);
		
		

	}

	public List<Professor> getProfessores() {
		return professores;
	}

	

	public List<Aluno> getAlunos() {
		return alunos;
	}

	

	public List<Tecnologia> getTecnologias() {
		return tecnologias;
	}

	


}
