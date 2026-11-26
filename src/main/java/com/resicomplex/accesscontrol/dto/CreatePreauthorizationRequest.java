package com.resicomplex.accesscontrol.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDateTime;

public record CreatePreauthorizationRequest(
        @NotBlank @Size(max = 36) String unitId,
        @NotBlank @Size(max = 150) String visitorName,
        @NotBlank @Size(max = 50) String documentNumber,
        @NotBlank @Size(max = 36) String authorizedBy,
        @NotNull LocalDateTime validFrom,
        @NotNull LocalDateTime validUntil) {
}
