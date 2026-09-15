package com.robertas.networkmonitor;

import java.io.IOException;
import java.net.InetAddress;

public class NetworkMonitor {

    public boolean isReachable(String host) throws IOException {
        InetAddress address = InetAddress.getByName(host);
        return address.isReachable(5000);
    }

    public long getResponseTime(String host) throws IOException {
        InetAddress address = InetAddress.getByName(host);

        long start = System.nanoTime();

        address.isReachable(5000);

        long end = System.nanoTime();

        return (end - start) / 1_000_000;
    }
}