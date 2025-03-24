package com.reminder.service;

import com.reminder.dao.ReminderRepository;
import com.reminder.dto.GetRemaindersRequestDto;
import com.reminder.dto.SaveRemainderDto;
import com.reminder.entity.Reminder;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class RemainderService {
    private ReminderRepository reminderRepository;
    public void saveRemainder(SaveRemainderDto remainderDto){
        Reminder remainder = Reminder.builder()
                .userId(remainderDto.getUserId())
                .content(remainderDto.getContent())
                .remindAt(remainderDto.toCronExpression())
                .build();
        log.info(remainder.toString());
        reminderRepository.save(remainder);
    }

    public Page<Reminder> getRemainders(GetRemaindersRequestDto dto) {
        Page<Reminder> byUserId = reminderRepository.findByUserId(dto.getUserId(),
                PageRequest.of(dto.getPageNumber(), dto.getPageSize(), Sort.by(Sort.Direction.DESC, "createdAt")));
        return byUserId;
    }
}
