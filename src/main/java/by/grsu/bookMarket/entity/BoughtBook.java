package by.grsu.bookMarket.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.sql.Date;
import java.util.List;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class BoughtBook extends BaseEntity<Long>{
    private String name;
    private String description;
    @OneToMany
    private List<Author> authors;
    private Date date;
}
