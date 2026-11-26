package com.resicomplex.accesscontrol.dto;

import java.time.LocalDateTime;

public record CorrespondenceResponse(
        String id,
        String unitId,
        String recipientName,
        String packageType,
        String courier,
        String status,
        String pickupPin,
        LocalDateTime receivedAt,
        LocalDateTime deliveredAt) {
}
