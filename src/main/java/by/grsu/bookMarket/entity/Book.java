package by.grsu.bookMarket.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.*;

import java.util.List;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class Book extends BaseEntity<Long>{
    private String name;
    private String description;
    @ManyToMany
    private List<Author> authors;
    private double price;
}
