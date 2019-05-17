package ua.den.model.dto;

import ua.den.model.annotations.*;

import javax.validation.constraints.NotNull;
import java.util.Objects;

public class CarParams {
    @NotNull
    private String model;
    @NotNull
    private String serialNumber;

    @NotNull
    @ValidEnginePower
    private Integer enginePower;

    @NotNull
    @ValidFuelTankCapacity
    private Integer fuelTankCapacity;

    @NotNull
    @ValidReleaseYear
    private Integer releaseYear;

    @NotNull
    @ValidMileage
    private Integer mileage;

    @NotNull
    @ValidAmountAvailable
    private Integer amountAvailable;

    @NotNull
    @ValidAmountAvailable
    private Integer price;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
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

    public Integer getAmountAvailable() {
        return amountAvailable;
    }

    public void setAmountAvailable(Integer amountAvailable) {
        this.amountAvailable = amountAvailable;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarParams carParams = (CarParams) o;
        return getModel().equals(carParams.getModel()) &&
                getSerialNumber().equals(carParams.getSerialNumber()) &&
                getEnginePower().equals(carParams.getEnginePower()) &&
                getFuelTankCapacity().equals(carParams.getFuelTankCapacity()) &&
                getReleaseYear().equals(carParams.getReleaseYear()) &&
                getMileage().equals(carParams.getMileage()) &&
                getPrice().equals(carParams.getPrice()) &&
                getAmountAvailable().equals(carParams.getAmountAvailable());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getModel(), getSerialNumber(), getEnginePower(), getFuelTankCapacity(), getReleaseYear(), getMileage(), getAmountAvailable(), getPrice());
    }

    @Override
    public String toString() {
        return "CarParams{" +
                "model='" + model + '\'' +
                ", serialNumber='" + serialNumber + '\'' +
                ", enginePower=" + enginePower +
                ", fuelTankCapacity=" + fuelTankCapacity +
                ", releaseYear=" + releaseYear +
                ", mileage=" + mileage +
                ", amountAvailable=" + amountAvailable +
                ", price=" + price +
                '}';
    }
}
