package infra;

import java.util.Scanner;

import tad_ListaArranjos.classes.ArrayIndexList;

import static principal.Main.OpcaoInvalida;

public class ListaDeArranjos {
	public static void listaDeArranjos() {
		Scanner ler = new Scanner(System.in);
		boolean sair = false;
		while (!sair) {
			System.out.println("\n === TAD Lista de Arranjo === \n");
			System.out.println("1. Definição");
			System.out.println("2. Usar");
			System.out.println("0. Sair");
			System.out.print("Escolha das Opções: ");
			int opc = ler.nextInt();

			switch (opc) {
			case 1: {
				System.out.println("\n === Definição === \n"
						+ "A Lista de Arranjo é um conjunto / vetor S de N elementos, onde cada elemento está "
						+ "armazenado no intervalo [0, N - 1] de modo que o primeiro elemento seja o índice 0, o segundo índice 1, "
						+ "o terceiro índice 2, e assim por diante. Sendo que o último elemento possui o índice N-1\n"
						+ "\n=== Inserção === \n"
						+ "A inserção de S é feita pelo método add (x, i), onde o elemento x é adicionado ao índice i de S tal que i> = 0 ei <= N.\n"
						+ "\n=== Remoção === \n"
						+ "A remoção em S é feita pelo método remove (i), onde i é o índice do elemento a ser removido em S, tal que i> = 0 ei <= N.\n"
						+ "\n=== Visualização === \n"
						+ "A visualização dos elementos de S são feitas dentro de chaves e separando cada elemento por uma virgula.\n"
						+ "Ex: (2, 4, 6, 8, 10)\n");
				break;
			}
			case 2: {
				boolean voltar = false;
				ArrayIndexList<Integer> lista = new ArrayIndexList<Integer>();

				while (!voltar) {
					System.out.println("\n1. Adicionar um elemento");
					System.out.println("2. Remover um elemento");
					System.out.println("3. Visualizar Lista");
					System.out.println("0. Voltar");
					System.out.print("Escolha das Opções: ");
					int opcTest = ler.nextInt();

					switch (opcTest) {
					case 1: {
						System.out.print("\nDigite um numero que será inserido: ");
						int elemento = ler.nextInt();
						System.out.print("Digite qual será a  posição de desse elemento na lista: ");
						int posicao = ler.nextInt();

						lista.add(elemento, posicao);

						System.out.println("\nO elemento " + elemento + " foi adicionado com sucesso!");
						break;
					}
					case 2: {
						if (!lista.isEmpty()) {
							System.out.print("\nDigite o Indice do elemento que vai ser removido: ");
							int indice = ler.nextInt();

							int removido = lista.remove(indice);
							System.out.println("\nElemento " + removido + " foi removido com sucesso!\n");
						} else {
							System.out.println("\nA Lista está vazia.");
							System.out.println("\nSe quiser usar está função você deve inserir valores.");
						}
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
