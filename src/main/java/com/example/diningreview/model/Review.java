package com.example.diningreview.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class Review {
    @Id
    @GeneratedValue
    private Long id;

    private String submitterName;

    private Long restaurantId;

    private Double peanutScore;
    private Double eggScore;
    private Double dairyScore;

    private String commentary;

    private Status status;
}
