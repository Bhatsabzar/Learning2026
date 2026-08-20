package com.Learning2026.Repository;

import com.Learning2026.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {


    User getById(long id);
    List<User> findByAddress(String address);

    boolean  existsByName(String name);

}
