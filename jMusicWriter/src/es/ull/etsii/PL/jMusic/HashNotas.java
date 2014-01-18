package es.ull.etsii.PL.jMusic;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;

public class HashNotas {
  public HashMap<String, BufferedImage> hash = new HashMap<String, BufferedImage>();   // Hash que almacena las imágenes dependiendo de la figura
  
  public HashNotas() {
    try {
      BufferedImage imagen = null;
      
      // Semicorchea
      imagen = ImageIO.read(new File("semicorchea.png"));
      hash.put("Semicorchea", imagen);
      
      // Corchea
      imagen = ImageIO.read(new File("corchea.png"));
      hash.put("Corchea", imagen);
      
      // Negra
      imagen = ImageIO.read(new File("negra.png"));
      hash.put("Negra", imagen);
      
      // Semicorchea
      imagen = ImageIO.read(new File("blanca.png"));
      hash.put("Blanca", imagen);
      
      // Semicorchea
      imagen = ImageIO.read(new File("redonda.png"));
      hash.put("Redonda", imagen);
      
      
      /**
       * SILENCIOS
       */
      
      imagen = ImageIO.read(new File("silencio_semicorchea.png"));
      hash.put("silencio_Semicorchea", imagen);
      
      // Corchea
      imagen = ImageIO.read(new File("silencio_corchea.png"));
      hash.put("silencio_Corchea", imagen);
      
      // Negra
      imagen = ImageIO.read(new File("silencio_negra.png"));
      hash.put("silencio_Negra", imagen);
      
      // Semicorchea
      imagen = ImageIO.read(new File("silencio_blanca.png"));
      hash.put("silencio_Blanca", imagen);
      
      // Semicorchea
      imagen = ImageIO.read(new File("silencio_redonda.png"));
      hash.put("silencio_Redonda", imagen);
      
      imagen = ImageIO.read(new File("sostenido.png"));
      hash.put("sostenido", imagen);
      
      imagen = ImageIO.read(new File("bemol.png"));
      hash.put("bemol", imagen);
      
    } catch (IOException e1) {
      System.out.println("Error al leer la imagen de figuras");
    }
  }
}
