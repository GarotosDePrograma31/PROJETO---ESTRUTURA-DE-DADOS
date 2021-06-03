package infra;

import static principal.Main.OpcaoInvalida;

import java.util.Scanner;

import tad_mapa.classes.*;

public class Mapa {
	public static void mapa() {
		Scanner ler = new Scanner(System.in);
		boolean sair = false;
		while (!sair) {
			System.out.println("\n === TAD Mapa === \n");
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
				HashTableMap<Integer, String> map = new HashTableMap<>();

				while (!voltar) {
					System.out.println("\n1. Adicionar um elementos");
					System.out.println("2. Remover um elemento");
					System.out.println("3. Visualizar Lista");
					System.out.println("0. Voltar");
					System.out.print("Escolha das Opções: ");
					int opcTest = ler.nextInt();

					switch (opcTest) {
					case 1: {
						System.out.print("\nDigite a chave que será inserido: ");
						int chave = ler.nextInt();
						System.out.print("\nDigite a texto que será inserido: ");
						String str = ler.nextLine();

						map.put(chave, str);

						System.out.println("\nForam adicionados no mapa a chave: " + chave + " com texto seguinte texto: " + str);
						break;
					}
					case 2: {
						System.out.print("\nDigite a chave que será inserido: ");
						int chave = ler.nextInt();
						String removido = map.remove(chave);
						System.out.println("\nElemento " + removido + " foi removido com sucesso!\n");

						break;
					}
					case 3: {
						System.out.println("\n" + map.toString());
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