package com.ekyc.capitaltrust.ekyc.repository;

import com.ekyc.capitaltrust.ekyc.model.EKyc;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EKycRepository extends JpaRepository<EKyc, Integer> {
    Optional<EKyc> findByTransactionId(String transactionId);
}
