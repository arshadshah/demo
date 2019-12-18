package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer addressId;

    @Column
    String address;

    @ManyToMany
    Set<Area> areas;
}
