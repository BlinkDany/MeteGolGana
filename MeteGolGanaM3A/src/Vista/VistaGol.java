/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import LIB.FSButtonMD;
import LIB.FSTexFieldMD;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author Derek
 */
public class VistaGol extends javax.swing.JInternalFrame {

    /**
     * Creates new form VistaGol
     */
    public VistaGol() {
        initComponents();
    }

    public JLabel getLblReMoGoles() {
        return lblReMoGoles;
    }

    public FSButtonMD getBtnBuscar() {
        return btnBuscar;
    }

    public JDialog getJdggolestabla() {
        return jdggolestabla;
    }

    public static FSButtonMD getBtnCancelar1() {
        return btnCancelar1;
    }

    public static FSButtonMD getBtnmandardatos() {
        return btnmandardatos;
    }

    public JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    public JScrollPane getjScrollPane2() {
        return jScrollPane2;
    }

    public JLabel getLblbusqueda() {
        return lblbusqueda;
    }

    public static JTable getTblbuscar() {
        return tblbuscar;
    }

    public static FSTexFieldMD getTxtbuscarcod() {
        return txtbuscarcod;
    }

    public static JButton getBtnAgregar() {
        return btnAgregar;
    }

    public FSButtonMD getBtnCancelar() {
        return btnCancelar;
    }

    public static JButton getBtnEliminar() {
        return btnEliminar;
    }

    public FSButtonMD getBtnEquipo() {
        return btnEquipo;
    }

    public static FSButtonMD getBtnInicio() {
        return btnInicio;
    }

    public FSButtonMD getBtnJugador() {
        return btnJugador;
    }

    public static JButton getBtnModificar() {
        return btnModificar;
    }

    public FSButtonMD getBtnPartido() {
        return btnPartido;
    }

    public FSButtonMD getBtnRegistrarModificar() {
        return btnRegistrarModificar;
    }

    public JDialog getJdgGoles() {
        return jdgGoles;
    }

    public static JTable getTblGoles() {
        return tblGoles;
    }

    public static FSTexFieldMD getTxtBuscar() {
        return txtBuscar;
    }

    public FSTexFieldMD getTxtCodEquipo() {
        return txtCodEquipo;
    }

    public FSTexFieldMD getTxtCodJugador() {
        return txtCodJugador;
    }

    public FSTexFieldMD getTxtCodPartido() {
        return txtCodPartido;
    }

    public FSTexFieldMD getTxtMinuto() {
        return txtMinuto;
    }

    public FSTexFieldMD getTxtcodGol() {
        return txtcodGol;
    }

