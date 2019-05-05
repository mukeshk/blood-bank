package io.indorse.bloodbank.model.dto;

import io.indorse.bloodbank.model.domain.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class BloodBankBranchDTO {

    private String uuid;
    private String branchName;
    private String manager;
    private String contactNumber;
    private String contactEmail;
    private AddressDTO address;

}
