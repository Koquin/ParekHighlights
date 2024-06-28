package models;
import java.time.LocalDate;
public class Postagem {
	
	private static int id;
	private String texto;
	private int curtidas;
	private int descurtidas;
	private LocalDate data;
	private Perfil perfil;
	
	
	public Postagem(String texto, Perfil perfil) {
		this.id++;
		this.texto = texto;
		this.curtidas = 0;
		this.descurtidas = 0;
		this.data = data.now();
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

	public LocalDate getData() {
		return data;
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		if (this.ehPopular()) {
			return 	"--- POPULAR ---"
			+"\n[ID] " + getId()
			+"\n[Curtidas] " + getCurtidas() 
			+"\n[Descutidas] " + getDescurtidas()
			+"\n[Data do post] " + getData()
			+"\n[Autor] " + getPerfil()
			+"\n[Conteúdo] " + getTexto();
		}
		else {
			return "[ID] " + getId()
			+"\n[Curtidas] " + getCurtidas() 
			+"\n[Descutidas] " + getDescurtidas()
			+"\n[Data do post] " + getData()
			+"\n[Autor] " + getPerfil()
			+"\n[Conteúdo] " + getTexto();
		}
	}
	
	

}
