package com.prefeitura.msc.iptu.services

import com.prefeitura.msc.iptu.dtos.ImovelDTO
import org.springframework.http.ResponseEntity

interface IptuService {

    fun getValorIPTU(anoBase: String, imovelDTO: ImovelDTO): ImovelDTO

}