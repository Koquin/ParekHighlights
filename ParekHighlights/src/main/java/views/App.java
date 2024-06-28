package views;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import controllers.RedeSocial;
import models.*;
public class App {
	private static RedeSocial parekHighlights = new RedeSocial();
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		boolean sair = false;
		do {
			int opcao = 0;
			menu();
			if (teclado.hasNextInt()) {
				opcao = teclado.nextInt();
			}
			else {
				System.out.println("Digite um numero válido!");
			}
			switch (opcao) {
			case 1: {
				parekHighlights.incluirPerfil(incluirPerfil()); 
				teclado.nextLine(); break;
			}
			case 2: parekHighlights.incluirPostagem(incluirPostagem()); break;
			case 3: {
				int id = 0;
				String nome = "";
				String email = "";
				System.out.println("Digite o id: ");
				id = teclado.nextInt();
				System.out.println("Digite o nome: ");
				teclado.nextLine();
				nome = teclado.nextLine();
				System.out.println("Digite o email: ");
				email = teclado.nextLine();
				List<Perfil> perfisAchados = parekHighlights.consultarPerfil(id, nome, email);
				for (Perfil perfil : perfisAchados) {
					System.out.println(perfil.toString());
				}
				break;
			}
			case 4:{
				int id = 0;
				String texto = "";
				String hashtag = "";
				System.out.println("Digite o id: ");
				id = teclado.nextInt();
				System.out.println("Digite o hashtag: ");
				hashtag = teclado.nextLine();
				System.out.println("Digite o id do perfil: ");
				Perfil perfil = (Perfil)parekHighlights.consultarPerfil(teclado.nextInt(), null, null);
				List<Postagem> postagensAchadas = parekHighlights.consultarPostagem(id, texto, hashtag, perfil);
				for (Postagem postagem : postagensAchadas) {
					System.out.println(postagem.toString());
				}
				break;
			}
			case 5: {
				System.out.println("Digite o id da postagem a ser curtida: ");
				parekHighlights.curtir(teclado.nextInt());
				break;
			}
			case 6: {
				System.out.println("Digite o id da postagem a ser descurtida: ");
				parekHighlights.descurtir(teclado.nextInt());
				break;
			}
			case 7: {
				System.out.println("Digite o id do perfil: ");
				parekHighlights.exibirPostagensPorPerfil(teclado.nextInt());
				break;
			}
			case 8: {
				System.out.println("Digite a hashtag: ");
				parekHighlights.exibirPostagensPorHashtag(teclado.nextLine());
				break;
			}
			case 0: {
				teclado.close();
				sair = true;
			}
			}
			
		}
		while (!sair);
	}
	
	public static void menu() {
		System.out.println("---PAREK HIGHLIGHTS---"
				+ "\nEscolha uma opção:"
				+ "\n1 - Incluir perfil"
				+ "\n2 - Incluir postagem"
				+ "\n3 - Consultar perfil"
				+ "\n4 - Consultar postagem"
				+ "\n5 - Curtir Postagem (especificar o ID)"
				+ "\n6 - Descurtir Postagem (especificar o ID)"
				+ "\n7 - Exibir postagens por perfil (Especificar o ID)"
				+ "\n8 - Exibir postagens por hashtag"
				+ "\n0 - Sair");
	}
	
	public static Perfil incluirPerfil() {
		Scanner teclado = new Scanner(System.in);
		String nome = "";
		String email = "";
		System.out.println("Digite o nome do perfil:");
		nome = teclado.nextLine();
		System.out.println("Digite o email do perfil:");
		email = teclado.nextLine();
		System.out.println("Perfil Adicionado!");
		return new Perfil(nome, email);
	}
	
	public static Postagem incluirPostagem() {
		Scanner teclado = new Scanner(System.in);
		Postagem postagem;
		String texto = "";
		System.out.println("Digite o texto:");
		texto = teclado.nextLine();
		System.out.println("Digite o id do perfil:");
		Perfil perfil = (Perfil)parekHighlights.consultarPerfil(teclado.nextInt(), null, null);
		postagem = new Postagem(texto, perfil);
		return postagem;
	}	
}
