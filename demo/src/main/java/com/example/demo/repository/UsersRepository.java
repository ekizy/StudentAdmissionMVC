package com.example.demo.repository;


import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.example.demo.model.Users;

import java.util.List;

public interface UsersRepository extends ElasticsearchRepository<Users, Long> {
    List<Users> findByName(String text);

    List<Users> findBySalary(Long salary);
}
