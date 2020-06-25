package com.svc.exampreparation.date.reposiroties;

import com.svc.exampreparation.date.Category;
import com.svc.exampreparation.date.CategoryEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, String> {
//     @Query("select c from Category c where c.name = ?1")
     Optional<Category> findByName(CategoryEnum name);


}
