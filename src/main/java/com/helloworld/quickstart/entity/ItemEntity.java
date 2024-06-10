package com.helloworld.quickstart.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ITEM")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ItemEntity {

    @Id
    private String id;

    private String name;
}
