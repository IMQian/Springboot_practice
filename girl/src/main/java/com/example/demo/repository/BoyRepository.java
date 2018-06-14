package com.example.demo.repository;

import com.example.demo.domain.Boy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BoyRepository extends JpaRepository<Boy,Integer> {
    //通过年龄来查询

    //public Boy findById(Integer id);

    public List<Boy> findByAge(Integer age);
    public List<Boy> findByName(String name);
}
