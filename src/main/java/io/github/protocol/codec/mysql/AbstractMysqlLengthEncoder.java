package io.github.protocol.codec.mysql;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

public abstract class AbstractMysqlLengthEncoder<T extends MysqlMsg> extends MessageToByteEncoder<T> {
    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, T t, ByteBuf byteBuf) throws Exception {
        final int writerIdx = byteBuf.writerIndex();
        // set four bytes to 0, after body encoded, set the length and sequenceId
        byteBuf.writeInt(0);
        encodeMsg(channelHandlerContext, t, byteBuf);
        final int len = byteBuf.writerIndex() - writerIdx - 4;
        byteBuf.setMediumLE(writerIdx, len).setByte(writerIdx + 3, t.sequenceId());
    }

    protected abstract void encodeMsg(ChannelHandlerContext channelHandlerContext,
                                      T t, ByteBuf byteBuf) throws Exception;
}
