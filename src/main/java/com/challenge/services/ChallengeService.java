package com.challenge.services;

import com.challenge.entity.Challenge;
import com.challenge.repository.ChallengeRepository;
import com.challenge.service.interfaces.ChallengeServiceInterface;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class ChallengeService implements ChallengeServiceInterface {

    @Autowired
    private ChallengeRepository challengeRepository;

    @Override
        public List<Challenge> findByAccelerationIdAndUserId(Long accelerationId, Long userId) {
        return challengeRepository.findByAccelerationsIdAndSubmissionsIdUserId(accelerationId,userId);
    }

    @Override
    public Challenge save(Challenge object) {
        object.setCreatedAt(LocalDateTime.now());
        return challengeRepository.save(object);
    }
}
