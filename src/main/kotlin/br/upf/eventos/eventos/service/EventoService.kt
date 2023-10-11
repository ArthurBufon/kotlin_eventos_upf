package br.upf.eventos.eventos.service

import br.upf.eventos.eventos.model.Evento
import br.upf.eventos.eventos.repository.EventoRepository
import org.springframework.stereotype.Service

@Service
class EventoService(private val repository: EventoRepository) {

    fun listar(): List<Evento>{
        return repository.findAll();
    }
}