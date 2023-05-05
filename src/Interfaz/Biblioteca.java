/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaz;

import Handlers.JPEGHandler;
import ListasEnlazadas.ImagenP;
import ListasEnlazadas.ListaImagen;
import ListasEnlazadas.ListaUsuario;
import ListasEnlazadas.Usuario;
import java.awt.Image;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;


/**
 *
 * @author rodri
 */
public class Biblioteca extends javax.swing.JFrame {
   private ListaUsuario nuevaListas;
   private ListaImagen  img;
   private String foto;
   private String NombreFoto;
   private Usuario usuarioRe;
   private String nombreFolder;   
    /**
     * Creates new form Biblioteca
     */
    public Biblioteca() {
        initComponents();
         setLocationRelativeTo(null);
    }

     public void setListas(ListaUsuario nuevaListas){
        this.nuevaListas = nuevaListas;
    }
     
    public void setUsuarios(String usuario){
        this.usuarioRe = (Usuario)nuevaListas.find(usuario);
        jLabel3.setText(usuarioRe.getNombre());
        actualizarcategorias();
    }
    
    private void actualizarcategorias(){
        DefaultListModel<String> listaC = new DefaultListModel<>();
        String [] Folder = (String[]) usuarioRe.getGaleria().get(0);
        System.out.println(Folder.length);
       
        for (int i = 0; i < Folder.length; i++) {
        listaC.addElement(Folder[i]);    
        }
        jList1.setModel(listaC);
    }
    
    private void mostrarImagen(JLabel cuadro, String ruta){
    
        if(!ruta.equals("")){
            Image img = new ImageIcon(ruta).getImage();
            img = img.getScaledInstance(488, 366   , Image.SCALE_SMOOTH);
            ImageIcon imgI = new ImageIcon(img);
            cuadro.setIcon(imgI);
        }
    }
    
