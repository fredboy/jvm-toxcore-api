package im.tox.core.typesafe

abstract class KeyCompanion<T : Any, S : Security>(
        size: Int,
        toValue: (T) -> ByteArray
) : FixedSizeByteArrayCompanion<T, S>(size, toValue)