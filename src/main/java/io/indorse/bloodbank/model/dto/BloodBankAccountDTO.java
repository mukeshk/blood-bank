package io.indorse.bloodbank.model.dto;

import io.indorse.bloodbank.model.domain.BloodGroup;
import io.indorse.bloodbank.model.domain.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class BloodBankAccountDTO {

    private String uuid;
    private String firstName;
    private String middleName;
    private String lastName;
    private String email;
    private Gender gender;
    private BloodGroup bloodGroup;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date birthDate;
    private AddressDTO address;

}
