/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ListasEnlazadas;
import Handlers.EstructuraDeDatos;
/**
 *
 * @author rodri
 */
public class Listas extends EstructuraDeDatos{
    private ListaImagen inicio;
    public Listas() {
    this.inicio = null;
}

 /* ********************************************************************** *
     * ********************************************************************** *
     * ********************************************************************** */
    @Override
    public void add(Object e) {
        /* Se convierte el parametro e de tipo objeto a ImagenP */
        ListaImagen newFolder = (ListaImagen)e;
        /* ****************************************************************** * 
          * Se verifica si ya existe la imagen en la lista                    *
          * Si ya existe la imagen la funcion find retornara algo diferente   *
          * de null por lo tanto no se agrega                                 *
          * ***************************************************************** */
        if(find(newFolder.getNombre())== null){
            /* Si es la primera imagen */
            if(this.index==0) addFirstImage(newFolder);
            else{
                /* *************************************************************** *
                  * Enlazamos el nuevo nodo usando como referencia el nodo inicial *
                  * Entonces decimos                                               *
                  *     - El nodo siguiente de la nueva imagen va a ser el         *
                  *       siguiente del nodo anterior de start                     *
                  *     - El nodo anterior de la nueva imagen va a ser el anterior *
                  *       del nodo start                                           *
                  * ************************************************************** */
                newFolder.setNextBack(inicio.getBack().getNext(), inicio.getBack());
                
                /* *********************************************************** *
                  * Si la lista solo tiene un elemento se debe cambia las      *
                  * referencias next y back del nodo inicial, colocando como   *
                  * back y next a la nueva imagen                              *
                  * ********************************************************** */
                if(index==1) inicio.setNextBack(newFolder, newFolder);
                /* *********************************************************** *
                  * Si existe mas de un elemento                               *
                  *     - Se cambia primero la referencia next del nodo        *
                  *       anterior del nodo start asignandole la nueva imagen  *
                  *     - Despues se cambia la referencia de back del nodo     *
                  *       Start asignandole la nueva imagen                    *
                  * ********************************************************** */
                else{
                    inicio.getBack().setNext(newFolder);
                    inicio.setBack(newFolder);
                }
                ImagenAgregada(nombre);
            }
        }
        /* Si ya existe se muentra un mensaje */
        else Mensaje("Ya existe un folder con el nombre "+ newFolder.getNombre());
    }

    private void addFirstImage(ListaImagen newFolder){
        /* ****************************************************************** *
         * Al ser el primer elemento de la lista y al ser una lista circular  *
         * se deben los apuntadores en esta caso hacia el mismo               *
         * ****************************************************************** * */
        newFolder.setNextBack(newFolder, newFolder);
        /* Ahora si asigna a start la nueva imagen ya que ahi inicia la lista */
        inicio = newFolder;
        ImagenAgregada(newFolder.getNombre());
    }
    
    private void ImagenAgregada(String nombre){
        Mensaje(nombre+" se agrego a la lista");
        this.index++;
    }

    /* ********************************************************************** *
     * ********************************************************************** *
     * ********************************************************************** */
    @Override
    public Object peek() {
        return null;
    }

    /* ********************************************************************** *
     * ********************************************************************** *
     * ********************************************************************** */
    @Override
    public Object find(Object e) {
        /* Seconvierte el objeto recibido a un String */
        String name = (String)e;
        /* Se crea un Nodo temporal que se usara para recorrer la lista */
        ListaImagen actual = inicio;
        /* Se recorre la lista usando un for usando como limite la cantidad de elementos en ella */
        for (int i = 0; i < index; i++) {
            /* ************************************************************** *
             * Se verifica si el nombre elemento analizdo son iguales con el  *
             * nombre ingresado si son iguales regresa el elemento            *
             * ************************************************************** */
            if(actual.getNombre().equals(name)) return actual;
            /* Si son diferentes se mueve al siguiente elemento */
            else actual = actual.getNext();
        }
        return null;
    }

