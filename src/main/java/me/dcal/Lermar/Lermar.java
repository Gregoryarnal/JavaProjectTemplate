package me.dcal.Lermar;

import java.io.IOException;

import me.dcal.Lermar.control.GameController;
import me.dcal.Lermar.control.permanences.Permanence;
import me.dcal.Lermar.view.RouletteView;

public class Lermar {

	public static void main(String[] args) throws IOException {
		// System.out.println("Hello world");
		// Permanence perm = new Permanence();
		GameController gameController = new GameController();
		

		RouletteView rouletteView = new RouletteView(gameController);
	}

}
