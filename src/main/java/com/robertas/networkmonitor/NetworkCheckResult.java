package com.robertas.networkmonitor;

public class NetworkCheckResult {
    
    private final String host;
    private final boolean reachable;
    private final long responseTime;

    public NetworkCheckResult(String host, boolean reachable, long responseTime) {
        this.host = host;
        this.reachable = reachable;
        this.responseTime = responseTime;
    }

    public String getHost() {
        return host;
    }

    public boolean isReachable() {
        return reachable;
    }

    public long getResponseTime() {
        return responseTime;
    }
}
