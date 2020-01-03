package interfacesExercise4

interface GameElement {
  val symbol: Char
}

class Robot : GameElement {
  override val symbol get() = 'R'
}

class Wall : GameElement {
  override val symbol get() = '#'
}

class Food : GameElement {
  override val symbol get() = '.'
}