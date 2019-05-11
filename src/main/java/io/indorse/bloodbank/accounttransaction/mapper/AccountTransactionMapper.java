package io.indorse.bloodbank.accounttransaction.mapper;

import io.indorse.bloodbank.model.domain.AccountTransaction;
import io.indorse.bloodbank.model.domain.TransactionType;
import io.indorse.bloodbank.model.dto.DonateBloodTransaction;
import io.indorse.bloodbank.model.dto.AccountTransactionListDTO;

public class AccountTransactionMapper {
    public static AccountTransaction mapNewDonationInstance(DonateBloodTransaction accountTransactionDTO){
        AccountTransaction transaction = new AccountTransaction();
        transaction.setBloodGroup(accountTransactionDTO.getBloodGroup());
        transaction.setTransactionDate(accountTransactionDTO.getTransactionDate());
        transaction.setType(TransactionType.DEPOSIT);
        transaction.setQuantity(accountTransactionDTO.getQuantity());
        transaction.setSafe(null);
        return transaction;
    }

    public static AccountTransactionListDTO map(AccountTransaction accountTransaction){
        AccountTransactionListDTO transactionDTO = new AccountTransactionListDTO();
        transactionDTO.setBloodGroup(accountTransaction.getBloodGroup());
        transactionDTO.setTransactionDate(accountTransaction.getTransactionDate());
        transactionDTO.setTransactionType(accountTransaction.getType());
        transactionDTO.setUuid(accountTransaction.getUuid());
        transactionDTO.setQuantity(accountTransaction.getQuantity());
        transactionDTO.setSafe(accountTransaction.getSafe());
        return transactionDTO;
    }
}
