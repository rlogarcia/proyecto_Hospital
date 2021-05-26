
package com.proyecto_hospital.vista;

import com.proyecto_hospital.controlador.ControladorPaciente;
import com.proyecto_hospital.modelo.Paciente;
import com.proyecto_hospital.controlador.ControladorUsuario;
import com.proyecto_hospital.excepciones.PacienteExcepciones;
import com.proyecto_hospital.excepciones.UsuarioExcepcion;
import com.proyecto_hospital.modelo.Eps;
import com.proyecto_hospital.modelo.Paciente;
import com.proyecto_hospital.modelo.Usuario;
import com.sun.xml.internal.ws.policy.sourcemodel.ModelNode;
import java.beans.PropertyVetoException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.html.parser.DTDConstants;
/**
 *
 * @author acer
 */
public class MDIProyectoh extends javax.swing.JFrame {
    PieChartExample grafico = new PieChartExample("Estaistica paciente");
    private ControladorUsuario controlUsuario;
    private ControladorPaciente ControladorPaciente;
    private Usuario usuarioAutenticado;
     
        
    
    public MDIProyectoh() {
        initComponents();
        fileMenu.hide();
        jifBienvenido.hide(); 
        
        
        controlUsuario= new ControladorUsuario();
        ControladorPaciente=new ControladorPaciente();
        llenarPacientes();
        
        grafico.setIconifiable(true);
        grafico.setClosable(true);
        grafico.setDefaultCloseOperation(HIDE_ON_CLOSE);
        desktopPane.add(grafico);
        
    }
     public boolean validarCedulaPaciente(){
        for(int i=0;  i<tblPacientes.getRowCount(); i++){
         if(tblPacientes.getValueAt(i, 1).equals(txtCedula.getText())){
            return true;
         }
     }
        return false;
        
    }
     public void eliminarDatos(){
          DefaultTableModel model= (DefaultTableModel) tblPacientes.getModel();
          int eli= tblPacientes.getSelectedRowCount();
         
           if (eli!=0){
              
            JOptionPane.showMessageDialog(rootPane, "eliminar");
                
            
        }else{
            JOptionPane.showMessageDialog(rootPane, "No hay datos que eliminar");
        
       
                }
         tblPacientes.repaint();
     }
//       
        private void llenarPacientes(){
            DefaultTableModel model= (DefaultTableModel) tblPacientes.getModel();
            model.getDataVector().removeAllElements();
                       
            
            for(Paciente pac: ControladorPaciente.getPacientes()){
                if(pac!=null){
                    Object[] fila= {pac.getNombre(),pac.getCedula(),pac.getDireccion(),pac.getEps(),pac.getTelefono(),pac.getSospechoso(),pac.getComplicaciones(),pac.getObservaciones()};
                    model.addRow(fila);
                    
                }
            }
            tblPacientes.repaint();
         }
        public void controlarEstadoMenus()
    {
        mnucrearpaciente.setEnabled(false);
        mnuverpaciente.setEnabled(false);
        

        mnucrearpaciente.setVisible(false);
        mnuverpaciente.setVisible(false);
        

        
        if(usuarioAutenticado!=null)
        {
                    switch(usuarioAutenticado.getRol().getCodigo())
            {
                case 1:
                    mnucrearpaciente.setEnabled(true);
                    mnucrearpaciente.setVisible(true);
                     System.out.println("Ingreso un medico");
                    mnuverpaciente.setVisible(true);
                    mnuverpaciente.setEnabled(true);

                    
                                      
                    break;
                case 2:
                    mnucrearpaciente.setEnabled(true);
                    mnucrearpaciente.setVisible(true);
                    System.out.println("Ingreso un enfermero");
                     mnuverpaciente.setVisible(true);
                    mnuverpaciente.setEnabled(true);
                    break;
                    
                case 3:
                   mnuverpaciente.setVisible(true);
                    mnuverpaciente.setVisible(true);
                    System.out.println("Ingreso un internista");
                    break;
                    
            }
        }
        else
        {

        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktopPane = new javax.swing.JDesktopPane();
        jifLogin = new javax.swing.JInternalFrame();
        lblUsuario = new javax.swing.JLabel();
        lblMensaje = new javax.swing.JLabel();
        lblContrasenia = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        btnIngresar = new javax.swing.JButton();
        txtContrasenia = new javax.swing.JPasswordField();
        jifBienvenido = new javax.swing.JInternalFrame();
        jLabel1 = new javax.swing.JLabel();
        btnOk = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jitCarNom = new javax.swing.JTextPane();
        jifCrearPacientes = new javax.swing.JInternalFrame();
        lblNombreCompleto = new javax.swing.JLabel();
        lblCedula = new javax.swing.JLabel();
        lblDireccion = new javax.swing.JLabel();
        lblEps = new javax.swing.JLabel();
        lblTelefono = new javax.swing.JLabel();
        txtNombreCompleto = new javax.swing.JTextField();
        txtCedula = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        cmbEps = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        txtObservaciones = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        chkSospechoso = new javax.swing.JCheckBox();
        chkComplicaciones = new javax.swing.JCheckBox();
        jifVerPacientes = new javax.swing.JInternalFrame();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblPacientes = new javax.swing.JTable();
        btnEliminarPaciente = new javax.swing.JButton();
        btnVerEstadistica = new javax.swing.JButton();
        btnAregarPaciente = new javax.swing.JButton();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        mnucrearpaciente = new javax.swing.JMenuItem();
        mnuverpaciente = new javax.swing.JMenuItem();
        mnusalir = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        contentMenuItem = new javax.swing.JMenuItem();
        aboutMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setPreferredSize(new java.awt.Dimension(1700, 1100));

        jifLogin.setMaximizable(true);
        jifLogin.setTitle("Ingreso a plataforma");
        jifLogin.setVisible(true);

        lblUsuario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblUsuario.setText("*Correo");

        lblMensaje.setFont(new java.awt.Font("Georgia", 0, 52)); // NOI18N
        lblMensaje.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMensaje.setText("Bienvenid@");

        lblContrasenia.setText("*Contraseña");

        txtCorreo.setText("rloaiza89567@umanizales.edu.co");
        txtCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCorreoActionPerformed(evt);
            }
        });

        btnIngresar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnIngresar.setText("Ingresar");
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });

        txtContrasenia.setText("roger123");
        txtContrasenia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContraseniaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jifLoginLayout = new javax.swing.GroupLayout(jifLogin.getContentPane());
        jifLogin.getContentPane().setLayout(jifLoginLayout);
        jifLoginLayout.setHorizontalGroup(
            jifLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jifLoginLayout.createSequentialGroup()
                .addGroup(jifLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnIngresar, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jifLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jifLoginLayout.createSequentialGroup()
                            .addGap(92, 92, 92)
                            .addGroup(jifLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(lblContrasenia)
                                .addComponent(lblUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(jifLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtCorreo)
                                .addComponent(txtContrasenia)))
                        .addGroup(jifLoginLayout.createSequentialGroup()
                            .addGap(53, 53, 53)
                            .addComponent(lblMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(63, Short.MAX_VALUE))
        );
        jifLoginLayout.setVerticalGroup(
            jifLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jifLoginLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(lblMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(jifLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jifLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblContrasenia)
                    .addComponent(txtContrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addComponent(btnIngresar)
                .addGap(37, 37, 37))
        );

        desktopPane.add(jifLogin);
        jifLogin.setBounds(760, 310, 490, 400);

        jifBienvenido.setClosable(true);
        jifBienvenido.setTitle("INICIO DE SECCION");
        jifBienvenido.setVisible(true);

        jLabel1.setFont(new java.awt.Font("Georgia", 0, 28)); // NOI18N
        jLabel1.setText("Bievenid@");

        btnOk.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnOk.setText("OK");
        btnOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkActionPerformed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/proyecto_hospital/vista/user.png"))); // NOI18N

        jitCarNom.setEditable(false);
        jScrollPane1.setViewportView(jitCarNom);

        javax.swing.GroupLayout jifBienvenidoLayout = new javax.swing.GroupLayout(jifBienvenido.getContentPane());
        jifBienvenido.getContentPane().setLayout(jifBienvenidoLayout);
        jifBienvenidoLayout.setHorizontalGroup(
            jifBienvenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jifBienvenidoLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jifBienvenidoLayout.createSequentialGroup()
                .addGroup(jifBienvenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jifBienvenidoLayout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jifBienvenidoLayout.createSequentialGroup()
                        .addGap(113, 113, 113)
                        .addComponent(btnOk, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jifBienvenidoLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jifBienvenidoLayout.setVerticalGroup(
            jifBienvenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jifBienvenidoLayout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(btnOk)
                .addContainerGap())
        );

        desktopPane.add(jifBienvenido);
        jifBienvenido.setBounds(830, 330, 300, 460);

        jifCrearPacientes.setClosable(true);
        jifCrearPacientes.setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        jifCrearPacientes.setIconifiable(true);
        jifCrearPacientes.setMaximizable(true);
        jifCrearPacientes.setTitle("Crear Pacientes");
        jifCrearPacientes.setVisible(false);

        lblNombreCompleto.setText("Nombre completo");

        lblCedula.setText("Cedula");

        lblDireccion.setText("Direccion");

        lblEps.setText("EPS");

        lblTelefono.setText("Telefono");

        txtNombreCompleto.setText("Roger Loaiza Garcia");

        txtCedula.setText("1053873806");

        txtDireccion.setText("alli");

        txtTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefonoActionPerformed(evt);
            }
        });

        cmbEps.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Salud Colmena E.P.S. S.A", "Salud Total S.A. E.P.S", "Cafesalud E.P.S. S.A.", "E.P.S.  Sanitas S.A 4", "E.P.S. Unimec - Liquidación", "Compensar  E.P.S", "EPS Prog. Comfenalco Antioquia", "SALUDCOLOMBIA EPS S.A", "SALUDVIDA S.A. EPS", "Colseguros E.P.S.", "\"E.P.S.  Saludcoop", "Coomeva E.P.S", "Solsalud S.A. EPS" }));
        cmbEps.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbEpsActionPerformed(evt);
            }
        });

        jLabel10.setText("Observaciones");

        btnAgregar.setText("AGREGAR");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        chkSospechoso.setText("Sospechoso de covid");
        chkSospechoso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkSospechosoActionPerformed(evt);
            }
        });

        chkComplicaciones.setText("Complicaciones");

        javax.swing.GroupLayout jifCrearPacientesLayout = new javax.swing.GroupLayout(jifCrearPacientes.getContentPane());
        jifCrearPacientes.getContentPane().setLayout(jifCrearPacientesLayout);
        jifCrearPacientesLayout.setHorizontalGroup(
            jifCrearPacientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jifCrearPacientesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAgregar)
                .addGap(34, 34, 34))
            .addGroup(jifCrearPacientesLayout.createSequentialGroup()
                .addGroup(jifCrearPacientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jifCrearPacientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jifCrearPacientesLayout.createSequentialGroup()
                            .addGap(39, 39, 39)
                            .addComponent(lblNombreCompleto, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jifCrearPacientesLayout.createSequentialGroup()
                            .addGap(98, 98, 98)
                            .addGroup(jifCrearPacientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(lblDireccion)
                                .addComponent(lblCedula))))
                    .addGroup(jifCrearPacientesLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jifCrearPacientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10)
                            .addComponent(lblTelefono)
                            .addComponent(lblEps))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jifCrearPacientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jifCrearPacientesLayout.createSequentialGroup()
                        .addComponent(txtObservaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 124, Short.MAX_VALUE))
                    .addGroup(jifCrearPacientesLayout.createSequentialGroup()
                        .addGroup(jifCrearPacientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jifCrearPacientesLayout.createSequentialGroup()
                                .addComponent(chkSospechoso)
                                .addGap(96, 96, 96)
                                .addComponent(chkComplicaciones))
                            .addGroup(jifCrearPacientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtNombreCompleto)
                                .addComponent(txtCedula)
                                .addComponent(txtDireccion)
                                .addComponent(txtTelefono)
                                .addComponent(cmbEps, 0, 400, Short.MAX_VALUE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jifCrearPacientesLayout.setVerticalGroup(
            jifCrearPacientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jifCrearPacientesLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jifCrearPacientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombreCompleto, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombreCompleto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jifCrearPacientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCedula)
                    .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jifCrearPacientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDireccion)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jifCrearPacientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEps)
                    .addComponent(cmbEps, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jifCrearPacientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTelefono)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jifCrearPacientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chkSospechoso)
                    .addComponent(chkComplicaciones))
                .addGap(18, 18, 18)
                .addGroup(jifCrearPacientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(txtObservaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnAgregar)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        desktopPane.add(jifCrearPacientes);
        jifCrearPacientes.setBounds(710, 260, 610, 480);

        jifVerPacientes.setClosable(true);
        jifVerPacientes.setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        jifVerPacientes.setIconifiable(true);
        jifVerPacientes.setMaximizable(true);
        jifVerPacientes.setTitle("Ver Pacientes");
        jifVerPacientes.setVisible(false);

        tblPacientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre Completo", "Cedula", "Direccion", "EPS", "Telefono", "Covid", "Sospechoso", "Observaciones"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPacientes.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tblPacientes.getTableHeader().setResizingAllowed(false);
        tblPacientes.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tblPacientes);

        btnEliminarPaciente.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnEliminarPaciente.setText("Eliminar Paciente");
        btnEliminarPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarPacienteActionPerformed(evt);
            }
        });

        btnVerEstadistica.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnVerEstadistica.setText("Ver Estadistica");
        btnVerEstadistica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerEstadisticaActionPerformed(evt);
            }
        });

        btnAregarPaciente.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnAregarPaciente.setText("Agregar Paciente");
        btnAregarPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAregarPacienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jifVerPacientesLayout = new javax.swing.GroupLayout(jifVerPacientes.getContentPane());
        jifVerPacientes.getContentPane().setLayout(jifVerPacientesLayout);
        jifVerPacientesLayout.setHorizontalGroup(
            jifVerPacientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jifVerPacientesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jifVerPacientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jifVerPacientesLayout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1140, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jifVerPacientesLayout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(btnVerEstadistica, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAregarPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(238, 238, 238)
                        .addComponent(btnEliminarPaciente)
                        .addGap(127, 127, 127))))
        );
        jifVerPacientesLayout.setVerticalGroup(
            jifVerPacientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jifVerPacientesLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jifVerPacientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVerEstadistica, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAregarPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminarPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(147, Short.MAX_VALUE))
        );

        desktopPane.add(jifVerPacientes);
        jifVerPacientes.setBounds(190, 190, 1180, 670);

        fileMenu.setMnemonic('f');
        fileMenu.setText("Inicio");

        mnucrearpaciente.setMnemonic('s');
        mnucrearpaciente.setText("Crear paciente ");
        mnucrearpaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnucrearpacienteActionPerformed(evt);
            }
        });
        fileMenu.add(mnucrearpaciente);

        mnuverpaciente.setMnemonic('a');
        mnuverpaciente.setText("Ver pacientes");
        mnuverpaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuverpacienteActionPerformed(evt);
            }
        });
        fileMenu.add(mnuverpaciente);

        mnusalir.setMnemonic('x');
        mnusalir.setText("Salir");
        mnusalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnusalirActionPerformed(evt);
            }
        });
        fileMenu.add(mnusalir);

        menuBar.add(fileMenu);

        helpMenu.setMnemonic('h');
        helpMenu.setText("Help");

        contentMenuItem.setMnemonic('c');
        contentMenuItem.setText("Contents");
        helpMenu.add(contentMenuItem);

        aboutMenuItem.setMnemonic('a');
        aboutMenuItem.setText("About");
        helpMenu.add(aboutMenuItem);

        menuBar.add(helpMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 1266, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 827, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mnusalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnusalirActionPerformed
         JOptionPane.showMessageDialog(rootPane, "Gracias por usar mi app");
        System.exit(0);
       
    }//GEN-LAST:event_mnusalirActionPerformed

    private void txtContraseniaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContraseniaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContraseniaActionPerformed

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
        try {
            usuarioAutenticado=controlUsuario.verificarUsuario(txtCorreo.getText(), txtContrasenia.getText());
                
                    this.jitCarNom.setText(usuarioAutenticado.getRol()+", "+usuarioAutenticado.getNombre()+" "+usuarioAutenticado.getApellido());
                    jifBienvenido.show();
                    controlarEstadoMenus();
                    jifLogin.hide();
                    fileMenu.show();
        } catch (UsuarioExcepcion ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage(), "Error", 1);
        }
    }//GEN-LAST:event_btnIngresarActionPerformed

    private void btnOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkActionPerformed
        jifBienvenido.hide();
    }//GEN-LAST:event_btnOkActionPerformed

    private void txtCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCorreoActionPerformed
        
    }//GEN-LAST:event_txtCorreoActionPerformed

    private void mnuverpacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuverpacienteActionPerformed
        jifVerPacientes.setVisible(true);
        if(jifVerPacientes.isIcon()){
            try {
                jifVerPacientes.setIcon(Boolean.FALSE);
            } catch (PropertyVetoException ex) {
                Logger.getLogger(MDIProyectoh.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_mnuverpacienteActionPerformed

    private void mnucrearpacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnucrearpacienteActionPerformed
        if(jifCrearPacientes.isIcon()){
            try {
                jifCrearPacientes.setIcon(Boolean.FALSE);
            } catch (PropertyVetoException ex) {
                Logger.getLogger(MDIProyectoh.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        jifCrearPacientes.setVisible(true);
    }//GEN-LAST:event_mnucrearpacienteActionPerformed

    private void txtTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefonoActionPerformed

    private void cmbEpsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbEpsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbEpsActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        int pos= cmbEps.getSelectedIndex();
       Paciente pacienteAdiccionar;
        
     
            try {
                if (validarCedulaPaciente()!=true){
                     pacienteAdiccionar=ControladorPaciente.verificarUsuario(txtNombreCompleto.getText(), txtCedula.getText(), txtDireccion.getText(),ControladorPaciente.getEps()[pos], txtTelefono.getText(), chkSospechoso.isSelected(), chkComplicaciones.isSelected(), txtObservaciones.getText());
               String mensaje= ControladorPaciente.adicionaPaciente(pacienteAdiccionar);
           llenarPacientes();    
                     JOptionPane.showMessageDialog(rootPane, mensaje);
           txtNombreCompleto.setText("");
           txtCedula.setText("");
           txtDireccion.setText("");
           txtObservaciones.setText("");
           txtTelefono.setText("");
           chkComplicaciones.setSelected(false);
           chkSospechoso.setSelected(false);
                }else{
                    JOptionPane.showMessageDialog(rootPane, "La cedula ya se encuentra registrada");
                }
          
//           
           
        } catch (UsuarioExcepcion ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage(), "Error", 1);
        }
          
        
        
//             try {
//                    
//              
//        } catch (PacienteExcepciones) {
//            JOptionPane.showMessageDialog(rootPane, getMessage(), "Error", 1);
//        }
           
           
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void chkSospechosoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkSospechosoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chkSospechosoActionPerformed

    private void btnAregarPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAregarPacienteActionPerformed
        jifCrearPacientes.show();
    }//GEN-LAST:event_btnAregarPacienteActionPerformed

    private void btnEliminarPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarPacienteActionPerformed
        eliminarDatos();
    }//GEN-LAST:event_btnEliminarPacienteActionPerformed

    private void btnVerEstadisticaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerEstadisticaActionPerformed
                  grafico.show();
        
        
        
    }//GEN-LAST:event_btnVerEstadisticaActionPerformed

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
            java.util.logging.Logger.getLogger(MDIProyectoh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MDIProyectoh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MDIProyectoh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MDIProyectoh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MDIProyectoh().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem aboutMenuItem;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnAregarPaciente;
    private javax.swing.JButton btnEliminarPaciente;
    private javax.swing.JButton btnIngresar;
    private javax.swing.JButton btnOk;
    private javax.swing.JButton btnVerEstadistica;
    private javax.swing.JCheckBox chkComplicaciones;
    private javax.swing.JCheckBox chkSospechoso;
    private javax.swing.JComboBox<String> cmbEps;
    private javax.swing.JMenuItem contentMenuItem;
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JInternalFrame jifBienvenido;
    private javax.swing.JInternalFrame jifCrearPacientes;
    private javax.swing.JInternalFrame jifLogin;
    private javax.swing.JInternalFrame jifVerPacientes;
    private javax.swing.JTextPane jitCarNom;
    private javax.swing.JLabel lblCedula;
    private javax.swing.JLabel lblContrasenia;
    private javax.swing.JLabel lblDireccion;
    private javax.swing.JLabel lblEps;
    private javax.swing.JLabel lblMensaje;
    private javax.swing.JLabel lblNombreCompleto;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem mnucrearpaciente;
    private javax.swing.JMenuItem mnusalir;
    private javax.swing.JMenuItem mnuverpaciente;
    private javax.swing.JTable tblPacientes;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JPasswordField txtContrasenia;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtNombreCompleto;
    private javax.swing.JTextField txtObservaciones;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables

}
