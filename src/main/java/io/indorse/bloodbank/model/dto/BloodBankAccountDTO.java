package io.indorse.bloodbank.model.dto;

import io.indorse.bloodbank.model.domain.BloodGroup;
import io.indorse.bloodbank.model.domain.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.util.Date;

@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class BloodBankAccountDTO {

    private String uuid;

    @NotEmpty(message = "first name must not be empty")
    @Length(min = 3,max = 150,message = "first name should be between 3 to 150 in length")
    private String firstName;

    @Length(min = 3,max = 150,message = "middle name should be between 3 to 150 in length")
    private String middleName;

    @NotEmpty(message = "last name must not be empty")
    @Length(min = 3,max = 150,message = "last name should be between 3 to 150 in length")
    private String lastName;

    @NotEmpty(message = "email must not be empty")
    @Email(message = "email should be a valid email")
    @Length(min = 6,max = 150,message = "email should be between 6 to 150 in length")
    private String email;

    @NotNull(message = "gender must not be empty")
    private Gender gender;

    @NotNull(message = "blood group must not be empty")
    private BloodGroup bloodGroup;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @NotNull(message = "birth date must not be empty")
    @Past(message = "birth date should be in the past")
    private Date birthDate;

    @NotNull(message = "address must not be empty")
    private AddressDTO address;

}
