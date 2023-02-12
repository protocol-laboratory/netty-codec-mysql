package io.github.protocol.codec.mysql;

public class MysqlMsg {

    protected int sequenceId;

    public MysqlMsg(int sequenceId) {
        this.sequenceId = sequenceId;
    }

    public int sequenceId() {
        return sequenceId;
    }
}
