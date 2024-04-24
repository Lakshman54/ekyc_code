package com.ekyc.capitaltrust.ekyc.utilities;

import com.ekyc.capitaltrust.ekyc.DTO.ekycDTO;
import com.ekyc.capitaltrust.ekyc.model.EKyc;

public class EntityDTOUtil {
    public EntityDTOUtil() {
    }

    public static ekycDTO toDto(EKyc entity) {
        ekycDTO dto = new ekycDTO();
        dto.setTransactionId(entity.getTransactionId());
        dto.setResponseFormed(entity.getResponseFormed());
        dto.setBufferedRequestShared(entity.getBufferedRequestShared());
        return dto;
    }

    public static EKyc toEntity(ekycDTO dto) {
        EKyc entity = new EKyc();
        entity.setTransactionId(dto.getTransactionId());
        entity.setResponseFormed(dto.getResponseFormed());
        entity.setBufferedRequestShared(dto.getBufferedRequestShared());
        return entity;
    }
}
