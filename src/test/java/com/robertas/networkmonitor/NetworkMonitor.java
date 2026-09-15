package com.robertas.networkmonitor;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;

class NetworkMonitorTest {

    @Test
    void googleShouldBeReachable() throws IOException {
        NetworkMonitor monitor = new NetworkMonitor();

        assertTrue(monitor.isReachable("google.com"));
    }
    @Test
    void googleShouldReturnAResponseTime() throws IOException {
        NetworkMonitor monitor = new NetworkMonitor();

        long responseTime = monitor.getResponseTime("google.com");

        assertTrue(responseTime >= 0);
    }
}