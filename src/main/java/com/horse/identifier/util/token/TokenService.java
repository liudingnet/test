package com.horse.identifier.util.token;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.horse.identifier.entity.User;
import com.horse.identifier.util.constant.DeviceTypeEnum;
import org.springframework.stereotype.Component;

@Component
public class TokenService {
    public String generateToken(User user, DeviceTypeEnum deviceTypeEnum){
        String token= JWT.create()
                .withClaim("employeeId", user.getEmployeeId())
                .withClaim("employeeNo", user.getEmployeeNo())
                .withClaim("employeeName", user.getEmployeeName())
                .withClaim("deviceTypeEnum", deviceTypeEnum.name())
                .withAudience(user.getEmployeeNo())
                .sign(Algorithm.HMAC256(user.getPassword()));
        return token;
    }

    public Claim getEmployeeNoByToken(String token){
        Claim claim = new Claim();
        claim.setEmployeeId(JWT.decode(token).getClaims().get("employeeId").asString());
        claim.setEmployeeNo(JWT.decode(token).getClaims().get("employeeNo").asString());
        claim.setEmployeeName(JWT.decode(token).getClaims().get("employeeName").asString());
        claim.setDeviceTypeEnum(JWT.decode(token).getClaims().get("deviceTypeEnum").asString());
        return claim;
    }
}
