package com.challenge.services;

import com.challenge.service.interfaces.ServiceInterface;
import org.springframework.stereotype.Service;

@Service
public class ServiceAbstractService implements ServiceInterface {
    @Override
    public Object save(Object object) {
        return null;
    }
}
