package com.demo.backend.security.Auth0;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
public class JwtToAccessTokenConverter {
    private final String TOKEN_EXCHANGE_URL = "https://oauth2.googleapis.com/token";
    private final String CLIENT_ID = "677738259531-r195imdtu2a5uqsrhd00mlp3remfqrgb.apps.googleusercontent.com";
    private final String CLIENT_SECRET = "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";

    public String exchangeJwtForAccessToken(String jwtToken) {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
        body.add("grant_type", "urn:ietf:params:oauth:grant-type:jwt-bearer");
        body.add("assertion", jwtToken);
        body.add("client_id", CLIENT_ID);
        body.add("client_secret", CLIENT_SECRET);

        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(body, headers);

        ResponseEntity<String> response = restTemplate.postForEntity(TOKEN_EXCHANGE_URL, requestEntity, String.class);
        if (response.getStatusCode() == HttpStatus.OK) {
            // El token de acceso está en el cuerpo de la respuesta JSON
            return response.getBody();
        } else {
            throw new RuntimeException("Failed to exchange JWT for access token. Response: " + response.getStatusCodeValue());
        }
    }
}

