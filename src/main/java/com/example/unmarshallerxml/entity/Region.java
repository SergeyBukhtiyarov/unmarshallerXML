package com.example.unmarshallerxml.entity;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Region {
    @JsonAlias("$id")
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int m_Item1;
    private long id;
    private String m_Item2;

}
