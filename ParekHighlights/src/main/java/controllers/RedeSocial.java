package controllers;

import java.util.ArrayList;
import java.util.List;

import models.*;


public class RedeSocial {
	private RepositorioDePostagens repositorioDePostagens = new RepositorioDePostagens();
	private RepositorioDePerfis repositorioDePerfis = new RepositorioDePerfis();
	
	public void incluirPerfil(Perfil perfil) {
		if (!repositorioDePerfis.existePerfil(perfil) && repositorioDePerfis.atributosPreenchidosPerfil(perfil)) {
			repositorioDePerfis.incluir(perfil);
		}
	}
	
	public List<Perfil> consultarPerfil(int id, String nome, String email){
		return repositorioDePerfis.consultar(id, nome, email);
	}
	
	public void incluirPostagem (Postagem postagem) {
		if (!repositorioDePostagens.existePostagem(postagem) && repositorioDePostagens.atributosPreenchidosPostagem(postagem)) {
			repositorioDePostagens.incluir(postagem);
		}
	}
	
	public List<Postagem> consultarPostagem (int id, String texto, String hashtag, Perfil perfil) {
		return repositorioDePostagens.consultar(id, texto, hashtag, perfil);
	}
	
	public void curtir (int idPostagem) {
		Postagem curtirPostagem = (Postagem)consultarPostagem(idPostagem, null, null, null);
		curtirPostagem.curtir();
	}
	
	public void descurtir (int idPostagem) {
		Postagem descurtirPostagem = (Postagem)consultarPostagem(idPostagem, null, null, null);
		descurtirPostagem.descurtir();
	}
	
	public boolean decrementarVisualizações(PostagemAvancada postagem) {
		if (postagem.getVisualizacoesRestantes() > 0) {
			postagem.decrementarVisualizacoes();
			return true;
		}
		return false;
	}
	
	public List<Postagem> exibirPostagensPorPerfil(int id){
		Perfil perfilPostagens = (Perfil)repositorioDePerfis.consultar(id, null, null);
		List<Postagem> postagensExibidas = repositorioDePostagens.consultar(0, null, null, perfilPostagens);
		for (Postagem postagem : postagensExibidas) {
			if (postagem instanceof PostagemAvancada) {
				if (this.decrementarVisualizações((PostagemAvancada)postagem)) {
					postagensExibidas.add(postagem);
				}
			}
			else {
				postagensExibidas.add(postagem);
			}
		}
		return postagensExibidas;
	}
	
	public List<Postagem> exibirPostagensPorHashtag(String hashtag){
		List<Postagem> postagensExibidas = new ArrayList<>();
		for (Postagem postagem : repositorioDePostagens.consultar(0, null, hashtag, null)) {
			if (this.decrementarVisualizações((PostagemAvancada)postagem)) {
				postagensExibidas.add(postagem);
			}
		}
		return postagensExibidas;
	}
}

	
	
	
	
