package com.vsc.springescarshop.data.repositories;

import com.vsc.springescarshop.data.models.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModelRepository extends JpaRepository<Model, String> {
}
