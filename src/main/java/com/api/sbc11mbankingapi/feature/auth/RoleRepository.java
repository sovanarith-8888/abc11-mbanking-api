package com.api.sbc11mbankingapi.feature.auth;

import com.api.sbc11mbankingapi.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}
