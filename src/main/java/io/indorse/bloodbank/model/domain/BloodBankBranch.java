package io.indorse.bloodbank.model.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Collection;

@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "blood_bank_branch")
public class BloodBankBranch {

    @Id
    @Column(name = "id" , nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="branchName", nullable = false, length = 255)
    private @NotNull String branchName;

    @Column(name="uuid",nullable = false,length = 100)
    private @NotNull String uuid;

    @Column(name = "manager",nullable = false,length = 150)
    private @NotNull String manager;

    @Column(name="contactNumber",nullable = false,length = 25)
    private @NotNull String contactNumber;

    @Column(name = "contactEmail",nullable = false,length = 100)
    private @NotNull  String contactEmail;

    @Embedded
    private Address address;

    @OneToMany(targetEntity=AccountTransaction.class, mappedBy="branch")
    private Collection<AccountTransaction> transactions;

}
