package io.indorse.bloodbank.model.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "blood_bank_transaction")
public class AccountTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="uuid",length = 100,unique = true)
    private String uuid;

    @ManyToOne
    @JoinColumn(name="accountId")
    private BloodBankAccount account;

    @ManyToOne
    @JoinColumn(name="branchId")
    private BloodBankBranch branch;

    @Enumerated(EnumType.STRING)
    @Column(name = "bloodGroup", nullable = false)
    private BloodGroup bloodGroup;

    @Enumerated(EnumType.STRING)
    @Column(name = "transactionType",length = 15)
    private TransactionType type;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="transactionDate")
    private Date transactionDate;

    @Column(name = "quantity")
    @NotNull
    private int quantity;

    @Column(name="safe")
    @NotNull
    private Boolean safe;

    @Column(name="processed", nullable = false)
    @NotNull
    private Boolean processed = false;
}
