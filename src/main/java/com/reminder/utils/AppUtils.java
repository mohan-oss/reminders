package com.reminder.utils;

import com.reminder.component.UserPrinciple;
import org.springframework.security.core.context.SecurityContextHolder;

public class AppUtils {

    public static UserPrinciple getUserPrinciple(){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(principal instanceof UserPrinciple){
            return (UserPrinciple) principal;
        }
        else{
            throw new NullPointerException("User principle not found in Security Context");
        }
    }
}
