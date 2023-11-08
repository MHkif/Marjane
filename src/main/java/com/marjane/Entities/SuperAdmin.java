package com.marjane.Entities;

import com.marjane.Entities.Abstracts.Person;
import jakarta.persistence.*;
import lombok.*;


@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "superAdmin")
public class SuperAdmin extends Person {

    @Id
    @Column(name = "CIN", length = 255)
    private String cin;

}