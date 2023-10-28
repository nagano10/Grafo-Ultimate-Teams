import java.util.ArrayList;
import java.util.List;

public class Grafo {
    private List<Jogador> jogadores;
    private List<Aresta> compatibilidades;

    public Grafo() {
        this.jogadores = new ArrayList<>();
        this.compatibilidades = new ArrayList<>();
    }

    public void adicionarJogador(String nome, String nacionalidade, String clube) {
        Jogador jogador = new Jogador(nome, nacionalidade, clube);
        jogadores.add(jogador);
    }

    public void calcularAfinidade() {
        for (int i = 0; i < jogadores.size(); i++) {
            Jogador jogador1 = jogadores.get(i);
            for (int j = i + 1; j < jogadores.size(); j++) {
                Jogador jogador2 = jogadores.get(j);
                int peso = calcularPesoAfinidade(jogador1, jogador2);
                compatibilidades.add(new Aresta(jogador1, jogador2, peso));
            }
        }
    }

    private int calcularPesoAfinidade(Jogador jogador1, Jogador jogador2) {
        if (jogador1.getClube().equals(jogador2.getClube()) && jogador1.getNacionalidade().equals(jogador2.getNacionalidade())) {
            return 3;
        } else if (jogador1.getClube().equals(jogador2.getClube()) || jogador1.getNacionalidade().equals(jogador2.getNacionalidade())) {
            return 2;
        } else {
            return 1;
        }
    }

    public void mostrarCompatibilidades() {
        for (Aresta aresta : compatibilidades) {
            System.out.println("Compatibilidade entre " + aresta.getInicio().getNome() + " e " + aresta.getFim().getNome() + ": " + aresta.getPeso());
        }
    }
}
