/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CambioColor;
import java.awt.Color;
/**
 *
 * @author rodri
 */
public class FiltrosColores extends CambiarColor{
    private Color NewColor;
    private boolean sepia=false;
    private boolean rojo=false;
    private boolean azul=false;
    private boolean verde=false;
     public FiltrosColores(String filename, String nombreFoto,boolean azul, boolean verde, boolean rojo, boolean sepia, String nombreColor) {
        super(filename,nombreColor+"-","colorR", nombreFoto);
        this.sepia=sepia;
        this.rojo=rojo;
        this.azul=azul;
        this.verde=verde;
}

@Override
    public void repintar(int i, int j, Color color) {
         if(sepia)
       NewColor =new Color((int)(0.4*color.getBlue()), (int)(0.23*color.getBlue()),(int)(0.16*color.getBlue()));
        if(rojo)
        NewColor = new Color(0, 0, color.getRed());    
        if(verde)
        NewColor = new Color(0, color.getGreen(), 0);  
        if(azul)
            NewColor=new Color(color.getBlue(),0,0);
        bmp.setRGB(i, j, NewColor.getRGB());
    }
}