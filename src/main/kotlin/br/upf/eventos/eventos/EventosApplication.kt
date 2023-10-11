package br.upf.eventos.eventos

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class EventosApplication

fun main(args: Array<String>) {
	runApplication<EventosApplication>(*args)
}
