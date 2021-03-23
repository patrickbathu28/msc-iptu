package com.prefeitura.msc.iptu.client

import com.prefeitura.msc.iptu.dtos.RegrasDTO
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*

@FeignClient(name = "stur", url = "https://livros-firebase-66a75.firebaseio.com")
interface SturClient {

    @GetMapping(path = arrayOf("/stur/iptu/regras"), consumes= arrayOf(MediaType.APPLICATION_JSON_VALUE))
    fun getRegras(@PathVariable("id") regras: RegrasDTO?): String?

    @GetMapping(path = arrayOf("/stur/iptu/regras/{ano}.json"), consumes= arrayOf(MediaType.APPLICATION_JSON_VALUE))
    fun getRegrasAno(@PathVariable("ano") ano: String?): RegrasDTO?

    @PutMapping(path = arrayOf("/stur/iptu/regras/{ano}.json"), consumes= arrayOf(MediaType.APPLICATION_JSON_VALUE))
    fun setRegras(@RequestBody regras: RegrasDTO, @PathVariable("ano") ano: String): String?

    @GetMapping(path = arrayOf("/stur/iptu/"), consumes= arrayOf(MediaType.APPLICATION_JSON_VALUE))
    fun getValores(): String?

    @DeleteMapping(path = arrayOf("/stur/iptu"), consumes= arrayOf(MediaType.APPLICATION_JSON_VALUE))
    fun deleteRegras(@PathVariable("id") id: String?): String?

}