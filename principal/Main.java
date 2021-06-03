package principal;

import java.util.Scanner;
import static infra.ListaDeArranjos.listaDeArranjos;
import static infra.Pilha.pilha;
import static infra.PilhaLSE.pilhaLSE;
import static infra.Fila.fila;
import static infra.FilaLSE.filaLSE;
import static infra.ListaDeNodos.listaDeNodos;
import static infra.ArvoreBinaria.arvoreBinaria;
import static infra.ArvoreGenerica.arvoreGenerica;
import static infra.FilaDePrioridades.filaDePrioridades;
import static infra.Mapa.mapa;
import static infra.Dicionario.dicionario;


public class Main {

	public static void main(String[] args) {
		Scanner ler = new Scanner(System.in);
		System.out.println("Seja Bem-Vindo ao Sistema de ED\n");
		System.out.println("==========================");
		boolean sair = false;
		while (!sair) {
			int opc;

			System.out.println("1. TAD-Lista Arranjo");
			System.out.println("2. TAD-Pilha: ");
			System.out.println("3. TAD-Fila");
			System.out.println("4. TAD-Lista de Nodos");
			System.out.println("5. TAD-Árvore Genérica");
			System.out.println("6. TAD-Árvore Binária");
			System.out.println("7. TAD-Fila de Prioridade");
			System.out.println("8. TAD-Mapa");
			System.out.println("9. TAD-Dicionário");
			System.out.println("10. TAD-Mapa Ordenado – ABB");
			System.out.println("11. TAD-Mapa Ordenado – AVL");
			System.out.println("12. TAD-Grafos");
			System.out.println("0. Sair");
			
			System.out.println("==========================");
			System.out.print("Escolha das Opções: ");

			opc = ler.nextInt();

			switch (opc) {
			case 1: {
				listaDeArranjos();
				break;
			}
			case 2: {
				System.out.println("1. TAD-Pilha (Array)");
				System.out.println("2. TAD-Pilha-LSE");
				System.out.print("Escolha das Opções: ");
				int opcPilha = ler.nextInt();
				switch (opcPilha) {
				case 1: {
					pilha();
					break;
				}
				case 2: {
					pilhaLSE();
					break;
				}
				default:{
					OpcaoInvalida();
				}
				}

				break;
			}
			case 3: {
				System.out.println("1. TAD-Fila (Array)");
				System.out.println("2. TAD-Pilha-LSE");
				System.out.print("Escolha das Opções: ");
				int opcPilha = ler.nextInt();
				switch (opcPilha) {
				case 1: {
					fila();
					break;
				}
				case 2: {
					filaLSE();
					break;
				}
				default:{
					OpcaoInvalida();
				}
				}

				break;
			}
			case 4: {
				listaDeNodos();
				break;
			}
			case 5: {
				System.out.println("Desculpe essa opção ainda não está pronta estamos trabalhando nisso");
				break;
			}
			case 6: {
				System.out.println("Desculpe essa opção ainda não está pronta estamos trabalhando nisso");
				
				break;
			}
			case 7: {
				filaDePrioridades();
				break;
			}
			case 8: {
				mapa();
				break;
			}
			case 9: {
				dicionario();
				break;
			}
			case 10: {
				System.out.println("Desculpe essa opção ainda não está pronta estamos trabalhando nisso");
				break;
			}
			case 11: {
				System.out.println("Desculpe essa opção ainda não está pronta estamos trabalhando nisso");
				break;
			}
			case 12: {
				System.out.println("Desculpe essa opção ainda não está pronta estamos trabalhando nisso");
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

	public static void OpcaoInvalida() {
		System.out.println("Por favor digite uma opção que seja valida!!!");
	}

}
