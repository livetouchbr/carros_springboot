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

        return rep.findAll().stream().map(CarroDTO::create).collect(Collectors.toList());

//        List<CarroDTO> list = new ArrayList<>();
//        for (Carro c : carros) {
//            list.add(new CarroDTO(c));
//        }
    }

    public Optional<CarroDTO> getCarroById(Long id) {
        return rep.findById(id).map(CarroDTO::create);

//        Optional<Carro> carro = rep.findById(id);
//        return carro.map(c -> Optional.of(new CarroDTO(c))).orElse(null);
    }

    public List<CarroDTO> getCarrosByTipo(String tipo) {
        return rep.findByTipo(tipo).stream().map(CarroDTO::create).collect(Collectors.toList());
    }

    public Carro save(Carro carro) {
        return rep.save(carro);
    }

    public void delete(Long id) {

        if(getCarroById(id).isPresent()) {
            rep.deleteById(id);
        }
    }
}
