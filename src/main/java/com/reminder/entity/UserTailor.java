package com.reminder.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "user_tailors")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserTailor {
    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String tailor;

    @Column(name = "user_id", nullable = false)
    private String userId;
}
