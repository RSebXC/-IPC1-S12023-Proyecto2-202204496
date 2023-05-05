
package ListasEnlazadas;


public class Usuario {
    private String nombre;
    private Listas galeria;
    private Usuario next;
    private Usuario back;

    public Usuario(String nombre, Usuario next, Usuario back) {
        this.nombre = nombre;
        this.galeria =  new Listas();
        
        this.next = next;
        this.back = back;
    }

    public Usuario(String nombre) {
        this.nombre = nombre;
        this.galeria =  new Listas();
        this.galeria.add(new ListaImagen("General"));
    }
    
    public void CrearFolder(String nombre){
        this.galeria.add(new ListaImagen(nombre));
    }
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Listas getGaleria() {
        return galeria;
    }

    public void setGaleria(Listas galeria) {
        this.galeria = galeria;
    }

    public Usuario getNext() {
        return next;
    }

    public void setNext(Usuario next) {
        this.next = next;
    }

    public Usuario getBack() {
        return back;
    }

    public void setBack(Usuario back) {
        this.back = back;
    }
       public void setNextBack(Usuario next, Usuario back){
        this.next = next;
        this.back = back;
    }
    

}
