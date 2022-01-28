package pl.saqie.SimpleBank.app.component.user.usecase.changepassword;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ChangePasswordDto {

    @NotEmpty(message = "Stare hasło nie może pozostać puste")
    private String oldPassword;
    @Size(min = 5, message = "Nowe hasło musi zawierać co najmniej 5 znaków")
    private String newPassword;

}
