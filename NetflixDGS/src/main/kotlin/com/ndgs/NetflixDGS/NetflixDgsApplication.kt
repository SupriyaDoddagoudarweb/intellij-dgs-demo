package com.ndgs.NetflixDGS

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class NetflixDgsApplication

fun main(args: Array<String>) {
	println("DGS is on")
	runApplication<NetflixDgsApplication>(*args)
}
