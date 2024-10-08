package com.example.diningreview.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class Restaurant {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String zipcode;

    private Double peanutScore;
    private Double eggScore;
    private Double dairyScore;
    private Double overallScore;
}
