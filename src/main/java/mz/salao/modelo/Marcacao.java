package mz.salao.modelo;


import java.time.LocalDateTime;

public class Marcacao {
    private int id;
    private Cliente cliente;
    private Profissional profissional;
    private Servico servico;
    private LocalDateTime dataHora;
    private TipoAtendimento tipoAtendimento;

    public Marcacao(int id, Cliente cliente, Profissional profissional,
                    Servico servico, LocalDateTime dataHora,
                    TipoAtendimento tipoAtendimento) {
        this.id = id;
        this.cliente = cliente;
        this.profissional = profissional;
        this.servico = servico;
        this.dataHora = dataHora;
        this.tipoAtendimento = tipoAtendimento;
    }

    public int getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Profissional getProfissional() {
        return profissional;
    }

    public Servico getServico() {
        return servico;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public TipoAtendimento getTipoAtendimento() {
        return tipoAtendimento;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setProfissional(Profissional profissional) {
        this.profissional = profissional;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public void setTipoAtendimento(TipoAtendimento tipoAtendimento) {
        this.tipoAtendimento = tipoAtendimento;
    }

    @Override
    public String toString() {
        return "Marcacao #"+ id +
                ", Cliente=" + cliente +
                ", Profissional=" + profissional +
                ", Servico=" + servico +
                ", Data e hora=" + dataHora +
                ", Atendimento=" + tipoAtendimento;
    }
}
