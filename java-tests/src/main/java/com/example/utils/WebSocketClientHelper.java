package com.example.utils;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;

public class WebSocketClientHelper extends WebSocketClient {
    private String lastMessage;

    public WebSocketClientHelper(URI serverUri) {
        super(serverUri);
    }

    @Override
    public void onOpen(ServerHandshake handshakedata) {
        System.out.println("WebSocket opened");
    }

    @Override
    public void onMessage(String message) {
        lastMessage = message;
    }

    @Override
    public void onClose(int code, String reason, boolean remote) {
        System.out.println("WebSocket closed");
    }

    @Override
    public void onError(Exception ex) {
        ex.printStackTrace();
    }

    public String getLastMessage() {
        return lastMessage;
    }
}
