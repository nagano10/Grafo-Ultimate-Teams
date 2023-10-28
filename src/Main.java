import java.text.DecimalFormat;
import java.util.List;
import java.util.Scanner;

public class Main {

    //Criacao de um menu que chama os metodos criados
    public static void main(String[] args) {
        Grafo grafo = new Grafo();
        Scanner scanner = new Scanner(System.in);

        int opcao;
        do {
            System.out.println("Menu:");
            System.out.println("1 - Adicionar jogador");
            System.out.println("2 - Remover jogador");
            System.out.println("3 - Listar os jogadores adicionados");
            System.out.println("4 - Filtrar jogadores por clube");
            System.out.println("5 - Mostrar a compatibilidade entre todos os jogadores");
            System.out.println("6 - Mostrar a compatibilidade do time no geral");
            System.out.println("7 - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do scanner

            switch (opcao) {
                case 1:
                    System.out.print("Nome do jogador: ");
                    String nome = scanner.nextLine();
                    System.out.print("Nacionalidade do jogador: ");
                    String nacionalidade = scanner.nextLine();
                    System.out.print("Clube do jogador: ");
                    String clube = scanner.nextLine();
                    grafo.adicionarJogador(nome, nacionalidade, clube);
                    break;
                case 2:
                    System.out.print("Nome do jogador a ser removido: ");
                    String nomeRemover = scanner.nextLine();
                    grafo.removerJogador(nomeRemover);
                    break;
                case 3:
                    grafo.listarJogadores();
                    break;
                case 4:
                    System.out.print("Nome do clube para filtrar jogadores: ");
                    String clubeFiltro = scanner.nextLine();
                    List<Jogador> jogadoresFiltrados = grafo.encontrarPorClube(clubeFiltro);
                    System.out.println("Jogadores do clube " + clubeFiltro + ":");
                    for (Jogador jogador : jogadoresFiltrados) {
                        System.out.println("Nome: " + jogador.getNome() +
                                ", Nacionalidade: " + jogador.getNacionalidade() +
                                ", Clube: " + jogador.getClube());
                    }
                    break;
                case 5:
                    grafo.limparCompatibilidades();
                    grafo.calcularAfinidade();
                    grafo.mostrarCompatibilidades();
                    break;
                case 6:
                    double afinidadeTotal = grafo.calcularAfinidadeTotal();
                    DecimalFormat df = new DecimalFormat("#.##");
                    System.out.println("Afinidade total do time: " + df.format(afinidadeTotal));
                    break;
                case 7:
                    System.out.println("Saindo do programa. Até mais!");
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, escolha novamente.");
                    break;
            }

        } while (opcao != 7);

        scanner.close();
    }
}
