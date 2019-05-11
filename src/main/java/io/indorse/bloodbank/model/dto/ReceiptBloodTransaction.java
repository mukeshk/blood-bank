package io.indorse.bloodbank.model.dto;

import io.indorse.bloodbank.model.domain.BloodGroup;
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
public class ReceiptBloodTransaction {

    @NotEmpty(message="branch id should be present")
    @Length
    private String inventoryUUID;

    @NotEmpty(message="account id should be present")
    @Length
    private String accountUUID;

    @FutureOrPresent
    @NotNull(message = "transaction date should be present")
    private Date transactionDate;

}
