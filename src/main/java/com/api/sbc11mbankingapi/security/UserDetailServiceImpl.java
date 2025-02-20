package com.api.sbc11mbankingapi.security;


import com.api.sbc11mbankingapi.domain.User;
import com.api.sbc11mbankingapi.feature.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username).orElseThrow(()-> new UsernameNotFoundException(username));
        CustomUserDetail customUserDetail = new CustomUserDetail();
        customUserDetail.setUser(user);
        // return pay-load
        return customUserDetail;
    }
}
