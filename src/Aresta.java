public class Aresta {
    private Jogador inicio;
    private Jogador fim;
    private int peso;

    public Aresta(Jogador inicio, Jogador fim, int peso) {
        this.inicio = inicio;
        this.fim = fim;
        this.peso = peso;
    }

    public Jogador getInicio() {
        return inicio;
    }

    public Jogador getFim() {
        return fim;
    }

    public int getPeso() {
        return peso;
    }
}
