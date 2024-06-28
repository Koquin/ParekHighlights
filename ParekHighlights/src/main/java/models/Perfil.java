package models;

public class Perfil {
	private static int id;
	private String nome;
	private String email;
	
	
	public Perfil(String nome, String email) {
		this.id++;
		this.nome = nome;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}
	
	@Override
	public String toString() {
		return "[ID]" + this.getId() + "\n[NOME]" + this.getNome() + "\n[EMAIL]" + this.getEmail();
	}
}
