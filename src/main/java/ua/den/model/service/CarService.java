package ua.den.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.den.model.dto.CarParams;
import ua.den.model.dto.SearchParam;
import ua.den.model.entity.Car;
import ua.den.model.entity.CarModel;
import ua.den.model.repository.CarModelRepository;
import ua.den.model.repository.CarRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarService {
    @Autowired
    private CarRepository carRepository;

    @Autowired
    private CarModelRepository carModelRepository;

    public Car getCarById(Long carId) {
        return carRepository.getOne(carId);
    }

    public Car addNewCar(CarParams carParams) {
        Car car = new Car.Builder()
                .enginePower(carParams.getEnginePower())
                .fuelTankCapacity(carParams.getFuelTankCapacity())
                .mileage(carParams.getMileage())
                .price(carParams.getPrice())
                .amountAvailable(carParams.getAmountAvailable())
                .releaseYear(carParams.getReleaseYear())
                .build();

        CarModel carModel = new CarModel();

        carModel.setModel(carParams.getModel());
        carModel.setSerialNumber(carParams.getSerialNumber());

        car.setCarModel(carModel);

        return carRepository.save(checkCarInRepository(car));
    }

    private Car checkCarInRepository(Car car) {
        List<Car> cars = carRepository.findAll();
        List<CarModel> carModel =
                carModelRepository.findByModelAndSerialNumber(car.getCarModel().getModel(),
                        car.getCarModel().getSerialNumber());

        cars = cars.stream().filter(car::equalsForBasic)
                .collect(Collectors.toList());

        if (cars.isEmpty()) {
            car.setId(null);
            car.getCarModel().setId(null);
        } else {
            Car carInRepo = cars.get(0);

            car.setId(carInRepo.getId());
            car.setAmountAvailable(car.getAmountAvailable() + carInRepo.getAmountAvailable());
        }

        if (carModel != null && !carModel.isEmpty()) {
            car.getCarModel().setId(carModel.get(0).getId());
        }

        return car;
    }

    public List<Car> getDefinedCarList(SearchParam searchParam) {
        List<Car> cars = carRepository.findAll();

        if (carListIsNotEmpty(cars) && searchParam.getEnginePower() != null) {
            cars = cars.stream()
                    .filter(car -> car.getEnginePower().equals(searchParam.getEnginePower()))
                    .collect(Collectors.toList());
        }
        if (carListIsNotEmpty(cars) && searchParam.getFuelTankCapacity() != null) {
            cars = cars.stream()
                    .filter(car -> car.getFuelTankCapacity().equals(searchParam.getFuelTankCapacity()))
                    .collect(Collectors.toList());
        }
        if (carListIsNotEmpty(cars) && searchParam.getMileage() != null) {
            cars = cars.stream()
                    .filter(car -> car.getMileage().equals(searchParam.getMileage()))
                    .collect(Collectors.toList());
        }
        if (carListIsNotEmpty(cars) && searchParam.getModel() != null && !searchParam.getModel().isEmpty()) {
            cars = cars.stream()
                    .filter(car -> car.getCarModel().getModel().equals(searchParam.getModel()))
                    .collect(Collectors.toList());

            if (carListIsNotEmpty(cars) && searchParam.getSerialNumber() != null
                    && !searchParam.getSerialNumber().isEmpty()
                    && !searchParam.getSerialNumber().equals("null")) {
                cars = cars.stream()
                        .filter(car -> car.getCarModel().getSerialNumber().equals(searchParam.getSerialNumber()))
                        .collect(Collectors.toList());
            }
        }
        if (carListIsNotEmpty(cars) && searchParam.getReleaseYear() != null) {
            cars = cars.stream()
                    .filter(car -> car.getReleaseYear().equals(searchParam.getReleaseYear()))
                    .collect(Collectors.toList());
        }

        return cars;
    }

    private boolean carListIsNotEmpty(List<Car> cars) {
        return !cars.isEmpty();
    }
}
