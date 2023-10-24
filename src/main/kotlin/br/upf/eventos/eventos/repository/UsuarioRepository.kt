package br.upf.eventos.eventos.repository

import br.upf.eventos.eventos.model.Evento
import br.upf.eventos.eventos.model.StatusEvento
import br.upf.eventos.eventos.model.Usuario
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.time.LocalDate

@Repository
interface UsuarioRepository: JpaRepository<Usuario, Long> {

}