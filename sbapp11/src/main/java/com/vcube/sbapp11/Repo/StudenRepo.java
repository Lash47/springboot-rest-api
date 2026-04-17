package com.vcube.sbapp11.Repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vcube.sbapp11.model.Student12;
@Repository
public interface StudenRepo extends JpaRepository<Student12, Integer> {

	Optional<Student12> findByname(String name);

}
