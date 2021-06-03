package infra;

import static principal.Main.OpcaoInvalida;
import java.util.Scanner;

import tad_pilha.classes.ArrayStack;

public class Pilha {
	public static void pilha() {
		Scanner ler = new Scanner(System.in);
		boolean sair = false;
		while (!sair) {
			System.out.println("\n === TAD Pilha === \n");
			System.out.println("1. Definição");
			System.out.println("2. Usar");
			System.out.println("0. Sair");
			System.out.print("Escolha das Opções: ");
			int opc = ler.nextInt();
			switch (opc) {
			case 1: {
				System.out.println("\n === Definição === \n"
						+ "Uma pilha é uma estrutura de dados básica, que segue o principio FIFO (First In, Last Out -> Primeiro a entrar, último a sair)"
						+ "\n=== Inserção === \n"
						+ "A inserção de x é feita pelo método push(x), onde o elemento x é adicionado no topo da lista, sendo que se a "
						+ "pilha estiver vazia o elemento digitado será a base."
						+ "\n=== Remoção === \n"
						+ "A remoção é feita pelo método pop, onde ele sempre vai excluir o elemento que está no top da pilha.\n"
						+ "\n=== Visualização === \n"
						+ "A visualização dos elementos são feitas dentro de chaves e separando cada elemento por uma virgula.\n"
						+ "Ex: [E, D, C, B, A]\n");
				break;
			}
			case 2: {
				boolean voltar = false;
				ArrayStack<Integer> pilha = new ArrayStack<Integer>();

				while (!voltar) {
					System.out.println("\n1. Adicionar um elemento");
					System.out.println("2. Remover o ultimo elemento");
					System.out.println("3. Visualizar Pilha Completa");
					System.out.println("0. Voltar");
					System.out.print("Escolha das Opções: ");
					int opcTest = ler.nextInt();

					switch (opcTest) {
					case 1: {
						System.out.print("\nDigite um numero que será inserido: ");
						int elemento = ler.nextInt();
						
						pilha.push(elemento);

						System.out.println("\nO elemento " + elemento + " foi adicionado com sucesso!");
						break;
					}
					case 2: {
						if (!pilha.isEmpty()) {

							int removido = pilha.pop();
							System.out.println("\nElemento " + removido + " foi removido com sucesso!\n");
						} else {
							System.out.println("\nA Lista está vazia.");
							System.out.println("\nSe quiser usar está função você deve inserir valores.");
						}
						break;
					}
					case 3: {
						System.out.println("\n" + pilha.toString());
						break;
					}
					case 0: {
						System.out.println("Tem certeza que deseja voltar?   (Sim/Nao)");
						char respSair;
						respSair = ler.next().toUpperCase().charAt(0);
						if (respSair == 'S')
							voltar = true;
						else
							voltar = false;
						break;
					}
					default:
						OpcaoInvalida();
						break;
					}
				}
				break;
			}
			case 0: {
				System.out.println("Tem certeza que deseja sair?   (Sim/Nao)");
				char respSair;
				respSair = ler.next().toUpperCase().charAt(0);
				if (respSair == 'S')
					sair = true;
				else
					sair = false;
				break;
			}
			default:
				OpcaoInvalida();
				break;
			}
		}
	}
}