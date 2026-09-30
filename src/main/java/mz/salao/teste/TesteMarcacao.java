package mz.salao.teste;


import mz.salao.modelo.*;
import mz.salao.servico.MarcacaoServico;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TesteMarcacao {
    public static void main(String[] args) {
        Cliente cliente = new Cliente(1, "Maria", "841234567");
        Profissional profissional =
                new Profissional(1, "Ana", "Cabeleireira", true);
        Servico servico =
                new Servico(1, "Tranças", 120, new BigDecimal("800"));

        MarcacaoServico agenda = new MarcacaoServico();
        LocalDateTime horario = LocalDateTime.now()
                .plusDays(1)
                .withHour(10)
                .withMinute(0)
                .withSecond(0)
                .withNano(0);

        Marcacao primeira = agenda.criarMarcacao(
                cliente, profissional, servico, horario,
                TipoAtendimento.SALAO);
        System.out.println("Criada: " + primeira);

        try {
            agenda.criarMarcacao(
                    cliente, profissional, servico,
                    horario.plusMinutes(30), TipoAtendimento.DOMICILIO);
            System.out.println("ERRO: aceitou um horário ocupado.");
        } catch (IllegalArgumentException e) {
            System.out.println("Conflito detectado: " + e.getMessage());
        }

        System.out.println("Total de marcações: "
                + agenda.listarMarcacoes().size());
    }
}
