package io.indorse.bloodbank.model.dto;

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
public class BloodBankBranchListDTO {

    private String uuid;
    private String branchName;
    private String manager;
    private String contactNumber;
    private String contactEmail;
    private AddressDTO address;

}
