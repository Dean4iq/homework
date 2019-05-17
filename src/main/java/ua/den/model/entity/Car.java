package ua.den.model.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "car")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer enginePower;
    private Integer fuelTankCapacity;
    private Integer amountAvailable;
    private Integer releaseYear;
    private Integer mileage;
    private Integer price;

    @ManyToOne
    @JoinColumn(name = "model_id")
    private CarModel carModel;

    public Car() {
    }

    private Car(Builder builder) {
        this.id = builder.id;
        this.enginePower = builder.enginePower;
        this.fuelTankCapacity = builder.fuelTankCapacity;
        this.amountAvailable = builder.amountAvailable;
        this.releaseYear = builder.releaseYear;
        this.mileage = builder.mileage;
        this.price = builder.price;
    }

    public static class Builder {
        private Long id;
        private Integer enginePower;
        private Integer fuelTankCapacity;
        private Integer amountAvailable;
        private Integer releaseYear;
        private Integer mileage;
        private Integer price;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder enginePower(Integer enginePower) {
            this.enginePower = enginePower;
            return this;
        }

        public Builder fuelTankCapacity(Integer fuelTankCapacity) {
            this.fuelTankCapacity = fuelTankCapacity;
            return this;
        }

        public Builder amountAvailable(Integer amountAvailable) {
            this.amountAvailable = amountAvailable;
            return this;
        }

        public Builder releaseYear(Integer releaseYear) {
            this.releaseYear = releaseYear;
            return this;
        }

        public Builder mileage(Integer mileage) {
            this.mileage = mileage;
            return this;
        }

        public Builder price(Integer price) {
            this.price = price;
            return this;
        }

        public Car build() {
            return new Car(this);
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getEnginePower() {
        return enginePower;
    }

    public void setEnginePower(Integer enginePower) {
        this.enginePower = enginePower;
    }

    public Integer getFuelTankCapacity() {
        return fuelTankCapacity;
    }

    public void setFuelTankCapacity(Integer fuelTankCapacity) {
        this.fuelTankCapacity = fuelTankCapacity;
    }

    public Integer getAmountAvailable() {
        return amountAvailable;
    }

    public void setAmountAvailable(Integer amountAvailable) {
        this.amountAvailable = amountAvailable;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

    public Integer getMileage() {
        return mileage;
    }

    public void setMileage(Integer mileage) {
        this.mileage = mileage;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public CarModel getCarModel() {
        return carModel;
    }

    public void setCarModel(CarModel carModel) {
        this.carModel = carModel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(getId(), car.getId()) &&
                getEnginePower().equals(car.getEnginePower()) &&
                getFuelTankCapacity().equals(car.getFuelTankCapacity()) &&
                getAmountAvailable().equals(car.getAmountAvailable()) &&
                getReleaseYear().equals(car.getReleaseYear()) &&
                getMileage().equals(car.getMileage()) &&
                getPrice().equals(car.getPrice()) &&
                getCarModel().equals(car.getCarModel());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getEnginePower(), getFuelTankCapacity(), getAmountAvailable(), getReleaseYear(), getMileage(), getPrice(), getCarModel());
    }


    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", enginePower=" + enginePower +
                ", fuelTankCapacity=" + fuelTankCapacity +
                ", amountAvailable=" + amountAvailable +
                ", releaseYear=" + releaseYear +
                ", mileage=" + mileage +
                ", price=" + price +
                '}';
    }
}
