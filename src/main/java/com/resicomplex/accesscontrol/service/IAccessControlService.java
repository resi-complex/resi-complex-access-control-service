package com.resicomplex.accesscontrol.service;

import com.resicomplex.accesscontrol.dto.CorrespondenceResponse;
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
}
