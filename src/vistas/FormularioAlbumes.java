//Esta clase se encargaba solamente de gestionar a los artistas

package vistas;

import modelo.*;

public class FormularioAlbumes extends javax.swing.JInternalFrame {

    private Spotify s = null;
    
    public FormularioAlbumes(Spotify s) {
        this.s = s;
        initComponents();
        this.lstAlbumes.setListData(this.s.getAlbumes().toArray());

        for (Artista a : this.s.getArtistas()){
            this.cmbArtistas.addItem(a);
        }
            
        this.cmbArtistas.setSelectedItem(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        lstAlbumes = new javax.swing.JList();
        jLabel1 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        btnEliminar = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        cmbArtistas = new javax.swing.JComboBox();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Gestion de albumes");
        getContentPane().setLayout(null);

        lstAlbumes.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lstAlbumes.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstAlbumesValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(lstAlbumes);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(0, 0, 140, 274);

        jLabel1.setText("Nombre");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(150, 10, 50, 16);
        getContentPane().add(txtNombre);
        txtNombre.setBounds(150, 30, 240, 22);

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEliminar);
        btnEliminar.setBounds(310, 160, 75, 22);

        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        getContentPane().add(btnNuevo);
        btnNuevo.setBounds(150, 160, 72, 22);

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        getContentPane().add(btnGuardar);
        btnGuardar.setBounds(230, 160, 75, 22);

        jLabel2.setText("Artista");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(150, 60, 37, 16);

        getContentPane().add(cmbArtistas);
        cmbArtistas.setBounds(150, 80, 240, 22);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        if(!this.lstAlbumes.isSelectionEmpty()){
            Album al = (Album) this.lstAlbumes.getSelectedValue();
            this.s.eliminarAlbum(al);
        }
        
        limpiar();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        limpiar();
        
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if(this.lstAlbumes.isSelectionEmpty()){
            this.s.crearAlbum(this.txtNombre.getText(), (Artista) this.cmbArtistas.getSelectedItem());
        }else{
            Album al = (Album) this.lstAlbumes.getSelectedValue();
            this.s.modificarAlbum(al, this.txtNombre.getText(), (Artista) this.cmbArtistas.getSelectedItem());
        }
        
        limpiar();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void lstAlbumesValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstAlbumesValueChanged
        if(! this.lstAlbumes.isSelectionEmpty()){//Esto me devuelve si no hay nada seleccionado en el listado
            Album al = (Album) this.lstAlbumes.getSelectedValue();
            this.txtNombre.setText(al.getNombre());//obtengo el nombre del artista y lo pongo en la caja de texto
            this.cmbArtistas.setSelectedItem(al.getArtista());
        }
    }//GEN-LAST:event_lstAlbumesValueChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JComboBox cmbArtistas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList lstAlbumes;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables


    private void limpiar(){
        this.txtNombre.setText("");
        System.out.println("Refrescando...");
        Spotify.getPersistencia().refrescar(this.s);
        System.out.println("Refrecado");
        
        this.lstAlbumes.setListData(this.s.getAlbumes().toArray());
        this.lstAlbumes.clearSelection();
    
    
    }
    
    
    
    
    
    
}