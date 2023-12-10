package im.tox.tox4j.core.data

data class ToxLossyPacket internal constructor(val value: ByteArray) {

  companion object : ToxCustomPacketCompanion<ToxLossyPacket>(
          minPacketId = 200,
          maxPacketId = 256,
          ToxLossyPacket::value
  ) {

    override fun unsafeFromValue(value: ByteArray): ToxLossyPacket {
      return ToxLossyPacket(value)
    }

  }
}
