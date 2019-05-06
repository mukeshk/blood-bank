package io.indorse.bloodbank.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;

@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class AddressDTO {
    @NotEmpty
    @Length(message = "address line should be between 10 and 150")
    private String addressLine1;

    @Length(message = "address line should be between 10 and 150")
    private String addressLine2;

    @Length(message = "address line should be between 10 and 150")
    @NotEmpty
    private String city;

    @Length(message = "address line should be between 10 and 150")
    @NotEmpty
    private String state;

    @Length(message = "address line should be between 4 and 10")
    @NotEmpty
    private String zipCode;
}
