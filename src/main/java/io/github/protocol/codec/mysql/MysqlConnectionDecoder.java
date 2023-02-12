package io.github.protocol.codec.mysql;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;

import java.util.List;

public class MysqlConnectionDecoder extends AbstractMysqlLengthDecoder {

    @Override
    protected void decode(ChannelHandlerContext ctx, int packetNum, ByteBuf packet, List<Object> out) {
    }
}
