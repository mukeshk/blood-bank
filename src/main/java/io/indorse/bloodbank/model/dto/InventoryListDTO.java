package io.indorse.bloodbank.model.dto;

import io.indorse.bloodbank.model.domain.BloodGroup;
import io.indorse.bloodbank.model.domain.InventoryType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class InventoryListDTO {
    private String uuid;
    private Date expiryDate;
    private float quantity;
    private BloodGroup bloodGroup;
    private InventoryType inventoryType;
    private String branchName;
    private String branchContactName;
    private String branchContactEmail;
    private String branchContactNumber;
    private String branchAddress;
}
