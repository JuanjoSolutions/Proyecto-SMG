package com.feedback2.proyectosmg.pedido.service;

import com.feedback2.proyectosmg.pedido.model.Pedido;
import com.feedback2.proyectosmg.pedido.repository.PedidoRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.springframework.boot.test.context.SpringBootTest;
import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
public class PedidoServiceTests {

    @Mock
    private PedidoRepository pedidoRepository;

    @InjectMocks
    private PedidoService pedidoService;

    @Test
    public void testCrearPedido() {
        Pedido pedido = new Pedido();
        pedido.setCliente("Cliente Test");
        pedido.setProducto("Producto Test");
        pedido.setCantidad(3);

        Pedido pedidoGuardado = new Pedido();
        pedidoGuardado.setId(1L);
        pedidoGuardado.setCliente("Cliente Test");
        pedidoGuardado.setProducto("Producto Test");
        pedidoGuardado.setCantidad(3);
        pedidoGuardado.setFecha(LocalDateTime.now());

        when(pedidoRepository.save(any(Pedido.class))).thenReturn(pedidoGuardado);

        Pedido resultado = pedidoService.crearPedido(pedido);

        assertNotNull(resultado.getId());
        assertEquals("Cliente Test", resultado.getCliente());
        verify(pedidoRepository, times(1)).save(pedido);
    }

    @Test
    public void testObtenerPedidoPorId() {
        Pedido pedido = new Pedido();
        pedido.setId(1L);
        pedido.setCliente("Cliente Test");
        pedido.setProducto("Producto Test");
        pedido.setCantidad(3);
        pedido.setFecha(LocalDateTime.now());

        when(pedidoRepository.findById(1L)).thenReturn(Optional.of(pedido));

        Pedido resultado = pedidoService.obtenerPedidoPorId(1L);

        assertEquals("Cliente Test", resultado.getCliente());
        verify(pedidoRepository, times(1)).findById(1L);
    }

    // Agrega más pruebas según sea necesario
}

