import java.util.*

class Deck {

    val cards = Array(52, { Card(it % 13, getSuit(it))})
    var cardsInDeck: MutableList<Card> = cards.toMutableList()

    fun drawcard() : Card = cardsInDeck.removeAt(0)

    fun reset() {
        cardsInDeck = cards.toMutableList()
        cardsInDeck.forEach { it.faceUp = false }
        Collections.shuffle(cardsInDeck)
    }

    private fun getSuit(i: Int) = when(i / 13) {
        0 -> clubs
        1 -> diamounds
        2 -> hearts
        else -> spades
    }
}