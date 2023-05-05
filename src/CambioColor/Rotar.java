/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CambioColor;

import Handlers.ImageHandler;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

/**
 *
 * @author rodri
 */
public class Rotar extends ImageHandler{
     BufferedImage jpg;
     BufferedImage bmp;
    BufferedImage bmpH;
    BufferedImage bmpV;
    File tmp;
    File Nuevojpg;
    String nombre;
    String nameBmp;
    String nameColor;
    String nombreFoto;
    String modificado;
    boolean copiaBmp=false;
    boolean copiaJpeg=false;
    
    
    
    public Rotar(String filename,String nombreFoto) {
        super(filename);
        this.jpg = null;
        this.bmpH = null;
        this.bmpV = null;
        this.bmp = null;
        this.tmp = new File(getFileName());
        this.nombre = filename;
        this.nameColor=nameColor;
        this.nameBmp=nameBmp;
        this.nombreFoto = nombreFoto;
        modificado = nombreFoto.substring(0, nombreFoto.length() - 4);
    }

    @Override
    public void readFile() throws Exception {
        File file = new File(getFileName());
        jpg = ImageIO.read(file);
        tmp = new File("./Temp/"+nameBmp+modificado+".bmp");
        ImageIO.write(jpg, "bmp", tmp);
        bmp = ImageIO.read(tmp);
        bmpH = ImageIO.read(tmp);
        bmpV = ImageIO.read(tmp);
    }

    @Override
    public void generateFiles() throws Exception {
        int k = 0;
        
        for (int i = 0; i < bmp.getWidth(); i++) {
            k=0;
            for (int j = bmp.getHeight()-1; j > -1; j--) {
                Color color = new Color(bmp.getRGB(i, j));
                bmpV.setRGB(i, k++, color.getRGB());
                //repintar(i, j, color);
            }
        }
        nameColor = "Hrotation-";
        Nuevojpg= new File("./Imagen/"+nameColor+modificado+".jpg");
        ImageIO.write(bmpV, "jpg", Nuevojpg);
        
        
        
        for (int j = 0; j < bmp.getHeight(); j++){
            k=0;
            for (int i = bmp.getWidth()-1; i > -1; i-- ) {
                Color color = new Color(bmp.getRGB(i, j));
                bmpH.setRGB(k++, j, color.getRGB());
                //repintar(i, j, color);
            }
        }
        nameColor = "Vrotatio-";
        Nuevojpg= new File("./Imagen/"+nameColor+modificado+".jpg");
        ImageIO.write(bmpH, "jpg", Nuevojpg);
        delete();
    }
    
    public void delete(){
        if(copiaBmp){
            this.tmp.delete();
        }
        if(copiaJpeg){
            this.Nuevojpg.delete();
        }
    }
    
    
 
    public void setCopiaBmp(boolean copiaBmp) {
        this.copiaBmp = copiaBmp;
    }

    public void setCopiaJpeg(boolean copiaJpeg) {
        this.copiaJpeg = copiaJpeg;
    }
    
}
