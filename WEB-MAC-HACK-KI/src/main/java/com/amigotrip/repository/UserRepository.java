package com.amigotrip.repository;

import com.amigotrip.domain.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Naver on 2017. 11. 8..
 */
public interface UserRepository extends CrudRepository<User, Long>{
    User findByEmail(String email);
}
