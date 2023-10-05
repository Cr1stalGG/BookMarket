package by.grsu.bookMarket.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
public abstract class BaseEntity <T extends Number>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private T id;
}
