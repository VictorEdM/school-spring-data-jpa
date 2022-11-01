package com.example.coursesspringdatajpa.guardian;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@EqualsAndHashCode
@AllArgsConstructor

@Embeddable
public class Guardian {

    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;
    @Column(name = "phone")
    private String phone;

}
