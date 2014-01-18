package es.ull.etsii.PL.jMusic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;



import static es.ull.etsii.PL.jMusic.Constantes.*;

public class JMusicWriter extends JFrame {
  //private HashNotas hashNotas = new HashNotas();   // Hash con las notas y las imágenes
  public JMusicWriter() {
    setSize(ANCHO_FRAME, ALTO_FRAME);
    setVisible(true);
    setLocationRelativeTo(null);
    setTitle("jMusic Writer - Creador de canciones");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setResizable(true);
  }
  
  public static void main(String[] args) { 
    HashNotas hashNotas = new HashNotas();   // Hash con las notas y las imágenes
    JMusicWriter jwriter = new JMusicWriter();
    Escenario escenario = new Escenario();
    jwriter.add(escenario);
    
    String datos = "";
    try {
      BufferedReader reader = new BufferedReader(new FileReader(args[0]));
      while (reader.ready())
        datos += reader.readLine();
      reader.close();
    }
    catch (IOException ex) {
      System.out.println ("Error de lectura");
    }
    
    String[] dato = datos.split("[{]|[}]\\s");
    HashMap<Integer, String> nombres = new HashMap<Integer, String>();
    nombres.put(0, "DO-");
    nombres.put(1, "DO-");
    nombres.put(2, "RE-");
    nombres.put(3, "RE-");
    nombres.put(4, "RE-");
    nombres.put(5, "MI-");
    nombres.put(6, "MI-");
    nombres.put(7, "FA-");
    nombres.put(8, "FA-");
    nombres.put(9, "SOL-");
    nombres.put(10, "SOL-");
    nombres.put(11, "SOL-");
    nombres.put(12, "LA-");
    nombres.put(13, "LA-");
    nombres.put(14, "LA-");
    nombres.put(15, "SI-");
    nombres.put(16, "SI-");

    HashMap<Integer, String> nombresFiguras = new HashMap<Integer, String>();
    nombresFiguras.put(0, "Redonda");
    nombresFiguras.put(1, "Blanca");
    nombresFiguras.put(2, "Negra");
    nombresFiguras.put(3, "Corchea");
    nombresFiguras.put(4, "Semicorchea");
    
    ArrayList<Integer> sostenidos = new ArrayList<Integer>();
    sostenidos.add(1); 
    sostenidos.add(4);
    sostenidos.add(8);
    sostenidos.add(11);
    sostenidos.add(14);
    
    ArrayList<Integer> bemoles = new ArrayList<Integer>();
    bemoles.add(2); 
    bemoles.add(5);
    bemoles.add(9);
    bemoles.add(12);
    bemoles.add(15);
    
    for (int i = 0; i < dato.length; i++) {
       if (dato[i].length() >= 7) {
         String[] notaM = dato[i].split(",\\s");
         boolean sostenido = false;
         boolean bemol = false;
         if (sostenidos.contains(notaM[0]))
           sostenido = true;
         if (bemoles.contains(notaM[0]))
           bemol = true;                  
         Figura nota = new Figura(false, nombres.get(Integer.parseInt(notaM[0])) + notaM[2], sostenido, bemol, nombresFiguras.get(Integer.parseInt(notaM[1])), Integer.parseInt(notaM[2]));
         nota.setTono(Integer.parseInt(notaM[0]));
         nota.setDuracionN(Integer.parseInt(notaM[1]));
         nota.setEscala(Integer.parseInt(notaM[2]));
         String imagenString = nombresFiguras.get(Integer.parseInt(notaM[1]));
         nota.setImagen(hashNotas.hash.get(imagenString));
         System.out.println(imagenString);
         escenario.getVectorFiguras().add(nota);
       }
       else if (dato[i].length() >= 1 && dato[i].length() < 7) {
         Figura nota = new Figura(true, "", false, false, nombresFiguras.get(Integer.parseInt(dato[i])), 0);
         String imagenString = "silencio_" + nombresFiguras.get(Integer.parseInt(dato[i]));
         nota.setImagen(hashNotas.hash.get(imagenString));
         nota.setSilencio(true);
         nota.setDuracionN(Integer.parseInt(dato[i]));
         escenario.getVectorFiguras().add(nota);
       }
       escenario.repaint();
    }
    
    System.out.println(escenario.getVectorFiguras().size());
    
    escenario.validate();
    escenario.repaint();
  }
}
