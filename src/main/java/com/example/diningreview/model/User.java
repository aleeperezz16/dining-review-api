package com.example.diningreview.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class User {
    @Id
    @GeneratedValue
    private Long id;

    private String displayName;

    private String city;
    private String state;
    private String zipcode;

    private Boolean peanutAllergies;
    private Boolean eggAllergies;
    private Boolean dairyAllergies;
}
