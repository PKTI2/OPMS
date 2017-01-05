package pl.opms.be.model;

import lombok.Data;

/**
 * Created by Dawid on 30.12.2016 at 15:56.
 */
@Data
public class PasswordToChange {
    private String actualPassword;
    private String actualPasswordConfirmed;
    private String newPassword;
    private String confirmNewPassword;
}
