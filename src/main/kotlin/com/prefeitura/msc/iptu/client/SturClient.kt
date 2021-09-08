package com.prefeitura.msc.iptu.client

import com.prefeitura.msc.iptu.dtos.RegrasDTO
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*

@FeignClient(name = "stur", url = "https://livros-firebase-66a75.firebaseio.com")
interface SturClient {

    @GetMapping(path = ["/stur/iptu/regras"], consumes= [MediaType.APPLICATION_JSON_VALUE])
    fun getRegras(@PathVariable("id") regras: RegrasDTO?): String?

    @GetMapping(path = ["/stur/iptu/regras/{ano}.json"], consumes= [MediaType.APPLICATION_JSON_VALUE])
    fun getRegrasAno(@PathVariable("ano") ano: String?): RegrasDTO?

    @PutMapping(path = ["/stur/iptu/regras/{ano}.json"], consumes= [MediaType.APPLICATION_JSON_VALUE])
    fun setRegras(@RequestBody regras: RegrasDTO, @PathVariable("ano") ano: String): String?

    @GetMapping(path = ["/stur/iptu/"], consumes= [MediaType.APPLICATION_JSON_VALUE])
    fun getValores(): String?

    @DeleteMapping(path = ["/stur/iptu"], consumes= [MediaType.APPLICATION_JSON_VALUE])
    fun deleteRegras(@PathVariable("id") id: String?): String?

}