package cj.geochat.eureka.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication(scanBasePackages = "cj.geochat.eureka.server")
public class CjGeochatEurekaServerApplication {

    public static void main(String[] args) {
        printEnv();
        SpringApplication.run(CjGeochatEurekaServerApplication.class, args);
    }

    private static void printEnv() {
        System.out.println("docker外部传入的环境变量:");
        System.out.println("\tgeochat.spring.profiles.active=" + System.getenv("geochat.spring.profiles.active"));
        System.out.println("\tgeochat.register-with-eureka=" + System.getenv("geochat.register-with-eureka"));
        System.out.println("\tgeochat.fetch-registry=" + System.getenv("geochat.fetch-registry"));
        System.out.println("\tgeochat.EUREKA_SERVER_URL=" + System.getenv("geochat.EUREKA_SERVER_URL"));
        System.out.println("\tgeochat.hostname=" + System.getenv("geochat.hostname"));
    }

}
