package cj.geochat.eureka.server.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class MyApplicationListener implements ApplicationListener {
    @Value("${spring.profiles.active}")
    private String springProfilesActive;
    @Value("${eureka.client.register-with-eureka}")
    private boolean registerWithEureka;
    @Value("${eureka.client.fetch-registry}")
    private boolean fetchRegistry;
    @Value("${eureka.client.serviceUrl.defaultZone}")
    private String EUREKA_SERVER_URL;
    @Value("${eureka.instance.hostname}")
    private String EUREKA_HOST_NAME;

    boolean runOnce;
    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        if (runOnce) {
            return;
        }
        System.out.println("Spring boot application.yml 生效的环境变量:");
        System.out.println("\tgeochat.spring.profiles.active="+springProfilesActive);
        System.out.println("\tgeochat.register-with-eureka="+registerWithEureka);
        System.out.println("\tgeochat.fetch-registry="+fetchRegistry);
        System.out.println("\tgeochat.EUREKA_SERVER_URL="+EUREKA_SERVER_URL);
        System.out.println("\tgeochat.hostname="+EUREKA_HOST_NAME);
        runOnce=true;
    }
}
