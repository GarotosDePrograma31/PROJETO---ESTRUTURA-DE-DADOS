package grafos;

import java.util.Iterator;
import java.util.Vector;

public class estrutura_grafo {
    private int quantidadeVertices;
    private Vector vertices, matrizAdjacencia[][];

    public estrutura_grafo() {
        this.quantidadeVertices = 0;
        this.vertices = new Vector();
    }
    public void removerAresta(int chave1, int chave2) {
        int indice1 = encontraIndice(chave1), indice2 = encontraIndice(chave2);
        if (indice1 != -1 && indice2 != -1 && matrizAdjacencia[indice1][indice2] != null) {//Apenas insere se ambas as chaves existirem no grafo
            Aresta objetoremovido = (Aresta) matrizAdjacencia[indice1][indice2].remove(0);
            matrizAdjacencia[indice2][indice1].remove(objetoremovido);//Remove o mesmo elemento da posi??o inversa
        }
    }
    public void inserirAresta(int chave1, int chave2) {
        int indice1 = encontraIndice(chave1), indice2 = encontraIndice(chave2);
        if (indice1 != -1 && indice2 != -1) {//Apenas insere se ambas as chaves existirem no grafo
            Aresta aresta = new Aresta();//Cria uma nova aresta
            if(indice1 == indice2)  //Ignora caso seja um la?o...
                aresta.setLoop(true); //Usado na contagem do grau..
            else{
                if (matrizAdjacencia[indice2][indice1] == null)
                    matrizAdjacencia[indice2][indice1] = new Vector();
                matrizAdjacencia[indice2][indice1].add(aresta);
            }
            if (matrizAdjacencia[indice1][indice2] == null)
                matrizAdjacencia[indice1][indice2] = new Vector();
            matrizAdjacencia[indice1][indice2].add(aresta);
        }
    }
    public void inserirVertice(int chave, int valor) {
        if (encontraIndice(chave) == -1) {//Apenas insere se a chave n?o existir
            //Adiciona o vertice
            vertices.add(new Vertice(chave, valor));
            //Amplia a matriz em uma linha e uma coluna, mantendo o conteudo.
            quantidadeVertices++;
            Vector tempMatrizAdjacencia[][] = new Vector[quantidadeVertices][quantidadeVertices];
            //Percorre toda matriz antiga passando os elementos pra nova
            for (int linha = 0; linha < quantidadeVertices - 1; linha++)
                for (int coluna = 0; coluna < quantidadeVertices - 1; coluna++)
                    tempMatrizAdjacencia[linha][coluna] = matrizAdjacencia[linha][coluna];
            matrizAdjacencia = tempMatrizAdjacencia;
        }
    }
    public void removerVertice(int chave) {
        int indice = encontraIndice(chave);
        if (indice != -1) { //Para caso a chave n?o exista
            vertices.remove(indice);
            // remove a linha e coluna respectiva ao indice da matriz de adjac?ncia
            quantidadeVertices--;
            Vector tempMatrizAdjacencia[][] = new Vector[quantidadeVertices][quantidadeVertices];
            int controleColuna, controleLinha = 0;
            //Percorre a matriz de adjacencia ignorando a linha e coluna completa relacionado ao indice
            for (int linha = 0; linha < quantidadeVertices + 1; linha++) {
                if (linha != indice) {//Ignora a linha do indice
                    controleColuna = 0;
                    for (int coluna = 0; coluna < quantidadeVertices + 1; coluna++) {
                        if (coluna != indice) {//Ignora a coluna do indice
                            tempMatrizAdjacencia[controleLinha][controleColuna] = matrizAdjacencia[linha][coluna];
                            if (coluna != indice)
                                controleColuna++;
                        }
                    }
                    controleLinha++;
                }
            }
            matrizAdjacencia = tempMatrizAdjacencia;
        }
    }
    private int encontraIndice(int chave) {
        Iterator I = vertices.iterator();
        int indice = 0;
        while (I.hasNext()) {
            Vertice v = (Vertice) (I.next());
            if (v.getChave() == chave)
                return indice;
            indice++;
        }
        return -1;
    }
    public void printGrafo() {
        System.out.println("\n\nVertices: ([chave] valor)\n");
        for (int f = 0; f < vertices.size(); f++)
            System.out.println(vertices.elementAt(f));
        System.out.println("\n\nMatriz de Adjacencia:\n");
        for (Vector[] linha : matrizAdjacencia) {
            for (Vector coluna : linha) {
                System.out.print((coluna != null) ? "| " + coluna.size() + "\t" : "| 0\t");
            }
            System.out.println("\n");
        }
    }
    public int ordem() {
        return quantidadeVertices;
    }
    public int grau(int chave) {
        int indice = encontraIndice(chave), grau = 0;
        if(indice != -1){
            for (int coluna = 0; coluna < quantidadeVertices; coluna++) {// Percorre todas colunas da tabela de adjacencia para o vertice selecionado
                if(matrizAdjacencia[indice][coluna] != null) {
                    for (Object aresta: matrizAdjacencia[indice][coluna]){
                        aresta = (Aresta) aresta;
                        if(((Aresta) aresta).isLoop()) grau += 2;
                        else grau += 1;
                        //Loop conta como 2 no grau.
                    }
                }
            }
        }
        return grau;
    }
    public boolean caminhoEuleriano(){
        Iterator I = vertices.iterator();
        int indicesImpar = 0;
        while (I.hasNext()) {
            Vertice v = (Vertice) (I.next());
            if(grau(v.getChave()) % 2 != 0){
                indicesImpar++;
            }
        }
        if(indicesImpar > 0 && indicesImpar != 2) return false;
        else return true;
    }
    public boolean circuitoEuleriano(){
        Iterator I = vertices.iterator();
        while (I.hasNext()) {
            Vertice v = (Vertice) (I.next());
            if(grau(v.getChave()) % 2 != 0){
                return true;
            }
        }
        return false;
    }
}