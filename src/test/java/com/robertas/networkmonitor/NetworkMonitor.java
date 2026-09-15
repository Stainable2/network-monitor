package com.robertas.networkmonitor;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import java.util.ArrayList;
import java.util.List;

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

    @Test
    void multipleHosts(){
        NetworkMonitor monitor = new NetworkMonitor();

        List<String> hosts = List.of("google.com", "github.com");

        List<NetworkCheckResult> results = monitor.checkAll(hosts);

        assertEquals(2, results.size());
        assertEquals("google.com", results.get(0).getHost());
        assertEquals("github.com", results.get(1).getHost());
    }

    void returnEmptyForNoHosts() {
        NetworkMonitor monitor = new NetworkMonitor();

        List<NetworkCheckResult> results = monitor.checkAll(List.of());

        assertTrue(results.isEmpty());
    }

    @Test
    void continueAfterInvalidHost() {
        NetworkMonitor monitor = new NetworkMonitor();

        List<String> hosts = List.of("google.com", "this-host-definitely-does-not-exist.com", "github.com");

        List<NetworkCheckResult> results = monitor.checkAll(hosts);

        assertEquals(3, results.size());
        assertEquals("google.com", results.get(0).getHost());
        assertEquals("this-host-definitely-does-not-exist.com", results.get(1).getHost());
        assertFalse(results.get(1).isReachable());
        assertEquals(-1, results.get(1).getResponseTime());
        assertEquals("github.com", results.get(2).getHost());
    }
}