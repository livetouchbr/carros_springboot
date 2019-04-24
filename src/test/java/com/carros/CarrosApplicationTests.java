package com.carros;

import com.carros.domain.Carro;
import com.carros.domain.CarroService;
import com.carros.domain.dto.CarroDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CarrosApplicationTests {

    @Autowired
    private CarroService service;

    @Test
    public void saveCarro() {

        Carro c = new Carro();
        c.setNome("Novo carro TestCase");
        c.setTipo("esportivos");

        service.save(c);

        // Verifica se existe id
        Long id = c.getId();
        assertNotNull(id);

        // Verifica se existwe no banco de dados
        assertTrue(service.getCarroById(id).isPresent());

        CarroDTO carro = service.getCarroById(id).get();
        assertEquals("Novo carro TestCase",carro.getNome());
        System.out.print("*** > " + carro.getNome());

        // Deleta
        service.delete(id);

        // O carro não pode existir agora
        assertFalse(service.getCarroById(id).isPresent());

    }

    @Test
    public void testListaCarros() {
        // Todos
        List<CarroDTO> carros = service.getCarros();
        System.out.println("\n\n***Carros: " + carros);
        assertFalse(carros.isEmpty());

        // Classicos
        assertFalse(service.getCarrosByTipo("classicos").isEmpty());

        // Esportivos
        assertFalse(service.getCarrosByTipo("esportivos").isEmpty());

        // Luxo
        assertFalse(service.getCarrosByTipo("luxo").isEmpty());

        // Não existe
        assertTrue(service.getCarrosByTipo("nao existe").isEmpty());
    }
}
