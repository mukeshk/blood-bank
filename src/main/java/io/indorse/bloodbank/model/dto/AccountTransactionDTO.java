package io.indorse.bloodbank.model.dto;

import io.indorse.bloodbank.model.domain.BloodGroup;
import io.indorse.bloodbank.model.domain.TransactionType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Future;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class AccountTransactionDTO {
    private String uuid;

    @NotEmpty(message="branch id should be present")
    @Length
    private String branchUUID;

    @NotEmpty(message="account id should be present")
    @Length
    private String accountUUID;

    @FutureOrPresent
    @NotNull(message = "transaction date should be present")
    private Date transactionDate;

    @NotNull(message = "transaction type should be present")
    private TransactionType transactionType;

    @NotNull(message = "blood group should be present")
    private BloodGroup bloodGroup;

}
