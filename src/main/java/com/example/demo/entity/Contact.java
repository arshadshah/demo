package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer contactId;

    @Column
    String contact;

    @ManyToOne
    User user;
}
