/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto2;
import Interfaz.Biblioteca;
import Interfaz.Menu;
import ListasEnlazadas.ImagenP;
import ListasEnlazadas.ListaImagen;
import ListasEnlazadas.ListaUsuario;
/**
 *
 * @author rodri
 */
public class Proyecto2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         ListaUsuario us = new ListaUsuario();
        // TODO code application logic here
        Menu nuevo = new Menu();
        Biblioteca bib = new Biblioteca();
        nuevo.setListas(us);
        nuevo.setVisible(true);
         
    }
    
}
