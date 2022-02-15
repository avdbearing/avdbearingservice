package com.avdbearing.repositories;

import com.avdbearing.domain.core.Brand;
import com.avdbearing.domain.core.Part;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartRepository extends JpaRepository<Part, Long> {

    Part findByBrandAndArticle(Brand brand, String article);




}
