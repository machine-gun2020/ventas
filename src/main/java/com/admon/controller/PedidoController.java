package com.admon.controller;

import com.admon.model.Pedido;
import com.admon.service.PedidoService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import jakarta.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Path("/pedidos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PedidoController {

    private static final Logger log = LoggerFactory.getLogger(PedidoController.class);

    @Inject
    PedidoService pedidoService;

    @GET
    @Path("/listar")
    @Produces(MediaType.TEXT_PLAIN)
    public List<Pedido> listarPedidos() {
        log.info("Listado, pedidos");
        List<Pedido> pedidos;
        pedidos = pedidoService.listarTodos();
        return pedidos;
    }

    @POST
    @Path("/inserta")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void agregarPedido(Pedido pedido) {
        log.info("Agregar, pedido");
        pedidoService.guardar(pedido);
    }
}
