package br.upf.eventos.eventos.service

import br.upf.eventos.eventos.converters.EventoConverter
import br.upf.eventos.eventos.dtos.EventoDTO
import br.upf.eventos.eventos.model.Evento
import br.upf.eventos.eventos.repository.EventoRepository
import org.springframework.stereotype.Service

@Service
class EventoService(private val repository: EventoRepository, private val converter: EventoConverter) {

    fun getAll(): List<Evento> {
        return repository.findAll();
    }

    fun getById(id: Long): Evento {
        return repository.findAll().first { it.id == id };
    }

    fun create(dto: EventoDTO) {
        return repository.create(converter.toEvento(dto));
    }
}