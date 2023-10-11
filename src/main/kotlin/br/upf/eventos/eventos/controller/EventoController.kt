package br.upf.eventos.eventos.controller

import br.upf.eventos.eventos.model.Evento
import br.upf.eventos.eventos.model.StatusEvento
import br.upf.eventos.eventos.service.EventoService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDate

@RestController
@RequestMapping("/eventos")
class EventoController(val eventoService: EventoService) {

    @GetMapping
    fun listar(): List<Evento>{
        return eventoService.listar();
    }
}