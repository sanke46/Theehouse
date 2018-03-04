object GameModel {
    val deck = Deck();
    val wastePile : MutableList<Card> = mutableListOf()
    val fondationPiles : Array<FoundetionFile> = arrayOf(
            FoundetionFile(clubs),
            FoundetionFile(diamounds),
            FoundetionFile(hearts),
            FoundetionFile(spades))
    val tableauPiles = Array(7, { TableauPile()})

    fun resetGame() {
        wastePile.clear()
        fondationPiles.forEach { it.reset() }
        deck.reset()

        tableauPiles.forEachIndexed { i, tableauPile ->
            val cardsInPile: MutableList<Card> = Array(i + 1, { deck.drawcard() }).toMutableList()
            tableauPiles[i] = TableauPile(cardsInPile)
        }
    }

    fun onDeckTap() {
        if (deck.cardsInDeck.size > 0) {
            val card = deck.drawcard()
            card.faceUp = true
            wastePile.add(card)
        } else {
            deck.cardsInDeck = wastePile.toMutableList()
            wastePile.clear()
        }
    }

    fun onFoundetionTap(foundetionIndex: Int) {
        val foundationPile = fondationPiles[foundetionIndex]

        if (foundationPile.cards.size > 0) {
            val card = foundationPile.cards.last()
            if (playCard(card)) {
                foundationPile.removeCard(card)
            }
        }
    }

    fun onTableauTap(tableauTapIndex: Int, cardIndex : Int) {
        val tableauPile = tableauPiles[tableauTapIndex]
        if (tableauPile.cards.size > 0) {
            val cards = tableauPile.cards.subList(cardIndex, tableauPile.cards.lastIndex + 1)
            if (playCards(cards)) {
                tableauPile.removeCards(cardIndex)
            }
        }

    }

    private fun playCards(cards: MutableList<Card>): Boolean {
        if (cards.size == 1) {
            return playCard(cards.first())
        } else {
            tableauPiles.forEach {
                if (it.addCards(cards)) {
                    return true
                }
            }
        }
        return false
    }

    fun onWasteTap() {
        if (wastePile.size > 0) {
            val card = wastePile.last()
            if (playCard(card)) {
                wastePile.remove(card)
            }
        }
    }

    private fun playCard(card: Card): Boolean {
        fondationPiles.forEach {
            if (it.addCard(card)) {
                return true
            }
        }
        tableauPiles.forEach {
            if (it.addCards(mutableListOf(card))) {
                return true
            }
        }

        return false
    }


    fun debugPrint() {
        var firstLine = if (wastePile.size > 0) "${wastePile.last()}" else "___"
        firstLine = firstLine.padEnd(18)
        fondationPiles.forEach {
            firstLine += if (it.cards.size > 0) "${it.cards.last()}" else "___"
            firstLine += "   "
        }
        println(firstLine)
        println()

        for (i in 0..12) {
            var row = ""
            tableauPiles.forEach {
                row += if (it.cards.size > i) "${it.cards[i]}" else "   "
                row += "   "
            }
            println(row)
        }
    }
}

