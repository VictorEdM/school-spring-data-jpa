package com.example.coursesspringdatajpa.guardian;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@EqualsAndHashCode
@AllArgsConstructor

@Embeddable
public class Guardian {

    @Column(name = "name", nullable = false, length = 100)
    private String name;
    @Column(name = "email", nullable = false, length = 125)
    private String email;
    @Column(name = "phone", nullable = false, length = 8)
    private String phone;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("[ Name: <").append(name).append(">, ");
        sb.append("Email: <").append(email).append(">, ");
        sb.append("Phone: <").append(phone).append(">");
        sb.append(']');
        return sb.toString();
    }
}
