package com.resicomplex.accesscontrol.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "visitor_preauthorizations")
@Getter
@Setter
@NoArgsConstructor
public class VisitorPreauthorization {

    @Id
    @Column(name = "id", length = 36)
    private String id;

    @Column(name = "unit_id", nullable = false, length = 36)
    private String unitId;

    @Column(name = "visitor_name", nullable = false, length = 150)
    private String visitorName;

    @Column(name = "document_number", nullable = false, length = 50)
    private String documentNumber;

    @Column(name = "authorized_by", nullable = false, length = 36)
    private String authorizedBy;

    @Column(name = "valid_from", nullable = false)
    private LocalDateTime validFrom;

    @Column(name = "valid_until", nullable = false)
    private LocalDateTime validUntil;

    @Column(name = "status", nullable = false, length = 20)
    private String status;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;
}
