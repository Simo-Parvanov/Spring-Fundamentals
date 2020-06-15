package com.vsc.springescarshop.data.repositories;

import com.vsc.springescarshop.data.models.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand, String> {

}