    public FSTexFieldMD getTxtdescripcion() {
        return txtdescripcion;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jdgGoles = new javax.swing.JDialog();
        btnCancelar = new LIB.FSButtonMD();
        btnRegistrarModificar = new LIB.FSButtonMD();
        txtdescripcion = new LIB.FSTexFieldMD();
        txtCodJugador = new LIB.FSTexFieldMD();
        txtMinuto = new LIB.FSTexFieldMD();
        txtcodGol = new LIB.FSTexFieldMD();
        txtCodPartido = new LIB.FSTexFieldMD();
        txtCodEquipo = new LIB.FSTexFieldMD();
        lblReMoGoles = new javax.swing.JLabel();
        btnJugador = new LIB.FSButtonMD();
        btnPartido = new LIB.FSButtonMD();
        btnEquipo = new LIB.FSButtonMD();
        jdggolestabla = new javax.swing.JDialog();
        btnCancelar1 = new LIB.FSButtonMD();
        txtbuscarcod = new LIB.FSTexFieldMD();
        lblbusqueda = new javax.swing.JLabel();
        btnmandardatos = new LIB.FSButtonMD();
        btnBuscar = new LIB.FSButtonMD();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblbuscar = new javax.swing.JTable();
        btnAgregar = new javax.swing.JButton();
        txtBuscar = new LIB.FSTexFieldMD();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblGoles = new javax.swing.JTable();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnInicio = new LIB.FSButtonMD();

        btnCancelar.setForeground(new java.awt.Color(0, 0, 0));
        btnCancelar.setText("Cancelar");
        btnCancelar.setColorHover(new java.awt.Color(0, 0, 0));
        btnCancelar.setColorNormal(new java.awt.Color(255, 0, 0));
        btnCancelar.setColorTextHover(new java.awt.Color(255, 255, 255));

        btnRegistrarModificar.setForeground(new java.awt.Color(0, 0, 0));
        btnRegistrarModificar.setText("Registrar");
        btnRegistrarModificar.setColorHover(new java.awt.Color(0, 102, 204));
        btnRegistrarModificar.setColorPressed(new java.awt.Color(0, 204, 51));
        btnRegistrarModificar.setColorTextHover(new java.awt.Color(255, 255, 255));

        txtdescripcion.setForeground(new java.awt.Color(0, 0, 0));
        txtdescripcion.setBordeColorFocus(new java.awt.Color(51, 51, 255));
        txtdescripcion.setPlaceholder("Descripcion");

        txtCodJugador.setForeground(new java.awt.Color(0, 0, 0));
        txtCodJugador.setBordeColorFocus(new java.awt.Color(51, 51, 255));
        txtCodJugador.setPlaceholder("Codigo Del Jugador");

        txtMinuto.setForeground(new java.awt.Color(0, 0, 0));
        txtMinuto.setBordeColorFocus(new java.awt.Color(51, 51, 255));
        txtMinuto.setPlaceholder("Minuto");

        txtcodGol.setForeground(new java.awt.Color(0, 0, 0));
        txtcodGol.setBordeColorFocus(new java.awt.Color(51, 51, 255));
        txtcodGol.setPlaceholder("Codigo");

        txtCodPartido.setForeground(new java.awt.Color(0, 0, 0));
        txtCodPartido.setBordeColorFocus(new java.awt.Color(51, 51, 255));
        txtCodPartido.setPlaceholder("Codigo del Partido");

        txtCodEquipo.setForeground(new java.awt.Color(0, 0, 0));
        txtCodEquipo.setBordeColorFocus(new java.awt.Color(51, 51, 255));
        txtCodEquipo.setPlaceholder("Codigo del Equipo");

        lblReMoGoles.setBackground(new java.awt.Color(0, 102, 204));
        lblReMoGoles.setFont(new java.awt.Font("STHupo", 1, 36)); // NOI18N
        lblReMoGoles.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblReMoGoles.setText("Registro o Modificar");

        btnJugador.setBackground(new java.awt.Color(204, 204, 204));
        btnJugador.setForeground(new java.awt.Color(0, 0, 0));
        btnJugador.setText("Buscar Jugador");

        btnPartido.setBackground(new java.awt.Color(204, 204, 204));
        btnPartido.setForeground(new java.awt.Color(0, 0, 0));
        btnPartido.setText("Buscar Partido");

        btnEquipo.setBackground(new java.awt.Color(204, 204, 204));
        btnEquipo.setForeground(new java.awt.Color(0, 0, 0));
        btnEquipo.setText("Buscar Equipo");

        javax.swing.GroupLayout jdgGolesLayout = new javax.swing.GroupLayout(jdgGoles.getContentPane());
        jdgGoles.getContentPane().setLayout(jdgGolesLayout);
        jdgGolesLayout.setHorizontalGroup(
            jdgGolesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jdgGolesLayout.createSequentialGroup()
                .addGroup(jdgGolesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jdgGolesLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(jdgGolesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtdescripcion, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                            .addComponent(txtcodGol, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                            .addComponent(txtMinuto, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                        .addGap(77, 77, 77)
                        .addGroup(jdgGolesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jdgGolesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtCodPartido, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
                                .addComponent(txtCodJugador, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                            .addComponent(txtCodEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(jdgGolesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnJugador, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                            .addComponent(btnPartido, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                            .addComponent(btnEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)))
                    .addGroup(jdgGolesLayout.createSequentialGroup()
                        .addGap(109, 109, 109)
                        .addComponent(btnRegistrarModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(137, 137, 137)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(86, Short.MAX_VALUE))
            .addComponent(lblReMoGoles, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jdgGolesLayout.setVerticalGroup(
            jdgGolesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jdgGolesLayout.createSequentialGroup()
                .addComponent(lblReMoGoles, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(jdgGolesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtcodGol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCodJugador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnJugador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(jdgGolesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtdescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCodPartido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPartido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jdgGolesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMinuto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCodEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(68, 68, 68)
                .addGroup(jdgGolesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegistrarModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );

        btnCancelar1.setForeground(new java.awt.Color(0, 0, 0));
        btnCancelar1.setText("Cancelar");
        btnCancelar1.setColorHover(new java.awt.Color(0, 0, 0));
        btnCancelar1.setColorNormal(new java.awt.Color(255, 0, 0));
        btnCancelar1.setColorTextHover(new java.awt.Color(255, 255, 255));

        txtbuscarcod.setForeground(new java.awt.Color(0, 0, 0));
        txtbuscarcod.setBordeColorFocus(new java.awt.Color(51, 51, 255));
        txtbuscarcod.setPlaceholder("Codigo");
        txtbuscarcod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbuscarcodActionPerformed(evt);
            }
        });

        lblbusqueda.setBackground(new java.awt.Color(0, 102, 204));
        lblbusqueda.setFont(new java.awt.Font("STHupo", 1, 36)); // NOI18N
        lblbusqueda.setForeground(new java.awt.Color(255, 255, 255));
        lblbusqueda.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblbusqueda.setText("tabla");

        btnmandardatos.setForeground(new java.awt.Color(0, 0, 0));
        btnmandardatos.setText("Guardar");
        btnmandardatos.setColorHover(new java.awt.Color(0, 102, 204));
        btnmandardatos.setColorPressed(new java.awt.Color(0, 204, 51));
        btnmandardatos.setColorTextHover(new java.awt.Color(255, 255, 255));
        btnmandardatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmandardatosActionPerformed(evt);
            }
        });

        btnBuscar.setBackground(new java.awt.Color(204, 204, 204));
        btnBuscar.setForeground(new java.awt.Color(0, 0, 0));
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        tblbuscar.setFont(new java.awt.Font("Yu Gothic Medium", 0, 18)); // NOI18N
        tblbuscar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Codigo", "Nombre"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblbuscar);

        javax.swing.GroupLayout jdggolestablaLayout = new javax.swing.GroupLayout(jdggolestabla.getContentPane());
        jdggolestabla.getContentPane().setLayout(jdggolestablaLayout);
        jdggolestablaLayout.setHorizontalGroup(
            jdggolestablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jdggolestablaLayout.createSequentialGroup()
                .addComponent(lblbusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 808, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jdggolestablaLayout.createSequentialGroup()
                .addGroup(jdggolestablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jdggolestablaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jdggolestablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jdggolestablaLayout.createSequentialGroup()
                                .addComponent(txtbuscarcod, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jdggolestablaLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 760, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jdggolestablaLayout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(btnCancelar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addComponent(btnmandardatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jdggolestablaLayout.setVerticalGroup(
            jdggolestablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jdggolestablaLayout.createSequentialGroup()
                .addComponent(lblbusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jdggolestablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtbuscarcod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jdggolestablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCancelar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnmandardatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        btnAgregar.setBackground(new java.awt.Color(0, 153, 0));
        btnAgregar.setFont(new java.awt.Font("Yu Gothic Medium", 1, 14)); // NOI18N
        btnAgregar.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/boton.png"))); // NOI18N
        btnAgregar.setText("Crear nuevo");
        btnAgregar.setToolTipText("Registrar un nuevo jugador");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        txtBuscar.setForeground(new java.awt.Color(0, 0, 0));
        txtBuscar.setToolTipText("Ingrese el Codigo del Gol");
        txtBuscar.setBordeColorFocus(new java.awt.Color(51, 51, 255));
        txtBuscar.setPlaceholder("Buscar Goles");
        txtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarActionPerformed(evt);
            }
        });

        tblGoles.setFont(new java.awt.Font("Yu Gothic Medium", 0, 18)); // NOI18N
        tblGoles.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Codigo Del Gol", "Descipcion", "Minuto", "Jugador", "Partido", "Equipo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblGoles);

        btnModificar.setBackground(new java.awt.Color(0, 102, 204));
        btnModificar.setFont(new java.awt.Font("Yu Gothic Medium", 1, 14)); // NOI18N
        btnModificar.setForeground(new java.awt.Color(255, 255, 255));
        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/modificar.png"))); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.setToolTipText("Registrar un nuevo jugador");

        btnEliminar.setBackground(new java.awt.Color(0, 0, 0));
        btnEliminar.setFont(new java.awt.Font("Yu Gothic Medium", 1, 14)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/contenedor-de-basura.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.setToolTipText("Registrar un nuevo jugador");

        jPanel1.setBackground(new java.awt.Color(0, 102, 204));

        jLabel1.setFont(new java.awt.Font("STHupo", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Goles");

        btnInicio.setBackground(new java.awt.Color(0, 102, 204));
        btnInicio.setText("Pagina Principal");
        btnInicio.setColorHover(new java.awt.Color(0, 102, 204));
        btnInicio.setColorNormal(new java.awt.Color(0, 102, 204));
        btnInicio.setColorPressed(new java.awt.Color(0, 102, 204));
        btnInicio.setColorTextHover(new java.awt.Color(204, 204, 204));
        btnInicio.setFont(new java.awt.Font("Yu Gothic Medium", 1, 18)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnInicio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAgregar)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 540, Short.MAX_VALUE)
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                            .addComponent(btnModificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(15, 15, 15))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregar))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnModificar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEliminar)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarActionPerformed

    private void txtbuscarcodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbuscarcodActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtbuscarcodActionPerformed

    private void btnmandardatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmandardatosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnmandardatosActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBuscarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btnAgregar;
    private LIB.FSButtonMD btnBuscar;
    public static LIB.FSButtonMD btnCancelar;
    public static LIB.FSButtonMD btnCancelar1;
    public static javax.swing.JButton btnEliminar;
    private LIB.FSButtonMD btnEquipo;
    public static LIB.FSButtonMD btnInicio;
    private LIB.FSButtonMD btnJugador;
    public static javax.swing.JButton btnModificar;
    private LIB.FSButtonMD btnPartido;
    public static LIB.FSButtonMD btnRegistrarModificar;
    public static LIB.FSButtonMD btnmandardatos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JDialog jdgGoles;
    private javax.swing.JDialog jdggolestabla;
    private javax.swing.JLabel lblReMoGoles;
    private javax.swing.JLabel lblbusqueda;
    public static javax.swing.JTable tblGoles;
    public static javax.swing.JTable tblbuscar;
    public static LIB.FSTexFieldMD txtBuscar;
    public static LIB.FSTexFieldMD txtCodEquipo;
    public static LIB.FSTexFieldMD txtCodJugador;
    public static LIB.FSTexFieldMD txtCodPartido;
    public static LIB.FSTexFieldMD txtMinuto;
    public static LIB.FSTexFieldMD txtbuscarcod;
    public static LIB.FSTexFieldMD txtcodGol;
    public static LIB.FSTexFieldMD txtdescripcion;
    // End of variables declaration//GEN-END:variables
}
