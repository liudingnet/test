package com.horse.identifier.controller;

import com.horse.identifier.model.*;
import com.horse.identifier.service.AccountService;
import com.horse.identifier.service.EvidenceService;
import com.horse.identifier.util.token.Claim;
import com.horse.identifier.util.token.CurrentUser;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

@RestController("/StickIdentifierEvidence")
@RequestMapping("/api/evidence")
@Api(tags = "贴码服务API")
public class StickIdentifierEvidenceController {
    @Autowired
    EvidenceService evidenceService;

    @PostMapping("/submitEvidence")
    @ApiOperation("上传贴码")
    public ResponseWrapper submitEvidence(String serialNo, String address)throws Exception {
        return new ResponseWrapper();
    }

    @GetMapping("/evidenceList")
    @ApiOperation("查询我的贴码清单")
    public ResponseWrapper<List<EvidenceItem>> queryMyEvidenceList(@CurrentUser @ApiIgnore Claim claim)throws Exception {
        evidenceService.GetMyEvidenceList(claim.getEmployeeId());
        return new ResponseWrapper<List<EvidenceItem>>();
    }

    @PostMapping("validateEvidence")
    @ApiOperation("验证图片是否已打印且未贴码")
    public ResponseWrapper<ImgValidation> validateEvidence(String mediaId)throws Exception {
        ResponseWrapper<ImgValidation> imgValidation = new ResponseWrapper<ImgValidation>();
        return imgValidation;
    }
}
