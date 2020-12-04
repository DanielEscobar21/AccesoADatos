
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class EliminarVisita extends JInternalFrame {

    private JLabel ApMa;
    private JLabel ApPa;
    private JButton Buscar;
    private JTextField Busqueda;
    private JButton Eliminar;
    private JLabel Motivo;
    private JLabel Nombre;
    private JLabel Nota;
    private JPanel Panel;
    private JComboBox<String> Por;
    private JTable Tabla;
    private JLabel TipoDoc;
    private JLabel Titulo;
    private JLabel VisitaA;
    private JLabel eApMa;
    private JLabel eApPa;
    private JLabel eBuscar;
    private JLabel eBuscar1;
    private JLabel eMotivo;
    private JLabel eNombre1;
    private JLabel eTipoDoc;
    private JLabel eVisitaA;
    private JScrollPane jScrollPane1;
    DefaultTableModel modelo = new DefaultTableModel();
    String Select = "Nombre";
    String ID = "";

    public EliminarVisita() throws ClassNotFoundException {
        java.awt.GridBagConstraints gridBagConstraints;

        Panel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla = new javax.swing.JTable();
        Titulo = new javax.swing.JLabel();
        eTipoDoc = new javax.swing.JLabel();
        eApPa = new javax.swing.JLabel();
        eApMa = new javax.swing.JLabel();
        eVisitaA = new javax.swing.JLabel();
        eMotivo = new javax.swing.JLabel();
        Eliminar = new javax.swing.JButton();
        eNombre1 = new javax.swing.JLabel();
        eBuscar = new javax.swing.JLabel();
        Por = new javax.swing.JComboBox<>();
        Busqueda = new javax.swing.JTextField();
        eBuscar1 = new javax.swing.JLabel();
        Buscar = new javax.swing.JButton();
        Nota = new javax.swing.JLabel();
        Nombre = new javax.swing.JLabel();
        ApPa = new javax.swing.JLabel();
        TipoDoc = new javax.swing.JLabel();
        VisitaA = new javax.swing.JLabel();
        ApMa = new javax.swing.JLabel();
        Motivo = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Agregar");
        getContentPane().setLayout(new java.awt.GridBagLayout());

        Panel.setBackground(new java.awt.Color(255, 255, 255));
        Panel.setForeground(new java.awt.Color(255, 255, 255));
        Panel.setLayout(new java.awt.GridBagLayout());

        Tabla.setBackground(new java.awt.Color(255, 255, 255));
        Tabla.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        Tabla.setForeground(new java.awt.Color(0, 0, 0));
        Tabla.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                    {null, null, null, null, null, null, null, null}
                },
                new String[]{
                    "ID", "Documento", "Nombre(s)", "Apellido Paterno", "Apellido Materno", "Fecha de Registro", "Visita a: ", "Motivo"
                }
        ) {
            boolean[] canEdit = new boolean[]{
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        jScrollPane1.setViewportView(Tabla);
        if (Tabla.getColumnModel().getColumnCount() > 0) {
            Tabla.getColumnModel().getColumn(0).setResizable(false);
            Tabla.getColumnModel().getColumn(0).setPreferredWidth(1);
            Tabla.getColumnModel().getColumn(1).setResizable(false);
            Tabla.getColumnModel().getColumn(1).setPreferredWidth(50);
            Tabla.getColumnModel().getColumn(2).setResizable(false);
            Tabla.getColumnModel().getColumn(2).setPreferredWidth(50);
            Tabla.getColumnModel().getColumn(3).setResizable(false);
            Tabla.getColumnModel().getColumn(3).setPreferredWidth(50);
            Tabla.getColumnModel().getColumn(4).setResizable(false);
            Tabla.getColumnModel().getColumn(4).setPreferredWidth(50);
            Tabla.getColumnModel().getColumn(5).setResizable(false);
            Tabla.getColumnModel().getColumn(5).setPreferredWidth(50);
            Tabla.getColumnModel().getColumn(6).setResizable(false);
            Tabla.getColumnModel().getColumn(6).setPreferredWidth(30);
            Tabla.getColumnModel().getColumn(7).setResizable(false);
            Tabla.getColumnModel().getColumn(1).setPreferredWidth(100);
        }
        Tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                try {
                    TablaMouseClicked(evt);
                } catch (ClassNotFoundException ex) {
                }
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.gridwidth = 131;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 980;
        gridBagConstraints.ipady = 307;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(12, 0, 10, 24);
        Panel.add(jScrollPane1, gridBagConstraints);

        Titulo.setFont(new java.awt.Font("Century Gothic", 1, 48)); // NOI18N
        Titulo.setForeground(new java.awt.Color(153, 0, 0));
        Titulo.setText("Eliminar una Visita");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 20;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(13, 64, 0, 0);
        Panel.add(Titulo, gridBagConstraints);

        eTipoDoc.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        eTipoDoc.setForeground(new java.awt.Color(153, 0, 0));
        eTipoDoc.setText("Tipo de Documento: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 10;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 18, 0, 0);
        Panel.add(eTipoDoc, gridBagConstraints);

        eApPa.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        eApPa.setForeground(new java.awt.Color(153, 0, 0));
        eApPa.setText("Apellido Paterno: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 61, 0, 0);
        Panel.add(eApPa, gridBagConstraints);

        eApMa.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        eApMa.setForeground(new java.awt.Color(153, 0, 0));
        eApMa.setText("Apellido Materno: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 58, 0, 0);
        Panel.add(eApMa, gridBagConstraints);

        eVisitaA.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        eVisitaA.setForeground(new java.awt.Color(153, 0, 0));
        eVisitaA.setText("Visita a: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 10;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 18, 0, 0);
        Panel.add(eVisitaA, gridBagConstraints);

        eMotivo.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        eMotivo.setForeground(new java.awt.Color(153, 0, 0));
        eMotivo.setText("Motivo:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 10;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 18, 0, 0);
        Panel.add(eMotivo, gridBagConstraints);

        Eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Eliminar_OFF.png"))); // NOI18N
        Eliminar.setBorder(null);
        Eliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Eliminar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Eliminar_ON.jpg"))); // NOI18N
        Eliminar.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Eliminar_ON.jpg"))); // NOI18N
        Eliminar.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Eliminar_ON.jpg"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 84, 0, 0);
        Panel.add(Eliminar, gridBagConstraints);
        Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    EliminarActionPerformed(evt);
                } catch (ClassNotFoundException ex) {
                }
            }
        });

        eNombre1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        eNombre1.setForeground(new java.awt.Color(153, 0, 0));
        eNombre1.setText("Nombre(s): ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 114, 0, 0);
        Panel.add(eNombre1, gridBagConstraints);

        eBuscar.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        eBuscar.setForeground(new java.awt.Color(153, 0, 0));
        eBuscar.setText("Buscar por  ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(19, 86, 0, 0);
        Panel.add(eBuscar, gridBagConstraints);

        Por.setBackground(new java.awt.Color(255, 255, 255));
        Por.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        Por.setForeground(new java.awt.Color(0, 0, 0));
        Por.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Nombre(s)", "ID", "Documento", "Apellido Paterno", "Apellido Materno", "Busca A:", " "}));
        Por.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PorActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.ipadx = 11;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 6, 0, 0);
        Panel.add(Por, gridBagConstraints);

        Busqueda.setBackground(new java.awt.Color(204, 204, 204));
        Busqueda.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        Busqueda.setForeground(new java.awt.Color(0, 0, 0));
        Busqueda.setBorder(null);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 30;
        gridBagConstraints.ipadx = 462;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 6, 0, 0);
        Panel.add(Busqueda, gridBagConstraints);

        eBuscar1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        eBuscar1.setForeground(new java.awt.Color(153, 0, 0));
        eBuscar1.setText(":");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(19, 6, 0, 0);
        Panel.add(eBuscar1, gridBagConstraints);

        Buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Buscar_OFF.png"))); // NOI18N
        Buscar.setBorder(null);
        Buscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Buscar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Buscar_ON.jpg"))); // NOI18N
        Buscar.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Buscar_ON.jpg"))); // NOI18N
        Buscar.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Buscar_ON.jpg"))); // NOI18N
        Buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 64;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 66;
        gridBagConstraints.gridheight = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(11, 6, 0, 0);
        Panel.add(Buscar, gridBagConstraints);

        Nota.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        Nota.setForeground(new java.awt.Color(102, 102, 102));
        Nota.setText("Busque en la barra de busqueda el registro a eliminar o seleccionela directamente de la tabla y de clic en eliminar.");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 65;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 138, 0, 0);
        Panel.add(Nota, gridBagConstraints);

        Nombre.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        Nombre.setForeground(new java.awt.Color(51, 51, 51));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.ipadx = 185;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 6, 0, 0);
        Panel.add(Nombre, gridBagConstraints);

        ApPa.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        ApPa.setForeground(new java.awt.Color(51, 51, 51));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.ipadx = 185;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 6, 0, 0);
        Panel.add(ApPa, gridBagConstraints);

        TipoDoc.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        TipoDoc.setForeground(new java.awt.Color(51, 51, 51));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 35;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 95;
        gridBagConstraints.ipadx = 153;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 5, 0, 0);
        Panel.add(TipoDoc, gridBagConstraints);

        VisitaA.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        VisitaA.setForeground(new java.awt.Color(51, 51, 51));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 17;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 113;
        gridBagConstraints.ipadx = 254;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 12, 0, 0);
        Panel.add(VisitaA, gridBagConstraints);

        ApMa.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        ApMa.setForeground(new java.awt.Color(51, 51, 51));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.ipadx = 185;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 6, 0, 0);
        Panel.add(ApMa, gridBagConstraints);

        Motivo.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        Motivo.setForeground(new java.awt.Color(51, 51, 51));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 17;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 113;
        gridBagConstraints.ipadx = 258;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 8, 0, 0);
        Panel.add(Motivo, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 31;
        gridBagConstraints.ipady = 26;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        getContentPane().add(Panel, gridBagConstraints);

        pack();

        try {
            Tabla.setModel(modelo);

            PreparedStatement ps = null;
            ResultSet rs = null;
            Conexion conn = new Conexion();
            Connection con = conn.getConexion();

            String sql = "SELECT IDVisita, TipoDocumento, Nombre, ApellidoPaterno, ApellidoMaterno, FechaRegistro, VisitaA, Motivo FROM Visita";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            ResultSetMetaData rsMd = (ResultSetMetaData) rs.getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();

            modelo.addColumn("ID");
            modelo.addColumn("Documento");
            modelo.addColumn("Nombre(s)");
            modelo.addColumn("Apellido Paterno");
            modelo.addColumn("Apellido Materno");
            modelo.addColumn("Fecha de Registro");
            modelo.addColumn("Visita a: ");
            modelo.addColumn("Motivo");

            int[] anchos = {1, 50, 50, 50, 50, 50, 30, 100};
            for (int i = 0; i < Tabla.getColumnCount(); i++) {
                Tabla.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
            }

            while (rs.next()) {
                Object[] filas = new Object[cantidadColumnas];
                for (int i = 0; i < cantidadColumnas; i++) {
                    filas[i] = rs.getObject(i + 1);
                }
                modelo.addRow(filas);
            }

        } catch (SQLException ex) {
        }
    }

    public void TablaMouseClicked(MouseEvent evt) throws ClassNotFoundException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            Conexion objCon = new Conexion();
            Connection conn = objCon.getConexion();

            int Fila = Tabla.getSelectedRow();
            ID = Tabla.getValueAt(Fila, 0).toString();

            ps = conn.prepareStatement("SELECT TipoDocumento, Nombre, ApellidoPaterno, ApellidoMaterno, FechaRegistro, VisitaA, Motivo FROM Visita WHERE IDVisita = ?");
            ps.setString(1, ID);
            rs = ps.executeQuery();

            while (rs.next()) {
                this.TipoDoc.setText(rs.getString("TipoDocumento"));
                this.Nombre.setText(rs.getString("Nombre"));
                this.ApPa.setText(rs.getString("ApellidoPaterno"));
                this.ApMa.setText(rs.getString("ApellidoMaterno"));
                this.VisitaA.setText(rs.getString("VisitaA"));
                this.Motivo.setText(rs.getString("Motivo"));
            }
        } catch (SQLException ex) {
        }

    }

    private void PorActionPerformed(ActionEvent evt) {
        String itemSeleecionado = (String) Por.getSelectedItem();
        switch (itemSeleecionado) {
            case "ID":
                Select = "IDVisita";
                break;
            case "Documento":
                Select = "TipoDocumento";
                break;
            case "Apellido Paterno":
                Select = "ApellidoPaterno";
                break;
            case "Apellido Materno":
                Select = "ApellidoMaterno";
                break;
            case "Visita a":
                Select = "VisitaA";
                break;

            default:
                break;
        }
    }

    public void BuscarActionPerformed(ActionEvent e) {
        String campo = Busqueda.getText();
        String where = "";
        if (!"".equals(campo)) {
            where = "WHERE " + Select + " = '" + campo + "'";
        }

        try {
            DefaultTableModel modelo = new DefaultTableModel();
            Tabla.setModel(modelo);

            PreparedStatement ps = null;
            ResultSet rs = null;
            Conexion conn = new Conexion();
            com.mysql.jdbc.Connection con = conn.getConexion();

            String sql = "SELECT IDVisita, TipoDocumento, Nombre, ApellidoPaterno, ApellidoMaterno, "
                    + "FechaRegistro, VisitaA, Motivo FROM Visita " + where;
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            ResultSetMetaData rsMd = (ResultSetMetaData) rs.getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();

            modelo.addColumn("ID");
            modelo.addColumn("Documento");
            modelo.addColumn("Nombre(s)");
            modelo.addColumn("Apellido Paterno");
            modelo.addColumn("Apellido Materno");
            modelo.addColumn("Fecha de Registro");
            modelo.addColumn("Visita a: ");
            modelo.addColumn("Motivo");

            int[] anchos = {1, 50, 50, 50, 50, 50, 30, 100};
            for (int i = 0; i < Tabla.getColumnCount(); i++) {
                Tabla.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
            }

            while (rs.next()) {
                Object[] filas = new Object[cantidadColumnas];
                for (int i = 0; i < cantidadColumnas; i++) {
                    filas[i] = rs.getObject(i + 1);
                }
                modelo.addRow(filas);

            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "La Busqueda no arrojó resultados.");
        }

    }

    private void EliminarActionPerformed(ActionEvent evt) throws ClassNotFoundException {
        int opp = JOptionPane.showConfirmDialog(null, "¿Esta seguro de que desea eliminar los datos seleccionados?", "Confirmar", JOptionPane.YES_NO_OPTION);
        if (opp == 0) {
            PreparedStatement ps = null;
            try {

                Conexion objCon = new Conexion();
                Connection conn = objCon.getConexion();

                int Fila = Tabla.getSelectedRow();
                String codigo = Tabla.getValueAt(Fila, 0).toString();

                ps = conn.prepareStatement("DELETE FROM Visita WHERE IDVisita=?");
                ps.setString(1, codigo);
                ps.execute();

                modelo.removeRow(Fila);
                JOptionPane.showMessageDialog(null, "Registro Eliminado");
                this.TipoDoc.setText("");
                this.Nombre.setText("");
                this.ApPa.setText("");
                this.ApMa.setText("");
                this.VisitaA.setText("");
                this.Motivo.setText("");

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al Eliminar Registro");
            }
        }
    }
}
