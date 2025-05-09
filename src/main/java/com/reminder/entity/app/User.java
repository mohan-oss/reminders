package com.reminder.entity.app;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "users")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User{

    @Id
    @Column(nullable = false)
    private String id;

    @PrePersist
    public void generateId() {
        if (id == null) {
            this.id = UUID.randomUUID().toString();
        }
    }

    @Column(name = "user_name")
    private String userName;

    @Column(name = "password")
    private String password;

    @Column
    private List<String> roles;

    @Column(nullable = false, name = "is_active")
    private Boolean isActive = true;

    @Column(nullable = false, name = "account_locked")
    private Boolean accountLocked = false;
}
