package data;

import java.util.List;

import model.Professor;
import model.Projeto;
import model.Tecnologia;

public interface ProjetoDAO {
	
	
	public void cadastrarProjeto(Projeto projeto);
	
	public List<Projeto> pesquisarProjetoTitulo(String titulo);
	
	public Projeto pesquisarProjetoResponsavel(String prof);
	
	public List<Projeto> pesquisarProjetoDataInicio(String dataInicio);
	
	public List<Projeto> pesquisarProjetoDataConclusao(String dataConclusao);
	
	public List<Projeto> pesquisarProjetoTecnologia(String tec);
	
	public void atualizarProjeto(Projeto projeto);
	
	public List<Projeto> listarProjeto();
	
	public void excluirProjeto(Projeto projeto);
	
	
}
