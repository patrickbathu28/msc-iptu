package com.prefeitura.msc.iptu.dtos

data class ImovelDTO(
    var cep: String,
    var dono: String,
    var areaConstruida : Double,
    var areaTotal : Double,
    var valorVenalConstrucao : Double? = null,
    var valorVenalTerreno : Double? = null,
    var valorVenalImovel : Double? = null,
    var iptu : Double? = null,
    var anoBase : String? = null
)
