package mz.salao.servico;

import mz.salao.modelo.Cliente;
import mz.salao.modelo.Marcacao;
import mz.salao.modelo.Profissional;
import mz.salao.modelo.Servico;
import mz.salao.modelo.TipoAtendimento;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MarcacaoServico {
    private final List<Marcacao> marcacoes = new ArrayList<>();
    private int proximoId = 1;

    public synchronized Marcacao criarMarcacao(
            Cliente cliente,
            Profissional profissional,
            Servico servico,
            LocalDateTime dataHora,
            TipoAtendimento tipoAtendimento) {

        if (cliente == null || profissional == null || servico == null
                || dataHora == null || tipoAtendimento == null) {
            throw new IllegalArgumentException("Preencha todos os dados da marcação.");
        }

        if (servico.getDuracaoMinutos() <= 0) {
            throw new IllegalArgumentException("A duração do serviço deve ser positiva.");
        }

        if (!dataHora.isAfter(LocalDateTime.now())) {
            throw new IllegalArgumentException("Escolha uma data e hora futuras.");
        }

        if (tipoAtendimento == TipoAtendimento.DOMICILIO
                && !profissional.isAtendeDomicilio()) {
            throw new IllegalArgumentException(
                    "Esta profissional não atende ao domicílio.");
        }

        LocalDateTime fimPretendido =
                dataHora.plusMinutes(servico.getDuracaoMinutos());

        for (Marcacao existente : marcacoes) {
            if (existente.getProfissional().getId() != profissional.getId()) {
                continue;
            }

            LocalDateTime inicioExistente = existente.getDataHora();
            LocalDateTime fimExistente = inicioExistente.plusMinutes(
                    existente.getServico().getDuracaoMinutos());

            boolean horariosSobrepostos =
                    dataHora.isBefore(fimExistente)
                            && inicioExistente.isBefore(fimPretendido);

            if (horariosSobrepostos) {
                throw new IllegalArgumentException(
                        "A profissional já tem uma marcação nesse horário.");
            }
        }

        Marcacao marcacao = new Marcacao(
                proximoId++, cliente, profissional, servico,
                dataHora, tipoAtendimento);

        marcacoes.add(marcacao);
        return marcacao;
    }

    public synchronized List<Marcacao> listarMarcacoes() {
        return new ArrayList<>(marcacoes);
    }
}