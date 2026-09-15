package com.robertas.networkmonitor;

import java.io.IOException;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;

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
    public List<NetworkCheckResult> checkAll(List<String> hosts) {
        List<NetworkCheckResult> results = new ArrayList<>();

        for (String host : hosts) {
            results.add(check(host));
        }

        return results;
    }
}