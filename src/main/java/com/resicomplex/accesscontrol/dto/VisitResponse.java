package com.resicomplex.accesscontrol.dto;

import java.time.LocalDateTime;

public record VisitResponse(
        String id,
        String visitorName,
        String documentNumber,
        String destinationUnitId,
        String visitType,
        String vehiclePlate,
        String vehicleType,
        LocalDateTime entryTime,
        LocalDateTime exitTime,
        String status,
        boolean active) {
}
