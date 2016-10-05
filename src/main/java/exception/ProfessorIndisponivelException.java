package exception;

public class ProfessorIndisponivelException extends Exception {
	
	@Override
	public String getMessage(){
		return "Professor já está cadastrado em um Projeto";
	}

}
