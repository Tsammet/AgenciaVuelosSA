package com.agencia.reserva.application;

import com.agencia.reserva.domain.entity.vuelo;
import com.agencia.reserva.domain.service.vueloService;

public class SeleccionarSillaUserCase {
 private final vueloService vueloService;

public SeleccionarSillaUserCase(com.agencia.reserva.domain.service.vueloService vueloService) {
    this.vueloService = vueloService;
}
  public vuelo execute(int id)  {
        return vueloService.findvuelo(id);
        
    }

}
