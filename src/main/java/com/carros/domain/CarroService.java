package com.carros.domain;

import com.carros.domain.dto.CarroDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CarroService {

    @Autowired
    private CarroRepository rep;

    public List<CarroDTO> getCarros() {

        return rep.findAll().stream().map(CarroDTO::new).collect(Collectors.toList());

//        List<CarroDTO> list = new ArrayList<>();
//        for (Carro c : carros) {
//            list.add(new CarroDTO(c));
//        }
    }

    public Optional<Carro> getCarroById(Long id) {
        return rep.findById(id);
    }

    public List<CarroDTO> getCarrosByTipo(String tipo) {
        return rep.findByTipo(tipo).stream().map(CarroDTO::new).collect(Collectors.toList());
    }

    public Carro save(Carro carro) {
        return rep.save(carro);
    }

    public Carro delete(Long id) {

        Optional<Carro> carro = getCarroById(id);

        if(carro.isPresent()) {
            rep.deleteById(id);

            return carro.get();
        }

        return null;
    }
}
