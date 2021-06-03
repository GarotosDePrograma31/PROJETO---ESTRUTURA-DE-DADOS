package infra;

import static principal.Main.OpcaoInvalida;
import java.util.Scanner;
import tad_lista_de_nodos.classses.*;
import tad_lista_de_nodos.interfaces.Position;

public class ListaDeNodos {
	public static void listaDeNodos() {
		Scanner ler = new Scanner(System.in);
		boolean sair = false;
		while (!sair) {
			System.out.println("\n === TAD Lista de Nodos === \n");
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
				NodePositionList<Integer> nodos = new NodePositionList<Integer>();

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

						if (nodos.isEmpty()) {
							nodos.addFirst(elemento);
							System.out.println(
									"\nO " + elemento + " elemento foi adicionado a primeira posição da lista.");
						} else {
							System.out.print("\nO Elemento deve ser adicionado no inicio ou no final da lista? ");
							System.out.println("\n1. Para adicionar no INICIO da Lista");
							System.out.println("2. Para adicionar no FIM da Lista");
							System.out.print("Escolha das Opções: ");
							int inicioFinal = ler.nextInt();
							if (inicioFinal == 1) {
								nodos.addFirst(elemento);

								System.out.println("\nO elemento " + elemento + " foi adicionado com sucesso!");
							} else if (inicioFinal == 2) {
								nodos.addLast(elemento);

								System.out.println("\nO elemento " + elemento + " foi adicionado com sucesso!");
							} else
								System.out.println("Opção Invalida Refaça todo o processo novamente!");
						}

						break;
					}

					case 2: {
						System.out.println("Digite o numero que será removido: ");
						int remover = ler.nextInt();

						Position<Integer> posicao = nodos.find(nodos.first(), remover);

						System.out.print("\nO Elemento deve ser REMOVIDO no inicio ou no final da lista? ");
						System.out.println("\n1. Para remover no INICIO da Lista");
						System.out.println("2. Para adicionar no FIM da Lista");
						System.out.print("Escolha das Opções: ");
						int inicioFinal = ler.nextInt();
						if (inicioFinal == 1) {
							posicao = nodos.find(nodos.first(), remover);

							int removido = nodos.remove(posicao);

							System.out.println("\nO numero removido " + removido + " foi removido com sucesso");
						} else if (inicioFinal == 2) {
							posicao = nodos.find(nodos.last(), remover);

							int removido = nodos.remove(posicao);

							System.out.println("\nO numero removido " + removido + " foi removido com sucesso");
						} else
							System.out.println("Opção Invalida Refaça todo o processo novamente!");

						break;
					}
					case 3: {
						System.out.println("\n" + nodos.toString());
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
