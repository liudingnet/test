package com.horse.identifier.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.horse.identifier.entity.Evidence;

import java.util.List;

public interface EvidenceService extends IService<Evidence> {
    List<Evidence> GetMyEvidenceList(String employeeNo);
}
