package com.resicomplex.accesscontrol.service;

import com.resicomplex.accesscontrol.dto.CorrespondenceResponse;
import com.resicomplex.accesscontrol.dto.CreatePreauthorizationRequest;
import com.resicomplex.accesscontrol.dto.PreauthorizationResponse;
import com.resicomplex.accesscontrol.dto.RegisterCorrespondenceRequest;
import com.resicomplex.accesscontrol.dto.RegisterVisitRequest;
import com.resicomplex.accesscontrol.dto.VisitResponse;
import java.util.List;

public interface IAccessControlService {

    VisitResponse registerVisit(RegisterVisitRequest request);

    List<VisitResponse> getActiveVisits();

    VisitResponse exitVisit(String id);

    CorrespondenceResponse registerCorrespondence(RegisterCorrespondenceRequest request);

    List<CorrespondenceResponse> getPendingCorrespondence(String unitId);

    CorrespondenceResponse markDelivered(String id);

    PreauthorizationResponse createPreauthorization(CreatePreauthorizationRequest request);

    List<PreauthorizationResponse> getActivePreauthorizations(String unitId);

    PreauthorizationResponse cancelPreauthorization(String id);
}
