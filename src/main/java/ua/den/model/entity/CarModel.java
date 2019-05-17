package ua.den.model.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="car_model")
public class CarModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String model;
    private String serialNumber;

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

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarModel carModel = (CarModel) o;
        return getId().equals(carModel.getId()) &&
                getModel().equals(carModel.getModel()) &&
                getSerialNumber().equals(carModel.getSerialNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getModel(), getSerialNumber());
    }

    @Override
    public String toString() {
        return "CarModel{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", serialNumber='" + serialNumber + '\'' +
                '}';
    }
}
