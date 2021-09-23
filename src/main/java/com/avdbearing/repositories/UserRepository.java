package com.avdbearing.repositories;

import com.avdbearing.domain.User;
import com.avdbearing.domain.core.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);


}
