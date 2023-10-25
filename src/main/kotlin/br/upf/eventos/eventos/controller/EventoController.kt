package br.upf.eventos.eventos.controller

import br.upf.eventos.eventos.dtos.EventoDTO
import br.upf.eventos.eventos.dtos.EventoResponseDTO
import br.upf.eventos.eventos.service.EventoService
import jakarta.transaction.Transactional
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.util.UriComponentsBuilder

@RestController
@RequestMapping("/eventos")
class EventoController(val service: EventoService) {

    @GetMapping
    fun getAll(@RequestParam(required = false) nomeEvento: String?): List<EventoResponseDTO> {
        return service.getAll(nomeEvento);
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): EventoResponseDTO {
        return service.getById(id);
    }

    @PostMapping
    @Transactional
    @ResponseStatus(HttpStatus.CREATED)
    fun create(
        @RequestBody @Valid evento: EventoDTO,
        uriBuilder: UriComponentsBuilder
    ): ResponseEntity<EventoResponseDTO> {
        val eventoResponse = service.create(evento);
        val uri = uriBuilder.path("/eventos/${eventoResponse.id}").build().toUri();
        return ResponseEntity.created(uri).body(eventoResponse);
    }

    @PutMapping("/{id}")
    @Transactional
    fun update(@PathVariable id: Long, @RequestBody @Valid evento: EventoDTO): EventoResponseDTO {
        return service.update(id, evento);
    }

    @DeleteMapping("/{id}")
    @Transactional
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun destroy(@PathVariable id: Long) {
        service.destroy(id);
    }
}