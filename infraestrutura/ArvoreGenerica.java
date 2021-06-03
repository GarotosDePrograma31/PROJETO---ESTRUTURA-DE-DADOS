package infra;

import static principal.Main.OpcaoInvalida;
import java.util.Scanner;

public class ArvoreGenerica {
	public static void arvoreGenerica() {
		Scanner ler = new Scanner(System.in);
		boolean sair = false;
		while (!sair) {
			System.out.println("\n === TAD Arvore Generica === \n");
			System.out.println("Nossa empresa pede Desculpas pois essa função ainda não está disponivel no nosso sistema!");
			System.out.println("0. Voltar para o Menu");
			int opc = ler.nextInt();
			switch (opc) {
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