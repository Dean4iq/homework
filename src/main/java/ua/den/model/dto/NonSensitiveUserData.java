package ua.den.model.dto;

import ua.den.model.annotations.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Objects;

public class NonSensitiveUserData {
    @NotNull
    @NotEmpty
    @ValidLogin
    private String login;

    @NotNull
    @NotEmpty
    @ValidEmail
    private String email;

    @NotNull
    @NotEmpty
    @ValidName
    private String name;

    @NotNull
    @NotEmpty
    @ValidLastName
    private String lastName;

    @NotNull
    @NotEmpty
    @ValidPatronymicName
    private String patronymicName;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPatronymicName() {
        return patronymicName;
    }

    public void setPatronymicName(String patronymicName) {
        this.patronymicName = patronymicName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NonSensitiveUserData that = (NonSensitiveUserData) o;
        return login.equals(that.login) &&
                email.equals(that.email) &&
                name.equals(that.name) &&
                lastName.equals(that.lastName) &&
                patronymicName.equals(that.patronymicName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, email, name, lastName, patronymicName);
    }

    @Override
    public String toString() {
        return "NonSensitiveUserData{" +
                "login='" + login + '\'' +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", patronymicName='" + patronymicName + '\'' +
                '}';
    }
}
