package com.ekyc.capitaltrust.ekyc.repository;

import com.ekyc.capitaltrust.ekyc.model.phonepe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface phonepeRepository extends JpaRepository<phonepe, Integer> {

    phonepe findByTransactionId(String transactionId);
}
