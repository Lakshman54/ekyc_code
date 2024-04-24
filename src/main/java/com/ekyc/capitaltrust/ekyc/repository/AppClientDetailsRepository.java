package com.ekyc.capitaltrust.ekyc.repository;

import com.ekyc.capitaltrust.ekyc.model.AppClientDetails;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppClientDetailsRepository extends JpaRepository<AppClientDetails, Integer> {
    Optional<AppClientDetails> findByLoanId(int LoanId);
}
