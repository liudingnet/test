package com.horse.identifier.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.horse.identifier.entity.Evidence;
import com.horse.identifier.mapper.EvidenceMapper;
import com.horse.identifier.service.EvidenceService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EvidenceServiceImpl extends ServiceImpl<EvidenceMapper, Evidence> implements EvidenceService {
    @Override
    public List<Evidence> GetMyEvidenceList(String employeeId){
        QueryWrapper<Evidence> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("employee_Id", employeeId);
        List<Evidence> myEvidenceList = this.list(queryWrapper);

        return myEvidenceList;
    }
}
