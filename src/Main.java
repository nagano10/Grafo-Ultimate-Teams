public class Main {
    public static void main(String[] args) {
        Grafo grafo = new Grafo();

        grafo.adicionarJogador("Neymar", "Brasileiro", "PSG");
        grafo.adicionarJogador("Messi", "Argentino", "PSG");
        grafo.adicionarJogador("Mbappé", "Francês", "PSG");
        grafo.adicionarJogador("Cristiano Ronaldo", "Português", "Manchester United");
        grafo.adicionarJogador("Marquinhos","Brasileiro","PSG");

        grafo.calcularAfinidade();
        grafo.mostrarCompatibilidades();
    }
}
