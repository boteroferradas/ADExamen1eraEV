package Models;

public class Celta {
    private int id;
    private String nome;
    private int soldo;

    public Celta(int id, String nome, int soldo) {
        this.id = id;
        this.nome = nome;
        this.soldo = soldo;
    }

    public Celta(String nome, int soldo) {
        this.nome = nome;
        this.soldo = soldo;
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

    public int getSoldo() {
        return soldo;
    }

    public void setSoldo(int soldo) {
        if (soldo >0){
            this.soldo = soldo;
        }
    }
}
