package io.github.protocol.codec.mysql;

import java.util.Set;

public class Handshake extends MysqlMsg {

    private final int protocolVersion;

    private final String serverVersion;

    private final int connectionId;

    private final Set<CapabilityFlag> capabilities;

    private final int serverLanguage;

    private final Set<ServerStatusFlag> serverStatus;

    private final String authPluginName;

    public Handshake(int sequenceId, int protocolVersion, String serverVersion, int connectionId,
                     Set<CapabilityFlag> capabilities, int serverLanguage, Set<ServerStatusFlag> serverStatus,
                     String authPluginName) {
        super(sequenceId);
        this.protocolVersion = protocolVersion;
        this.serverVersion = serverVersion;
        this.connectionId = connectionId;
        this.capabilities = capabilities;
        this.serverLanguage = serverLanguage;
        this.serverStatus = serverStatus;
        this.authPluginName = authPluginName;
    }

    public int protocolVersion() {
        return protocolVersion;
    }

    public String serverVersion() {
        return serverVersion;
    }

    public int connectionId() {
        return connectionId;
    }

    public Set<CapabilityFlag> capabilities() {
        return capabilities;
    }

    public int serverLanguage() {
        return serverLanguage;
    }

    public Set<ServerStatusFlag> serverStatus() {
        return serverStatus;
    }

    public String authPluginName() {
        return authPluginName;
    }
}
