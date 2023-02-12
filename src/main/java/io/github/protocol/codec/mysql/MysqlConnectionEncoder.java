package io.github.protocol.codec.mysql;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;

public class MysqlConnectionEncoder<T extends MysqlMsg> extends AbstractMysqlLengthEncoder<T> {
    @Override
    protected void encodeMsg(ChannelHandlerContext channelHandlerContext, MysqlMsg mysqlMsg,
                             ByteBuf byteBuf) throws Exception {
    }
}
