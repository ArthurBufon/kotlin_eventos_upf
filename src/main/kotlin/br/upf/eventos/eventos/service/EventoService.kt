package br.upf.eventos.eventos.service

import br.upf.eventos.eventos.converters.EventoConverter
import br.upf.eventos.eventos.dtos.EventoDTO
import br.upf.eventos.eventos.dtos.EventoResponseDTO
import br.upf.eventos.eventos.exceptions.NotFoundException
import br.upf.eventos.eventos.model.Evento
import br.upf.eventos.eventos.repository.EventoRepository
import org.springframework.stereotype.Service

const val ERROR_MESSAGE = "Evento não encontrado!";

@Service
class EventoService(private val repository: EventoRepository, private val converter: EventoConverter) {

    fun getAll(): List<EventoResponseDTO> {
        return repository.findAll().map(converter::toEventoResponseDTO);
    }

    fun getById(id: Long): EventoResponseDTO {
        val evento = repository.findAll().firstOrNull() { it.id == id }?:throw NotFoundException(ERROR_MESSAGE);
        return converter.toEventoResponseDTO(evento);
    }

    fun create(dto: EventoDTO): EventoResponseDTO {
        return converter.toEventoResponseDTO(repository.create(converter.toEvento(dto)));
    }

    fun update(id: Long, dto: EventoDTO): EventoResponseDTO {
        val evento = repository.findAll().firstOrNull() { it.id == id }?:throw NotFoundException(ERROR_MESSAGE);
        return converter.toEventoResponseDTO(repository.update(evento, converter.toEvento(dto)));
    }

    fun destroy(id: Long) {
        val evento = repository.findAll().firstOrNull() { it.id == id }?:throw NotFoundException(ERROR_MESSAGE);
        return repository.destroy(evento);
    }
}