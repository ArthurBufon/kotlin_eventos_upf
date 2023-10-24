package br.upf.eventos.eventos.model

import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany

data class Usuario(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val nome: String,
    val cidade: String,
    val telefone: String,

    @OneToMany(mappedBy = "usuario")
    val inscricoes: List<Inscricao> = listOf()
)
