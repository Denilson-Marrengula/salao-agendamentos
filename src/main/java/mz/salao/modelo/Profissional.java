package mz.salao.modelo;

public class Profissional {
    private int id;
    private String nome;
    private String especialidade;
    private boolean atendeDomicilio;

    public Profissional(int id, String nome, String especialidade, boolean atendeDomicilio) {
        this.id = id;
        this.nome = nome;
        this.especialidade = especialidade;
        this.atendeDomicilio = atendeDomicilio;
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

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public boolean getAtendeDomicilio() {
        return atendeDomicilio;
    }

    public void setAtendeDomicilio(boolean atendeDomicilio) {
        this.atendeDomicilio = atendeDomicilio;
    }
    public boolean isAtendeDomicilio() {
        return atendeDomicilio;
    }
    @Override
    public String toString() {
        return nome+ "-" +especialidade + (atendeDomicilio ? "(salao e domicilio)" : "(salao)");
    }


}
