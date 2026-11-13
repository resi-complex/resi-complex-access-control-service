package com.resicomplex.accesscontrol.service;

import com.resicomplex.accesscontrol.dto.CorrespondenceResponse;
import com.resicomplex.accesscontrol.dto.RegisterCorrespondenceRequest;
import com.resicomplex.accesscontrol.dto.RegisterVisitRequest;
import com.resicomplex.accesscontrol.dto.VisitResponse;
import com.resicomplex.accesscontrol.model.Correspondence;
import com.resicomplex.accesscontrol.model.Visit;
import com.resicomplex.accesscontrol.repository.CorrespondenceRepository;
import com.resicomplex.accesscontrol.repository.VisitRepository;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class AccessControlService implements IAccessControlService {

    private static final String VISIT_ACTIVE = "ACTIVE";
    private static final String VISIT_COMPLETED = "COMPLETED";
    private static final String CORRESPONDENCE_PENDING = "PENDING_PICKUP";
    private static final String CORRESPONDENCE_DELIVERED = "DELIVERED";

    private final VisitRepository visitRepository;
    private final CorrespondenceRepository correspondenceRepository;

    public AccessControlService(VisitRepository visitRepository,
                                CorrespondenceRepository correspondenceRepository) {
        this.visitRepository = visitRepository;
        this.correspondenceRepository = correspondenceRepository;
    }

    @Override
    public VisitResponse registerVisit(RegisterVisitRequest request) {
        Visit visit = new Visit();
        visit.setId(UUID.randomUUID().toString());
        visit.setVisitorName(request.visitorName());
        visit.setDocumentNumber(request.documentNumber());
        visit.setDestinationUnitId(request.destinationUnitId());
        visit.setVisitType(request.visitType());
        visit.setVehiclePlate(request.vehiclePlate());
        visit.setVehicleType(request.vehicleType());
        visit.setEntryTime(LocalDateTime.now());
        visit.setStatus(VISIT_ACTIVE);
        return toResponse(visitRepository.save(visit));
    }

    @Override
    public List<VisitResponse> getActiveVisits() {
        return visitRepository.findByStatus(VISIT_ACTIVE).stream().map(this::toResponse).toList();
    }

    @Override
    public VisitResponse exitVisit(String id) {
        Visit visit = visitRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Visit not found"));
        if (VISIT_COMPLETED.equals(visit.getStatus())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Visit already completed");
        }
        visit.setExitTime(LocalDateTime.now());
        visit.setStatus(VISIT_COMPLETED);
        return toResponse(visitRepository.save(visit));
    }

    @Override
    public CorrespondenceResponse registerCorrespondence(RegisterCorrespondenceRequest request) {
        Correspondence item = new Correspondence();
        item.setId(UUID.randomUUID().toString());
        item.setUnitId(request.unitId());
        item.setRecipientName(request.recipientName());
        item.setPackageType(request.packageType());
        item.setTrackingOrCourier(request.courier());
        item.setStatus(CORRESPONDENCE_PENDING);
        item.setReceivedAt(LocalDateTime.now());
        return toResponse(correspondenceRepository.save(item));
    }

    @Override
    public List<CorrespondenceResponse> getPendingCorrespondence(String unitId) {
        List<Correspondence> items = (unitId == null || unitId.isBlank())
                ? correspondenceRepository.findByStatus(CORRESPONDENCE_PENDING)
                : correspondenceRepository.findByUnitIdAndStatus(unitId, CORRESPONDENCE_PENDING);
        return items.stream().map(this::toResponse).toList();
    }

    @Override
    public CorrespondenceResponse markDelivered(String id) {
        Correspondence item = correspondenceRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Correspondence not found"));
        if (CORRESPONDENCE_DELIVERED.equals(item.getStatus())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Correspondence already delivered");
        }
        item.setStatus(CORRESPONDENCE_DELIVERED);
        item.setDeliveredAt(LocalDateTime.now());
        return toResponse(correspondenceRepository.save(item));
    }

    private VisitResponse toResponse(Visit v) {
        return new VisitResponse(v.getId(), v.getVisitorName(), v.getDocumentNumber(),
                v.getDestinationUnitId(), v.getVisitType(), v.getVehiclePlate(), v.getVehicleType(),
                v.getEntryTime(), v.getExitTime(), v.getStatus(), VISIT_ACTIVE.equals(v.getStatus()));
    }

    private CorrespondenceResponse toResponse(Correspondence c) {
        return new CorrespondenceResponse(c.getId(), c.getUnitId(), c.getRecipientName(),
                c.getPackageType(), c.getTrackingOrCourier(), c.getStatus(),
                c.getReceivedAt(), c.getDeliveredAt());
    }
}
