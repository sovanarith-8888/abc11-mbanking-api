package com.api.sbc11mbankingapi.feature.user;

import com.api.sbc11mbankingapi.domain.Role;
import com.api.sbc11mbankingapi.domain.User;
import com.api.sbc11mbankingapi.feature.auth.RoleRepository;
import com.api.sbc11mbankingapi.feature.user.dto.RegisterRequest;
import com.api.sbc11mbankingapi.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.aspectj.apache.bcel.classfile.Module;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void register(RegisterRequest registerRequest) {
        // validate national Card Id
        if(userRepository.isNationalCardIdExisted(registerRequest.nationalCardId())){
            throw new ResponseStatusException(HttpStatus.CONFLICT,"National card Id is already exists");
        }

        // Validate phone number
        if(userRepository.existsByPhoneNumber(registerRequest.phoneNumber())){
            throw new ResponseStatusException(HttpStatus.CONFLICT,"Phone number is already exists");
        }

        // Validate Email
        if(userRepository.existsByEmail(registerRequest.email())){
            throw new ResponseStatusException(HttpStatus.CONFLICT,"Email is already exists");
        }

        // Validate password and confirm password
        if(!registerRequest.password().equals(registerRequest.confirmPassword())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Confirm password is not match");
        }

        // Transfer data from dto to Domain model
        User user = userMapper.fromRegisterRequest(registerRequest);
        user.setUuid(UUID.randomUUID().toString());
        user.setIsAccountNonLocked(true);
        user.setIsAccountNonExpired(true);
        user.setIsCredentialsNonExpired(true);
        user.setIsDeleted(false);
        user.setIsBlocked(false);
        user.setIsVerified(false);
        user.setCreatedAt(LocalDateTime.now());
        user.setProfileImage("user-avatar.png");
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        List<Role> roles = new ArrayList<>();
        roles.add(roleRepository.findById(1).orElseThrow());
        roles.add(roleRepository.findById(2).orElseThrow());
        user.setRoles(roles);

        userRepository.save(user);
    }
}
