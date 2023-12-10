package im.tox.tox4j.exceptions

abstract class ToxException(val errorCode: Enum<*>, message: String?) : Exception(message) {

  override val message: String
    get() = when {
      super.message.isNullOrBlank() -> "Error code: ${errorCode.name}"
      else -> "${super.message}, error code: ${errorCode.name}"
    }

}
