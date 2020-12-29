package com.example.springjwt.repo;

import com.example.springjwt.entity.Auth;
import com.example.springjwt.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface LoginRepository  extends JpaRepository<Auth,Long>, JpaSpecificationExecutor<Auth> {
}
