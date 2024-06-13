package com.akash.Indusspay.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="User_tbl")
public class User {
    @Id
    Integer userId;
    String firstName;
    String lastName;
    @Column(name="email_")
    String email;
    @Column(name="phone_")
    String phone;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName = "userId")
    UserBank userBank;
    @OneToMany
            (cascade = CascadeType.ALL, mappedBy = "userId")
    List<UserTxn> userTxn;

}
