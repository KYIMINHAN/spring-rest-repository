package com.kyiminhan.mm.spring.repo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.kyiminhan.mm.spring.entity.User;

/**
 * The Interface UserRepository.</BR>
 *
 * @author KYIMINHAN </BR>
 * @version 1.0 </BR>
 * @since 2019/04/11 </BR>
 *        spring-rest-crud-demo system </BR>
 *        com.kyiminhan.mm.spring.repo </BR>
 *        UserRepository.java </BR>
 */
@Repository
@Qualifier(value = "userRepository")
public interface UserRepository extends BaseRepository<User> {

}