package io.indorse.bloodbank.accounttransaction.mapper;

import io.indorse.bloodbank.model.domain.AccountTransaction;
import io.indorse.bloodbank.model.domain.TransactionType;
import io.indorse.bloodbank.model.dto.DonateBloodTransaction;
import io.indorse.bloodbank.model.dto.AccountTransactionListDTO;

public class AccountTransactionMapper {
    /**
     * Map Donate request to transaction entity
     * @param accountTransactionDTO Holds the donation request model
     * @return account entity instance
     */
    public static AccountTransaction mapNewDonationInstance(DonateBloodTransaction accountTransactionDTO){
        AccountTransaction transaction = new AccountTransaction();
        transaction.setBloodGroup(accountTransactionDTO.getBloodGroup());
        transaction.setTransactionDate(accountTransactionDTO.getTransactionDate());
        transaction.setType(TransactionType.DEPOSIT);
        transaction.setQuantity(accountTransactionDTO.getQuantity());
        transaction.setSafe(null);
        return transaction;
    }

    /**
     * Map account transaction to List model
     * @param accountTransaction Holds the transaction instance
     * @return Holds the account transaction list model.
     */
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
