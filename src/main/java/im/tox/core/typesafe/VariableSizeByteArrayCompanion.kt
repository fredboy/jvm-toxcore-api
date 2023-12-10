package im.tox.core.typesafe

abstract class VariableSizeByteArrayCompanion<T : Any>(
        val maxSize: Int,
        toValue: (T) -> ByteArray,
) : ByteArrayCompanion<T, Security.Sensitive>(toValue) {

    override fun validate(value: ByteArray): Exception? {
        return require(value.size < maxSize) { "Invalid length: ${value.size} > $maxSize" }
    }

}