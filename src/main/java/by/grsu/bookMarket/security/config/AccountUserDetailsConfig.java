package by.grsu.bookMarket.security.config;

import by.grsu.bookMarket.entity.Account;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class AccountUserDetailsConfig implements UserDetails {
    private String mail;
    private String password;
    private List<SimpleGrantedAuthority> authorities;


    public AccountUserDetailsConfig(Account account){
        this.mail = account.getMail();
        this.password = account.getPassword();
        this.authorities = account.getRoles().stream().map(x -> new SimpleGrantedAuthority(x.getRole().toString())).toList();
    }
    
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.mail;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
