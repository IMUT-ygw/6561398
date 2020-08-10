package com.imut.dao;

import com.imut.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author nmtl_ygw
 * @Description
 * @date 2020/5/27 8:06
 */
@Repository
public interface UserDao extends JpaRepository<User,Integer> {
}
