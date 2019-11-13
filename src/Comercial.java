import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

/** @author David Grande */
public class Comercial extends javax.swing.JFrame {

  Connection con;
  ResultSet rs;
  Statement st;
  String driver = "com.mysql.jdbc.Driver";
  String urlMysql = "jdbc:mysql://localhost:3306/";

  /** Creates new form Comercial */
  public Comercial() {
    initComponents();
    txtmoddeleg.setEnabled(false);
    txtmodgerencia.setEnabled(false);
    txtmodnombre.setEnabled(false);
    txtpass1.setEnabled(false);
    txtpass2.setEnabled(false);
    txtpassnomb.setEnabled(false);
    txtusunombj.setEnabled(false);
    cmbbaja.setEnabled(false);
  }

  public void limpiaraltas() {
    txtnombrealtas.setText("");
    txtdelegacionaltas.setText("");
    txtpassaltas.setText("");
    txtrepitpassaltas.setText("");
    txtusuarioaltas.setText("");
    txtgerentealtas.setText("");
  }

  public void limpiarmod() {
    txtmoddeleg.setText("");
    txtmodgerencia.setText("");
    txtmodnombre.setText("");
    txtmodusuario.setText("");
    txtmodusuario.setEnabled(true);
    txtmoddeleg.setEnabled(false);
    txtmodgerencia.setEnabled(false);
    txtmodnombre.setEnabled(false);
  }

  public void limpiarpass() {
    txtpassusu.setText("");
    txtpass1.setText("");
    txtpass2.setText("");
    txtpassnomb.setText("");
    txtpassusu.setEnabled(true);
    txtpass1.setEnabled(false);
    txtpass2.setEnabled(false);
    txtpassnomb.setEnabled(false);
  }

