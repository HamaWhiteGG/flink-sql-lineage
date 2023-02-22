package com.hw.lineage.server.application.service.impl;

import com.hw.lineage.server.application.assembler.DtoAssembler;
import com.hw.lineage.server.application.service.UserService;
import com.hw.lineage.server.domain.entity.User;
import com.hw.lineage.server.domain.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @description: UserServiceImpl
 * @author: HamaWhite
 * @version: 1.0.0
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserRepository userRepository;

    @Resource
    private DtoAssembler assembler;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.find(username);
        return assembler.fromUser(user);
    }
}
