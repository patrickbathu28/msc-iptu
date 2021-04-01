package com.prefeitura.msc.iptu.services

import com.prefeitura.msc.iptu.client.SturClient
import com.prefeitura.msc.iptu.dtos.ImovelDTO
import com.prefeitura.msc.iptu.dtos.RegrasDTO
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.PathVariable
import java.text.DecimalFormat
import kotlin.math.round

@Service
class CalculoIPTUServiceImp(val sturClient: SturClient) : IptuService {

    override fun getValorIPTU(anoBase: String, imovelDTO: ImovelDTO): ImovelDTO {

        println("CalculoIPTUServiceImp.getValorIPTU - start - anoBase ${anoBase}")

        var regrasDTO : RegrasDTO? = sturClient.getRegrasAno(anoBase)

        imovelDTO.anoBase = anoBase

        if (regrasDTO != null) {
            this.valorVenalTerreno(imovelDTO, regrasDTO)
            this.valorVenalConstrucao(imovelDTO, regrasDTO)
            this.valorVenalImovel(imovelDTO)
            this.valorImposto(imovelDTO, regrasDTO)
        }
        println("CalculoIPTUServiceImp.getValorIPTU - end - imovelDTO ${imovelDTO}")
        return imovelDTO
    }

    private fun valorVenalTerreno(imovelDTO: ImovelDTO, regrasDTO: RegrasDTO){
       imovelDTO.valorVenalTerreno =  (imovelDTO.areaTotalTerreno?.minus(imovelDTO.areaConstruida)) * (regrasDTO.valorMetroTerreno)
    }

    private fun valorVenalConstrucao(imovelDTO: ImovelDTO, regrasDTO: RegrasDTO){
        imovelDTO.valorVenalConstrucao =  regrasDTO.valorMetroConstruido * imovelDTO.areaConstruida
    }

    private fun valorVenalImovel(imovelDTO: ImovelDTO){
        imovelDTO.valorVenalImovel = imovelDTO.valorVenalTerreno?.plus(imovelDTO.valorVenalConstrucao!!)
    }

    private fun valorImposto(imovelDTO: ImovelDTO, regrasDTO: RegrasDTO) {
        imovelDTO.iptu = (imovelDTO.valorVenalImovel!! * regrasDTO.aliguota!!) / 100
    }

}