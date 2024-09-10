package my.demo.service.utils;

import io.jsonwebtoken.*;
import my.demo.config.BusinessException;
import my.demo.domain.vo.LoginInfo;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.Date;

/**
 * @author liu peng bo
 * @date 2024/09/03 15:19
 */
public class JwtUtil {

    private static final String SECRET_KEY = "MQHWz4TGUQTSVQZK";
    private static final SecretKey secretKey = Jwts.SIG.HS256.key().random(new SecureRandom(SECRET_KEY.getBytes(StandardCharsets.UTF_8))).build();
    private static final String ISSUER = "base";
    private static final String USER = "user";

    public static String createJwtToken(LoginInfo loginInfo) {
        Date current = new Date();
        return Jwts.builder()
                .issuer(ISSUER)
                .subject(USER)
                .claim(USER, JsonUtil.toJson(loginInfo))
                .issuedAt(current)
                .expiration(new Date(System.currentTimeMillis() + 604800000))
                .signWith(secretKey)
                .compact();
    }

    public static LoginInfo parseJwtToken(String token) {
        try {
            Claims claims = Jwts.parser().verifyWith(secretKey).build().parseSignedClaims(token).getPayload();
            return JsonUtil.parseJson((String) claims.get(USER), LoginInfo.class);
        } catch (JwtException e) {
            throw new BusinessException("100", "token无效或过期");
        }
    }

    public static void main(String[] args) {
        LoginInfo loginInfo = new LoginInfo();
        loginInfo.setId(1L);
        loginInfo.setName("lybgeek");
        loginInfo.setPhone("123456789");
        String token = createJwtToken(loginInfo);
        System.out.println(token);
        parseJwtToken(token);
    }
}
