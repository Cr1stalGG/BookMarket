package by.grsu.bookMarket.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

@MappedSuperclass
@Data
public abstract class BaseEntity <T extends Number>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private T id;
}
