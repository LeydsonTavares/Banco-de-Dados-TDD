package model;

public class Tecnologia {



	private String nome;
	private String tipo;
	private String link;
	
	
	public Tecnologia() {
		
	}
	

	public void setNome(String nome) {
		this.nome = nome;

	}

	public void setTipo(String tipo) {
		this.tipo = tipo;

	}

	public void setLink(String link) {

		this.link = link;
	}

	public String getNome() {

		return this.nome;
	}

	public String getTipo() {
		return this.tipo;
	}

	public String getLink() {
		
		return this.link;
	}

}
