package Model;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Stack;

public class InputContainer implements MouseListener{
	
	private Stack<MouseEvent> inputs;
	
	public InputContainer(){
		inputs = new Stack<MouseEvent>();
	}
	
	public void addToStack(MouseEvent e){
		inputs.add(e);
	}
	
	public Stack<MouseEvent> getInputs(){
		return inputs;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		this.addToStack(arg0);
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
