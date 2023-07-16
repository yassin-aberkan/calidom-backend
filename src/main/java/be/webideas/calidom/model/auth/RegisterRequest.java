package be.webideas.calidom.model.auth;

import be.webideas.calidom.model.GenderType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private LocalDate dateBirth;
    private GenderType gender;
}