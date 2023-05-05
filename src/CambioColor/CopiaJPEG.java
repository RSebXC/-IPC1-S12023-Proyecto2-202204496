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
public class CopiaJPEG extends CambiarColor{
    public CopiaJPEG(String filename, String nombreFoto) {
    super(filename,"copia-","ELIMINATEDBMP-", nombreFoto);
    }
    @Override
    public void repintar(int i, int j, Color color) {
    }
}
