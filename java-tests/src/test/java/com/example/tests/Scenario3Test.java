package com.example.tests;

import com.example.config.TestConfig;
import com.example.utils.WebSocketClientHelper;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.URI;

public class Scenario3Test {

    @Test(groups = {"api", "smoke"})
    public void testWebSocketPingPong() throws Exception {
        WebSocketClientHelper client = new WebSocketClientHelper(new URI(TestConfig.MYWS));
        client.connectBlocking();

        client.send("{\"ping\":1}");
        Thread.sleep(1000); // wait for response

        String response = client.getLastMessage();
        Assert.assertTrue(response.contains("\"ping\":\"pong\""), "Expected pong response");

        client.close();
    }
}
