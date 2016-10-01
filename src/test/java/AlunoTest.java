import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import model.Aluno;

public class AlunoTest {
	
	private Aluno aluno;
	
	@Before
	public void iniciarTest(){
		this.aluno = new Aluno();
	
	}
	
	
	@Test
	public void testeAluno(){
		
		aluno.setNome("Leydson Tavares");
		aluno.setMatricula("1423080014");
		aluno.setPeriodo(4);
		
		assertEquals ("Leydson Tavares", aluno.getNome());
		assertEquals ("1423080014", aluno.getMatricula());
		assertEquals (4, aluno.getPeriodo());
	}


	
	

}
