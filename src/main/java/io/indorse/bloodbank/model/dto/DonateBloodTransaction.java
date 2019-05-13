package io.indorse.bloodbank.model.dto;

import io.indorse.bloodbank.model.domain.BloodGroup;
import io.indorse.bloodbank.model.domain.TransactionType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;
import java.util.Date;

@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class DonateBloodTransaction {

    @NotEmpty(message="branch id should be present")
    @Length
    private String branchUUID;

    @NotEmpty(message="account id should be present")
    @Length
    private String accountUUID;

    @NotNull(message = "transaction date should be present")
    private Date transactionDate;

    @NotNull(message = "blood group should be present")
    private BloodGroup bloodGroup;

    @NotNull(message = "quantity should be present")
    @Min(value = 350, message = "quantity should be greater then 350ml")
    @Max(value = 450, message = "quantity should be less then 450ml")
    private int quantity;
}
