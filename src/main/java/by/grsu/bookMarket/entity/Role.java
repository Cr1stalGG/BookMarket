package by.grsu.bookMarket.entity;

import by.grsu.bookMarket.entity.enumirations.RoleConstant;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Transient;
import lombok.*;

import java.util.List;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
public class Role extends BaseEntity<Integer> {
    @Builder.Default
    private RoleConstant role = RoleConstant.ROLE_USER;
    @Transient
    @ManyToMany(mappedBy = "roles")
    private List<Account> accounts;
}
