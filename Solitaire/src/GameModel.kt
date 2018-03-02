class GameModel {
    val deck = Deck();
    val wastePile : MutableList<Card> = mutableListOf()
    val fondationPiles : Array<FoundetionFile> = arrayOf(
            FoundetionFile(clubs),
            FoundetionFile(diamounds),
            FoundetionFile(hearts),
            FoundetionFile(spades))
    val tableauPiles = Array(7, { TableauPile()})
}