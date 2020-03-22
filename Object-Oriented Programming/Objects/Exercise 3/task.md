## Objects (#3)

Starting with:

```kotlin
interface AdventureGame {
  interface Environment
  interface Character
  val environment: Environment
  val characters: MutableList<Character>
  fun populate()
}
```

Define a class `Jungle` which is an `Environment`, and classes `Monkey` and
`Snake` which are each `Character`s. Within each class, place an `object
Factory` with a `create()` function. Give `Monkey` and `Snake` a `toString()`
that returns their class name.

Now define an `object MonkeysVsSnakes` which is an `AdventureGame`, using the
various `create()` functions to initialize it. `populate()` only needs to add
one `Monkey` and one `Snake`. The predefined `main()` will test your code.