package com.resicomplex.accesscontrol.repository;

import com.resicomplex.accesscontrol.model.Visit;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VisitRepository extends JpaRepository<Visit, String> {

    List<Visit> findByStatus(String status);
}
