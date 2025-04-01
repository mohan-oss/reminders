package com.reminder.dao;

import com.reminder.entity.CommonPromptTailors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommonPromptTailorsRepo extends JpaRepository<CommonPromptTailors, Long> {

}
