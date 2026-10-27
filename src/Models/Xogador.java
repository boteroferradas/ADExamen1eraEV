package Models;

public class Xogador {
    private int id;
    private String nome;
    private String posicion;
    private int idade;

    public Xogador(String nome, String posicion, int idade) {
        this.nome = nome;
        this.posicion = posicion;
        this.idade = idade;
    }

    public Xogador(int id, String nome, String posicion, int idade) {
        this.id = id;
        this.nome = nome;
        this.posicion = posicion;
        this.idade = idade;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        if (idade > 0) {
            this.idade = idade;
        }
    }
}
