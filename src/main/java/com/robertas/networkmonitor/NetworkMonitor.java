package com.robertas.networkmonitor;

import java.io.IOException;
import java.net.InetAddress;

public class NetworkMonitor {

    public boolean isReachable(String host) throws IOException {
        InetAddress address = InetAddress.getByName(host);
        return address.isReachable(5000);
    }
}