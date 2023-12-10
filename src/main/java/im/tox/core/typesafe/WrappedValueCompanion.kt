package im.tox.core.typesafe

import com.fernandocejas.sample.core.functional.Either
import com.fernandocejas.sample.core.functional.toLeft
import com.fernandocejas.sample.core.functional.toRight
import im.tox.core.ModuleCompanion

abstract class WrappedValueCompanion<Repr, T : Any, S : Security> : ModuleCompanion<T, S>() {

  abstract val toValue: (T) -> Repr

  protected abstract fun validate(value: Repr): Exception?

  abstract fun unsafeFromValue(value: Repr): T

  fun fromValue(value: Repr): Either<Exception, T> {
    return validate(value)?.toLeft() ?: unsafeFromValue(value).toRight()
  }

  protected fun require(value: Boolean, lazyMessage: () -> Any): Exception? {
      return try {
          kotlin.require(value, lazyMessage)
          null
      } catch (exception: Exception) {
          exception
      }
  }

}
