package org.example.create_token.jwt;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtTokenProvider {

    private final String SECURITY_KEY = "eyJhbGciOiJIUzUxMiIsInR5cCI6IkpXVCJ9xeyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IlRva2VuIENyZWF0b3IiLCJhZG1pbiI6dHJ1ZSwiaWF0IjoxNTE2MjM5MDIyfQx2Mxp9DDBPO7I63yrYM1Lg4t9rt4dfw0GuCIo8nAvE7pyigD16hq5v0C9NB925In1SKSABACSDj2hJXw6M9yBiw";
    private final long EXPIRATION_TIME = 86400;


    // Token yaratish
    public String generateToken(String token) {
        return Jwts.builder()
                .setSubject(token)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS512, SECURITY_KEY)
                .compact();
    }

    // Tokenni tasdiqlash
    public boolean validateToken(String token) {

        try {
            Jwts.parser().setSigningKey(SECURITY_KEY).parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // Tokenni user ichidan olish
    public String getUsernameFromToken(String token) {
        return Jwts.parser()
                .setSigningKey(SECURITY_KEY)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

}
