package com.resicomplex.accesscontrol.repository;

import com.resicomplex.accesscontrol.model.Correspondence;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CorrespondenceRepository extends JpaRepository<Correspondence, String> {

    List<Correspondence> findByStatus(String status);

    List<Correspondence> findByUnitIdAndStatus(String unitId, String status);
}
