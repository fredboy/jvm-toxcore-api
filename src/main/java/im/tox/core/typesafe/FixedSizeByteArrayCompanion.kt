import im.tox.core.typesafe.ByteArrayCompanion
import im.tox.core.typesafe.Security

abstract class FixedSizeByteArrayCompanion<T : Any, S : Security>(
        val size: Int,
        toValue: (T) -> ByteArray,
) : ByteArrayCompanion<T, S>(toValue) {

    override fun validate(value: ByteArray): Exception? {
        return require(value.size == size) { "Invalid length: ${value.size} != $size" }
    }

}