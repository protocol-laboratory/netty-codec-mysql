package io.github.protocol.codec.mysql;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.handler.codec.TooLongFrameException;

import java.util.List;

public abstract class AbstractMysqlLengthDecoder extends ByteToMessageDecoder {

    private final int maxBytesInMessage;

    public AbstractMysqlLengthDecoder() {
        this(MysqlConst.DEFAULT_MAX_BYTES_IN_MESSAGE);
    }

    public AbstractMysqlLengthDecoder(int maxBytesInMessage) {
        this.maxBytesInMessage = maxBytesInMessage;
    }

    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf buf,
                          List<Object> list) throws Exception {
        if (buf.readableBytes() < MysqlConst.LEN_PACKET_SIZE) {
            return;
        }
        buf.markReaderIndex();
        int packetLength = buf.readUnsignedMediumLE();
        if (packetLength > maxBytesInMessage) {
            throw new TooLongFrameException("packet length: " + packetLength + " is larger than " + maxBytesInMessage);
        }
        final int packetNum = buf.readByte();
        if (buf.readableBytes() < packetLength) {
            buf.resetReaderIndex();
            return;
        }
        ByteBuf packet = buf.readSlice(packetLength);
        decode(channelHandlerContext, packetNum, packet, list);
    }

    protected abstract void decode(ChannelHandlerContext ctx, int packetNum, ByteBuf packet, List<Object> out);
}
