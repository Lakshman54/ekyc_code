package com.ekyc.capitaltrust.ekyc.dao;

import com.ekyc.capitaltrust.ekyc.DTO.ekycDTO;
import com.ekyc.capitaltrust.ekyc.repository.EKycRepository;
import com.ekyc.capitaltrust.ekyc.utilities.EntityDTOUtil;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class eKycDao {
    @Autowired
    private EKycRepository eKycRepository;

    public eKycDao() {
    }

    public List<ekycDTO> getAlleKyc() {
        return this.eKycRepository.findAll().stream().map(EntityDTOUtil::toDto).toList();
    }

    public ekycDTO getEkycbyId(String transactionId) {
        return (ekycDTO)this.eKycRepository.findByTransactionId(transactionId).stream().map(EntityDTOUtil::toDto).findFirst().stream();
    }

    public void saveEkyc(ekycDTO ekycDTO) {
        this.eKycRepository.save(EntityDTOUtil.toEntity(ekycDTO));
    }

    public void deleteEkyc(ekycDTO ekycDTO) {
        this.eKycRepository.delete(EntityDTOUtil.toEntity(ekycDTO));
    }

    public void updateEkyc(ekycDTO ekycDTO) {
        this.eKycRepository.save(EntityDTOUtil.toEntity(ekycDTO));
    }
}
