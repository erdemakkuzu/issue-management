package com.erdemakkuzu.issuemanagement.service;

import com.erdemakkuzu.issuemanagement.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created by temelt on 4.02.2019.
 */
public interface UserService {

  User save(User user);

  User getById(Long id);

  Page<User> getAllPageable(Pageable pageable);

  User getByUsername(String username);
}
