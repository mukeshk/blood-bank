package io.indorse.bloodbank.accounttransaction.mapper;

import io.indorse.bloodbank.model.domain.AccountTransaction;
import io.indorse.bloodbank.model.dto.AccountTransactionDTO;
import io.indorse.bloodbank.model.dto.AccountTransactionListDTO;

public class AccountTransactionMapper {
    public static AccountTransaction mapNewInstance(AccountTransactionDTO accountTransactionDTO){
        AccountTransaction transaction = new AccountTransaction();
        transaction.setBloodGroup(accountTransactionDTO.getBloodGroup());
        transaction.setTransactionDate(accountTransactionDTO.getTransactionDate());
        transaction.setType(accountTransactionDTO.getTransactionType());
        return transaction;
    }

    public static AccountTransactionListDTO map(AccountTransaction accountTransaction){
        AccountTransactionListDTO transactionDTO = new AccountTransactionListDTO();
        transactionDTO.setBloodGroup(accountTransaction.getBloodGroup());
        transactionDTO.setTransactionDate(accountTransaction.getTransactionDate());
        transactionDTO.setTransactionType(accountTransaction.getType());
        transactionDTO.setUuid(accountTransaction.getUuid());
        return transactionDTO;
    }
}
