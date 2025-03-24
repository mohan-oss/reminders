package com.reminder.entity;

import com.reminder.entity.convertors.CronExpressionConverter;
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
