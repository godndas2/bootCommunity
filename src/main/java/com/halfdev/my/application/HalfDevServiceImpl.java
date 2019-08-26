package com.halfdev.my.application;

import com.halfdev.my.domain.mapper.UserConnectionMapper;
import com.halfdev.my.domain.mapper.UserMapper;
import com.halfdev.my.domain.mapper.UserRoleMapper;
import com.halfdev.my.domain.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class HalfDevServiceImpl implements HalfDevService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Autowired
    private UserConnectionMapper userConnectionMapper;

    @Override
    public User save(User user) {
        user.setPassword(PasswordEncoderFactories.createDelegatingPasswordEncoder().encode(user.getPassword()));
        user.setStatus(UserStatus.ON);
        user.setRegDate(LocalDateTime.now());
        userMapper.save(user);
        user.getRoles().stream().forEach(role -> userRoleMapper.save(new UserRole(user.getId(), role.getType().getValue())));
        return user;
    }

    @Override
    @Transactional
    public User signUp(UserConnection userConnection) {
        User user = new User();
        user.setEmail(userConnection.getEmail());
        user.setNickname(userConnection.getDisplayName());
        user.setPassword(userConnection.getEmail());
        user.setStatus(UserStatus.ON);
        user.setRegDate(LocalDateTime.now());
        user.setRoles(List.of(new Role(1, RoleType.USER)));
        user.setConnection(userConnection);
        save(user);
        userConnectionMapper.save(userConnection);
        return user;
    }

    @Override
    public User update(User user) {
        return user;
    }

    @Override
    public User findByEmail(String email) {
        return userMapper.findByEmail(email);
    }
}
