package com.facebook.lithium;

import io.reactivesocket.transport.tcp.server.TcpReactiveSocketServer;


public class JavaTCPServer {

    public static void main(String[] args) {

        String file = "/Users/mjzhu/fbjava-hg/lithium/experiments/tck/test_server/servertest$.txt";

        if (args.length > 0) {
            file = args[0];
        }

        JServerDriver jsd =
                new JServerDriver(file);

        TcpReactiveSocketServer.create(4567)
                .start((setupPayload, reactiveSocket) -> {
                    // create request handler
                    return jsd.parse();
                }).awaitShutdown();

    }

}
