package com.reminder.entity.app;

import com.reminder.entity.app.convertors.CronExpressionConverter;
import jakarta.persistence.*;
import lombok.*;
import org.quartz.CronExpression;

@Entity
@Table(name = "reminders")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Reminder extends CommonAuditor{
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String userId;

    @Column
    private String content;

    @Column
    @Convert(converter = CronExpressionConverter.class)
    private CronExpression remindAt;

}
