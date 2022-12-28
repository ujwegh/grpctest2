package com.example.grpcservice2;

import io.grpc.CallOptions;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.mvnsearch.spring.boot.reactive.grpc.demo.service.HelloReply;
import org.mvnsearch.spring.boot.reactive.grpc.demo.service.HelloRequest;
import org.mvnsearch.spring.boot.reactive.grpc.demo.service.ReactorGreeterGrpc;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@ReactiveGrpcService
public class ReactiveGreeterImpl extends ReactorGreeterGrpc.GreeterImplBase {

    @Override
    public Mono<HelloReply> sayHello(Mono<HelloRequest> request) {
        return request.map(helloRequest -> HelloReply.newBuilder().setMessage("Hello " + helloRequest.getName()).build());
    }

    @Override
    public Mono<HelloReply> sayHelloAgain(Mono<HelloRequest> request) {
        return request.map(helloRequest -> HelloReply.newBuilder().setMessage("Hello Again " + helloRequest.getName()).build());
    }
}
