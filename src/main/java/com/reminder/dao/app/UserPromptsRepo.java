package com.reminder.dao.app;

import com.reminder.entity.app.UserPrompt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserPromptsRepo extends JpaRepository<UserPrompt, Integer> {

    @Query("SELECT u.prompt FROM UserPrompt u WHERE u.userId = :userId")
    List<String> findPromptsByUserId(@Param("userId") String userId);

}
