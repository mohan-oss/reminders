package com.reminder.dao.app;

import com.reminder.entity.app.CommonPromptTailors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommonPromptTailorsRepo extends JpaRepository<CommonPromptTailors, Long> {

}
