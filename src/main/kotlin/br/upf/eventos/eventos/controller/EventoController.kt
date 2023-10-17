package br.upf.eventos.eventos.controller

import br.upf.eventos.eventos.dtos.EventoDTO
import br.upf.eventos.eventos.dtos.EventoResponseDTO
import br.upf.eventos.eventos.model.Evento
import br.upf.eventos.eventos.model.StatusEvento
import br.upf.eventos.eventos.service.EventoService
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDate

@RestController
@RequestMapping("/eventos")
class EventoController(val service: EventoService) {

    @GetMapping
    fun getAll(): List<EventoResponseDTO> {
        return service.getAll();
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): EventoResponseDTO {
        return service.getById(id);
    }

    @PostMapping
    fun create(@RequestBody @Valid evento: EventoDTO) {
        service.create(evento);
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody @Valid evento: EventoDTO){
        service.update(id, evento);
    }
}