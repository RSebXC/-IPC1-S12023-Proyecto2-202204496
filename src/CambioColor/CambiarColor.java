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


public abstract class CambiarColor extends ImageHandler{
    BufferedImage jpg;
    BufferedImage bmp;
    File tmp;
    File Nuevojpg;
    String nombre;
    String nameBmp;
    String nameColor;
    String nombreFoto;
    String modificado;
    boolean copiaBmp=false;
    boolean copiaJpeg=false;
    
    public CambiarColor(String filename, String nameColor, String nameBmp,String nombreFoto) {
        super(filename);
        this.jpg = null;
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
    }

    @Override
    public void generateFiles() throws Exception {
        for (int i = 0; i < bmp.getWidth(); i++) {
            for (int j = 0; j < bmp.getHeight(); j++) {
                Color color = new Color(bmp.getRGB(i, j));
                repintar(i, j, color);
            }
        }
        
        Nuevojpg= new File("./Imagen/"+nameColor+modificado+".jpg");
        ImageIO.write(bmp, "jpg", Nuevojpg);
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
    
    public abstract void repintar(int i, int j, Color color);
 
    public void setCopiaBmp(boolean copiaBmp) {
        this.copiaBmp = copiaBmp;
    }

    public void setCopiaJpeg(boolean copiaJpeg) {
        this.copiaJpeg = copiaJpeg;
    }
}
