package com.vsc.springescarshop.data.repositories;

import com.vsc.springescarshop.data.models.Brand;
import com.vsc.springescarshop.data.models.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface BrandRepository extends JpaRepository<Brand, String> {
    @Query("Select m from Model as m where m.id = :id")
    Model findByModelById (Long id);
}
