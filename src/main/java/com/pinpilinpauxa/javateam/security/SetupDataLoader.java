package com.pinpilinpauxa.javateam.security;

import com.pinpilinpauxa.javateam.model.Privilege;
import com.pinpilinpauxa.javateam.model.Admin;
import com.pinpilinpauxa.javateam.repository.PrivilegeRepository;
import com.pinpilinpauxa.javateam.repository.RoleRepository;
import com.pinpilinpauxa.javateam.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Role;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

@Component
public class SetupDataLoader implements
        ApplicationListener<ContextRefreshedEvent> {

    boolean alreadySetup = false;

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PrivilegeRepository privilegeRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    private Object email;

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {

        if (alreadySetup)
            return;
        Privilege readPrivilege
                = createPrivilegeIfNotFound("READ_PRIVILEGE");
        Privilege writePrivilege
                = createPrivilegeIfNotFound("WRITE_PRIVILEGE");

        List<Privilege> adminPrivileges = Arrays.asList(
                readPrivilege, writePrivilege);
        createRoleIfNotFound("ROLE_ADMIN", adminPrivileges);
        createRoleIfNotFound("ROLE_USER", Arrays.asList(readPrivilege));
        
        Role adminRole = RoleRepository.findByName("ROLE_ADMIN");
        Admin user = new Admin();
        user.setId(1L);
        user.setEmail("admin1@gmail.com");
        user.setPassword(passwordEncoder.encode("12345678"));
        user.setNombre("administrador1");
        user.setUsuario("administrador1");
        user.setRoles(Arrays.asList(adminRole));
        user.setEnabled(true);
        AdminRepository.save(user);

        alreadySetup = true;
    }

    @Transactional
    Privilege createPrivilegeIfNotFound(String name) {

        Privilege privilege = PrivilegeRepository.findByName(name);
        if (privilege == null) {
            privilege = new Privilege();
        }
        return privilege;
    }

    @Transactional
    Role createRoleIfNotFound(
            String name, List<Privilege> privileges) {

        Role role = RoleRepository.findByName(name);
        if (role == null) {
        }
        return role;
    }
}
