package com.resicomplex.accesscontrol.dto;

import java.time.LocalDateTime;

public record PreauthorizationResponse(
        String id,
        String unitId,
        String visitorName,
        String documentNumber,
        String authorizedBy,
        LocalDateTime validFrom,
        LocalDateTime validUntil,
        String status,
        LocalDateTime createdAt) {
}
