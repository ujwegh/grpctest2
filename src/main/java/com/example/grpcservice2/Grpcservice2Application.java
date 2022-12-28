package com.example.grpcservice2;

import com.netflix.discovery.EurekaClient;
import io.grpc.BindableService;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.util.List;

@EnableDiscoveryClient
@SpringBootApplication
public class Grpcservice2Application {

    public static void main(String[] args) {
        SpringApplication.run(Grpcservice2Application.class, args);
    }

    @Slf4j
    @EnableDiscoveryClient
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Configuration
    public static class ReactiveGrpcAutoConfiguration {
        private static final int PORT = 9002;
        @Bean(destroyMethod = "shutdown")
        public Server reactiveGrpcServer(@Autowired @ReactiveGrpcService List<BindableService> bindableService) throws IOException {
            ServerBuilder<?> builder = ServerBuilder.forPort(PORT);
            log.info("gRPC server started on: " + PORT);
            for (io.grpc.BindableService service : bindableService) {
                builder.addService(service);
                log.info("Reactive gRPC service exposed: " + service.getClass().getName());
            }
            return builder.build().start();
        }

    }
}
