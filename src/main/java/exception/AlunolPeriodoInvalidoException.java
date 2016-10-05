package exception;

public class AlunolPeriodoInvalidoException extends Exception {
	
	@Override
	public String getMessage(){
		return "Periodo do aluno inferior a 4º";
	}

}
