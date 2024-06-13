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
@Table(name="User_bank_tbl")
public class UserBank {


//    @OneToOne(fetch=FetchType.LAZY,mappedBy = "userBank")
//    User user;

    Integer userId;
    String bankName;
    String bankIfsc;
    @Id
    String accountNumber;

}
