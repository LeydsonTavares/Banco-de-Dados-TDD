import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import model.Tecnologia;

public class TecnologiaTest {
	
	private Tecnologia tecnologia;
	
	
	@Before
	public void iniciarTest(){
		this.tecnologia =  new Tecnologia();
	
	}
	
	@Test
	public void testeTecnologia(){
		
		tecnologia.setNome("AngularJS");
		tecnologia.setTipo("Web");
		tecnologia.setLink("https://angularjs.org/");
		
		assertEquals ("AngularJS", tecnologia.getNome());
		assertEquals ("Web", tecnologia.getTipo());
		assertEquals ("https://angularjs.org/", tecnologia.getLink());
		
		
	}
	

}
