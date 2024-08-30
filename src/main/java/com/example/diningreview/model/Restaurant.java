package com.example.diningreview.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "RESTAURANTS")
@AllArgsConstructor
@NoArgsConstructor
public class Restaurant {
    @Id
    @GeneratedValue
    @Getter
    @Setter
    private long id;

    @Column
    @Getter
    @Setter
    private String name;

    @Column
    @Getter
    @Setter
    private String zipcode;

    @Column
    @Getter
    @Setter
    private Double peanutScore;

    @Column
    @Getter
    @Setter
    private Double eggScore;

    @Column
    @Getter
    @Setter
    private Double dairyScore;

    @Column
    @Getter
    @Setter
    private Double overallScore;
}
