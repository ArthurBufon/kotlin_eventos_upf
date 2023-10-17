package br.upf.eventos.eventos.dtos

import br.upf.eventos.eventos.model.StatusEvento
import java.time.LocalDate

data class EventoDTO(
    val nome: String,
    val data: LocalDate,
    val descricao: String,
    val status: StatusEvento
)
