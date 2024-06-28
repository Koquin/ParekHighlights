package models;
import java.util.Date;

public class Postagem {
	
	private int id;
	private String texto;
	private int curtidas;
	private int descurtidas;
	private Date data;
	private Perfil perfil;
	
	
	public Postagem(int id, String texto, Date data, Perfil perfil) {
		this.id = id;
		this.texto = texto;
		this.curtidas = 0;
		this.descurtidas = 0;
		this.data = data;
		this.perfil = perfil;
	}

	public void curtir() {
		this.curtidas++;
	}
	
	public void descurtir() {
		this.descurtidas++;
	}
	
	public boolean ehPopular() {
		return this.curtidas > (this.descurtidas * 1.5);
	}

	public String getTexto() {
		return texto;
	}
	
	public int getCurtidas() {
		return curtidas;
	}

	public int getDescurtidas() {
		return descurtidas;
	}

	public Date getData() {
		return data;
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public int getId() {
		return id;
	}

}
