package com.prefeitura.msc.iptu.services

import com.prefeitura.msc.iptu.dtos.ImovelDTO

interface IptuService {
    fun getValorIPTU(anoBase: String, imovelDTO: ImovelDTO): ImovelDTO
}