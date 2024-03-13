package com.jtbank.backend.model;

import com.jtbank.backend.constant.AccountType;
import com.jtbank.backend.model.helper.Auditing;
import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
@Entity //add the curent object value to the data-base, data-base column
@Table(name = "account_table") //to create the tablename
public class Account extends Auditing{
    @Id //create id automatically
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int accountSlNo;
    @Column(unique = true , nullable = false)
    private long accountNumber;
    @Column(name = "account_name" , nullable = false) //to create the column in the table
    private String accountHolderName;
    @Column(nullable = false)
    private String contactNumber;
    @Lob //large object
    private String aboutCustomer;
    @Embedded
    private Credential credential;
    @Enumerated(EnumType.STRING)
    private AccountType accountType;
    private double accountBalance;
//  @Embedded
//  private Auditing auditing;

}
