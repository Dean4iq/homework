package ua.den.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "car")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String model;
    private String serialNumber;
    private Integer enginePower;
    private Integer fuelTankCapacity;
    private Integer amountAvailable;
    private Integer releaseYear;
    private Integer mileage;

    private Car(Builder builder) {
        this.id = builder.id;
        this.model = builder.model;
        this.serialNumber = builder.serialNumber;
        this.enginePower = builder.enginePower;
        this.fuelTankCapacity = builder.fuelTankCapacity;
        this.amountAvailable = builder.amountAvailable;
        this.releaseYear = builder.releaseYear;
        this.mileage = builder.mileage;
    }

    public static class Builder {
        private Long id;
        private String model;
        private String serialNumber;
        private Integer enginePower;
        private Integer fuelTankCapacity;
        private Integer amountAvailable;
        private Integer releaseYear;
        private Integer mileage;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder model(String model) {
            this.model = model;
            return this;
        }

        public Builder serialNumber(String serialNumber) {
            this.serialNumber = serialNumber;
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

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
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

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        if (!id.equals(car.id)) return false;
        if (!model.equals(car.model)) return false;
        if (!serialNumber.equals(car.serialNumber)) return false;
        if (!enginePower.equals(car.enginePower)) return false;
        if (!fuelTankCapacity.equals(car.fuelTankCapacity)) return false;
        if (!amountAvailable.equals(car.amountAvailable)) return false;
        if (!releaseYear.equals(car.releaseYear)) return false;
        return mileage.equals(car.mileage);

    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + model.hashCode();
        result = 31 * result + serialNumber.hashCode();
        result = 31 * result + enginePower.hashCode();
        result = 31 * result + fuelTankCapacity.hashCode();
        result = 31 * result + amountAvailable.hashCode();
        result = 31 * result + releaseYear.hashCode();
        result = 31 * result + mileage.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", serialNumber='" + serialNumber + '\'' +
                ", enginePower=" + enginePower +
                ", fuelTankCapacity=" + fuelTankCapacity +
                ", amountAvailable=" + amountAvailable +
                ", releaseYear=" + releaseYear +
                ", mileage=" + mileage +
                '}';
    }
}
