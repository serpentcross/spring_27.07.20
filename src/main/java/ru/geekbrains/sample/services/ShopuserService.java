package ru.geekbrains.sample.services;

import lombok.RequiredArgsConstructor;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.stereotype.Service;
import ru.geekbrains.sample.persistence.entities.Shopuser;
import ru.geekbrains.sample.persistence.enums.Role;
import ru.geekbrains.sample.persistence.repositories.ShopuserRepository;

import java.util.ArrayList;
import java.util.Collection;

@Service
@RequiredArgsConstructor
public class ShopuserService implements UserDetailsService {

    private final ShopuserRepository shopUserRepository;

    public Shopuser findByLogin(String login) {
        return shopUserRepository.findByLogin(login);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Shopuser shopUser = findByLogin(username);
        if (shopUser == null) {
            throw new UsernameNotFoundException("Invalid username or password!");
        }
        return new User(shopUser.getLogin(), shopUser.getPassword(), mapRolesToAuthorities(shopUser.getRole()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Role role) {
        return role != null ? new ArrayList<GrantedAuthority>() {{ add((GrantedAuthority) role::name); }} : new ArrayList<>();
    }


}