import static org.junit.Assert.assertEquals;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import exception.AlunolNullException;
import exception.AlunolPeriodoInvalidoException;
import exception.ProfessorIndisponivelException;
import exception.ResponsavelNullException;
import model.Aluno;
import model.Professor;
import model.Projeto;
import model.Tecnologia;

public class ProjetoTest {
	
	private Projeto projeto;
	private Professor professor;
	private Aluno aluno;
	private Tecnologia tecnologia;
	
	Calendar calendar = Calendar.getInstance();
	static SimpleDateFormat dateformat = new SimpleDateFormat("DD/MM/yyyy");
	
	
	@Before
	public void iniciarTest(){
		projeto = new Projeto();
		professor = new Professor();
		aluno = new Aluno();
		
	}
	
	
	@Test
	public void testeResponsavelValido() throws ResponsavelNullException, ProfessorIndisponivelException{

		projeto.setResponsavel(professor);
		assertEquals(professor,projeto.getResponsavel());
				
	}
	@Test(expected=ResponsavelNullException.class)
	public void TesteResponsavelNull() throws ResponsavelNullException, ProfessorIndisponivelException{
		projeto.setResponsavel(null);
		
	}
	
	
	@Test
	public void testeAlunoValido() throws AlunolNullException, AlunolPeriodoInvalidoException{
		aluno.setPeriodo(4);
		projeto.setAluno(aluno);	
		assertEquals(aluno,projeto.getAluno());
	}
	
	@Test (expected=AlunolNullException.class)
	public void testAlunoNull() throws AlunolNullException, AlunolPeriodoInvalidoException{
		projeto.setAluno(null);
	}
	
	
	
	@Test
	public void testProjeto() throws AlunolNullException, AlunolPeriodoInvalidoException{
		
	
		
		projeto.setDataInicio("22/09/2016");
		projeto.setDataConclusao("22/09/2017");
		projeto.setTitulo("Stefanini");
		projeto.setLink("https://twitter.com/?lang=pt-br");
		projeto.setDescricao("Projeto LTI ");
		projeto.setArea("Sistemas Distribuidos");
		projeto.setAluno(aluno);
		projeto.setTecnologia(tecnologia);
		
		
		
		assertEquals("22/09/2016",projeto.getDataInicio());
		assertEquals("22/09/2017",projeto.getDataConclusao());
		assertEquals("Stefanini",projeto.getTitulo());
		assertEquals("https://twitter.com/?lang=pt-br", projeto.getLink());
		assertEquals("Projeto LTI ",projeto.getDescricao());
        assertEquals("Sistemas Distribuidos", projeto.getArea());
        assertEquals(aluno,projeto.getAluno());
        assertEquals(tecnologia,projeto.getTecnologia());
		
	}
	
	
	

}
