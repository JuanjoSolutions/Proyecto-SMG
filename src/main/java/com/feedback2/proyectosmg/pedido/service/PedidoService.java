package com.feedback2.proyectosmg.pedido.service;

import com.feedback2.proyectosmg.pedido.model.Pedido;
import com.feedback2.proyectosmg.pedido.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Transactional
    public Pedido crearPedido(Pedido pedido) {
        pedido.setFecha(java.time.LocalDateTime.now());
        return pedidoRepository.save(pedido);
    }

    public List<Pedido> obtenerTodosPedidos() {
        return pedidoRepository.findAll();
    }

    public Pedido obtenerPedidoPorId(Long id) {
        return pedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido no encontrado"));
    }

    @Transactional
    public Pedido actualizarPedido(Long id, Pedido pedidoDetalles) {
        Pedido pedido = obtenerPedidoPorId(id);
        pedido.setCliente(pedidoDetalles.getCliente());
        pedido.setProducto(pedidoDetalles.getProducto());
        pedido.setCantidad(pedidoDetalles.getCantidad());
        return pedidoRepository.save(pedido);
    }

    @Transactional
    public void eliminarPedido(Long id) {
        Pedido pedido = obtenerPedidoPorId(id);
        pedidoRepository.delete(pedido);
    }
}

