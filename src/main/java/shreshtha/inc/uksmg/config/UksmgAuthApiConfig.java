package shreshtha.inc.uksmg.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

@ConfigurationProperties(prefix = "uksmg.auth")
@Data
public class UksmgAuthApiConfig {

    @Value("${grant-type}")
    private String grantType;

    @Value("${client-id}")
    private String clientId;
    @Value("${client-secret}")
    private String clientSecret;

    @Value("${issuer}")
    private String issuerUrl;

    @Value("${endpoint.authorization}")
    private String authorizationEndpoint;

    @Value("${endpoint.token}")
    private String tokenEndpoint;

    @Value("${endpoint.logout}")
    private String logoutEndpoint;

}
