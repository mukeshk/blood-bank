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

    private String uuid;

    @NotEmpty
    @Length(message = "branch name length between 5 and 250")
    private String branchName;

    @NotEmpty
    @Length(message = "manager name length between 5 and 150")
    private String manager;

    @NotEmpty
    @Length(message = "contact number length between 5 and 15")
    private String contactNumber;

    @NotEmpty
    @Length(message = "contact email length between 5 and 150")
    private String contactEmail;

    @NotNull
    private AddressDTO address;

}
