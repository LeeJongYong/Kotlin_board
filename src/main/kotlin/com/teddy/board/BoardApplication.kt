package com.teddy.board

import jakarta.annotation.PostConstruct
import mu.KotlinLogging
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing

private val logger = KotlinLogging.logger {}

// Entity에서 Listener를 사용하기 위한 annotation
@EnableJpaAuditing
@SpringBootApplication
class BoardApplication

fun main(args: Array<String>) {
	runApplication<BoardApplication>(*args)

	// KotlinLogging의 default는 info
	logger.info("logger info")
}
