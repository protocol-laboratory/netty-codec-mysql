package io.github.protocol.codec.mysql;

import java.util.Map;
import java.util.Set;

public class HandshakeResp extends MysqlMsg {

    private final Set<CapabilityFlag> capabilityFlags;

    private final int maxPacketSize;

    private final int charset;

    private final String authPluginName;

    private final Map<String, String> attributes;

    public HandshakeResp(int sequenceId, Set<CapabilityFlag> capabilityFlags, int maxPacketSize, int charset,
                         String authPluginName, Map<String, String> attributes) {
        super(sequenceId);
        this.capabilityFlags = capabilityFlags;
        this.maxPacketSize = maxPacketSize;
        this.charset = charset;
        this.authPluginName = authPluginName;
        this.attributes = attributes;
    }

    public Set<CapabilityFlag> capabilityFlags() {
        return capabilityFlags;
    }

    public int maxPacketSize() {
        return maxPacketSize;
    }

    public int charset() {
        return charset;
    }

    public String authPluginName() {
        return authPluginName;
    }

    public Map<String, String> attributes() {
        return attributes;
    }
}
