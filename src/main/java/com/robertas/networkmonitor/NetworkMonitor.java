package com.robertas.networkmonitor;

import java.io.IOException;
import java.net.InetAddress;

public class NetworkMonitor {

    public NetworkCheckResult check(String host) {
        try {
            InetAddress address = InetAddress.getByName(host);

            long start = System.nanoTime();

            boolean reachable = address.isReachable(5000);

            long end = System.nanoTime();

            long responseTime = (end - start) / 1_000_000;

            return new NetworkCheckResult(host, reachable, responseTime);
        } catch (IOException e) {
            return new NetworkCheckResult(host, false, -1);
        }
    }
}