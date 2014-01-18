/**
 * Práctica
 *
 *
 * @autor Oliver Valido Ramos
 * @date 13/05/2013
 */
package es.ull.etsii.PL.jMusic;

import java.applet.AudioClip;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.JApplet;

public class Sonidos {
  private ArrayList<AudioClip> sonidosGuitar = new ArrayList<AudioClip>();
  private ArrayList<AudioClip> sonidosPiano = new ArrayList<AudioClip>();
  private ArrayList<AudioClip> sonidosViolin = new ArrayList<AudioClip>();
  
  public Sonidos() {
    cargarSonidos();
  }
  
  public void reproducirGuitarra(Figura nota) {
    if (nota.getEscala() == 2)
      nota.setTono(nota.getTono() + 17);
    int delay = 0;
    switch (nota.getDuracionN()) {
      case 0: delay = 1000; break;   //Redonda
      case 1: delay = 500; break;   //Blanca
      case 2: delay = 250; break;    //Negra
      case 3: delay = 175; break;    //Corchea
      case 4: delay = 87; break;    //Semicorchea
    }
    if (!nota.isSilencio())
      getSonidosGuitar().get(nota.getTono()).play();
    try{
      Thread.sleep(delay);
    }
    catch(Exception ie){
    }
    if (!nota.isSilencio())
      getSonidosGuitar().get(nota.getTono()).stop();
  }
  
  public void reproducirPiano(Figura nota) {
    if (nota.getEscala() == 2)
      nota.setTono(nota.getTono() + 17);
    int delay = 0;
    switch (nota.getDuracionN()) {
      case 0: delay = 1000; break;   //Redonda
      case 1: delay = 500; break;   //Blanca
      case 2: delay = 250; break;    //Negra
      case 3: delay = 175; break;    //Corchea
      case 4: delay = 87; break;    //Semicorchea
    }
    if (!nota.isSilencio())
      getSonidosPiano().get(nota.getTono()).play();
    try{
      Thread.sleep(delay);
    }
    catch(Exception ie){
    }
    getSonidosPiano().get(nota.getTono()).stop();
  }
  
  public void reproducirViolin(Figura nota) {
    if (nota.getEscala() == 2)
      nota.setTono(nota.getTono() + 17);
    int delay = 0;
    switch (nota.getDuracionN()) {
      case 0: delay = 1000; break;   //Redonda
      case 1: delay = 500; break;   //Blanca
      case 2: delay = 250; break;    //Negra
      case 3: delay = 175; break;    //Corchea
      case 4: delay = 87; break;    //Semicorchea
    }
    if (!nota.isSilencio())
      getSonidosViolin().get(nota.getTono()).play();
    try{
      Thread.sleep(delay);
    }
    catch(Exception ie){
    }
    getSonidosViolin().get(nota.getTono()).stop();
  }
  
