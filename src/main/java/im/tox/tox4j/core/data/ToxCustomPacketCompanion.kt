package im.tox.tox4j.core.data

import com.fernandocejas.sample.core.functional.Either
import im.tox.core.typesafe.VariableSizeByteArrayCompanion
import im.tox.tox4j.core.ToxCoreConstants

abstract class ToxCustomPacketCompanion<T : Any>(
        val minPacketId: Int,
        val maxPacketId: Int,
        toValue: (T) -> ByteArray
) : VariableSizeByteArrayCompanion<T>(ToxCoreConstants.maxCustomPacketLength, toValue) {

  init {
    require(minPacketId <= maxPacketId)
  }

  override fun validate(value: ByteArray): Exception? {
    return if (value.isEmpty()) {
      IllegalArgumentException("Empty custom packet")
    } else {
      val packetId = value.first().toInt() and 0xff

      if (packetId !in minPacketId..maxPacketId) {
        IllegalArgumentException("Invalid packet id: $packetId; should be $minPacketId <= id <= $maxPacketId")
      } else {
        null
      }
    }
  }

  fun fromByteArray(packedId: Int, value: ByteArray): Either<Exception, T> {
    return fromValue(ByteArray(value.size + 1) { if (it == 0) packedId.toByte() else value[ it - 1] })
  }

}
