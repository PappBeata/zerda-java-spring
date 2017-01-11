package com.greenfox.exams.spring.Repository;

import com.greenfox.exams.spring.Entity.Experience;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExperienceRepo extends CrudRepository<Experience, Long> {
}