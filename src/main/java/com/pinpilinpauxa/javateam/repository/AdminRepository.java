package com.pinpilinpauxa.javateam.repository;

import com.pinpilinpauxa.javateam.model.Admin;
import com.pinpilinpauxa.javateam.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface AdminRepository extends JpaRepository<User, Long> {
    static void save(Admin user) {
    }

    @Query("SELECT u FROM User u WHERE u.email = ?1")
    public static Admin findByEmail(String email);
}