package br.upf.eventos.eventos.repository

import br.upf.eventos.eventos.model.Evento
import br.upf.eventos.eventos.model.StatusEvento
import org.springframework.stereotype.Repository
import java.time.LocalDate

@Repository
class EventoRepository(private var eventos: MutableList<Evento>) {

    init {
        // Data de hoje.
        val hoje = LocalDate.now();

        // Evento 1.
        val evento1 = Evento(
            id = 1,
            nome = "UPF em Dança",
            data = hoje,
            dataInicioInsc = hoje.atStartOfDay().plusDays(10),
            dataFimInsc = hoje.atStartOfDay().plusDays(20),
            descricao = "Melhor evento de dança de salão",
            status = StatusEvento.ABERTO,
        );

        // Evento 2.
        val evento2 = Evento(
            id = 2,
            nome = "UPF em Dança 2",
            data = hoje,
            dataInicioInsc = hoje.atStartOfDay().plusDays(10),
            dataFimInsc = hoje.atStartOfDay().plusDays(20),
            descricao = "Melhor evento de dança de salão 2",
            status = StatusEvento.ABERTO,
        );

        // Evento 3.
        val evento3 = Evento(
            id = 3,
            nome = "UPF em Dança 3",
            data = hoje,
            dataInicioInsc = hoje.atStartOfDay().plusDays(10),
            dataFimInsc = hoje.atStartOfDay().plusDays(20),
            descricao = "Melhor evento de dança de salão 3",
            status = StatusEvento.ABERTO,
        );

        // Lista com eventos.
        eventos = mutableListOf(evento1, evento2, evento3);
    }

    // Returns all Eventos.
    fun findAll() = eventos;

    // Creates new Evento.
    fun create(evento: Evento) {
        eventos.add(evento);
    }
}