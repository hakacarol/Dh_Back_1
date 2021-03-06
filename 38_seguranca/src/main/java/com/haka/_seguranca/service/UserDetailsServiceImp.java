package com.haka._seguranca.service;

import com.haka._seguranca.model.Usuario;
import com.haka._seguranca.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserDetailsServiceImp implements UserDetailsService {

    @Autowired
    private UsuarioRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Usuario usuario = repository.findByUserName(username);
        Set<GrantedAuthority> grantList = new HashSet<GrantedAuthority>();

        grantList.add(new SimpleGrantedAuthority("USER"));

        UserDetails user = new User(usuario.getUserName(), ("{noop}" + usuario.getPassword()), grantList);

        return user;
    }
}
