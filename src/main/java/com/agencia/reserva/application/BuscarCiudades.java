package com.agencia.reserva.application;

import java.util.List;

import com.agencia.reserva.domain.entity.Ciudad;
import com.agencia.reserva.domain.service.vueloService;

public class BuscarCiudades {
    private final vueloService vueloService;

    public BuscarCiudades(vueloService vueloService) {
        this.vueloService = vueloService;
    }

        public  List<Ciudad>  execute()  {
                return vueloService.findAllCiudades();
            

        // vueloService.BuscarVuelo();
    }

}
