package udc.psw;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class LinePanel extends JPanel implements MouseMotionListener, MouseListener {
	
	private JLabel status;
	
	private int xi = 0;
	private int yi = 0;
	private int xf = 0;
	private int yf = 0;
	private int control;
	
	public LinePanel(JLabel status) {
		this.status = status;
		
		addMouseMotionListener(this);
		addMouseListener(this);
		
		setBackground(Color.WHITE);
	}
	public int desenho(int escolha) {
		this.control = escolha;
		return this.control;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		switch(control) {
		case 1: //ponto
		xi = e.getX();
		yi = e.getY();
		break;
		case 2: //linha
			break;
		}
		repaint();
		}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		
		switch(control) {
		case 1: //ponto
			g.fillOval(xi-2, yi-2, 5, 5);
			break;
		case 2: //linha
			g.drawLine(xi, yi, xf, yf);
			break;
		}
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		xi = e.getX();
		yi = e.getY();

	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
	}
	
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		xf = e.getX();
		yf = e.getY();
		repaint();
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		status.setText(String.format("Movimento na posição [%d, %d]", e.getX(), e.getY()));
		
	}
}
