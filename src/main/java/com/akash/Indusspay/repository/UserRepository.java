package com.akash.Indusspay.repository;

import com.akash.Indusspay.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    public User findByEmail(String email);
    public User findByPhone(String phone);


}
