package com.kkm.kkm_server_v2.global.config.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@Setter
@Getter
@ConstructorBinding
@ConfigurationProperties("jwt")
public class JwtProperties {

    private Long accessExp;
    private Long refreshExp;
    private String prefix;
    private String header;
    private String secretKey;
}
