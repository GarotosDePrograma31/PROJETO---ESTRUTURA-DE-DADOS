package infra;

import static principal.Main.OpcaoInvalida;

import java.util.Scanner;

import tad_fila_de_prioridade.classes.*;

public class FilaDePrioridades {
	public static void filaDePrioridades() {
		Scanner ler = new Scanner(System.in);
		boolean sair = false;
		while (!sair) {
			System.out.println("\n === TAD Fila de Prioridades === \n");
			System.out.println("1. Definição");
			System.out.println("2. Usar");
			System.out.println("0. Sair");
			System.out.print("Escolha das Opções: ");
			int opc = ler.nextInt();

			switch (opc) {
			case 1: {
				System.out.println("...");
				break;
			}
			case 2: {
				boolean voltar = false;
				SortedListPriorityQueue<Integer, Integer> lista = new SortedListPriorityQueue<Integer, Integer>();

				while (!voltar) {
					System.out.println("\n1. Adicionar um elementos");
					System.out.println("2. Remover um elemento");
					System.out.println("3. Visualizar Lista");
					System.out.println("0. Voltar");
					System.out.print("Escolha das Opções: ");
					int opcTest = ler.nextInt();

					switch (opcTest) {
					case 1: {
						System.out.print("\nDigite um numero que será inserido: ");
						int elemento1 = ler.nextInt();
						System.out.print("Digite qual será a chave de desse elemento na lista: ");
						int elemento2 = ler.nextInt();

						lista.insert(elemento1, elemento2);

						System.out.println("\nO elementos (" + elemento1 + elemento2 + ") foram adicionados com sucesso!");
						break;
					}
					case 2: {
						int removido = lista.removeMin().getValue();
						System.out.println("\nElemento " + removido + " foi removido com sucesso!\n");

						break;
					}
					case 3: {
						System.out.println("\n" + lista.toString());
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