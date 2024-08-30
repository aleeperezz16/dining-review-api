package com.example.diningreview.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "USERS")
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue
    @Getter
    @Setter
    private long id;

    @Column(unique = true)
    @Getter
    @Setter
    private String displayName;

    @Column
    @Getter
    @Setter
    private String city;

    @Column
    @Getter
    @Setter
    private String state;

    @Column
    @Getter
    @Setter
    private String zipcode;

    @Column
    @Getter
    @Setter
    private boolean peanutAllergies;

    @Column
    @Getter
    @Setter
    private boolean eggAllergies;

    @Column
    @Getter
    @Setter
    private boolean dairyAllergies;
}
