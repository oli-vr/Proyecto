package es.ull.etsii.PL.jMusic;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import static es.ull.etsii.PL.jMusic.Constantes.*;
import javax.swing.JPanel;

public class Pentagrama extends JPanel {
  private ArrayList<Figura> vector = new ArrayList<Figura>();
  private int x;
  private int y;
  
  
  public Pentagrama(int x, int y) {
    this.x = x;
    this.y = y;
  }
  
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.setColor(Color.BLACK);
    int ancho = 15;
    g.drawLine(x, y, ANCHO_FRAME, y);
    for (int i = 0; i < 4; i ++) {
      g.drawLine(x, y + ancho, ANCHO_FRAME, y + ancho);
      ancho += 15;
    }
  }
  
}
