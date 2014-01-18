package es.ull.etsii.PL.jMusic;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.HashMap;

import javax.swing.JPanel;

import static es.ull.etsii.PL.jMusic.Constantes.*;

public class Figura extends JPanel {   //DO-N-1    Do negra 1 escala, osea el DO grave
  private String nota;            // Nota ( DO, RE, MI, FA, SOL, LA, SI )
  private boolean silencio;       // True si se trata de un silencio
  private boolean sostenido;      // True si es sostenido
  private boolean bemol;          // True si es bemol
  private String duracion;        // Tipo de figura, N (negra) etc.
  private int escala;             // Escala grave o aguda
  private BufferedImage imagen;   // Imagen de la figura
  private int posicion;           // Indica la posición 
  private int tono;
  private int duracionN;
  private HashMap<String, Integer> nombres = new HashMap<String, Integer>(); // String Integer notas

  public Figura(boolean silencio, String nota, boolean sostenido, boolean bemol, String duracion, int escala) {
    setSilencio(silencio);
    setNota(nota);
    setSostenido(sostenido);
    setBemol(bemol);
    setDuracion(duracion);
    setEscala(escala);
    //System.out.println(nota);
    nombres.put("DO-1", 0);
    nombres.put("RE-1", 1);
    nombres.put("MI-1", 2);
    nombres.put("FA-1", 3);
    nombres.put("SOL-1", 4);
    nombres.put("LA-1", 5);
    nombres.put("SI-1", 6);
    nombres.put("DO-2", 7);
    nombres.put("RE-2", 8);
    nombres.put("MI-2", 9);
    nombres.put("FA-2", 10);
    nombres.put("SOL-2", 11);
    nombres.put("LA-2", 12);
    nombres.put("SI-2", 13);
    
    if (silencio) { // Posicion en el eje Y 
      setPosicion(PENTAGRAMA_Y - 10);
    } else {  // Si no es silencio, la posición Y vendrá dada dependiendo de la nota de las 2 escalas que sea (14 posiciones)
      switch (nombres.get(nota)) {
      case 0: setPosicion(PENTAGRAMA_Y + 18);
      break;
      case 1: setPosicion(PENTAGRAMA_Y + 12);
      break;
      case 2: setPosicion(PENTAGRAMA_Y + 6);
      break;
      case 3: setPosicion(PENTAGRAMA_Y - 2);
      break;
      case 4: setPosicion(PENTAGRAMA_Y - 8);
      break;
      case 5: setPosicion(PENTAGRAMA_Y - 18);
      break;
      case 6: setPosicion(PENTAGRAMA_Y - 26);
      break;
      case 7: setPosicion(PENTAGRAMA_Y - 34);
      break;
      case 8: setPosicion(PENTAGRAMA_Y - 42);
      break;
      case 9: setPosicion(PENTAGRAMA_Y - 48);
      break;
      case 10: setPosicion(PENTAGRAMA_Y - 56);
      break;
      case 11: setPosicion(PENTAGRAMA_Y - 62);
      break;
      case 12: setPosicion(PENTAGRAMA_Y - 68);
      break;
      case 13: setPosicion(PENTAGRAMA_Y - 74);
      break;
    }
      /* switch (nota) {
        case "DO-1": setPosicion(PENTAGRAMA_Y + 18);
        break;
        case "RE-1": setPosicion(PENTAGRAMA_Y + 12);
        break;
        case "MI-1": setPosicion(PENTAGRAMA_Y + 6);
        break;
        case "FA-1": setPosicion(PENTAGRAMA_Y - 2);
        break;
        case "SOL-1": setPosicion(PENTAGRAMA_Y - 8);
        break;
        case "LA-1": setPosicion(PENTAGRAMA_Y - 18);
        break;
        case "SI-1": setPosicion(PENTAGRAMA_Y - 26);
        break;
        case "DO-2": setPosicion(PENTAGRAMA_Y - 34);
        break;
        case "RE-2": setPosicion(PENTAGRAMA_Y - 42);
        break;
        case "MI-2": setPosicion(PENTAGRAMA_Y - 48);
        break;
        case "FA-2": setPosicion(PENTAGRAMA_Y - 56);
        break;
        case "SOL-2": setPosicion(PENTAGRAMA_Y - 62);
        break;
        case "LA-2": setPosicion(PENTAGRAMA_Y - 68);
        break;
        case "SI-2": setPosicion(PENTAGRAMA_Y - 74);
        break;
      }*/
    }
  }
  
  public void setPosicion() {
    posicion = 100;
  }
  
  protected void paintComponent(Graphics g, int x) {
    super.paintComponent(g);
    
    g.drawImage(imagen, x, posicion, null);

  }
  
  /** Getter del atributo sostenido
   * @return sostenido
   */
  public boolean isSostenido() {
    return sostenido;
  }

  /** Setter del atributo sostenido
   * @param sostenido 
   */
  public void setSostenido(boolean sostenido) {
    this.sostenido = sostenido;
  }

  /** Getter del atributo duracion
   * @return duracion
   */
  public String getDuracion() {
    return duracion;
  }

  /** Setter del atributo duracion
   * @param duracion 
   */
  public void setDuracion(String duracion) {
    this.duracion = duracion;
  }

  /** Getter del atributo escala
   * @return escala
   */
  public int getEscala() {
    return escala;
  }

  /** Setter del atributo escala
   * @param escala 
   */
  public void setEscala(int escala) {
    this.escala = escala;
  }

  
  /** Getter del atributo nota
   * @return nota
   */
  public String getNota() {
    return nota;
  }
  
  /** Setter del atributo nota
   * @param nota 
   */
  public void setNota(String nota) {
    this.nota = nota;
  }
  
  /** Getter del atributo silencio
   * @return silencio
   */
  public boolean isSilencio() {
    return silencio;
  }
  
  /** Setter del atributo silencio
   * @param silencio 
   */
  public void setSilencio(boolean silencio) {
    this.silencio = silencio;
  }



  /** Getter del atributo bemol
   * @return bemol
   */
  public boolean isBemol() {
    return bemol;
  }



  /** Setter del atributo bemol
   * @param bemol 
   */
  public void setBemol(boolean bemol) {
    this.bemol = bemol;
  }



  /** Getter del atributo imagen
   * @return imagen
   */
  public BufferedImage getImagen() {
    return imagen;
  }



  /** Setter del atributo imagen
   * @param imagen 
   */
  public void setImagen(BufferedImage imagen) {
    this.imagen = imagen;
  }



  /** Getter del atributo posicion
   * @return posicion
   */
  public int getPosicion() {
    return posicion;
  }



  /** Setter del atributo posicion
   * @param posicion 
   */
  public void setPosicion(int posicion) {
    this.posicion = posicion;
  }


  public int getTono() {
    return tono;
  }

  public void setTono(int tono) {
    this.tono = tono;
  }

  public int getDuracionN() {
    return duracionN;
  }

  public void setDuracionN(int duracionN) {
    this.duracionN = duracionN;
  }

  /** Getter de nombres */
  public HashMap<String, Integer> getNombres() {
    return nombres;
  }

  /** Setter de nombres */
  public void setNombres(HashMap<String, Integer> nombres) {
    this.nombres = nombres;
  } 
}
