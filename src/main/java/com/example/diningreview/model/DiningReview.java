package com.example.diningreview.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "DINING_REVIEWS")
@NoArgsConstructor
@AllArgsConstructor
public class DiningReview {
    @Id
    @GeneratedValue
    @Getter
    @Setter
    private long id;

    @Column
    @Getter
    @Setter
    private String submitterName;

    @Column
    @Getter
    @Setter
    private long restaurantId;

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
    private String commentary;

    @Column
    @Getter
    @Setter
    private Status status;
}
