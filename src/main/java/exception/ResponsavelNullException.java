package exception;

public class ResponsavelNullException extends Exception {
	
	@Override
	public String getMessage(){
		return "Professor não existe na base de Dados";
	}

}
