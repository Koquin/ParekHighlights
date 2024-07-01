package models;
import java.time.LocalDate;
public class Postagem {
	
	private int id;
	private static int idContagem;
	private String texto;
	private int curtidas;
	private int descurtidas;
	private LocalDate data;
	private Perfil perfil;
	
	
	public Postagem(String texto, Perfil perfil) {
		this.idContagem++;
		this.texto = texto;
		this.curtidas = 0;
		this.descurtidas = 0;
		this.data = data.now();
		this.perfil = perfil;
		this.id = idContagem;
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
			+"\n[Autor] " + getPerfil().getNome()
			+"\n[Conteúdo] " + getTexto();
		}
		else {
			return "[ID] " + getId()
			+"\n[Curtidas] " + getCurtidas() 
			+"\n[Descutidas] " + getDescurtidas()
			+"\n[Data do post] " + getData()
			+"\n[Autor] " + getPerfil().getNome()
			+"\n[Conteúdo] " + getTexto();
		}
	}
	
	

}
