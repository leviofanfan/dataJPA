package com.miki.dataBaseJPA.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.miki.dataBaseJPA.entity.Teacher;

@Repository
public interface TeacherRepository extends JpaRepository< Teacher, Long>{

}
