package com.zhou.haizhi.nexus.netty.bio;

import groovy.util.logging.Slf4j;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Create by zhoumingbing on 2020-06-23
 */
@Slf4j
public class Server {

    private static final int DEFAULT_PORT = 7777;
    private static ServerSocket serverSocket;

    public static void main(String[] args) throws IOException {
        start(DEFAULT_PORT);
        while (true) {
            Socket socket = serverSocket.accept();
            new ServerHandler(socket).start();
        }
    }

    public static void start(int port) throws IOException {
        if (serverSocket != null) {
            return;
        }
        serverSocket = new ServerSocket(port);
    }
}
