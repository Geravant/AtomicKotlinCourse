## Companion Objects (#1)

The idea of the *Factory* shown in `CompanionFactory.kt` becomes more
interesting when you introduce multiple factories, so the same configuration
can easily create different types of objects.

Start with two interfaces:

```kotlin
interface Vendor {
  fun pencil()
  fun pen()
}

interface VendorFactory {
  fun create(): Vendor
}
```

Create `Vendor1` and `Vendor2` which implement `Vendor`. The member functions
use `Trace` to report the `Vendor` class name and "pencil" or "pen". Each
`Vendor` implementation also has a `companion object` with a `factory` property
containing an anonymous inner class that implements `VendorFactory`.

Now write a standalone function `consumer(factory: VendorFactory)` which uses
`factory` to create a `Vendor`. Use that `Vendor` to call `pencil()` and
`pen()`. The starter code in `main()` will validate your solution.