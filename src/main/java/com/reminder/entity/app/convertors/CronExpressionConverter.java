package com.reminder.entity.app.convertors;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import org.quartz.CronExpression;

import java.text.ParseException;

@Converter(autoApply = true)
public class CronExpressionConverter implements AttributeConverter<CronExpression, String> {

    @Override
    public String convertToDatabaseColumn(CronExpression cronExpression) {
        return (cronExpression != null) ? cronExpression.getCronExpression() : null;
    }

    @Override
    public CronExpression convertToEntityAttribute(String cronExpression) {
        try {
            return (cronExpression != null) ? new CronExpression(cronExpression) : null;
        } catch (ParseException e) {
            throw new IllegalArgumentException("Invalid cron expression: " + cronExpression, e);
        }
    }
}
