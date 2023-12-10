package im.tox.tox4j.core.data

data class ToxLosslessPacket internal constructor(val value: ByteArray) {

  companion object : ToxCustomPacketCompanion<ToxLosslessPacket>(
          minPacketId = 160,
          maxPacketId = 191,
          ToxLosslessPacket::value
  ) {

    override fun unsafeFromValue(value: ByteArray): ToxLosslessPacket {
      return ToxLosslessPacket(value)
    }

  }
}
