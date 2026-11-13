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
@Table(name = "visits")
@Getter
@Setter
@NoArgsConstructor
public class Visit {

    @Id
    @Column(name = "id", length = 36)
    private String id;

    @Column(name = "visitor_name", nullable = false, length = 150)
    private String visitorName;

    @Column(name = "document_number", nullable = false, length = 50)
    private String documentNumber;

    @Column(name = "destination_unit_id", nullable = false, length = 36)
    private String destinationUnitId;

    @Column(name = "visit_type", nullable = false, length = 30)
    private String visitType;

    @Column(name = "vehicle_plate", length = 20)
    private String vehiclePlate;

    @Column(name = "vehicle_type", length = 20)
    private String vehicleType;

    @Column(name = "entry_time", nullable = false)
    private LocalDateTime entryTime;

    @Column(name = "exit_time")
    private LocalDateTime exitTime;

    @Column(name = "guard_user_id", length = 36)
    private String guardUserId;

    @Column(name = "status", nullable = false, length = 20)
    private String status;
}
