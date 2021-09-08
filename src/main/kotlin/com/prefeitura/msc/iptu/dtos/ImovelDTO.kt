package com.prefeitura.msc.iptu.dtos

data class ImovelDTO(
    var cep: String? = null,
    var dono: String? = null ,
    var areaConstruida : Double,
    var areaTotalTerreno : Double,
    var valorVenalConstrucao : Double? = null,
    var valorVenalTerreno : Double? = null,
    var valorVenalImovel : Double? = null,
    var valorImposto : Double? = null,
    var anoBase : String? = null
)
