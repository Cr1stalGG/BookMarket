package by.grsu.bookMarket.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
public class Account extends BaseEntity<Long> {
    private String mail;
    private String password;
    private double cash;
    @OneToMany
    private List<BoughtBook> boughtBooks;
    @ManyToMany(fetch = FetchType.EAGER, cascade= CascadeType.ALL)
    private List<Role> roles;

}
