package ua.den.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.den.model.entity.CarModel;
import ua.den.model.repository.CarModelRepository;

import java.util.*;

@Service
public class CarModelService {
    @Autowired
    private CarModelRepository carModelRepository;

    public Set<String> getSetOfCarModels() {
        List<CarModel> carModels = carModelRepository.findAll();

        Map<String, CarModel> carModelMap = new HashMap<>();

        carModels.forEach(model -> carModelMap.putIfAbsent(model.getModel(), model));

        return carModelMap.keySet();
    }

    public List<CarModel> getAllCarModels() {
        return carModelRepository.findAll();
    }
}
