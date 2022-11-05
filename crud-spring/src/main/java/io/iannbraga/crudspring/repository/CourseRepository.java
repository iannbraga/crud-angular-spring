package io.iannbraga.crudspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.iannbraga.crudspring.model.CourseModel;

@Repository
public interface CourseRepository extends JpaRepository<CourseModel, Long>{
}
