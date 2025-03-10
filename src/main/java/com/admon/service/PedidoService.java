package com.admon.service;

import com.admon.model.Pedido;
import com.admon.repository.PedidoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import java.util.List;

@ApplicationScoped
public class PedidoService {
    @Inject
    PedidoRepository pedidoRepository;

    public List<Pedido> listarTodos() {
        return pedidoRepository.listAll();
    }

    public void guardar(Pedido pedido) {
        pedidoRepository.persist(pedido);
    }
}
