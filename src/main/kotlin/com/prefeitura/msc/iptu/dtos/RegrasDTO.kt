package com.prefeitura.msc.iptu.dtos

import org.springframework.data.annotation.Id

data class RegrasDTO(
    var ano: String,
    var aliguota: Double ,
    var valorMetroConstruido : Double,
    var valorMetroTerreno : Double
)
