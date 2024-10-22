package com.wakeferndemo.service;

import com.wakeferndemo.models.RestockingRequest;
import com.wakeferndemo.repository.RestockingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestockingRequestService {

    @Autowired
    private RestockingRepository restockingRepository;

    public List<RestockingRequest> getAllRequests() {
        return restockingRepository.findAll();
    }

    public RestockingRequest createRequest(RestockingRequest restockingRequest) {
        return restockingRepository.save(restockingRequest);
    }
}
