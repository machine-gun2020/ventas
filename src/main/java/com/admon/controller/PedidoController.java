package com.admon.controller;

import com.admon.model.Pedido;
import com.admon.service.PedidoService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

@Path("/pedidos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PedidoController {
    @Inject
    PedidoService pedidoService;

    @GET
    public List<Pedido> listarPedidos() {
        return pedidoService.listarTodos();
    }

    @POST
    public void agregarPedido(Pedido pedido) {
        pedidoService.guardar(pedido);
    }
}
