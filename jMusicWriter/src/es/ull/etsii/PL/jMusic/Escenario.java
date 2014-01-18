package es.ull.etsii.PL.jMusic;

import static es.ull.etsii.PL.jMusic.Constantes.ALTO_FRAME;
import static es.ull.etsii.PL.jMusic.Constantes.ANCHO_FRAME;
import static es.ull.etsii.PL.jMusic.Constantes.PENTAGRAMA_X;
import static es.ull.etsii.PL.jMusic.Constantes.PENTAGRAMA_Y;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class Escenario extends JPanel {
  private Pentagrama pentagrama = new Pentagrama(PENTAGRAMA_X, PENTAGRAMA_Y);
  private ArrayList<Figura> vectorFiguras = new ArrayList<Figura>();
  private int puntero = 10;    // Puntero actual donde se pintará la siguiente nota.
  private HashNotas hashNotas = new HashNotas();   // Hash con las notas y las imágenes
  private Sonidos sonido = new Sonidos();
  private HashMap<String, Integer> nombres = new HashMap<String, Integer>();
  private HashMap<String, Integer> nombresNotas = new HashMap<String, Integer>();
  
  String[] figurasStrings = {"Semicorchea", "Corchea", "Negra", "Blanca", "Redonda"};
  String[] figurasNotas = {"DO-1", "RE-1", "MI-1", "FA-1", "SOL-1", "LA-1", "SI-1", "DO-2", "RE-2", "MI-2", "FA-2", "SOL-2", "LA-2", "SI-2"};
  String salida = "";
  
  JCheckBox silencio = new JCheckBox("Silencio", false);
  JCheckBox sostenido = new JCheckBox("Sostenido", false);
  JCheckBox bemol = new JCheckBox("Bemol", false);
  JComboBox cajaNotas = new JComboBox(figurasNotas);
  JComboBox cajaFiguras = new JComboBox(figurasStrings);
  JButton insertar = new JButton("Insertar");
  JButton borrar = new JButton("Borrar");
  JButton guardar = new JButton("Guardar como");
  JButton play = new JButton("Play!");
  
  
  
  public Escenario() {
    
    nombres.put("Negra", 0);
    nombres.put("Corchea", 1);
    nombres.put("Semicorchea", 2);
    nombres.put("Redonda", 3);
    nombres.put("Blanca", 4);
    nombres.put("silencio_Negra", 5);
    nombres.put("silencio_Corchea", 6);
    nombres.put("silencio_Semicorchea", 7);
    nombres.put("silencio_Redonda", 8);
    nombres.put("silencio_Blanca", 9);
    
    nombresNotas.put("DO-1", 0);
    nombresNotas.put("DO-1", 1);
    nombresNotas.put("RE-1", 2);
    nombresNotas.put("RE-1", 3);
    nombresNotas.put("RE-1", 4);
    nombresNotas.put("MI-1", 5);
    nombresNotas.put("MI-1", 6);
    nombresNotas.put("FA-1", 7);
    nombresNotas.put("FA-1", 8);
    nombresNotas.put("SOL-1", 9);
    nombresNotas.put("SOL-1", 10);
    nombresNotas.put("SOL-1", 11);
    nombresNotas.put("LA-1", 12);
    nombresNotas.put("LA-1", 13);
    nombresNotas.put("LA-1", 14);
    nombresNotas.put("SI-1", 15);
    nombresNotas.put("SI-1", 16);
    nombresNotas.put("DO-2", 17);
    nombresNotas.put("DO-2", 18);
    nombresNotas.put("RE-2", 19);
    nombresNotas.put("RE-2", 20);
    nombresNotas.put("RE-2", 21);
    nombresNotas.put("MI-2", 22);
    nombresNotas.put("MI-2", 23);
    nombresNotas.put("FA-2", 24);
    nombresNotas.put("FA-2", 25);
    nombresNotas.put("SOL-2", 26);
    nombresNotas.put("SOL-2", 27);
    nombresNotas.put("SOL-2", 28);
    nombresNotas.put("LA-2", 29);
    nombresNotas.put("LA-2", 30);
    nombresNotas.put("LA-2", 31);
    nombresNotas.put("SI-2", 32);
    nombresNotas.put("SI-2", 33);
    
    
    setSize(ANCHO_FRAME, ALTO_FRAME);
    JPanel panelBotones = new JPanel();
    //panelBotones.setLayout(new GridLayout(1, 2));
    

    
    cajaFiguras.setSelectedIndex(0);
    
    panelBotones.add(cajaNotas);
    panelBotones.add(cajaFiguras);
    panelBotones.add(insertar);
    silencio.setText("Silencio");
    panelBotones.add(silencio);
    sostenido.setText("Sostenido");
    panelBotones.add(sostenido);
    bemol.setText("Bemol");
    panelBotones.add(bemol);
    panelBotones.add(borrar);
    panelBotones.add(guardar);
    panelBotones.add(play);
    
    add(panelBotones, BorderLayout.NORTH);
    
    
    
    add(pentagrama);
    
    
    /**
     * Listeners
     */
    play.addActionListener(new ActionListener() {
      
      @Override
      public void actionPerformed(ActionEvent arg0) {
        
      for (int i = 0; i < vectorFiguras.size(); i++) {
        sonido.reproducirViolin(vectorFiguras.get(i));
      }
        
      }
    });
    
    insertar.addActionListener(new ActionListener() {
      
      @Override
      public void actionPerformed(ActionEvent arg0) {
        String imagenString = (String) cajaFiguras.getSelectedItem();
        if (silencio.isSelected())
          imagenString = "silencio_" + imagenString; // Si es silencio, especificamos que la imagen sea la del silencio
        Figura figura = new Figura(silencio.isSelected(), (String) cajaNotas.getSelectedItem(), sostenido.isSelected(), bemol.isSelected(), imagenString , 0);
        figura.setImagen(hashNotas.hash.get(imagenString));
        figura.setDuracionN(nombres.get(imagenString));
        //System.out.println(cajaNotas.getSelectedItem());
        figura.setTono(nombresNotas.get(cajaNotas.getSelectedItem()));
        vectorFiguras.add(figura); 
        repaint();
        silencio.setSelected(false);
        sostenido.setSelected(false);
        bemol.setSelected(false);
      }
    });
    
    borrar.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        if (vectorFiguras.size() >= 1) {
          vectorFiguras.remove(vectorFiguras.size() - 1);
          repaint();
          silencio.setSelected(false);
          sostenido.setSelected(false);
          bemol.setSelected(false);
        }
      }
    });
    
    guardar.addActionListener(new ActionListener() {
      JFileChooser fileChooser = new JFileChooser();
      
      @Override
      public void actionPerformed(ActionEvent arg0) {
        
        
        
        for (int i = 0; i < vectorFiguras.size(); i++) {
          String[] token = vectorFiguras.get(i).getNota().split("[-]");
          String figura = "";
          switch (nombres.get(vectorFiguras.get(i).getDuracion())) {
          case 0: figura = "N";
          break;
          case 1: figura = "C";
          break;
          case 2: figura = "SC";
          break;
          case 3: figura = "R";
          break;
          case 4: figura = "B";
          break;
          case 5: figura = "N";
          break;
          case 6: figura = "C";
          break;
          case 7: figura = "SC";
          break;
          case 8: figura = "R";
          break;
          case 9: figura = "B";
          break;
        }
          /*
          switch (vectorFiguras.get(i).getDuracion()) {
            case "Negra": figura = "N";
            break;
            case "Corchea": figura = "C";
            break;
            case "Semicorchea": figura = "SC";
            break;
            case "Redonda": figura = "R";
            break;
            case "Blanca": figura = "B";
            break;
            case "silencio_Negra": figura = "N";
            break;
            case "silencio_Corchea": figura = "C";
            break;
            case "silencio_Semicorchea": figura = "SC";
            break;
            case "silencio_Redonda": figura = "R";
            break;
            case "silencio_Blanca": figura = "B";
            break;
          } */
          if (vectorFiguras.get(i).isSostenido() ) 
            token[0] += "#";
          if (vectorFiguras.get(i).isBemol() ) 
            token[0] += "b";
          
          if (vectorFiguras.get(i).isSilencio())
            salida += (figura + ";");
          else
            salida += (token[0] + "-" + figura + "-" +token[1] + ";");
        }
        if (fileChooser.showSaveDialog(Escenario.this) == JFileChooser.APPROVE_OPTION) {
          File file = fileChooser.getSelectedFile();
          
          try {
            FileWriter writer = new FileWriter(file);
            writer.write(salida);   // Escribimos el fichero de salida para compilarlo 
            writer.close();
          } catch (IOException e) {
            e.printStackTrace();
          }
        }
        
      }
    });
  }
  
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.setColor(Color.WHITE);
    g.fillRect(0, 0, getWidth(), getHeight());
    g.setColor(new Color(238, 238, 238));
    g.fillRect(0, 0, getWidth(), 40);
    pentagrama.paintComponent(g);
    g.setColor(new Color (162, 162, 162));
    g.fillRect(0, 200, getWidth(), 150);
    for (int i = 0; i < vectorFiguras.size(); i++) {
      if (vectorFiguras.get(i).isSostenido()){
        //puntero -= 10;
        g.drawImage(hashNotas.hash.get("sostenido"), puntero, vectorFiguras.get(i).getPosicion() + 15, null);
        puntero += 20;
      }
      
      if (vectorFiguras.get(i).isBemol()){
        //puntero -= 10;
        g.drawImage(hashNotas.hash.get("bemol"), puntero, vectorFiguras.get(i).getPosicion() + 15, null);
        puntero += 20;  
      }
      
      vectorFiguras.get(i).paintComponent(g, puntero);
      
      puntero += 20;
    }
    puntero = 0;
    g.setColor(Color.BLACK);
    //g.drawString("Salida = " + salida, 10, 238);
  }

  public ArrayList<Figura> getVectorFiguras() {
    return vectorFiguras;
  }

  public void setVectorFiguras(ArrayList<Figura> vectorFiguras) {
    this.vectorFiguras = vectorFiguras;
  }  
}
