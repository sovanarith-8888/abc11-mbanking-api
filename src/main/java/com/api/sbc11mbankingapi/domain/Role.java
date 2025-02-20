package com.api.sbc11mbankingapi.domain;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import java.util.List;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "roles")
public class Role implements GrantedAuthority {
    @Override
    public String getAuthority() {
        return "ROLE_" + name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @ManyToMany(mappedBy = "roles")
    private List<User> users;
}
