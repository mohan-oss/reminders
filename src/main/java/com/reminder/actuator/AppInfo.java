package com.reminder.actuator;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@Endpoint(id="app")
public class AppInfo {

    @ReadOperation
    public Map<String,Object> getDetails(){
        return Map.of("name","expense-tracker","java",1.8);
    }
}
