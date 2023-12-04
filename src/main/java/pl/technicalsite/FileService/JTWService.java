package pl.technicalsite.FileService;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.PlainJWT;
import com.nimbusds.jwt.SignedJWT;

public interface JTWService {

    PlainJWT createJwt();

    SignedJWT createSignedJwt(JWTClaimsSet jwtPayload, String privateKey) throws JOSEException;

}
