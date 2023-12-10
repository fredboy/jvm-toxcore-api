import im.tox.core.typesafe.Security

abstract class KeyCompanion<T : Any, S : Security>(
        size: Int,
        toValue: (T) -> ByteArray
) : FixedSizeByteArrayCompanion<T, S>(size, toValue)