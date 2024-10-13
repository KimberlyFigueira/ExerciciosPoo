package ex1;

import java.util.ArrayList;
import java.util.Scanner;

public class SistemaCadastro {
		static ArrayList<Usuario> listaUsuarios = new ArrayList<>();
		
		public static void bemVindo() {
		System.out.println("Seja muito bem-vinde! Oque deseja fazer?");
		System.out.println("1 - Cadastrar novo usuário");
		System.out.println("2 - Realizar login");
		System.out.println("3 - Sair");
	}
	
		public static void cadastroUsuario() {
		Scanner input = new Scanner (System.in);
		System.out.println("Digite seu nome de usuário:");
		String nome = input.next();
		System.out.println("Digite seu email:");
		String email = input.next();
		System.out.println("Digite sua senha:");
		String senha = input.next();
		System.out.println("Cadastro efetuado com sucesso!");
		System.out.println("");
		Usuario usuario = new Usuario(nome, email, senha);
		listaUsuarios.add(usuario);
		bemVindo();
	}
	
		public static void realizarLogin() {
		Scanner input = new Scanner (System.in);
		System.out.println("Digite seu email:");
		String loginEmail = input.next();
		System.out.println("Digite sua senha:");
		String loginSenha = input.next();
		for(Usuario usuario : listaUsuarios) {
			if(usuario.getEmail().equals(loginEmail) && usuario.getSenha().equals(loginSenha)){
				System.out.println("Login realizado com sucesso!");
				System.out.println("");
				System.out.println("Selecione uma opção abaixo.");
				System.out.println("1 - Editar dados da conta");
				System.out.println("2 - Visualizar dados da conta");
				System.out.println("3 - Sair");
				int opcao = input.nextInt();
				if(opcao == 3) {
					System.out.println("Saindo do sistema. Volte sempre!");
					System.out.println("");
				} else if (opcao == 1 || opcao == 2) {
					System.out.println("Opção indisponível no momento.");
					System.out.println("");
				}else {
					System.out.println("Opção inválida.");
					System.out.println("");
				}
			}else {
				System.out.println("Credenciais incorretas. Tente novamente!");
			}bemVindo();
		}
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		bemVindo();
		while(true) {
			int option = input.nextInt();
			switch(option) {
			case 1: cadastroUsuario();
			break;
			case 2: realizarLogin();
			break;
			case 3: System.out.println("Saindo do sistema. Volte sempre!");
			break;
			default: System.out.println("Opção inválida. Tente novamente!");
			}
		}
	}

}
