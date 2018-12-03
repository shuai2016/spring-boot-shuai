package com.shuai.repository;

import com.shuai.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * UserRepository
 *
 * @author shuai
 * @date 2018/12/3
 */
public interface UserRepository extends JpaRepository<User,Integer> {
}
