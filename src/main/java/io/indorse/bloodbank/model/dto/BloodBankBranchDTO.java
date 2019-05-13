package io.indorse.bloodbank.model.dto;

import io.indorse.bloodbank.model.domain.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class BloodBankBranchDTO {

    @NotEmpty(message = "branch name is required")
    @Length(message = "branch name length between 5 and 250")
    private String branchName;

    @NotEmpty(message = "manger name is required")
    @Length(message = "manager name length between 5 and 150")
    private String manager;

    @NotEmpty(message = "contact number is required")
    @Length(message = "contact number length between 5 and 15")
    private String contactNumber;

    @NotEmpty(message = "contact email is required")
    @Length(message = "contact email length between 5 and 150")
    private String contactEmail;

    @NotNull
    private AddressDTO address;

}
