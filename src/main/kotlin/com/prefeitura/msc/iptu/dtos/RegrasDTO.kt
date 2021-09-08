package com.prefeitura.msc.iptu.dtos

data class RegrasDTO(
    var ano: String,
    var aliguota: Double ,
    var valorMetroConstruido : Double,
    var valorMetroTerreno : Double
)
