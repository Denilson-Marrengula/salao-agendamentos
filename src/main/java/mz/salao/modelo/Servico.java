package mz.salao.modelo;

import java.math.BigDecimal;

public class Servico {
    private int id;
    private String nome;
    private int duracaoMinutos;
    private BigDecimal preco;

    public Servico(int id, String nome, int duracaoMinutos, BigDecimal preco) {
        this.id = id;
        this.nome = nome;
        this.duracaoMinutos = duracaoMinutos;
        this.preco = preco;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getDuracaoMinutos() {
        return duracaoMinutos;
    }

    public void setDuracaoMinutos(int duracaoMinutos) {
        this.duracaoMinutos = duracaoMinutos;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return nome + "-" + duracaoMinutos + "min" + preco+ "MT";
    }
}
