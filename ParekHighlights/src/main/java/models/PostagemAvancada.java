package models;

import java.util.ArrayList;
import java.util.List;

public class PostagemAvancada extends Postagem {

    private List<String> hashtags = new ArrayList<>();
    private int visualizacoesRestantes;

    public PostagemAvancada(int id, String texto, Perfil perfil, List<String> hashtags, int visualizacoesRestantes) {
        super(texto, perfil);
        if (hashtags != null) {
            this.hashtags = new ArrayList<>(hashtags);
        }
        this.visualizacoesRestantes = visualizacoesRestantes;
    }

    public void adicionarHashtag(String hashtag) {
        hashtags.add(hashtag);
    }

    public boolean existeHashtag(String hashtag) {
        return hashtags.contains(hashtag);
    }

    public void decrementarVisualizacoes() {
        if (this.visualizacoesRestantes > 0) {
            this.visualizacoesRestantes--;
        }
    }

    public List<String> getHashtags() {
        return new ArrayList<>(hashtags);
    }
    
    public String getHashtag(String hashtag) {
    	for (String hashtagI : hashtags) {
    		if (hashtag.equals(hashtagI)) {
    			return hashtagI;
    		}
    	}
    	return null;
    }

    public int getVisualizacoesRestantes() {
        return visualizacoesRestantes;
    }
}
