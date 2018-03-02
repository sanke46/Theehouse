val clubs = "Clubs"
val diamounds = "Diamounds"
val hearts = "Hearts"
val spades = "Spades"
val redSuits = arrayOf(diamounds,hearts)
val blackSuits = arrayOf(clubs,spades)

data class Card(val value : Int, val suit : String, var faceUp : Boolean = false) {

}