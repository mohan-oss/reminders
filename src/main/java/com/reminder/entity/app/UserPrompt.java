package com.reminder.entity.app;

import com.reminder.utils.AppUtils;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "prompts")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserPrompt extends CommonAuditor{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "user_id")
    private String userId;
    @PrePersist
    public void generateId() {
        if (userId == null) {
            this.userId = AppUtils.getCurrentUserId();
        }
    }

    @Column
    private String prompt;

    @OneToMany()
    @JoinColumn(name = "user_prompt_id")
    private List<UserTailor> userTailors;

    @OneToMany()
    @JoinColumn(name = "common_prompt_id")
    private List<CommonPromptTailors> commonTailors;

}
