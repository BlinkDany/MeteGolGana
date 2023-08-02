/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import LIB.FSButtonMD;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;

/**
 *
 * @author tatip
 */
public class MenuPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form MenuPrincipal
     */
    public MenuPrincipal() {
        initComponents();

    }

    public JButton getBtnEstadios() {
        return btnEstadios;
    }

    public void setBtnEstadios(JButton btnEstadios) {
        this.btnEstadios = btnEstadios;
    }

    public JButton getBtnEntrenador() {
        return btnEntrenador;
    }

    public JButton getBtncerrarsesion() {
        return btncerrarsesion;
    }

    public void setBtnEntrenador(JButton btnEntrenador) {
        this.btnEntrenador = btnEntrenador;
    }

    public JButton getBtnCampeonato() {
        return btnCampeonato;
    }

    public JButton getBtnResumen() {
        return btnResumen;
    }

    public void setBtnResumen(JButton btnResumen) {
        this.btnResumen = btnResumen;
    }

    public void setBtnCampeonato(JButton btnCampeonato) {
        this.btnCampeonato = btnCampeonato;
    }

    public JButton getBtnEquipos() {
        return BtnEquipos;
    }

    public JButton getBtnGoles() {
        return BtnGoles;
    }

    public JButton getBtnTemporada() {
        return btnTemporada;
    }

    public void setBtnTemporada(JButton btnTemporada) {
        this.btnTemporada = btnTemporada;
    }

    public JDesktopPane getDesctopPrincipal() {
        return desctopPrincipal;
    }

    public void setDesctopPrincipal(JDesktopPane desctopPrincipal) {
        this.desctopPrincipal = desctopPrincipal;
    }

    public JButton getBtnJugadores() {
        return btnJugadores;
    }

    public void setBtnJugadores(JButton btnJugadores) {
        this.btnJugadores = btnJugadores;
    }

    public void setBtnJugadores(FSButtonMD btnJugadores) {
        this.btnJugadores = btnJugadores;
    }

    public JMenuItem getjMenuItem1() {
        return jMenuItem1;
    }

    public void setjMenuItem1(JMenuItem jMenuItem1) {
        this.jMenuItem1 = jMenuItem1;
    }

    public JPanel getjPanel1() {
        return jPanel1;
    }

    public void setjPanel1(JPanel jPanel1) {
        this.jPanel1 = jPanel1;
    }

    public JToolBar getToolBar() {
        return toolBar;
    }

    public void setToolBar(JToolBar toolBar) {
        this.toolBar = toolBar;
    }

    public JButton getBtnArbitros() {
        return BtnArbitros;
    }

    public void setBtnArbitros(JButton BtnArbitros) {
        this.BtnArbitros = BtnArbitros;
    }

    public JButton getBtnPatidos() {
        return BtnPatidos;
    }

    public void setBtnPatidos(JButton BtnPatidos) {
        this.BtnPatidos = BtnPatidos;
    }

    public JButton getBtnAsignacion() {
        return BtnAsignacion;
    }

    public void setBtnAsignacion(JButton BtnAsignacion) {
        this.BtnAsignacion = BtnAsignacion;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        toolBar = new javax.swing.JToolBar();
        btnCampeonato = new javax.swing.JButton();
        jSeparator12 = new javax.swing.JToolBar.Separator();
        btnTemporada = new javax.swing.JButton();
        jSeparator11 = new javax.swing.JToolBar.Separator();
        BtnEquipos = new javax.swing.JButton();
        jSeparator13 = new javax.swing.JToolBar.Separator();
        btnEstadios = new javax.swing.JButton();
        jSeparator14 = new javax.swing.JToolBar.Separator();
        btnJugadores = new javax.swing.JButton();
        jSeparator15 = new javax.swing.JToolBar.Separator();
        btnEntrenador = new javax.swing.JButton();
        jSeparator16 = new javax.swing.JToolBar.Separator();
        BtnArbitros = new javax.swing.JButton();
        jSeparator17 = new javax.swing.JToolBar.Separator();
        BtnPatidos = new javax.swing.JButton();
        jSeparator18 = new javax.swing.JToolBar.Separator();
        BtnAsignacion = new javax.swing.JButton();
        jSeparator19 = new javax.swing.JToolBar.Separator();
        BtnGoles = new javax.swing.JButton();
        jSeparator20 = new javax.swing.JToolBar.Separator();
        btnResumen = new javax.swing.JButton();
        jSeparator21 = new javax.swing.JToolBar.Separator();
        desctopPrincipal = new javax.swing.JDesktopPane();
        panelImage1 = new org.edisoncor.gui.panel.PanelImage();
        btncerrarsesion = new javax.swing.JButton();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        toolBar.setBackground(new java.awt.Color(102, 102, 102));
        toolBar.setRollover(true);

        btnCampeonato.setBackground(new java.awt.Color(255, 255, 255));
        btnCampeonato.setFont(new java.awt.Font("Yu Gothic Medium", 1, 14)); // NOI18N
        btnCampeonato.setForeground(new java.awt.Color(0, 153, 204));
        btnCampeonato.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/campeonato64x64.png"))); // NOI18N
        btnCampeonato.setText("Campeonato");
        btnCampeonato.setToolTipText("Ver Campeonatos");
        btnCampeonato.setFocusable(false);
        btnCampeonato.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCampeonato.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        toolBar.add(btnCampeonato);
        toolBar.add(jSeparator12);

        btnTemporada.setBackground(new java.awt.Color(255, 255, 255));
        btnTemporada.setFont(new java.awt.Font("Yu Gothic Medium", 1, 14)); // NOI18N
        btnTemporada.setForeground(new java.awt.Color(0, 153, 204));
        btnTemporada.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/calendario 64x64.jpg"))); // NOI18N
        btnTemporada.setText("Temporada");
        btnTemporada.setToolTipText("Ver las temporadas existentes");
        btnTemporada.setFocusable(false);
        btnTemporada.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnTemporada.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        toolBar.add(btnTemporada);
        toolBar.add(jSeparator11);

        BtnEquipos.setBackground(new java.awt.Color(255, 255, 255));
        BtnEquipos.setFont(new java.awt.Font("Yu Gothic Medium", 1, 14)); // NOI18N
        BtnEquipos.setForeground(new java.awt.Color(0, 153, 204));
        BtnEquipos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/partners (1).png"))); // NOI18N
        BtnEquipos.setText("Equipos");
        BtnEquipos.setFocusable(false);
        BtnEquipos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BtnEquipos.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        toolBar.add(BtnEquipos);
        toolBar.add(jSeparator13);

        btnEstadios.setBackground(new java.awt.Color(255, 255, 255));
        btnEstadios.setFont(new java.awt.Font("Yu Gothic Medium", 1, 14)); // NOI18N
        btnEstadios.setForeground(new java.awt.Color(0, 153, 204));
        btnEstadios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/estadio.png"))); // NOI18N
        btnEstadios.setText("Estadios");
        btnEstadios.setFocusable(false);
        btnEstadios.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEstadios.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        toolBar.add(btnEstadios);
        toolBar.add(jSeparator14);

        btnJugadores.setBackground(new java.awt.Color(255, 255, 255));
        btnJugadores.setFont(new java.awt.Font("Yu Gothic Medium", 1, 14)); // NOI18N
        btnJugadores.setForeground(new java.awt.Color(0, 153, 204));
        btnJugadores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/jugador-de-futbol (1).png"))); // NOI18N
        btnJugadores.setText("Jugadores");
        btnJugadores.setFocusable(false);
        btnJugadores.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnJugadores.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        toolBar.add(btnJugadores);
        toolBar.add(jSeparator15);

        btnEntrenador.setBackground(new java.awt.Color(255, 255, 255));
        btnEntrenador.setFont(new java.awt.Font("Yu Gothic Medium", 1, 14)); // NOI18N
        btnEntrenador.setForeground(new java.awt.Color(0, 153, 204));
        btnEntrenador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/personal.png"))); // NOI18N
        btnEntrenador.setText("Entrenador");
        btnEntrenador.setFocusable(false);
        btnEntrenador.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEntrenador.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEntrenador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntrenadorActionPerformed(evt);
            }
        });
        toolBar.add(btnEntrenador);
        toolBar.add(jSeparator16);

        BtnArbitros.setBackground(new java.awt.Color(255, 255, 255));
        BtnArbitros.setFont(new java.awt.Font("Yu Gothic Medium", 1, 14)); // NOI18N
        BtnArbitros.setForeground(new java.awt.Color(0, 153, 204));
        BtnArbitros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/arbitro (1).png"))); // NOI18N
        BtnArbitros.setText("Arbitro");
        BtnArbitros.setFocusable(false);
        BtnArbitros.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BtnArbitros.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        toolBar.add(BtnArbitros);
        toolBar.add(jSeparator17);

        BtnPatidos.setBackground(new java.awt.Color(255, 255, 255));
        BtnPatidos.setFont(new java.awt.Font("Yu Gothic Medium", 1, 14)); // NOI18N
        BtnPatidos.setForeground(new java.awt.Color(0, 153, 204));
        BtnPatidos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/campo-de-futbol.png"))); // NOI18N
        BtnPatidos.setText("Partidos");
        BtnPatidos.setFocusable(false);
        BtnPatidos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BtnPatidos.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BtnPatidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnPatidosActionPerformed(evt);
            }
        });
        toolBar.add(BtnPatidos);
        toolBar.add(jSeparator18);

        BtnAsignacion.setBackground(new java.awt.Color(255, 255, 255));
        BtnAsignacion.setFont(new java.awt.Font("Yu Gothic Medium", 1, 14)); // NOI18N
        BtnAsignacion.setForeground(new java.awt.Color(0, 153, 204));
        BtnAsignacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/recurso.png"))); // NOI18N
        BtnAsignacion.setText("Asignacion");
        BtnAsignacion.setFocusable(false);
        BtnAsignacion.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BtnAsignacion.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        toolBar.add(BtnAsignacion);
        toolBar.add(jSeparator19);

        BtnGoles.setBackground(new java.awt.Color(255, 255, 255));
        BtnGoles.setFont(new java.awt.Font("Yu Gothic Medium", 1, 14)); // NOI18N
        BtnGoles.setForeground(new java.awt.Color(0, 153, 204));
        BtnGoles.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/goal.png"))); // NOI18N
        BtnGoles.setText("Goles");
        BtnGoles.setFocusable(false);
        BtnGoles.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BtnGoles.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        toolBar.add(BtnGoles);
        toolBar.add(jSeparator20);

        btnResumen.setBackground(new java.awt.Color(255, 255, 255));
        btnResumen.setFont(new java.awt.Font("Yu Gothic Medium", 1, 14)); // NOI18N
        btnResumen.setForeground(new java.awt.Color(0, 153, 204));
        btnResumen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/analisis.png"))); // NOI18N
        btnResumen.setText("Resumen partidos");
        btnResumen.setFocusable(false);
        btnResumen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnResumen.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        toolBar.add(btnResumen);
        toolBar.add(jSeparator21);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(toolBar, javax.swing.GroupLayout.DEFAULT_SIZE, 1028, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(toolBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        desctopPrincipal.setBackground(new java.awt.Color(255, 255, 255));

        panelImage1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/wallhaven-96gro1.jpg"))); // NOI18N

        btncerrarsesion.setBackground(new java.awt.Color(255, 255, 255));
        btncerrarsesion.setFont(new java.awt.Font("Yu Gothic Medium", 1, 14)); // NOI18N
        btncerrarsesion.setForeground(new java.awt.Color(0, 102, 153));
        btncerrarsesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/flecha-hacia-la-izquierda.png"))); // NOI18N
        btncerrarsesion.setText("Cerrar Sesion");

        javax.swing.GroupLayout panelImage1Layout = new javax.swing.GroupLayout(panelImage1);
        panelImage1.setLayout(panelImage1Layout);
        panelImage1Layout.setHorizontalGroup(
            panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelImage1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btncerrarsesion)
                .addContainerGap())
        );
        panelImage1Layout.setVerticalGroup(
            panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelImage1Layout.createSequentialGroup()
                .addContainerGap(510, Short.MAX_VALUE)
                .addComponent(btncerrarsesion)
                .addContainerGap())
        );

        desctopPrincipal.setLayer(panelImage1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout desctopPrincipalLayout = new javax.swing.GroupLayout(desctopPrincipal);
        desctopPrincipal.setLayout(desctopPrincipalLayout);
        desctopPrincipalLayout.setHorizontalGroup(
            desctopPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelImage1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        desctopPrincipalLayout.setVerticalGroup(
            desctopPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelImage1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(desctopPrincipal)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(desctopPrincipal))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnPatidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnPatidosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BtnPatidosActionPerformed

    private void btnEntrenadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntrenadorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEntrenadorActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnArbitros;
    private javax.swing.JButton BtnAsignacion;
    private javax.swing.JButton BtnEquipos;
    private javax.swing.JButton BtnGoles;
    private javax.swing.JButton BtnPatidos;
    private javax.swing.JButton btnCampeonato;
    private javax.swing.JButton btnEntrenador;
    private javax.swing.JButton btnEstadios;
    private javax.swing.JButton btnJugadores;
    private javax.swing.JButton btnResumen;
    private javax.swing.JButton btnTemporada;
    private javax.swing.JButton btncerrarsesion;
    private javax.swing.JDesktopPane desctopPrincipal;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JToolBar.Separator jSeparator11;
    private javax.swing.JToolBar.Separator jSeparator12;
    private javax.swing.JToolBar.Separator jSeparator13;
    private javax.swing.JToolBar.Separator jSeparator14;
    private javax.swing.JToolBar.Separator jSeparator15;
    private javax.swing.JToolBar.Separator jSeparator16;
    private javax.swing.JToolBar.Separator jSeparator17;
    private javax.swing.JToolBar.Separator jSeparator18;
    private javax.swing.JToolBar.Separator jSeparator19;
    private javax.swing.JToolBar.Separator jSeparator20;
    private javax.swing.JToolBar.Separator jSeparator21;
    private org.edisoncor.gui.panel.PanelImage panelImage1;
    private javax.swing.JToolBar toolBar;
    // End of variables declaration//GEN-END:variables
}
