package ex2;

import java.util.ArrayList;
import java.util.Scanner;

public class SistemaProdutos {
	
	static ArrayList<Produto> listaProdutos = new ArrayList<>();
	
	public static void exibirMenu(){
		System.out.println("Seja muito bem-vinde! Oque você deseja?");
		System.out.println("1 - Adicionar novo produto");
		System.out.println("2 - Visualizar lista de produtos");
		System.out.println("3 - Remover produto");
		System.out.println("4 - Sair");
	}
	
	public static void adicionarProduto() {
	    Scanner input = new Scanner(System.in);
	    
	    System.out.println("Digite o código do produto:");
	    int codigo = input.nextInt();
	    input.nextLine();
	    if (verificarProduto(codigo)) {
	        System.out.println("Código já cadastrado. Tente novamente!");
	        exibirMenu();
	        return;
	    }
	    System.out.println("Digite o nome do produto:");
	    String nome = input.nextLine();
	    System.out.println("Digite o preço do produto:");
	    double preco = input.nextDouble();
	    Produto produto = new Produto(codigo, nome, preco);
	    listaProdutos.add(produto);
	    System.out.println("Produto adicionado com sucesso!");
	    exibirMenu();										
	}
	
	public static boolean verificarProduto(int codigo) {
		for(Produto produto : listaProdutos) {
			if(produto.getCodigo() == codigo){
				return true;
			}
		}
		return false;
	}
	
	public static void mostrarProdutos() {
		for (int i = 0; i < listaProdutos.size(); i++) {
		    Produto produto = listaProdutos.get(i);
		    System.out.println(i + ": " + produto);
		}exibirMenu();
	}
	
	public static void removerProduto() {
		Scanner input = new Scanner(System.in);
		System.out.println("Digite o índice do produto que você deseja remover.");
		int codigoRemover = input.nextInt();
		listaProdutos.remove(codigoRemover);
		System.out.println("Produto removido com sucesso!");
		exibirMenu();
	}
	
	public static void sair() {
		System.out.println("Encerrando o programa. Volte sempre!");
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		

		exibirMenu();
		while(true) {
			int opcao = input.nextInt();
			switch(opcao) {
			case 1: adicionarProduto();
			break;
			case 2: mostrarProdutos();
			break;
			case 3: removerProduto();
			break;
			case 4: sair();
			default: System.out.println("Opção inválida");
			}
		}
	}
}