    /* ********************************************************************** *
     * ********************************************************************** *
     * ********************************************************************** */
    @Override
    public Object getNext() {
        return null;
    }

    /* ********************************************************************** *
     * ********************************************************************** *
     * ********************************************************************** */
    @Override
    public int getSize() {
        return this.index;
    }

    /* ********************************************************************** *
     * ********************************************************************** *
     * ********************************************************************** */
    @Override
    public Object get(int i) {
        String [] Folders = new String[this.index];
        ListaImagen actual = inicio;
         for (int k = 0; k < index; k++) {
            
             Folders[k] = actual.getNombre();
             actual = actual.getNext();
            
        }
        
        return Folders;
    }

    /* ********************************************************************** *
     * ********************************************************************** *
     * ********************************************************************** */
    @Override
    public Object pop() {
        return null;
    }

    /* ********************************************************************** *
     * ********************************************************************** *
     * ********************************************************************** */
    @Override
    public void delete(Object e) {
        /* ********************************************************************
         * Se busca el elemento usando el metodo Find y asignandolo a una     *
         * variable de tipo objeto                                            *
         * ****************************************************************** */
        ListaImagen name = (ListaImagen)e;
        Object imagenAEliminar = find(name.getNombre());
        /* ********************************************************************
         * Se verifica que lo que se obtuvo es diferente de null para poder   *
         * convertirlo a nuestro nodo de tipo ImagenP                         *
         * ****************************************************************** */
        if(imagenAEliminar!=null){
            /* Se convierte el objeto a tipo ImagenP */
            ListaImagen actual = (ListaImagen)imagenAEliminar;
            /* ************************************************************** *
             * Si solo existe una imagen en la lista y se elimina solo se     *
             * reinicia la variable start con null                            *
             * ************************************************************** */
            if(index==1){
                
                inicio.setNext(null);
                inicio = null;
            }
            /* ************************************************************** *
             * Si existe mas de una imagen se deben cambiar los apuntadores   *
             * de la imagen anterior y siguiente del la imagen actual         *
             *  - Se le indica a la imagen anterior que su siguiente es la    *
             *    imagen siguiente de actual                                  *
             *  - Se le indica a la imagen siguiente que su anterior es la    *
             *    imagen anterior de actual                                   *
             * ************************************************************** */
            else{
                actual.getBack().setNext(actual.getNext());
                actual.getNext().setBack(actual.getBack());
            }
            Mensaje(actual.getNombre()+" se ha eliminado de la lista");
            /* Se reduce en uno la cantidad de elementos en la lista */
            index--;
        }        
        /* ******************************************************************* *
         * Si devuelve un valor null la imagen con el nombre buscado no existe *
         * Por lo que solo se mostrara un mensaje indicando eso                *
         * ******************************************************************* */
        else{
            if(index==0) Mensaje("Eliminacion: Lista vacia");
            else Mensaje((String)e+" no existe en la lista");
        }
    }

    /* ********************************************************************** *
     * ********************************************************************** *
     * ********************************************************************** */
    public void update(String name, String newName){
        
        /* ********************************************************************
         * Se busca el elemento usando el metodo Find y asignandolo a una     *
         * variable de tipo objeto                                            *
         * ****************************************************************** */
        Object imagenAEliminar = find(name);
        /* ********************************************************************
         * Se verifica que lo que se obtuvo es diferente de null para poder   *
         * convertirlo a nuestro nodo de tipo ImagenP                         *
         * ****************************************************************** */
        if(imagenAEliminar!=null){
            /* Se convierte el objeto a tipo ImagenP */
            ListaImagen actual = (ListaImagen)imagenAEliminar;
            actual.setNombre(newName);
            Mensaje(name+" actualizo el nombre");
        }
        else{
            if(index==0) Mensaje("Actualizacion: Lista vacia");
            else Mensaje(name+" no existe en la lista");
        }
    }
    
    /* ********************************************************************** *
     * ********************************************************************** *
     * ********************************************************************** */
    private void Mensaje(String m){
        System.out.println(m);
    }
}