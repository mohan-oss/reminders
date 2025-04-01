package com.reminder.component;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "app.reminders")
@Getter
@Setter
public class ReminderProperties {
    private int delay;
}
