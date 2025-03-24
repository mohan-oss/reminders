package com.reminder.dto;

import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.quartz.CronExpression;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Slf4j
public class SaveRemainderDto {
    private String userId;
    private String content;
    @NonNull
    private String cronExpression;


    public CronExpression toCronExpression() {
        try{
            log.info(cronExpression);
            return new CronExpression(cronExpression);
        }
        catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
