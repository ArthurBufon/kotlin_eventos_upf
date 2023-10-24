package br.upf.eventos.eventos.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import java.time.LocalDate
import java.time.LocalDateTime

@Entity
data class Evento(
    @Id @GeneratedValue
    val id: Long? = null,
    val nome: String,
    val data: LocalDate,
    val dataInicioInsc: LocalDateTime,
    val dataFimInsc: LocalDateTime,
    val descricao: String,
    val status: StatusEvento,
    val inscritos: List<Inscricao> = listOf(),
)
