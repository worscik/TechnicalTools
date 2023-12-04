package pl.technicalsite.FileService;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.JWSSigner;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.PlainJWT;
import com.nimbusds.jwt.SignedJWT;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Service
public class JWTServiceImpl implements JTWService {

    @Override
    public PlainJWT createJwt() {
        LocalDateTime now = LocalDateTime.now();
        Date nowDate = Date.from(now.atZone(ZoneId.systemDefault()).toInstant());
        LocalDateTime nowPlus1Hour = now.plusHours(1);
        Date expirationDate = Date.from(nowPlus1Hour.atZone(ZoneId.systemDefault()).toInstant());
        JWTClaimsSet claimSet = new JWTClaimsSet.Builder()
                .subject("user@technicaltool.pl")
                .issueTime(nowDate)
                .expirationTime(expirationDate)
                .claim("role", "USER")
                .build();
        return new PlainJWT(claimSet);
    }

    @Override
    public SignedJWT createSignedJwt(JWTClaimsSet jwtPayload, String privateKey) throws JOSEException {
        JWSAlgorithm algorithm = JWSAlgorithm.HS256;
        JWSHeader header = new JWSHeader(algorithm);
        JWSSigner jwsSigner = new MACSigner(privateKey);
        SignedJWT signedJWT = new SignedJWT(header, jwtPayload);
        signedJWT.sign(jwsSigner);
        return signedJWT;
    }


}
