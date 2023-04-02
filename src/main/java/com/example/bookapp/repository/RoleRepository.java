package com.example.bookapp.repository;


import com.example.bookapp.entity.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CrudRepository <Role, Long> {
}
