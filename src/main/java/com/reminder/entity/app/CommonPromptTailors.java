package com.reminder.entity.app;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "common_tailors")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommonPromptTailors{
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String tailor;

}
