package com.prefeitura.msc.iptu.controller


import com.prefeitura.msc.iptu.client.SturClient
import com.prefeitura.msc.iptu.dtos.ImovelDTO
import com.prefeitura.msc.iptu.dtos.RegrasDTO
import com.prefeitura.msc.iptu.services.IptuService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.ws.rs.PUT

@RestController
@RequestMapping("/v1/iptu")
class CalculoIPTUController {

    @Autowired
    private var iptuService: IptuService? = null

    @ApiOperation(value = "Api de Calculo do IPTU com ano Base")
    @PostMapping(path = arrayOf("/{anoBase}/calculo"), produces= arrayOf(MediaType.APPLICATION_JSON_VALUE))
    fun calculoIPTU(@PathVariable("anoBase") anoBase: String, @RequestBody imovelDTO: ImovelDTO):
            ResponseEntity<ImovelDTO> = ResponseEntity.status(HttpStatus.OK).body(iptuService?.getValorIPTU(anoBase, imovelDTO))

}