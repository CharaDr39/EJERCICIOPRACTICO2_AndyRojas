package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Set;

import com.dao.RoleDao;
import com.dao.UsuarioDao;
import com.domain.Role;
import com.domain.Usuario;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    CommandLineRunner initData(UsuarioDao usuarioDao,
                               RoleDao roleDao,
                               PasswordEncoder encoder) {
        return args -> {
            // Crear roles
            Role adminRole = roleDao.save(new Role(null, "ROLE_ADMIN"));
            Role userRole  = roleDao.save(new Role(null, "ROLE_USER"));

            // Usuario administrador
            if (usuarioDao.findByUsername("admin") == null) {
                Usuario admin = new Usuario();
                admin.setUsername("admin");
                admin.setPassword(encoder.encode("admin123"));
                admin.setEnabled(true);
                admin.setRoles(Set.of(adminRole));
                usuarioDao.save(admin);
            }

            // Usuario normal
            if (usuarioDao.findByUsername("user") == null) {
                Usuario user = new Usuario();
                user.setUsername("user");
                user.setPassword(encoder.encode("user123"));
                user.setEnabled(true);
                user.setRoles(Set.of(userRole));
                usuarioDao.save(user);
            }
        };
    }
}
