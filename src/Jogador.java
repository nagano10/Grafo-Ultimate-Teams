public class Jogador {
    private String nome;
    private String nacionalidade;
    private String clube;

    public Jogador(String nome, String nacionalidade, String clube) {
        this.nome = nome;
        this.nacionalidade = nacionalidade;
        this.clube = clube;
    }

    public String getNome() {
        return nome;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public String getClube() {
        return clube;
    }
}
