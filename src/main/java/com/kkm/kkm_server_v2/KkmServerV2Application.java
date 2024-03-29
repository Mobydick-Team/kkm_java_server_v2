package com.kkm.kkm_server_v2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
@EnableFeignClients
@ConfigurationPropertiesScan
public class KkmServerV2Application {

    public static void main(String[] args) {
        SpringApplication.run(KkmServerV2Application.class, args);
    }


}
