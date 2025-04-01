package com.reminder.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "prompts")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserPrompt extends CommonAuditor{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String userId;

    @Column
    private String prompt;
}
