package models;

import java.util.List;
import java.util.ArrayList;
public class RepositorioDePostagens {

	private List<Postagem> postagens = new ArrayList<>();
	
	public void incluir(Postagem postagem) {
		postagens.add(postagem);
	}
	
	public List<Postagem> consultar(int id, String texto, String hashtag, Perfil perfil){
		List<Postagem> retornarPostagens = new ArrayList<>();
			for (Postagem postagem : postagens) {
				if (postagem instanceof PostagemAvancada) {
					PostagemAvancada postagemAvancada = (PostagemAvancada) postagem;
					if (id > 0  && (postagem.getId() == id)
							|| (!texto.isEmpty() && texto != null && texto.equals(postagem.getTexto()))
							|| (!hashtag.isEmpty() && hashtag != null && hashtag.equals(postagemAvancada.getHashtag(hashtag)))
							|| (perfil != null && perfil.equals(postagemAvancada.getPerfil()))) 
					{
						retornarPostagens.add(postagemAvancada);
					}
				}
				else {
	                if ((id > 0 && postagem.getId() == id)
	                        || (texto != null && !texto.isEmpty() && texto.equals(postagem.getTexto()))
	                        || (perfil != null && perfil.equals(postagem.getPerfil()))) {
	                    retornarPostagens.add(postagem);
	                }
		}
	}
		return retornarPostagens;
}
	
	public Postagem consultarPostagemPorID (int id) {
		for (Postagem postagem : postagens) {
			if (postagem.getId() == id) {
				return postagem;
			}
		}
		return null;
	}
	
	public boolean existePostagem(Postagem postagem) {
		for (Postagem postagem1 : postagens) {
			if (postagem.getId() == postagem1.getId()) {
				return true;
			}
		}
		return false;
	}
	
	public boolean atributosPreenchidosPostagem(Postagem postagem) {
		return postagem.getId() > 0
				&& !postagem.getTexto().isEmpty() && postagem.getTexto() != null
				&& postagem.getPerfil() != null;
	}
}
