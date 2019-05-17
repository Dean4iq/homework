package ua.den.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.den.model.entity.CarModel;

import java.util.List;

public interface CarModelRepository extends JpaRepository<CarModel, Long> {
    List<CarModel> findAll();
}
