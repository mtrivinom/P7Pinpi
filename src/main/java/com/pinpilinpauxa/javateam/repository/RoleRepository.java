package com.pinpilinpauxa.javateam.repository;

import com.pinpilinpauxa.javateam.model.Admin;
import com.pinpilinpauxa.javateam.model.Privilege;
import com.pinpilinpauxa.javateam.model.User;
import org.springframework.context.annotation.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface RoleRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u WHERE u.email = ?1")
    public static Admin findByEmail(String email) {
        return null;

    }

    static Role findByName(String name) {
        return null;
    }
}



