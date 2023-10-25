package br.upf.eventos.eventos.service

import br.upf.eventos.eventos.converters.EventoConverter
import br.upf.eventos.eventos.dtos.EventoDTO
import br.upf.eventos.eventos.dtos.EventoResponseDTO
import br.upf.eventos.eventos.exceptions.NotFoundException
import br.upf.eventos.eventos.repository.EventoRepository
import org.springframework.stereotype.Service

const val ERROR_MESSAGE = "Evento não encontrado!";

@Service
class EventoService(private val repository: EventoRepository, private val converter: EventoConverter) {

    fun getAll(nomeEvento: String?): List<EventoResponseDTO> {
        val eventos = if(nomeEvento == null){
            repository.findAll();
        }else{
            repository.findByNome(nomeEvento);
        }

        return eventos.map(converter::toEventoResponseDTO);
    }

    fun getById(id: Long): EventoResponseDTO {
        val evento = repository.findById(id).orElseThrow{NotFoundException(ERROR_MESSAGE)};
        return converter.toEventoResponseDTO(evento);
    }

    fun create(dto: EventoDTO): EventoResponseDTO {
        return converter.toEventoResponseDTO(repository.save(converter.toEvento(dto)));
    }

    fun update(id: Long, dto: EventoDTO): EventoResponseDTO {
        val evento = repository.findById(id)
            .orElseThrow { NotFoundException(ERROR_MESSAGE) }
            .copy(
                nome = dto.nome,
                data = dto.data,
                descricao = dto.descricao,
                status = dto.status
            )

        return converter.toEventoResponseDTO(
            repository.save(evento)
        );
    }

    fun destroy(id: Long) {
        return repository.deleteById(id);
    }
}