  public void cargarSonidos() {
    //Cargamos todas los sonidos en el array en orden
    for (int  i = 2; i <= 3; i++) {
      File archivoG = new File("Guitarra/DO" + i + ".mid");
      File archivoP = new File("Piano/DO" + i + ".mid");
      File archivoV = new File("Violin/DO" + i + ".mid");
      URL audioG;
      URL audioP;
      URL audioV;
      try {
        audioG = archivoG.toURI().toURL();
        audioP = archivoP.toURI().toURL();
        audioV = archivoV.toURI().toURL();
        AudioClip notaG = JApplet.newAudioClip(audioG);
        AudioClip notaP = JApplet.newAudioClip(audioP);
        AudioClip notaV = JApplet.newAudioClip(audioV);
        getSonidosGuitar().add(notaG);
        getSonidosPiano().add(notaP);
        getSonidosViolin().add(notaV);
      } catch (MalformedURLException e) {
        e.printStackTrace();
        System.out.println("problemita");
      }
      archivoG = new File("Guitarra/DO" + i + "S.mid");
      archivoP = new File("Piano/DO" + i + "S.mid");
      archivoV = new File("Violin/DO" + i + "S.mid");
      try {
        audioG = archivoG.toURI().toURL();
        audioP = archivoP.toURI().toURL();
        audioV = archivoV.toURI().toURL();
        AudioClip notaG = JApplet.newAudioClip(audioG);
        AudioClip notaP = JApplet.newAudioClip(audioP);
        AudioClip notaV = JApplet.newAudioClip(audioV);
        getSonidosGuitar().add(notaG);
        getSonidosPiano().add(notaP);
        getSonidosViolin().add(notaV);
        getSonidosGuitar().add(notaG);
        getSonidosPiano().add(notaP);
        getSonidosViolin().add(notaV);
      } catch (MalformedURLException e) {
        e.printStackTrace();
      }
      archivoG = new File("Guitarra/RE" + i + ".mid");
      archivoP = new File("Piano/RE" + i + ".mid");
      archivoV = new File("Violin/RE" + i + ".mid");
      try {
        audioG = archivoG.toURI().toURL();
        audioP = archivoP.toURI().toURL();
        audioV = archivoV.toURI().toURL();
        AudioClip notaG = JApplet.newAudioClip(audioG);
        AudioClip notaP = JApplet.newAudioClip(audioP);
        AudioClip notaV = JApplet.newAudioClip(audioV);
        getSonidosGuitar().add(notaG);
        getSonidosPiano().add(notaP);
        getSonidosViolin().add(notaV);
      } catch (MalformedURLException e) {
        e.printStackTrace();
      }
      archivoG = new File("Guitarra/RE" + i + "S.mid");
      archivoP = new File("Piano/RE" + i + "S.mid");
      archivoV = new File("Violin/RE" + i + "S.mid");
      try {
        audioG = archivoG.toURI().toURL();
        audioP = archivoP.toURI().toURL();
        audioV = archivoV.toURI().toURL();
        AudioClip notaG = JApplet.newAudioClip(audioG);
        AudioClip notaP = JApplet.newAudioClip(audioP);
        AudioClip notaV = JApplet.newAudioClip(audioV);
        getSonidosGuitar().add(notaG);
        getSonidosPiano().add(notaP);
        getSonidosViolin().add(notaV);
        getSonidosGuitar().add(notaG);
        getSonidosPiano().add(notaP);
        getSonidosViolin().add(notaV);
      } catch (MalformedURLException e) {
        e.printStackTrace();
      }
      archivoG = new File("Guitarra/MI" + i + ".mid");
      archivoP = new File("Piano/MI" + i + ".mid");
      archivoV = new File("Violin/MI" + i + ".mid");
      try {
        audioG = archivoG.toURI().toURL();
        audioP = archivoP.toURI().toURL();
        audioV = archivoV.toURI().toURL();
        AudioClip notaG = JApplet.newAudioClip(audioG);
        AudioClip notaP = JApplet.newAudioClip(audioP);
        AudioClip notaV = JApplet.newAudioClip(audioV);
        getSonidosGuitar().add(notaG);
        getSonidosPiano().add(notaP);
        getSonidosViolin().add(notaV);
      } catch (MalformedURLException e) {
        e.printStackTrace();
      }
      archivoG = new File("Guitarra/FA" + i + ".mid");
      archivoP = new File("Piano/FA" + i + ".mid");
      archivoV = new File("Violin/FA" + i + ".mid");
      try {
        audioG = archivoG.toURI().toURL();
        audioP = archivoP.toURI().toURL();
        audioV = archivoV.toURI().toURL();
        AudioClip notaG = JApplet.newAudioClip(audioG);
        AudioClip notaP = JApplet.newAudioClip(audioP);
        AudioClip notaV = JApplet.newAudioClip(audioV);
        getSonidosGuitar().add(notaG);
        getSonidosPiano().add(notaP);
        getSonidosViolin().add(notaV);
      } catch (MalformedURLException e) {
        e.printStackTrace();
      }
      archivoG = new File("Guitarra/FA" + i + "S.mid");
      archivoP = new File("Piano/FA" + i + "S.mid");
      archivoV = new File("Violin/FA" + i + "S.mid");
      try {
        audioG = archivoG.toURI().toURL();
        audioP = archivoP.toURI().toURL();
        audioV = archivoV.toURI().toURL();
        AudioClip notaG = JApplet.newAudioClip(audioG);
        AudioClip notaP = JApplet.newAudioClip(audioP);
        AudioClip notaV = JApplet.newAudioClip(audioV);
        getSonidosGuitar().add(notaG);
        getSonidosPiano().add(notaP);
        getSonidosViolin().add(notaV);
        getSonidosGuitar().add(notaG);
        getSonidosPiano().add(notaP);
        getSonidosViolin().add(notaV);
      } catch (MalformedURLException e) {
        e.printStackTrace();
      }
      archivoG = new File("Guitarra/SOL" + i + ".mid");
      archivoP = new File("Piano/SOL" + i + ".mid");
      archivoV = new File("Violin/SOL" + i + ".mid");
      try {
        audioG = archivoG.toURI().toURL();
        audioP = archivoP.toURI().toURL();
        audioV = archivoV.toURI().toURL();
        AudioClip notaG = JApplet.newAudioClip(audioG);
        AudioClip notaP = JApplet.newAudioClip(audioP);
        AudioClip notaV = JApplet.newAudioClip(audioV);
        getSonidosGuitar().add(notaG);
        getSonidosPiano().add(notaP);
        getSonidosViolin().add(notaV);
      } catch (MalformedURLException e) {
        e.printStackTrace();
      }
      archivoG = new File("Guitarra/SOL" + i + "S.mid");
      archivoP = new File("Piano/SOL" + i + "S.mid");
      archivoV = new File("Violin/SOL" + i + "S.mid");
      try {
        audioG = archivoG.toURI().toURL();
        audioP = archivoP.toURI().toURL();
        audioV = archivoV.toURI().toURL();
        AudioClip notaG = JApplet.newAudioClip(audioG);
        AudioClip notaP = JApplet.newAudioClip(audioP);
        AudioClip notaV = JApplet.newAudioClip(audioV);
        getSonidosGuitar().add(notaG);
        getSonidosPiano().add(notaP);
        getSonidosViolin().add(notaV);
        getSonidosGuitar().add(notaG);
        getSonidosPiano().add(notaP);
        getSonidosViolin().add(notaV);
      } catch (MalformedURLException e) {
        e.printStackTrace();
      }
      archivoG = new File("Guitarra/LA" + i + ".mid");
      archivoP = new File("Piano/LA" + i + ".mid");
      archivoV = new File("Violin/LA" + i + ".mid");
      try {
        audioG = archivoG.toURI().toURL();
        audioP = archivoP.toURI().toURL();
        audioV = archivoV.toURI().toURL();
        AudioClip notaG = JApplet.newAudioClip(audioG);
        AudioClip notaP = JApplet.newAudioClip(audioP);
        AudioClip notaV = JApplet.newAudioClip(audioV);
        getSonidosGuitar().add(notaG);
        getSonidosPiano().add(notaP);
        getSonidosViolin().add(notaV);
      } catch (MalformedURLException e) {
        e.printStackTrace();
      }
      archivoG = new File("Guitarra/LA" + i + "S.mid");
      archivoP = new File("Piano/LA" + i + "S.mid");
      archivoV = new File("Violin/LA" + i + "S.mid");
      try {
        audioG = archivoG.toURI().toURL();
        audioP = archivoP.toURI().toURL();
        audioV = archivoV.toURI().toURL();
        AudioClip notaG = JApplet.newAudioClip(audioG);
        AudioClip notaP = JApplet.newAudioClip(audioP);
        AudioClip notaV = JApplet.newAudioClip(audioV);
        getSonidosGuitar().add(notaG);
        getSonidosPiano().add(notaP);
        getSonidosViolin().add(notaV);
        getSonidosGuitar().add(notaG);
        getSonidosPiano().add(notaP);
        getSonidosViolin().add(notaV);
      } catch (MalformedURLException e) {
        e.printStackTrace();
      }
      archivoG = new File("Guitarra/SI" + i + ".mid");
      archivoP = new File("Piano/SI" + i + ".mid");
      archivoV = new File("Violin/SI" + i + ".mid");
      try {
        audioG = archivoG.toURI().toURL();
        audioP = archivoP.toURI().toURL();
        audioV = archivoV.toURI().toURL();
        AudioClip notaG = JApplet.newAudioClip(audioG);
        AudioClip notaP = JApplet.newAudioClip(audioP);
        AudioClip notaV = JApplet.newAudioClip(audioV);
        getSonidosGuitar().add(notaG);
        getSonidosPiano().add(notaP);
        getSonidosViolin().add(notaV);
      } catch (MalformedURLException e) {
        e.printStackTrace();
      }
    }
  }
  
  /** Getter de sonidosGuitar */
  public ArrayList<AudioClip> getSonidosGuitar() {
    return sonidosGuitar;
  }

  /** Setter de sonidosGuitar */
  public void setSonidosGuitar(ArrayList<AudioClip> sonidosGuitar) {
    this.sonidosGuitar = sonidosGuitar;
  }

  /** Getter de sonidosPiano */
  public ArrayList<AudioClip> getSonidosPiano() {
    return sonidosPiano;
  }

  /** Setter de sonidosPiano */
  public void setSonidosPiano(ArrayList<AudioClip> sonidosPiano) {
    this.sonidosPiano = sonidosPiano;
  }

  /** Getter de sonidosViolin */
  public ArrayList<AudioClip> getSonidosViolin() {
    return sonidosViolin;
  }

  /** Setter de sonidosViolin */
  public void setSonidosViolin(ArrayList<AudioClip> sonidosViolin) {
    this.sonidosViolin = sonidosViolin;
  }
}
