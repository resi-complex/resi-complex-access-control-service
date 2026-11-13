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
@Table(name = "correspondence")
@Getter
@Setter
@NoArgsConstructor
public class Correspondence {

    @Id
    @Column(name = "id", length = 36)
    private String id;

    @Column(name = "unit_id", nullable = false, length = 36)
    private String unitId;

    @Column(name = "recipient_name", nullable = false, length = 150)
    private String recipientName;

    @Column(name = "package_type", nullable = false, length = 50)
    private String packageType;

    @Column(name = "tracking_or_courier", length = 100)
    private String trackingOrCourier;

    @Column(name = "status", nullable = false, length = 20)
    private String status;

    @Column(name = "received_at", nullable = false)
    private LocalDateTime receivedAt;

    @Column(name = "delivered_at")
    private LocalDateTime deliveredAt;
}
