package com.svc.exampreparation.date.reposiroties;

import com.svc.exampreparation.date.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, String> {

}
