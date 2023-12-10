package im.tox.core.typesafe

import com.fernandocejas.sample.core.functional.Either
import com.fernandocejas.sample.core.functional.toLeft
import com.fernandocejas.sample.core.functional.toRight
import im.tox.core.ModuleCompanion
import im.tox.core.typesafe.Security

abstract class WrappedValueCompanion<Repr, T : Any, S : Security>: ModuleCompanion<T, S>() {

  protected abstract fun validate(value: Repr): Exception?

  protected abstract fun unsafeFromValue(value: Repr): T

  fun fromValue(value: Repr): Either<Exception, T> {
    return validate(value)?.toLeft() ?: unsafeFromValue(value).toRight()
  }

}
