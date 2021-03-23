package com.prefeitura.msc.iptu

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@EnableFeignClients
@SpringBootApplication
class MscIptuApplication

fun main(args: Array<String>) {
	runApplication<MscIptuApplication>(*args)
}
