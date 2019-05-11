package io.indorse.bloodbank.model.dto;

import io.indorse.bloodbank.model.domain.BloodGroup;
import io.indorse.bloodbank.model.domain.TransactionType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class AccountTransactionListDTO {

    private String uuid;
    private Date transactionDate;
    private TransactionType transactionType;
    private BloodGroup bloodGroup;
    private float quantity;
    private Boolean safe;
}
