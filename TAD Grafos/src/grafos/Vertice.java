package grafos;

public class Vertice {
    int chave,valor;
    public Vertice(int chave, int valor){
        this.chave = chave;
        this.valor = valor;
    }
    @Override
    public String toString() {
        return "[ "+chave+" ] "+ valor;
    }
    public int getChave() {
        return chave;
    }

    public void setChave(int chave) {
        this.chave = chave;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
}