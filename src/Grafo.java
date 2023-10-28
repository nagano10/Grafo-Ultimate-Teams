import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Grafo {
    private List<Jogador> jogadores;
    private List<Aresta> compatibilidades;

    public Grafo() {
        this.jogadores = new ArrayList<>();
        this.compatibilidades = new ArrayList<>();
    }

    //Adiciona um jogador, passando parametros de Nome, Nacionalidade e Clube.
    public void adicionarJogador(String nome, String nacionalidade, String clube) {
        Jogador jogador = new Jogador(nome, nacionalidade, clube);
        jogadores.add(jogador);
    }

    //Calcula a Afinidade entre todos os jogadores.
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

    //Classifica as afinidades em peso. Criterios levados em consideracao
    //Afinidade 1: os jogadores nao jogam no mesmo time nem sao da mesma nacionalidade.
    //Afinidade 2: Os jogadores jogam no mesmo time ou sao da mesma nacionalidade.
    //Afinidade 3: Os jogadores jogam no mesmo time e sao da mesma nacionalidade.
    private int calcularPesoAfinidade(Jogador jogador1, Jogador jogador2) {
        if (jogador1.getClube().equals(jogador2.getClube()) && jogador1.getNacionalidade().equals(jogador2.getNacionalidade())) {
            return 3;
        } else if (jogador1.getClube().equals(jogador2.getClube()) || jogador1.getNacionalidade().equals(jogador2.getNacionalidade())) {
            return 2;
        } else {
            return 1;
        }
    }

    //Imprime as compatibilidades
    public void mostrarCompatibilidades() {
        for (Aresta aresta : compatibilidades) {
            System.out.println("Compatibilidade entre " + aresta.getInicio().getNome() + " e " + aresta.getFim().getNome() + ": " + aresta.getPeso());
        }
    }

    //Remove um jogador de acordo com seu nome.
    public void removerJogador(String nomeJogador) {
        Iterator<Jogador> iterator = jogadores.iterator();
        while (iterator.hasNext()) {
            Jogador jogador = iterator.next();
            if (jogador.getNome().equals(nomeJogador)) {
                // Remove o jogador
                iterator.remove();
                // Remove as arestas associadas ao jogador
                Iterator<Aresta> arestaIterator = compatibilidades.iterator();
                while (arestaIterator.hasNext()) {
                    Aresta aresta = arestaIterator.next();
                    if (aresta.getInicio().equals(jogador) || aresta.getFim().equals(jogador)) {
                        arestaIterator.remove();
                    }
                }
                System.out.println("Jogador " + nomeJogador + " removido com sucesso.");
                return;
            }
        }
        System.out.println("Jogador " + nomeJogador + " não encontrado.");
    }

    //Lista todos os jogadores adicionados.
    public void listarJogadores() {
        System.out.println("Lista de Jogadores:");
        for (Jogador jogador : jogadores) {
            System.out.println("Nome: " + jogador.getNome() +
                    ", Nacionalidade: " + jogador.getNacionalidade() +
                    ", Clube: " + jogador.getClube());
        }
    }

    //Lista os jogadores filtrando por clube.
    public List<Jogador> encontrarPorClube(String clube) {
        List<Jogador> jogadoresNoClube = new ArrayList<>();
        for (Jogador jogador : jogadores) {
            if (jogador.getClube().equalsIgnoreCase(clube)) {
                jogadoresNoClube.add(jogador);
            }
        }
        return jogadoresNoClube;
    }

    //Calcula a afinidade total do time, somando todas as afinidades e dividindo pela qtd das mesmas.
    public double calcularAfinidadeTotal() {
        double somaAfinidades = 0;
        int numeroCombinacoes = (jogadores.size() * (jogadores.size() - 1)) / 2;

        for (Aresta aresta : compatibilidades) {
            somaAfinidades += aresta.getPeso();
        }

        return somaAfinidades / numeroCombinacoes;
    }

    //Limpa as compatibilidades para nao imprimir repetido.
    public void limparCompatibilidades() {
        compatibilidades.clear();
    }
}
