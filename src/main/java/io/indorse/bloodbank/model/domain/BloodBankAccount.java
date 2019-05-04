package io.indorse.bloodbank.model.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "blood_bank_account")
public class BloodBankAccount implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Long id;

    @Column(name = "uuid", nullable = false)
    private @NotNull String uuid;

    @Column(name = "firstName", nullable = false)
    private @NotNull String firstName;

    @Column(name = "middleName", nullable = false)
    private @NotNull String middleName;

    @Column(name = "lastName", nullable = false)
    private @NotNull String lastName;

    @Column(name = "email", nullable = false)
    private @NotNull String email;

    @Temporal(TemporalType.DATE)
    private Date birthDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender", nullable = false)
    private Gender gender;

    @Enumerated(EnumType.STRING)
    @Column(name = "bloodGroup", nullable = false)
    private BloodGroup bloodGroup;

    @Embedded
    private Address address;

    @OneToMany(mappedBy="account")
    private Collection<AccountTransaction> transactions;

}