package br.upf.eventos.eventos.service

import br.upf.eventos.eventos.converters.EventoConverter
import br.upf.eventos.eventos.dtos.EventoDTO
import br.upf.eventos.eventos.dtos.EventoResponseDTO
import br.upf.eventos.eventos.model.Evento
import br.upf.eventos.eventos.repository.EventoRepository
import org.springframework.stereotype.Service

@Service
class EventoService(private val repository: EventoRepository, private val converter: EventoConverter) {

    fun getAll(): List<EventoResponseDTO> {
        return repository.findAll().map(converter::toEventoResponseDTO);
    }

    fun getById(id: Long): EventoResponseDTO {
        val evento =  repository.findAll().first { it.id == id };
        return converter.toEventoResponseDTO(evento);
    }

    fun create(dto: EventoDTO) {
        return repository.create(converter.toEvento(dto));
    }

    fun update(id: Long, dto: EventoDTO) {
        val evento =  repository.findAll().first { it.id == id };
        return repository.update(evento, converter.toEvento(dto));
    }
}