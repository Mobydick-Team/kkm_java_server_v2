package com.kkm.kkm_server_v2.domian.category.entity.repository;

import com.kkm.kkm_server_v2.domian.category.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
