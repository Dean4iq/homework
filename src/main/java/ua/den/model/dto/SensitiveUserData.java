package ua.den.model.dto;

import ua.den.model.annotations.PasswordMatches;
import ua.den.model.annotations.ValidPassword;

import javax.validation.constraints.NotNull;
import java.util.Objects;

@PasswordMatches
public class SensitiveUserData {
    @NotNull
    private String oldPassword;

    @NotNull
    @ValidPassword
    private String newPassword;

    @NotNull
    private String repeatedPassword;

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getRepeatedPassword() {
        return repeatedPassword;
    }

    public void setRepeatedPassword(String repeatedPassword) {
        this.repeatedPassword = repeatedPassword;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SensitiveUserData that = (SensitiveUserData) o;
        return oldPassword.equals(that.oldPassword) &&
                newPassword.equals(that.newPassword) &&
                repeatedPassword.equals(that.repeatedPassword);
    }

    @Override
    public int hashCode() {
        return Objects.hash(oldPassword, newPassword, repeatedPassword);
    }

    @Override
    public String toString() {
        return "SensitiveUserData{" +
                "oldPassword='" + oldPassword + '\'' +
                ", newPassword='" + newPassword + '\'' +
                ", repeatedPassword='" + repeatedPassword + '\'' +
                '}';
    }
}
