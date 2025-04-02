package com.reminder.service.user;

import com.reminder.component.UserPrinciple;
import com.reminder.dao.app.UserRepository;
import com.reminder.dto.UserRegistrationDto;
import com.reminder.entity.app.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppUserDetailsService implements UserDetailsService{
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUserName(username);
        if(user.isPresent()){
            return new UserPrinciple(user.get());
        }
        else{
            throw new UsernameNotFoundException("User name - " + username + " not found");
        }
    }

    public ResponseEntity<Object> registerUser(UserRegistrationDto dto){
        User user = User.builder().userName(dto.getUserName())
                .roles(List.of("USER"))
                .isActive(true).password(passwordEncoder.encode(dto.getPassword()))
                .accountLocked(false).build();
        userRepository.save(user);

        return ResponseEntity.noContent().build();
    }
}
