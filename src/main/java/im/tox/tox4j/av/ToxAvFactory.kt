package im.tox.tox4j.av

import im.tox.tox4j.core.ToxCore

abstract class ToxAvFactory {

  abstract fun <R> withToxAv(tox: ToxCore, f: (ToxAv) -> R): R

  fun <R> withToxAv(av: ToxAv, f: (ToxAv) -> R): R {
    return av.use(f)
  }

  fun <R> withToxAvN(
          toxes: List<ToxCore>,
          initial: List<Pair<ToxCore, ToxAv>> = emptyList(),
          f: (List<Pair<ToxCore, ToxAv>>) -> R
  ): R {
    val (tox, tail) = toxes.firstAndTail()

    return withToxAv(tox) { av ->
      withToxAvN(tail, mutableListOf(tox to av).apply { addAll(initial) }, f)
    }
  }

  private fun <T> List<T>.firstAndTail(): Pair<T, List<T>> {
    return when {
      size == 1 -> first() to emptyList()
      else -> first() to subList(1, size)
    }
  }

}
