package org.example.create_token.repository.jpa;

import org.example.create_token.entity.UserBase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository("jpaUserRepo")
public interface UserRepos extends JpaRepository<UserBase, UUID> {
    // create query requests
}
