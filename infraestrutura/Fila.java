package infra;

import static principal.Main.OpcaoInvalida;

import java.util.EmptyStackException;
import java.util.Scanner;
import tad_fila.classes.ArrayQueue;


public class Fila {
	public static void fila() {
		Scanner ler = new Scanner(System.in);
		boolean sair = false;
		while (!sair) {
			System.out.println("\n === TAD Fila === \n");
			System.out.println("1. Definição");
			System.out.println("2. Usar");
			System.out.println("0. Sair");
			System.out.print("Escolha das Opções: ");
			int opc = ler.nextInt();

			switch (opc) {
			case 1: {
				System.out.println("\n === Definição === \n"
						+ "Uma Fila é uma estrutura de dados básica, que segue o principio FIFO (First-In, First-Out -> Primeiro a entrar, Primeiro a sair).\n"
						+ "\n=== Inserção === \n"
						+ "A inserção de x é feita pelo método enqueue(x), onde o elemento x é adicionado no final da fila, sendo que se a \n"
						+ "fila estiver vazia o elemento digitado será a base."
						+ "\n=== Remoção === \n"
						+ "A remoção é feita pelo método pop, onde ele sempre vai excluir o elemento que está no top da pilha.\n"
						+ "\n=== Visualização === \n"
						+ "A visualização dos elementos são feitas dentro de chaves e separando cada elemento por uma virgula.\n"
						+ "Ex: [1, 2, 3, 4, 5]\n");
				break;
			}
			case 2: {
				boolean voltar = false;
				ArrayQueue<Integer> fila = new ArrayQueue<Integer>();

				while (!voltar) {
					System.out.println("\n1. Adicionar um elemento");
					System.out.println("2. Remover um elemento");
					System.out.println("3. Visualizar Fila");
					System.out.println("0. Voltar");
					System.out.print("Escolha das Opções: ");
					int opcTest = ler.nextInt();

					switch (opcTest) {
					case 1: {
						System.out.print("\nDigite um numero que será inserido: ");
						int elemento = ler.nextInt();
						
						fila.enqueue(elemento);

						System.out.println("\nO elemento " + elemento + " foi adicionado com sucesso!");
						break;
					}
					case 2: {
						try {
							int removido = fila.dequeue();
							System.out.println("\nElemento " + removido + " foi removido com sucesso!\n");
						} 
						catch (EmptyStackException e) {
							System.out.println(e);
						}
						break;
					}
					case 3: {
						System.out.println("\n" + fila.toString());
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