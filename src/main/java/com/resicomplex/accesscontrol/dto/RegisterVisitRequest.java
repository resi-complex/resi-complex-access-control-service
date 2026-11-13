package com.resicomplex.accesscontrol.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record RegisterVisitRequest(
        @NotBlank @Size(max = 150) String visitorName,
        @NotBlank @Size(max = 50) String documentNumber,
        @NotBlank @Size(max = 36) String destinationUnitId,
        @NotBlank @Pattern(regexp = "PERSONAL_VISITOR|COMMERCIAL_CLIENT") String visitType,
        @Size(max = 20) String vehiclePlate,
        @Pattern(regexp = "CAR|MOTORCYCLE|NONE") String vehicleType) {
}
