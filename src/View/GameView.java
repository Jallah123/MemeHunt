package View;

import java.awt.Dimension;

import javax.swing.JFrame;

import Model.GameModel;

public class GameView extends JFrame{

	private static final long serialVersionUID = -4755646091718898407L;
	private PlayingField playingField;
	
	public GameView(GameModel gameModel){
		playingField = new PlayingField(gameModel);
		this.setContentPane(playingField);
		this.setPreferredSize(new Dimension(1280, 720));
		this.setMinimumSize(this.getPreferredSize());
		this.setTitle("Meme Hunt");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);
	}
	
	public PlayingField getPlayingField(){
		return playingField;
	}
}
