package com.robertas.networkmonitor;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

class NetworkMonitorTest {

    @Test
    void reachable() {
        NetworkMonitor monitor = new NetworkMonitor();

        NetworkCheckResult result = monitor.check("google.com");

        assertTrue(result.isReachable());
    }

    @Test
    void returnAResponseTime() {
        NetworkMonitor monitor = new NetworkMonitor();

        NetworkCheckResult result = monitor.check("google.com");

        assertTrue(result.getResponseTime() >= 0);
    }

    @Test
    void containHost() {
        NetworkMonitor monitor = new NetworkMonitor();

        NetworkCheckResult result = monitor.check("google.com");

        assertEquals("google.com", result.getHost());
    }

    @Test
    void notBeReachable() {
        NetworkMonitor monitor = new NetworkMonitor();

        NetworkCheckResult result = monitor.check("this-host-definitely-does-not-exist.com");

        assertFalse(result.isReachable());
        assertEquals(-1, result.getResponseTime());
    }
}