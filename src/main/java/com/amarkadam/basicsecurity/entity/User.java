package com.amarkadam.basicsecurity.entity;

import com.amarkadam.basicsecurity.entity.Roles;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String username;
    private String password;


    @OneToMany
    @JoinColumn(name = "user_id")
    Set<Roles> roles;
}
