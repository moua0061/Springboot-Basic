package com.springbootbasics.store.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "profiles")
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "bio")
    private String bio;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "date_of_birth")
    private String dateOfBirth;

    @Column(name = "loyalty_points")
    private int loyaltyPoints;

    @OneToOne
    @JoinColumn(name = "id")
    @MapsId //hibernate will use this as both PK & FK
    @ToString.Exclude
    private User user;
}
