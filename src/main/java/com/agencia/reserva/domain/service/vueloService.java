package com.agencia.reserva.domain.service;


import java.util.List;

import com.agencia.reserva.domain.entity.Asientosdetalles;
import com.agencia.reserva.domain.entity.BuscarVuelo;
import com.agencia.reserva.domain.entity.Ciudad;
import com.agencia.reserva.domain.entity.DetalleReserva;
import com.agencia.reserva.domain.entity.Pasajero;
import com.agencia.reserva.domain.entity.VuelosDto;
import com.agencia.reserva.domain.entity.vuelo;
import com.agencia.tipoDocumento.domain.entity.TipoDocumento;

public interface vueloService {

    VuelosDto consultvuelo(int id);
    List<String> BuscarVuelo(BuscarVuelo BuscarVuelo);
    void updatevuelo(vuelo vuelo);
    vuelo findvuelo(int id);
    void deletevuelo(int id);
    void asignarsilla(Asientosdetalles asientosdetalles);
    List<Ciudad> findAllCiudades();
    int crearReserva(BuscarVuelo bVuelo);
    int VerificarPasajero(Pasajero pasajero);
    List<TipoDocumento> buscarTipoDocumento();
    int crearReservaDetalle(DetalleReserva detalleReserva);
    List<String> sillasVacias(int idConexion);


}
