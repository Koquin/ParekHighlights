package models;

import java.util.ArrayList;
import java.util.List;

public class RepositorioDePerfis {
    private List<Perfil> perfis = new ArrayList<>();

    public void incluir(Perfil perfil) {
        perfis.add(perfil);
    }

    public List<Perfil> consultar(int id, String nome, String email) {
        List<Perfil> retornarPerfis = new ArrayList<>();
        if (id > 0 || (nome != null && !nome.isEmpty()) || (email != null && !email.isEmpty())) {
            for (Perfil perfil : perfis) {
                if ((id > 0 && perfil.getId() == id) ||
                    (nome != null && !nome.isEmpty() && perfil.getNome().equals(nome)) ||
                    (email != null && !email.isEmpty() && perfil.getEmail().equals(email))) {
                    retornarPerfis.add(perfil);
                }
            }
        }
        return retornarPerfis;
    }
	
	public boolean existePerfil(Perfil perfil) {
		for (Perfil proPerfil : perfis) {
			if (proPerfil.getId() == perfil.getId()
			|| proPerfil.getNome().equals(perfil.getNome())
			|| proPerfil.getEmail().equals(perfil.getEmail()))
			{
				return true;
			}
		}
		return false;
	}
	
	public boolean atributosPreenchidosPerfil(Perfil perfil) {
		return perfil.getId() > 0 
				&& !perfil.getNome().isEmpty() && perfil.getNome() != null
				&& !perfil.getEmail().isEmpty() && perfil.getEmail() != null;
	}
	
}
