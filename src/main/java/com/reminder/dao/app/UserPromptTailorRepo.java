package com.reminder.dao.app;

import com.reminder.entity.app.UserTailor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserPromptTailorRepo extends JpaRepository<UserTailor,Long> {

    @Query("SELECT tailor FROM UserTailor ut WHERE ut.userId = :userId")
    List<String> findByUserId(@Param("userId") String userId);
}
