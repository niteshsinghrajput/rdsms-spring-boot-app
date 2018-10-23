package com.rdsms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.rdsms.entity.User;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
	Optional<User> findByEmail(String email);

    Optional<User> findByUserNameOrEmail(String userName, String email);

    List<User> findByUserIdIn(List<Long> userIds);

    Optional<User> findByUserName(String userName);

    Boolean existsByUserName(String userName);

    Boolean existsByEmail(String email);
}
