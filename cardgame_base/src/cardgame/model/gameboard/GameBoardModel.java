/**
 * Created by MrE on 31 okt 2013
 */
package cardgame.model.gameboard;

import java.util.ArrayList;

import cardgame.gui.base.CardGuiBase;
import cardgame.gui.base.SnapAreaGuiBase;
import framework.cardgame.mvcbase.abstracts.AbstractModel;

public class GameBoardModel extends AbstractModel {
	
	private String boardImage;
	private ArrayList<CardGuiBase> cards;
	private ArrayList<SnapAreaGuiBase> snapAreas;
	
	public void setBoardImage(String newBoardImage) {
		String oldBoardImage = boardImage;
		boardImage = newBoardImage;
		firePropertyChange("BoardImage", oldBoardImage, boardImage);
	}
	
	public void setCards(ArrayList<CardGuiBase> newCards) {
		ArrayList<CardGuiBase> oldCards = cards;
		cards = newCards;
		firePropertyChange("Cards", oldCards, cards);
	}
	
	public void setSnapAreas(ArrayList<SnapAreaGuiBase> newSnapAreas) {
		ArrayList<SnapAreaGuiBase> oldSnapAreas = snapAreas;
		snapAreas = newSnapAreas;
		firePropertyChange("SnapAreas", oldSnapAreas, snapAreas);
	}
}
