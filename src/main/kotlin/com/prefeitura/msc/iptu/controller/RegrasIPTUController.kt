package com.prefeitura.msc.iptu.controller


import com.prefeitura.msc.iptu.client.SturClient
import com.prefeitura.msc.iptu.dtos.RegrasDTO
import io.swagger.annotations.ApiOperation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.ws.rs.PUT

@RestController
@RequestMapping("/v1/iptu/{ano}/regras")
class RegrasIPTUController ( val sturClient : SturClient? ) {

    @ApiOperation(value = "Get regras por ao para calculo IPTU")
    @GetMapping(produces= [MediaType.APPLICATION_JSON_VALUE])
    fun getRuleIPTU(@PathVariable("ano") ano: String): ResponseEntity<RegrasDTO> = ResponseEntity.status(HttpStatus.OK).body(sturClient?.getRegrasAno(ano))

    @ApiOperation(value = "Cadastro de Regras por ano para calculo IPTU")
    @PostMapping(consumes = [MediaType.APPLICATION_JSON_VALUE], produces= [MediaType.APPLICATION_JSON_VALUE])
    fun createRuleIPTU(@RequestBody regrasDTO: RegrasDTO, @PathVariable("ano") ano: String) = ResponseEntity.status(HttpStatus.CREATED).body(sturClient?.setRegras(regrasDTO, ano))

    @ApiOperation(value = "Atualização de Regras por ano para calculo IPTU")
    @PutMapping(produces= [MediaType.APPLICATION_JSON_VALUE])
    fun updateRule(@RequestBody regrasDTO: RegrasDTO, @PathVariable("ano") ano: String) = ResponseEntity.status(HttpStatus.OK).body(sturClient?.setRegras(regrasDTO, ano))

}