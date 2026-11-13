package com.resicomplex.accesscontrol.controller;

import com.resicomplex.accesscontrol.dto.CorrespondenceResponse;
import com.resicomplex.accesscontrol.dto.RegisterCorrespondenceRequest;
import com.resicomplex.accesscontrol.service.IAccessControlService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/correspondence")
public class CorrespondenceController {

    private final IAccessControlService service;

    public CorrespondenceController(IAccessControlService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CorrespondenceResponse register(@Valid @RequestBody RegisterCorrespondenceRequest request) {
        return service.registerCorrespondence(request);
    }

    @GetMapping
    public List<CorrespondenceResponse> pending(@RequestParam(name = "unitId", required = false) String unitId) {
        return service.getPendingCorrespondence(unitId);
    }

    @PatchMapping("/{id}/deliver")
    public CorrespondenceResponse deliver(@PathVariable("id") String id) {
        return service.markDelivered(id);
    }
}