    private ImagenP buscarImagen(){
    JFileChooser fc = new JFileChooser();
    FileNameExtensionFilter filtro = new FileNameExtensionFilter("jpg, jpeg, png", "jpg", "jpeg", "png");
    fc.setFileFilter(filtro);
    int resp = fc.showOpenDialog(this);
    if(resp==JFileChooser.APPROVE_OPTION){
    String nombre = fc.getSelectedFile().getName();
    String ubicacion = fc.getSelectedFile().getPath();
    return new ImagenP(nombre, ubicacion);
    }
    return null;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        img1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jList1.setBackground(new java.awt.Color(255, 204, 102));
        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jList1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jList1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 74, 137, 298));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Categorias");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 40, 100, -1));

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 380, 137, -1));

        jButton1.setBackground(new java.awt.Color(255, 255, 51));
        jButton1.setText("Agregar Categoria");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(169, 379, -1, -1));

        jButton2.setBackground(new java.awt.Color(153, 255, 153));
        jButton2.setText("Eliminar Categoria Seleccionada");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 422, 277, -1));

        jButton3.setBackground(new java.awt.Color(153, 255, 255));
        jButton3.setText("<");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 92, -1, 280));

        jButton4.setBackground(new java.awt.Color(153, 255, 255));
        jButton4.setText(">");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(787, 92, -1, 280));

        jButton5.setBackground(new java.awt.Color(153, 153, 255));
        jButton5.setText("Agregar Imagen");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 30, -1, -1));

        jButton6.setBackground(new java.awt.Color(255, 153, 255));
        jButton6.setText("Eliminar Imagen");
        jButton6.setToolTipText("");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 30, -1, -1));

        jButton8.setBackground(new java.awt.Color(255, 153, 153));
        jButton8.setText("Salir");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(773, 379, -1, -1));
        jPanel1.add(img1, new org.netbeans.lib.awtextra.AbsoluteConstraints(235, 94, 530, 270));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Nombre Imagen");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 70, 220, -1));

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("jLabel3");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nombre de Usuario:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(540, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addContainerGap(432, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 870, 480));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 873, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 475, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        Menu nuevo = new Menu();
        nuevo.setListas(nuevaListas);
        nuevo.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.nombreFolder = jTextField1.getText();
        if(camposLlenos()){
            usuarioRe.getGaleria().add(new ListaImagen(nombreFolder));
            actualizarcategorias();
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        try{
         img = (ListaImagen) usuarioRe.getGaleria().find(jList1.getSelectedValue());
        ImagenP actual = (ImagenP) img.getBackImage();
        if(actual!=null){
        jLabel4.setText(actual.getName());
        System.out.println(actual.getPath_());
        mostrarImagen(img1, actual.getPath_());
        }
        
        }catch(Exception e){
            mensaje("No hay imagen para mostrar");
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        try{
          img = (ListaImagen) usuarioRe.getGaleria().find(jList1.getSelectedValue());
        ImagenP actual = (ImagenP) img.getNextImage();
         if(actual!=null){
        jLabel4.setText(actual.getName());
        System.out.println(actual.getPath_());
        mostrarImagen(img1, actual.getPath_());}
        }catch(Exception e){
               mensaje("No hay imagen para mostrar");
         }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        try{
            if(jList1.getSelectedValue()!=null)agregarImageALista();
        
        
        }catch(Exception e){
            mensaje("Es necesario seleccionar una carpeta/categoria");
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
         try {
            if(!jLabel4.getText().equals("")){
                
          img = (ListaImagen) usuarioRe.getGaleria().find(jList1.getSelectedValue());
        
        ImagenP actual = (ImagenP) img.find(jLabel4.getText());
        
        String siguiente = actual.getNext().getPath_();
        String nombre = actual.getNext().getName();
                System.out.println("DATOS " + siguiente + nombre);
        img.delete(actual);
        
        if(actual.getNext()!= actual){
            
            jLabel4.setText(nombre);
            
            if(img.getSize()!=0)
            mostrarImagen(img1,siguiente);
            
            else{
            jLabel4.setText("");
            System.out.println("No hay imagen");
         this.img1.setIcon(null);
        }

        }

            }
           
        } catch (Exception e) {
            mensaje("No hay imagen que eliminar");
            
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jList1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList1MouseClicked
        // TODO add your handling code here:
        MostrarListaDeImagenes();
    }//GEN-LAST:event_jList1MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
         try{
        if(jList1.getSelectedValue()!=null){
                
        ListaImagen  fold = (ListaImagen) usuarioRe.getGaleria().find((String)jList1.getSelectedValue());
            System.out.println(fold.getNombre());
         usuarioRe.getGaleria().delete((Object)fold);
         actualizarcategorias();
         this.jLabel4.setText("");
         this.img1.setIcon(null);
         if(fold.getSize()!=0){
             jList1.setSelectedIndex(0);
            fold = (ListaImagen) usuarioRe.getGaleria().find((String)jList1.getSelectedValue());
            
            
         }else{
             mensaje("No hay mas folders para mostrar");
         }
        }
            
            
        }catch(Exception e){
             mensaje("No fue posible eliminar la carpeta/categoria\n debe seleccionar la carpeta a eliminar");
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    
     private void agregarImageALista(){
        ImagenP actual = buscarImagen();
        foto = actual.getPath_();
        
        if(!foto.equals(""))
        {
           img = (ListaImagen) usuarioRe.getGaleria().find(jList1.getSelectedValue());
            
            img.add(actual);
            MostrarListaDeImagenes();
        }
        
    }
     
     
     
     private boolean camposLlenos() {
        String msj = "";

        
        if (jTextField1.getText().isEmpty() || jTextField1.getText().equals(""))msj += "Nombre del folder necesario";

        
        if (!msj.equals("")) {
            mensaje(msj);
            return false;
        }
        return true;
    }
     
     
     private void mensaje(String mensaje){
        JOptionPane.showMessageDialog(null, mensaje);
    }
     
     
     
     /*private ImagenP buscarImagen(){
        JFileChooser fc = new JFileChooser();
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("jpg, jpeg, png", "jpg", "jpeg", "png");
        fc.setFileFilter(filtro);
        
        int resp = fc.showOpenDialog(this);
        if(resp==JFileChooser.APPROVE_OPTION){
            String nombre = fc.getSelectedFile().getName();
            String ubicacion = fc.getSelectedFile().getPath();
            return new ImagenP(nombre, ubicacion);
        }
        return null;
    }*/
     
     private void MostrarListaDeImagenes(){
              try{
            if(jList1.getSelectedValue()!=null){
                
          img = (ListaImagen) usuarioRe.getGaleria().find(jList1.getSelectedValue());
        ImagenP firstImage = (ImagenP)img.get(0);
        jLabel4.setText(firstImage.getName());
        mostrarImagen(img1, firstImage.getPath_());}
            
            
            else{
                this.jLabel4.setText("");
                this.img1.setIcon(null);
                
            }
        }catch(Exception e){
            
            System.out.println(e.getMessage());
        }
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Biblioteca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Biblioteca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Biblioteca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Biblioteca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Biblioteca().setVisible(true);
            }
        });
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel img1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}