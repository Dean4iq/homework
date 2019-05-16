package ua.den.model.dto;

import ua.den.model.annotations.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@PasswordMatches
public class UserDto {
    @NotNull
    @NotEmpty
    @ValidLogin
    private String login;

    @NotNull
    @NotEmpty
    @ValidPassword
    private String password;

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

    @NotNull
    @NotEmpty
    private String repeatedPassword;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getRepeatedPassword() {
        return repeatedPassword;
    }

    public void setRepeatedPassword(String repeatedPassword) {
        this.repeatedPassword = repeatedPassword;
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

        UserDto userDto = (UserDto) o;

        if (!login.equals(userDto.login)) return false;
        if (!password.equals(userDto.password)) return false;
        if (!email.equals(userDto.email)) return false;
        if (!name.equals(userDto.name)) return false;
        if (!lastName.equals(userDto.lastName)) return false;
        if (!patronymicName.equals(userDto.patronymicName)) return false;
        return repeatedPassword.equals(userDto.repeatedPassword);

    }

    @Override
    public int hashCode() {
        int result = login.hashCode();
        result = 31 * result + password.hashCode();
        result = 31 * result + email.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + lastName.hashCode();
        result = 31 * result + patronymicName.hashCode();
        result = 31 * result + repeatedPassword.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", patronymicName='" + patronymicName + '\'' +
                ", repeatedPassword='" + repeatedPassword + '\'' +
                '}';
    }
}
