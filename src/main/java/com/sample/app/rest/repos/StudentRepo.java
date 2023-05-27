package com.sample.app.rest.repos;

import com.sample.app.rest.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository <Student, Long> {
}
