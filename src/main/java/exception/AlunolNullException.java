package exception;

public class AlunolNullException extends Exception {
	
	@Override
	public String getMessage(){
		return "Aluno não existe na base de Dados";
	}

}
