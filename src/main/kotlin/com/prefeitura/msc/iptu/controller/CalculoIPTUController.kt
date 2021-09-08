package com.prefeitura.msc.iptu.controller


import com.prefeitura.msc.iptu.dtos.ImovelDTO
import com.prefeitura.msc.iptu.services.IptuService
import io.swagger.annotations.ApiOperation
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/v1/iptu")
class CalculoIPTUController ( val iptuService: IptuService?) {

    @ApiOperation(value = "Api de Calculo do IPTU com ano Base")
    @PostMapping(path = ["/{anoBase}/calculo"], produces= [MediaType.APPLICATION_JSON_VALUE])
    fun calculoIPTU(@PathVariable("anoBase") anoBase: String, @RequestBody imovelDTO: ImovelDTO):
            ResponseEntity<ImovelDTO> = ResponseEntity.status(HttpStatus.OK).body(iptuService?.getValorIPTU(anoBase, imovelDTO))

}