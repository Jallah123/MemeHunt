package View;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import Model.GameModel;
import Model.GameUnit;

public class PlayingField extends JPanel{
	
	private static final long serialVersionUID = -5575128227457186909L;
	private GameModel gameModel;
	
	public PlayingField(GameModel gameModel){
		this.gameModel = gameModel;
		setLayout(null);
		setMinimumSize(new Dimension(1280, 720));
		setPreferredSize(getMinimumSize());
		setVisible(true);
	}
	
	@Override
	public void paintComponent(Graphics g1) {
		super.paintComponent(g1);
		Graphics2D g = (Graphics2D) g1;
		g.drawImage(new ImageIcon("assets/background.png").getImage(), 0, 0,
				this.getWidth(), this.getHeight(), null);
		for(GameUnit gu: gameModel.getGameUnits()){
			g.drawImage(new ImageIcon(gu.getImageUrl()).getImage(), gu.getPosition().x, gu.getPosition().y, gu.getWidth(), gu.getHeight(), null);
		}
	}
}
