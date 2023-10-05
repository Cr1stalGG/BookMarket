package by.grsu.bookMarket.entity;

import by.grsu.bookMarket.entity.enumirations.RoleConstant;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Transient;
import lombok.*;

import java.util.List;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class Role extends BaseEntity<Integer> {
    @Builder.Default
    private RoleConstant role = RoleConstant.ROLE_USER;
    @Transient
    @ManyToMany(mappedBy = "roles", cascade= CascadeType.ALL)
    private List<Account> accounts;
}
