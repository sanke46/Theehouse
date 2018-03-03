class GamePresenter {
    var view: GameView? = null

    fun setGameView(gameView: GameView) {
        view = gameView
    }

    fun onDeckTap() {
        GameModel.onDeckTap()
        view?.update()
    }

    fun onWasteTap() {
        GameModel.onWasteTap()
        view?.update()
    }

    fun onFoundetionTap(foundetionIndex: Int) {
        GameModel.onFoundetionTap(foundetionIndex)
        view?.update()
    }

    fun onTableauTap(tableauTapIndex: Int, cardIndex : Int) {
        GameModel.onTableauTap(tableauTapIndex,cardIndex)
        view?.update()
    }
}