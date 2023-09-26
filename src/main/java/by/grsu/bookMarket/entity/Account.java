package by.grsu.bookMarket.entity;


import by.grsu.bookMarket.entity.enumirations.RoleConstant;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Data
public class Account extends BaseEntity<Long> implements UserDetails {
    private String mail;
    private String password;
    private double cash;
    @OneToMany
    private List<BoughtBook> boughtBooks;
    private RoleConstant role;

    public void buyBook(double price, BoughtBook book){
        this.cash -= price;
        this.boughtBooks.add(book);
    }

    public void addAmount(double amount) {
        this.cash += amount;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(this.role.name()));
    }

    @Override
    public String getUsername() {
        return this.mail;
    }

    @Override
    public String getPassword(){
        return this.password;
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
