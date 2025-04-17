package com.serviceimplementation;

import org.springframework.security.core.userdetails.*;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.dao.UsuarioDao;
import com.domain.Usuario;
import java.util.stream.Collectors;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired private UsuarioDao repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario u = repo.findByUsername(username);
        if (u==null) throw new UsernameNotFoundException("Usuario no encontrado");
        var authorities = u.getRoles()
            .stream()
            .map(r -> new SimpleGrantedAuthority(r.getName()))
            .collect(Collectors.toList());
        return new User(u.getUsername(), u.getPassword(), u.isEnabled(),
                        true, true, true, authorities);
    }
}