  @SuppressWarnings("unchecked")
  private void initComponents() {

    jTextField3 = new javax.swing.JTextField();
    jTabbedPane1 = new javax.swing.JTabbedPane();
    jPanel1 = new javax.swing.JPanel();
    jPanel2 = new javax.swing.JPanel();
    jLabel2 = new javax.swing.JLabel();
    txtnombrealtas = new javax.swing.JTextField();
    jLabel3 = new javax.swing.JLabel();
    btnsalircomerciales = new javax.swing.JButton();
    btnaltacomercial = new javax.swing.JButton();
    txtdelegacionaltas = new javax.swing.JTextField();
    jLabel4 = new javax.swing.JLabel();
    txtusuarioaltas = new javax.swing.JTextField();
    jLabel5 = new javax.swing.JLabel();
    jLabel6 = new javax.swing.JLabel();
    txtgerentealtas = new javax.swing.JTextField();
    jLabel7 = new javax.swing.JLabel();
    txtpassaltas = new javax.swing.JPasswordField();
    txtrepitpassaltas = new javax.swing.JPasswordField();
    jPanel3 = new javax.swing.JPanel();
    jPanel5 = new javax.swing.JPanel();
    jLabel8 = new javax.swing.JLabel();
    txtmodnombre = new javax.swing.JTextField();
    jLabel9 = new javax.swing.JLabel();
    txtmoddeleg = new javax.swing.JTextField();
    jLabel10 = new javax.swing.JLabel();
    txtmodusuario = new javax.swing.JTextField();
    jLabel11 = new javax.swing.JLabel();
    txtmodgerencia = new javax.swing.JTextField();
    btnsalir2 = new javax.swing.JButton();
    btnguarmod = new javax.swing.JButton();
    btnlimpiar = new javax.swing.JButton();
    jPanel4 = new javax.swing.JPanel();
    jPanel6 = new javax.swing.JPanel();
    jLabel12 = new javax.swing.JLabel();
    txtpassusu = new javax.swing.JTextField();
    jLabel13 = new javax.swing.JLabel();
    jLabel14 = new javax.swing.JLabel();
    txtpass1 = new javax.swing.JPasswordField();
    txtpass2 = new javax.swing.JPasswordField();
    btnsalir3 = new javax.swing.JButton();
    btncmbpass = new javax.swing.JButton();
    jLabel15 = new javax.swing.JLabel();
    txtpassnomb = new javax.swing.JTextField();
    jPanel7 = new javax.swing.JPanel();
    jPanel8 = new javax.swing.JPanel();
    jLabel16 = new javax.swing.JLabel();
    txtusubaja = new javax.swing.JTextField();
    cmbbaja = new javax.swing.JComboBox();
    jLabel17 = new javax.swing.JLabel();
    jLabel1 = new javax.swing.JLabel();
    txtusunombj = new javax.swing.JTextField();
    btnsalir4 = new javax.swing.JButton();
    btnbaja = new javax.swing.JButton();

    jTextField3.setText("jTextField3");

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    jTabbedPane1.setToolTipText("");

    jLabel2.setText("Nombre :");

    jLabel3.setText("Delegacion :");

    btnsalircomerciales.setText("Salir");
    btnsalircomerciales.addActionListener(
        new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnsalircomercialesActionPerformed(evt);
          }
        });

    btnaltacomercial.setText("Alta");
    btnaltacomercial.setMaximumSize(new java.awt.Dimension(56, 32));
    btnaltacomercial.setMinimumSize(new java.awt.Dimension(56, 32));
    btnaltacomercial.addActionListener(
        new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnaltacomercialActionPerformed(evt);
          }
        });

    jLabel4.setText("Usuario / Codigo Comercial :");

    jLabel5.setText("Contraseña :");

    jLabel6.setText("Gerente :");

    jLabel7.setText("Repite Contraseña :");

    txtpassaltas.setMinimumSize(new java.awt.Dimension(14, 24));

    txtrepitpassaltas.setMinimumSize(new java.awt.Dimension(14, 24));

    javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
    jPanel2.setLayout(jPanel2Layout);
    jPanel2Layout.setHorizontalGroup(
        jPanel2Layout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(
                jPanel2Layout
                    .createSequentialGroup()
                    .addGap(18, 18, 18)
                    .addGroup(
                        jPanel2Layout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(
                                jPanel2Layout
                                    .createParallelGroup(
                                        javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(
                                        jLabel7,
                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                        Short.MAX_VALUE)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel5))
                            .addComponent(jLabel4)
                            .addComponent(
                                btnaltacomercial,
                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                76,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(
                                jLabel6,
                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                118,
                                javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(
                        jPanel2Layout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(
                                javax.swing.GroupLayout.Alignment.TRAILING,
                                jPanel2Layout
                                    .createSequentialGroup()
                                    .addGroup(
                                        jPanel2Layout
                                            .createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(
                                                txtnombrealtas,
                                                javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtdelegacionaltas))
                                    .addGap(21, 21, 21))
                            .addGroup(
                                javax.swing.GroupLayout.Alignment.TRAILING,
                                jPanel2Layout
                                    .createSequentialGroup()
                                    .addGroup(
                                        jPanel2Layout
                                            .createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(
                                                txtgerentealtas,
                                                javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(
                                                txtrepitpassaltas,
                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                Short.MAX_VALUE)
                                            .addComponent(
                                                txtpassaltas,
                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                Short.MAX_VALUE)
                                            .addGroup(
                                                jPanel2Layout
                                                    .createSequentialGroup()
                                                    .addGap(0, 45, Short.MAX_VALUE)
                                                    .addComponent(
                                                        btnsalircomerciales,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        76,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(txtusuarioaltas))
                                    .addGap(20, 20, 20)))));
    jPanel2Layout.setVerticalGroup(
        jPanel2Layout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(
                jPanel2Layout
                    .createSequentialGroup()
                    .addGap(25, 25, 25)
                    .addGroup(
                        jPanel2Layout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(
                                txtnombrealtas,
                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(
                        jPanel2Layout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(
                                txtdelegacionaltas,
                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(
                        jPanel2Layout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(
                                txtusuarioaltas,
                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(
                                jLabel4,
                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                21,
                                javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(
                        jPanel2Layout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(
                                txtpassaltas,
                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                27,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(
                        jPanel2Layout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(
                                txtrepitpassaltas,
                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                30,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(
                        jPanel2Layout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(
                                txtgerentealtas,
                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(
                        javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                    .addGroup(
                        jPanel2Layout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnsalircomerciales)
                            .addComponent(
                                btnaltacomercial,
                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)));

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
        jPanel1Layout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(
                jPanel2,
                javax.swing.GroupLayout.DEFAULT_SIZE,
                javax.swing.GroupLayout.DEFAULT_SIZE,
                Short.MAX_VALUE));
    jPanel1Layout.setVerticalGroup(
        jPanel1Layout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(
                jPanel2,
                javax.swing.GroupLayout.DEFAULT_SIZE,
                javax.swing.GroupLayout.DEFAULT_SIZE,
                Short.MAX_VALUE));

    jTabbedPane1.addTab("Altas", jPanel1);

    jLabel8.setText("Nombre :");

    jLabel9.setText("Delegacion :");

    jLabel10.setText("Usuario :");

    txtmodusuario.addFocusListener(
        new java.awt.event.FocusAdapter() {
          public void focusLost(java.awt.event.FocusEvent evt) {
            txtmodusuarioFocusLost(evt);
          }
        });

    jLabel11.setText("Gerente :");

    btnsalir2.setText("Salir");
    btnsalir2.addActionListener(
        new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnsalir2ActionPerformed(evt);
          }
        });

    btnguarmod.setText("Guardar");
    btnguarmod.addActionListener(
        new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnguarmodActionPerformed(evt);
          }
        });

    btnlimpiar.setText("Limpiar");
    btnlimpiar.addActionListener(
        new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnlimpiarActionPerformed(evt);
          }
        });

    javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
    jPanel5.setLayout(jPanel5Layout);
    jPanel5Layout.setHorizontalGroup(
        jPanel5Layout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(
                javax.swing.GroupLayout.Alignment.TRAILING,
                jPanel5Layout
                    .createSequentialGroup()
                    .addGap(17, 17, 17)
                    .addGroup(
                        jPanel5Layout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11)
                            .addComponent(btnguarmod))
                    .addGroup(
                        jPanel5Layout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(
                                jPanel5Layout
                                    .createSequentialGroup()
                                    .addPreferredGap(
                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                        Short.MAX_VALUE)
                                    .addGroup(
                                        jPanel5Layout
                                            .createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(
                                                txtmodnombre,
                                                javax.swing.GroupLayout.Alignment.TRAILING,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                114,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(
                                                txtmoddeleg,
                                                javax.swing.GroupLayout.Alignment.TRAILING,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                114,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(
                                                txtmodusuario,
                                                javax.swing.GroupLayout.Alignment.TRAILING,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                114,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(
                                                txtmodgerencia,
                                                javax.swing.GroupLayout.Alignment.TRAILING,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                114,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(
                                jPanel5Layout
                                    .createSequentialGroup()
                                    .addGap(36, 36, 36)
                                    .addComponent(btnlimpiar)
                                    .addPreferredGap(
                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                        44,
                                        Short.MAX_VALUE)
                                    .addComponent(
                                        btnsalir2,
                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                        76,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(20, 20, 20)));
    jPanel5Layout.setVerticalGroup(
        jPanel5Layout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(
                jPanel5Layout
                    .createSequentialGroup()
                    .addGap(33, 33, 33)
                    .addGroup(
                        jPanel5Layout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(
                                txtmodnombre,
                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(
                        jPanel5Layout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(
                                txtmoddeleg,
                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(
                        jPanel5Layout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(
                                txtmodusuario,
                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(
                        jPanel5Layout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(
                                txtmodgerencia,
                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(
                        javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                    .addGroup(
                        jPanel5Layout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnsalir2)
                            .addComponent(btnguarmod)
                            .addComponent(btnlimpiar))
                    .addGap(14, 14, 14)));

    javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
    jPanel3.setLayout(jPanel3Layout);
    jPanel3Layout.setHorizontalGroup(
        jPanel3Layout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(
                jPanel5,
                javax.swing.GroupLayout.DEFAULT_SIZE,
                javax.swing.GroupLayout.DEFAULT_SIZE,
                Short.MAX_VALUE));
    jPanel3Layout.setVerticalGroup(
        jPanel3Layout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(
                jPanel5,
                javax.swing.GroupLayout.DEFAULT_SIZE,
                javax.swing.GroupLayout.DEFAULT_SIZE,
                Short.MAX_VALUE));

    jTabbedPane1.addTab("Modificaciones", jPanel3);

    jLabel12.setText("Usuario :");

    txtpassusu.addFocusListener(
        new java.awt.event.FocusAdapter() {
          public void focusLost(java.awt.event.FocusEvent evt) {
            txtpassusuFocusLost(evt);
          }
        });

    jLabel13.setText("Contraseña :");

    jLabel14.setText("Repite Contraseña :");

    btnsalir3.setText("Salir");
    btnsalir3.addActionListener(
        new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnsalir3ActionPerformed(evt);
          }
        });

    btncmbpass.setText("Cambiar");
    btncmbpass.addActionListener(
        new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
            btncmbpassActionPerformed(evt);
          }
        });

    jLabel15.setText("Nombre :");

    javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
    jPanel6.setLayout(jPanel6Layout);
    jPanel6Layout.setHorizontalGroup(
        jPanel6Layout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(
                jPanel6Layout
                    .createSequentialGroup()
                    .addGroup(
                        jPanel6Layout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(
                                jPanel6Layout
                                    .createSequentialGroup()
                                    .addGap(25, 25, 25)
                                    .addGroup(
                                        jPanel6Layout
                                            .createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel14)
                                            .addComponent(jLabel13)
                                            .addComponent(btncmbpass))
                                    .addGap(77, 77, 77)
                                    .addGroup(
                                        jPanel6Layout
                                            .createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(
                                                btnsalir3,
                                                javax.swing.GroupLayout.Alignment.TRAILING,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                89,
                                                Short.MAX_VALUE)
                                            .addComponent(txtpass1)
                                            .addComponent(txtpass2)))
                            .addGroup(
                                jPanel6Layout
                                    .createSequentialGroup()
                                    .addGap(24, 24, 24)
                                    .addGroup(
                                        jPanel6Layout
                                            .createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel12)
                                            .addComponent(jLabel15))
                                    .addPreferredGap(
                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                        Short.MAX_VALUE)
                                    .addGroup(
                                        jPanel6Layout
                                            .createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtpassusu)
                                            .addComponent(
                                                txtpassnomb,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                89,
                                                Short.MAX_VALUE))))
                    .addGap(36, 36, 36)));
    jPanel6Layout.setVerticalGroup(
        jPanel6Layout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(
                jPanel6Layout
                    .createSequentialGroup()
                    .addGap(40, 40, 40)
                    .addGroup(
                        jPanel6Layout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(
                                txtpassusu,
                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(
                        jPanel6Layout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(
                                txtpassnomb,
                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(
                        jPanel6Layout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(
                                txtpass1,
                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(
                        jPanel6Layout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(
                                txtpass2,
                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(67, 67, 67)
                    .addGroup(
                        jPanel6Layout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnsalir3)
                            .addComponent(btncmbpass))
                    .addContainerGap(22, Short.MAX_VALUE)));

    javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
    jPanel4.setLayout(jPanel4Layout);
    jPanel4Layout.setHorizontalGroup(
        jPanel4Layout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(
                jPanel6,
                javax.swing.GroupLayout.DEFAULT_SIZE,
                javax.swing.GroupLayout.DEFAULT_SIZE,
                Short.MAX_VALUE));
    jPanel4Layout.setVerticalGroup(
        jPanel4Layout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(
                jPanel6,
                javax.swing.GroupLayout.DEFAULT_SIZE,
                javax.swing.GroupLayout.DEFAULT_SIZE,
                Short.MAX_VALUE));

    jTabbedPane1.addTab("Reset Contraseña", jPanel4);

    jLabel16.setText("Usuario :");

    txtusubaja.addFocusListener(
        new java.awt.event.FocusAdapter() {
          public void focusLost(java.awt.event.FocusEvent evt) {
            txtusubajaFocusLost(evt);
          }
        });

    cmbbaja.setModel(new javax.swing.DefaultComboBoxModel(new String[] {"-", "SI", "NO"}));

    jLabel17.setText("Dar de baja :");

    jLabel1.setText("Nombre : ");

    btnsalir4.setText("Salir");
    btnsalir4.addActionListener(
        new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnsalir4ActionPerformed(evt);
          }
        });

    btnbaja.setText("Baja");
    btnbaja.addActionListener(
        new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnbajaActionPerformed(evt);
          }
        });

    javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
    jPanel8.setLayout(jPanel8Layout);
    jPanel8Layout.setHorizontalGroup(
        jPanel8Layout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(
                javax.swing.GroupLayout.Alignment.TRAILING,
                jPanel8Layout
                    .createSequentialGroup()
                    .addGap(15, 15, 15)
                    .addGroup(
                        jPanel8Layout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(
                                jLabel1,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                Short.MAX_VALUE)
                            .addComponent(
                                jLabel17,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                Short.MAX_VALUE)
                            .addComponent(
                                jLabel16,
                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                69,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(
                                btnbaja,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                Short.MAX_VALUE))
                    .addPreferredGap(
                        javax.swing.LayoutStyle.ComponentPlacement.RELATED, 114, Short.MAX_VALUE)
                    .addGroup(
                        jPanel8Layout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmbbaja, 0, 100, Short.MAX_VALUE)
                            .addComponent(txtusubaja)
                            .addComponent(txtusunombj)
                            .addComponent(
                                btnsalir4,
                                javax.swing.GroupLayout.Alignment.TRAILING,
                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                74,
                                javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(42, 42, 42)));
    jPanel8Layout.setVerticalGroup(
        jPanel8Layout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(
                jPanel8Layout
                    .createSequentialGroup()
                    .addGap(29, 29, 29)
                    .addGroup(
                        jPanel8Layout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(
                                txtusubaja,
                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(
                        jPanel8Layout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(
                                txtusunombj,
                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(
                        jPanel8Layout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(
                                cmbbaja,
                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17))
                    .addPreferredGap(
                        javax.swing.LayoutStyle.ComponentPlacement.RELATED, 104, Short.MAX_VALUE)
                    .addGroup(
                        jPanel8Layout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnsalir4)
                            .addComponent(btnbaja))
                    .addGap(14, 14, 14)));

    javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
    jPanel7.setLayout(jPanel7Layout);
    jPanel7Layout.setHorizontalGroup(
        jPanel7Layout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(
                jPanel8,
                javax.swing.GroupLayout.DEFAULT_SIZE,
                javax.swing.GroupLayout.DEFAULT_SIZE,
                Short.MAX_VALUE));
    jPanel7Layout.setVerticalGroup(
        jPanel7Layout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(
                jPanel8,
                javax.swing.GroupLayout.DEFAULT_SIZE,
                javax.swing.GroupLayout.DEFAULT_SIZE,
                Short.MAX_VALUE));

    jTabbedPane1.addTab("Bajas", jPanel7);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1));
    layout.setVerticalGroup(
        layout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1));

    pack();
  } // </editor-fold>//GEN-END:initComponents

  private void btnsalircomercialesActionPerformed(
      java.awt.event.ActionEvent evt) { // GEN-FIRST:event_btnsalircomercialesActionPerformed
    this.setVisible(false);
  } // GEN-LAST:event_btnsalircomercialesActionPerformed

  private void btnaltacomercialActionPerformed(
      java.awt.event.ActionEvent evt) { // GEN-FIRST:event_btnaltacomercialActionPerformed
    int b = 0;
    String pass = new String(txtpassaltas.getPassword());
    String pass1 = new String(txtrepitpassaltas.getPassword());
    if (!txtnombrealtas.getText().equalsIgnoreCase("")
        || !txtdelegacionaltas.getText().equalsIgnoreCase("")
        || !pass.equalsIgnoreCase("")
        || !pass1.equalsIgnoreCase("")
        || !txtusuarioaltas.getText().equalsIgnoreCase("")
        || !txtgerentealtas.getText().equalsIgnoreCase("")) {
      if (pass.equals(pass1)) {
        try {
          Class.forName(driver).newInstance();
          con = DriverManager.getConnection(urlMysql + "sencitel", "sencitel", "Ludwig1753");
          st = con.createStatement();
          rs = st.executeQuery("select usuario from comercial ");
          rs.next();
          do {
            if (rs.getString("usuario").equalsIgnoreCase(txtusuarioaltas.getText())) {
              JOptionPane.showMessageDialog(
                  null, "El codigo de comercial ya existe", "Error", JOptionPane.WARNING_MESSAGE);
              b = 1;
            }
          } while (rs.next());
          if (b == 0) {

            if (JOptionPane.showConfirmDialog(
                    null, "Estas dando de alta un Gerente?", "Alta", JOptionPane.YES_NO_OPTION)
                == JOptionPane.YES_OPTION) {
              st.execute(
                  "INSERT INTO `comercial`(`usuario`, `nombre`, `pass`, `delegacion`, `gerente`, `activo`) VALUES "
                      + "('"
                      + txtusuarioaltas.getText()
                      + "', '"
                      + txtnombrealtas.getText()
                      + "', "
                      + "'"
                      + pass
                      + "', '"
                      + txtdelegacionaltas.getText()
                      + "', "
                      + "'"
                      + txtgerentealtas.getText()
                      + "','NO')");

              JOptionPane.showMessageDialog(
                  null,
                  "Ya esta dado de alta de forma correcta",
                  "Error",
                  JOptionPane.YES_NO_CANCEL_OPTION);

            } else {
              st.execute(
                  "INSERT INTO `comercial`(`usuario`, `nombre`, `pass`, `delegacion`, `gerente`, `activo`) VALUES "
                      + "('"
                      + txtusuarioaltas.getText()
                      + "', '"
                      + txtnombrealtas.getText()
                      + "', "
                      + "'"
                      + pass
                      + "', '"
                      + txtdelegacionaltas.getText()
                      + "', "
                      + "'"
                      + txtgerentealtas.getText()
                      + "','SI')");

              JOptionPane.showMessageDialog(
                  null,
                  "Ya esta dado de alta de forma correcta",
                  "Altas",
                  JOptionPane.YES_NO_CANCEL_OPTION);
              limpiaraltas();
            }
          }

        } catch (SQLException
            | ClassNotFoundException
            | InstantiationException
            | IllegalAccessException ex) {
          Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
      } else {
        JOptionPane.showMessageDialog(
            null, "Las Contreñas no coinciden", "Error", JOptionPane.WARNING_MESSAGE);
      }

    } else {
      JOptionPane.showMessageDialog(
          null, "Faltan Campos Obligatorios por cubrir", "Error", JOptionPane.WARNING_MESSAGE);
    }
  } // GEN-LAST:event_btnaltacomercialActionPerformed

  private void btnsalir2ActionPerformed(
      java.awt.event.ActionEvent evt) { // GEN-FIRST:event_btnsalir2ActionPerformed
    this.setVisible(false);
  } // GEN-LAST:event_btnsalir2ActionPerformed

  private void txtmodusuarioFocusLost(
      java.awt.event.FocusEvent evt) { // GEN-FIRST:event_txtmodusuarioFocusLost
    if (txtmodusuario.getText().equalsIgnoreCase("")) {
      JOptionPane.showMessageDialog(
          null, "Pon codigo de comercial", "Error", JOptionPane.WARNING_MESSAGE);
    } else {
      try {
        Class.forName(driver).newInstance();
        con = DriverManager.getConnection(urlMysql + "sencitel", "sencitel", "Ludwig1753");
        st = con.createStatement();
        rs =
            st.executeQuery(
                "select * from comercial where usuario='" + txtmodusuario.getText() + "' ");
        if (rs.next()) {
          txtmoddeleg.setText(rs.getString("delegacion"));
          txtmodgerencia.setText(rs.getString("Gerente"));
          txtmodnombre.setText(rs.getString("nombre"));
          txtmodusuario.setEnabled(false);
          txtmoddeleg.setEnabled(true);
          txtmodgerencia.setEnabled(true);
          txtmodnombre.setEnabled(true);
        } else {
          JOptionPane.showMessageDialog(
              null, "Codigo incorrecto", "Error", JOptionPane.WARNING_MESSAGE);
        }
      } catch (SQLException
          | ClassNotFoundException
          | InstantiationException
          | IllegalAccessException ex) {
        Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
  } // GEN-LAST:event_txtmodusuarioFocusLost

  private void btnlimpiarActionPerformed(
      java.awt.event.ActionEvent evt) { // GEN-FIRST:event_btnlimpiarActionPerformed
    limpiarmod();
  } // GEN-LAST:event_btnlimpiarActionPerformed

  private void btnguarmodActionPerformed(
      java.awt.event.ActionEvent evt) { // GEN-FIRST:event_btnguarmodActionPerformed
    if (!txtmodnombre.getText().equalsIgnoreCase("")
        || !txtmoddeleg.getText().equalsIgnoreCase("")
        || !txtmodgerencia.getText().equalsIgnoreCase("")) {
      try {
        Class.forName(driver).newInstance();
        con = DriverManager.getConnection(urlMysql + "sencitel", "sencitel", "Ludwig1753");
        st = con.createStatement();
        st.executeUpdate(
            "UPDATE comercial SET nombre='"
                + txtmodnombre.getText()
                + "',"
                + "delegacion='"
                + txtmoddeleg.getText()
                + "',"
                + "Gerente='"
                + txtmodgerencia.getText()
                + "' where usuario='"
                + txtmodusuario.getText()
                + "'");
      } catch (SQLException
          | ClassNotFoundException
          | InstantiationException
          | IllegalAccessException ex) {
        Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
      }
      limpiarmod();
    } else {
      JOptionPane.showMessageDialog(
          null, "Has borrado campos obligatorios", "Error", JOptionPane.WARNING_MESSAGE);
    }
  } // GEN-LAST:event_btnguarmodActionPerformed

  private void btnsalir3ActionPerformed(
      java.awt.event.ActionEvent evt) { // GEN-FIRST:event_btnsalir3ActionPerformed
    this.setVisible(false);
  } // GEN-LAST:event_btnsalir3ActionPerformed

  private void txtpassusuFocusLost(
      java.awt.event.FocusEvent evt) { // GEN-FIRST:event_txtpassusuFocusLost
    if (txtpassusu.getText().equalsIgnoreCase("")) {
      JOptionPane.showMessageDialog(
          null, "Pon codigo de comercial", "Error", JOptionPane.WARNING_MESSAGE);
    } else {
      try {
        Class.forName(driver).newInstance();
        con = DriverManager.getConnection(urlMysql + "sencitel", "sencitel", "Ludwig1753");
        st = con.createStatement();
        rs =
            st.executeQuery(
                "select * from comercial where usuario='" + txtpassusu.getText() + "' ");
        if (rs.next()) {
          txtpassnomb.setText(rs.getString("nombre"));
          txtpassusu.setEnabled(false);
          txtpass1.setEnabled(true);
          txtpass2.setEnabled(true);
        } else {
          JOptionPane.showMessageDialog(
              null, "Codigo incorrecto", "Error", JOptionPane.WARNING_MESSAGE);
        }
      } catch (SQLException
          | ClassNotFoundException
          | InstantiationException
          | IllegalAccessException ex) {
        Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
  } // GEN-LAST:event_txtpassusuFocusLost

  private void btncmbpassActionPerformed(
      java.awt.event.ActionEvent evt) { // GEN-FIRST:event_btncmbpassActionPerformed
    String pass = new String(txtpass1.getPassword());
    String pass1 = new String(txtpass2.getPassword());
    if (!pass.equals("") || !pass1.equals("")) {
      if (pass.equals(pass1)) {

        try {
          Class.forName(driver).newInstance();
          con = DriverManager.getConnection(urlMysql + "sencitel", "sencitel", "Ludwig1753");
          st = con.createStatement();
          st.executeUpdate(
              "UPDATE comercial SET pass='"
                  + pass
                  + "' where usuario='"
                  + txtpassusu.getText()
                  + "'");
          limpiarpass();
          JOptionPane.showMessageDialog(null, "Cambiada!!!", "Listo", JOptionPane.WARNING_MESSAGE);
        } catch (SQLException
            | ClassNotFoundException
            | InstantiationException
            | IllegalAccessException ex) {
          Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }

      } else {
        JOptionPane.showMessageDialog(
            null, "Las contraseñas no coinciden", "Error", JOptionPane.WARNING_MESSAGE);
      }
    } else {
      JOptionPane.showMessageDialog(null, "Pon contraseña", "Error", JOptionPane.WARNING_MESSAGE);
    }
  } // GEN-LAST:event_btncmbpassActionPerformed

  private void txtusubajaFocusLost(
      java.awt.event.FocusEvent evt) { // GEN-FIRST:event_txtusubajaFocusLost
    if (txtusubaja.getText().equalsIgnoreCase("")) {
      JOptionPane.showMessageDialog(
          null, "Pon codigo de comercial", "Error", JOptionPane.WARNING_MESSAGE);
    } else {
      try {
        Class.forName(driver).newInstance();
        con = DriverManager.getConnection(urlMysql + "sencitel", "sencitel", "Ludwig1753");
        st = con.createStatement();
        rs =
            st.executeQuery(
                "select * from comercial where usuario='" + txtusubaja.getText() + "' ");
        if (rs.next()) {
          txtusunombj.setText(rs.getString("nombre"));
          txtusubaja.setEnabled(false);
          if (rs.getString("activo").equalsIgnoreCase("SI")) {
            cmbbaja.setSelectedIndex(1);

          } else {
            cmbbaja.setSelectedIndex(2);
          }
          cmbbaja.setEnabled(true);
        } else {
          JOptionPane.showMessageDialog(
              null, "Codigo incorrecto", "Error", JOptionPane.WARNING_MESSAGE);
        }
      } catch (SQLException
          | ClassNotFoundException
          | InstantiationException
          | IllegalAccessException ex) {
        Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
  } // GEN-LAST:event_txtusubajaFocusLost

  private void btnsalir4ActionPerformed(
      java.awt.event.ActionEvent evt) { // GEN-FIRST:event_btnsalir4ActionPerformed
    this.setVisible(false);
  } // GEN-LAST:event_btnsalir4ActionPerformed

  private void btnbajaActionPerformed(
      java.awt.event.ActionEvent evt) { // GEN-FIRST:event_btnbajaActionPerformed

    try {
      Class.forName(driver).newInstance();
      con = DriverManager.getConnection(urlMysql + "sencitel", "sencitel", "Ludwig1753");
      st = con.createStatement();
      if (cmbbaja.getSelectedItem().toString().equalsIgnoreCase("SI")) {
        st.executeUpdate(
            "UPDATE comercial SET activo='NO' where usuario='" + txtusubaja.getText() + "'");
      } else {
        if (cmbbaja.getSelectedItem().toString().equalsIgnoreCase("NO")) {
          st.executeUpdate(
              "UPDATE comercial SET activo='SI' where usuario='" + txtusubaja.getText() + "'");
        } else {
          JOptionPane.showMessageDialog(
              null, "Opcion no valida", "Listo", JOptionPane.WARNING_MESSAGE);
        }
      }
      cmbbaja.setSelectedIndex(0);
      cmbbaja.setEnabled(false);
      txtusubaja.setText("");
      txtusubaja.setEnabled(true);

    } catch (SQLException
        | ClassNotFoundException
        | InstantiationException
        | IllegalAccessException ex) {
      Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
    }
  } // GEN-LAST:event_btnbajaActionPerformed

  /** @param args the command line arguments */
  public static void main(String args[]) {
    /* Set the Nimbus look and feel */
    // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
    /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
     * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
     */
    try {
      for (javax.swing.UIManager.LookAndFeelInfo info :
          javax.swing.UIManager.getInstalledLookAndFeels()) {
        if ("Nimbus".equals(info.getName())) {
          javax.swing.UIManager.setLookAndFeel(info.getClassName());
          break;
        }
      }
    } catch (ClassNotFoundException
        | InstantiationException
        | IllegalAccessException
        | javax.swing.UnsupportedLookAndFeelException ex) {
      java.util.logging.Logger.getLogger(Comercial.class.getName())
          .log(java.util.logging.Level.SEVERE, null, ex);
    }
    // </editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(
        new Runnable() {
          @Override
          public void run() {
            new Comercial().setVisible(true);
          }
        });
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton btnaltacomercial;
  private javax.swing.JButton btnbaja;
  private javax.swing.JButton btncmbpass;
  private javax.swing.JButton btnguarmod;
  private javax.swing.JButton btnlimpiar;
  private javax.swing.JButton btnsalir2;
  private javax.swing.JButton btnsalir3;
  private javax.swing.JButton btnsalir4;
  private javax.swing.JButton btnsalircomerciales;
  private javax.swing.JComboBox cmbbaja;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel10;
  private javax.swing.JLabel jLabel11;
  private javax.swing.JLabel jLabel12;
  private javax.swing.JLabel jLabel13;
  private javax.swing.JLabel jLabel14;
  private javax.swing.JLabel jLabel15;
  private javax.swing.JLabel jLabel16;
  private javax.swing.JLabel jLabel17;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JLabel jLabel4;
  private javax.swing.JLabel jLabel5;
  private javax.swing.JLabel jLabel6;
  private javax.swing.JLabel jLabel7;
  private javax.swing.JLabel jLabel8;
  private javax.swing.JLabel jLabel9;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JPanel jPanel2;
  private javax.swing.JPanel jPanel3;
  private javax.swing.JPanel jPanel4;
  private javax.swing.JPanel jPanel5;
  private javax.swing.JPanel jPanel6;
  private javax.swing.JPanel jPanel7;
  private javax.swing.JPanel jPanel8;
  private javax.swing.JTabbedPane jTabbedPane1;
  private javax.swing.JTextField jTextField3;
  private javax.swing.JTextField txtdelegacionaltas;
  private javax.swing.JTextField txtgerentealtas;
  private javax.swing.JTextField txtmoddeleg;
  private javax.swing.JTextField txtmodgerencia;
  private javax.swing.JTextField txtmodnombre;
  private javax.swing.JTextField txtmodusuario;
  private javax.swing.JTextField txtnombrealtas;
  private javax.swing.JPasswordField txtpass1;
  private javax.swing.JPasswordField txtpass2;
  private javax.swing.JPasswordField txtpassaltas;
  private javax.swing.JTextField txtpassnomb;
  private javax.swing.JTextField txtpassusu;
  private javax.swing.JPasswordField txtrepitpassaltas;
  private javax.swing.JTextField txtusuarioaltas;
  private javax.swing.JTextField txtusubaja;
  private javax.swing.JTextField txtusunombj;
  // End of variables declaration//GEN-END:variables
}
