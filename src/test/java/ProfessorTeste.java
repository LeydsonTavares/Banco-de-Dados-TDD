import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import exception.ProfessorIndisponivelException;
import exception.ResponsavelNullException;
import model.Professor;
import model.Projeto;

public class ProfessorTeste {
	

	private Projeto projeto;
	private Professor professor;
	
	@Before
	public void iniciarTest(){
		projeto = new Projeto();
		professor = new Professor();
		
	}
	
	@Test
	public void testeProfessor(){
		
		professor.setNome("Adiano Santos");
		professor.setCodigo("058999");
		
		assertEquals("Adiano Santos",professor.getNome());
		assertEquals("058999",professor.getCodigo());
		
		
		
	}
	@Test
	public void testDisponibilidadeValido() throws ProfessorIndisponivelException, ResponsavelNullException{
		professor.setProjeto(projeto);
		assertEquals(projeto, professor.getProjeto());
		
	}
	
	
    @Test(expected = ProfessorIndisponivelException.class)
    public void testDisponibilidadeInvalido() throws ProfessorIndisponivelException, ResponsavelNullException{
    	professor.setProjeto(projeto);
    	professor.setProjeto(new Projeto());
    	
    }
}
