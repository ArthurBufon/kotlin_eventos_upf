package br.upf.eventos.eventos.converters

import br.upf.eventos.eventos.dtos.EventoDTO
import br.upf.eventos.eventos.model.Evento
import org.springframework.stereotype.Component
import java.time.LocalDateTime

@Component
class EventoConverter {

    fun toEvento(dto: EventoDTO): Evento{
        return Evento(
            nome = dto.nome,
            data = dto.data,
            dataInicioInsc = LocalDateTime.now(),
            dataFimInsc = LocalDateTime.now(),
            descricao = dto.descricao,
            status = dto.status,
        )
    }

}