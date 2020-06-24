package com.svc.exampreparation.date.reposiroties;

import com.svc.exampreparation.date.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, String> {
}
