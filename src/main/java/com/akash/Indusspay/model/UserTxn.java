package com.akash.Indusspay.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name="User_txn_tbl")
public class UserTxn {



    Integer userId;
    Integer txnId;
    @Column(name="service_")
    String service;
    @Column(name="amount_")
    Integer amount;
    Double gst;
    Integer commission;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    int id_;
    @ManyToOne(cascade = CascadeType.ALL)
            @JoinColumn(referencedColumnName="userId")
            @JsonIgnore
    User user;
}
