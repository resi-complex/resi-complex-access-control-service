package com.resicomplex.accesscontrol.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record RegisterCorrespondenceRequest(
        @NotBlank @Size(max = 36) String unitId,
        @NotBlank @Size(max = 150) String recipientName,
        @NotBlank @Pattern(regexp = "ENVELOPE|BOX|FOOD_DELIVERY") String packageType,
        @Size(max = 100) String courier) {
}
