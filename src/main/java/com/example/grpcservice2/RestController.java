package com.example.grpcservice2;

import com.netflix.discovery.EurekaClient;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.NameResolver;
import org.mvnsearch.spring.boot.reactive.grpc.demo.service.HelloReply;
import org.mvnsearch.spring.boot.reactive.grpc.demo.service.HelloRequest;
import org.mvnsearch.spring.boot.reactive.grpc.demo.service.ReactorGreeterGrpc;
import org.springframework.web.bind.annotation.GetMapping;
import reactor.core.publisher.Mono;


@org.springframework.web.bind.annotation.RestController
public class RestController {

    private ManagedChannel channel = ManagedChannelBuilder.forAddress("127.0.0.1", 9002)
            .usePlaintext()
            .build();

    @GetMapping("/")
    public Mono<HelloReply> send() {
        HelloRequest request = HelloRequest.newBuilder()
                .setName("WOWOWO")
                .build();
        ReactorGreeterGrpc.ReactorGreeterStub stub = ReactorGreeterGrpc.newReactorStub(channel);
        return stub.sayHello(request);
    }
}
