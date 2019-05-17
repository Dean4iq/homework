package ua.den.model.dto;

import ua.den.model.annotations.ValidEnginePower;
import ua.den.model.annotations.ValidFuelTankCapacity;
import ua.den.model.annotations.ValidMileage;
import ua.den.model.annotations.ValidReleaseYear;

import java.util.Objects;

public class SearchParam {
    private String model;
    private String serialNumber;

    @ValidEnginePower
    private Integer enginePower;

    @ValidFuelTankCapacity
    private Integer fuelTankCapacity;

    @ValidReleaseYear
    private Integer releaseYear;

    @ValidMileage
    private Integer mileage;

    public SearchParam() {
    }

    private SearchParam(Builder builder) {
        this.model = builder.model;
        this.serialNumber = builder.serialNumber;
        this.enginePower = builder.enginePower;
        this.fuelTankCapacity = builder.fuelTankCapacity;
        this.releaseYear = builder.releaseYear;
        this.mileage = builder.mileage;
    }

    public static class Builder {
        private String model;
        private String serialNumber;
        private Integer enginePower;
        private Integer fuelTankCapacity;
        private Integer releaseYear;
        private Integer mileage;

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

        public Builder releaseYear(Integer releaseYear) {
            this.releaseYear = releaseYear;
            return this;
        }

        public Builder mileage(Integer mileage) {
            this.mileage = mileage;
            return this;
        }

        public SearchParam build() {
            return new SearchParam(this);
        }
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SearchParam that = (SearchParam) o;

        if (!Objects.equals(model, that.model)) return false;
        if (!Objects.equals(serialNumber, that.serialNumber)) return false;
        if (!Objects.equals(enginePower, that.enginePower)) return false;
        if (!Objects.equals(fuelTankCapacity, that.fuelTankCapacity))
            return false;
        if (!Objects.equals(releaseYear, that.releaseYear)) return false;
        return Objects.equals(mileage, that.mileage);

    }

    @Override
    public int hashCode() {
        int result = model != null ? model.hashCode() : 0;
        result = 31 * result + (serialNumber != null ? serialNumber.hashCode() : 0);
        result = 31 * result + (enginePower != null ? enginePower.hashCode() : 0);
        result = 31 * result + (fuelTankCapacity != null ? fuelTankCapacity.hashCode() : 0);
        result = 31 * result + (releaseYear != null ? releaseYear.hashCode() : 0);
        result = 31 * result + (mileage != null ? mileage.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "SearchParam{" +
                "model='" + model + '\'' +
                ", serialNumber='" + serialNumber + '\'' +
                ", enginePower=" + enginePower +
                ", fuelTankCapacity=" + fuelTankCapacity +
                ", releaseYear=" + releaseYear +
                ", mileage=" + mileage +
                '}';
    }
}
