package com.resicomplex.accesscontrol.repository;

import com.resicomplex.accesscontrol.model.VisitorPreauthorization;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VisitorPreauthorizationRepository extends JpaRepository<VisitorPreauthorization, String> {

    List<VisitorPreauthorization> findByStatus(String status);

    List<VisitorPreauthorization> findByUnitIdAndStatus(String unitId, String status);
}
