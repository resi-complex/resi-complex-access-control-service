package com.resicomplex.accesscontrol.controller;

import com.resicomplex.accesscontrol.dto.CreatePreauthorizationRequest;
import com.resicomplex.accesscontrol.dto.PreauthorizationResponse;
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
@RequestMapping("/api/v1/preauthorizations")
public class PreauthorizationController {

    private final IAccessControlService service;

    public PreauthorizationController(IAccessControlService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PreauthorizationResponse create(@Valid @RequestBody CreatePreauthorizationRequest request) {
        return service.createPreauthorization(request);
    }

    @GetMapping
    public List<PreauthorizationResponse> listActive(@RequestParam(name = "unitId", required = false) String unitId) {
        return service.getActivePreauthorizations(unitId);
    }

    @PatchMapping("/{id}/cancel")
    public PreauthorizationResponse cancel(@PathVariable("id") String id) {
        return service.cancelPreauthorization(id);
    }
}
