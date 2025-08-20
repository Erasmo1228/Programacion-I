/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */


package sistemamodernolibioteca;
import Clases.consultas;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.text.*;
import java.util.regex.Pattern;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.DocumentEvent;


/**
 *
 * @author Juan
 */
public class ModernLibrarySystem extends javax.swing.JFrame {
    //Declaramos una instancia de la clase consulta
consultas con = new consultas();
//iniciamos el constructor por defecto
public ModernLibrarySystem() {
    initComponents();
    initComponentsOP();
    setLocationRelativeTo(null);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        //Se declara una instancia de la clase consulta con los metodos que dan registros de la base de datos
        con.RellenaLaTablaConDatosMySQL("libro", tablaLibros);
        con.leerLectores("usuario", tablaLibros1);
        con.leerSalidas("salida", tablaLibros2);
        //Se declara otra instancia de la clase consulta, en este caso para trabajar con el conteo de registros
        Clases.consultas contador = new Clases.consultas();
        //Se instancia la clase timer que se encargar de actualizar cada segundo el conteo de registros en la base de datos
        Timer timer = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                 contador.contarRegistros("usuario", lblLectores);
                contador.contarRegistros("libro", lblTotalLibros);
                contador.contarRegistros("salida", lblPrestamos);
            }
        });
        timer.start();
       
        //Con la siguiente instruccion se crea un evento con la clase MouseAdapter
        //que seleccionara el valor del registro seleccionado en el JTable y lo pondra en los campos en blanco
        tablaLibros.addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent Mouse_evt)
                {
                    JTable table = (JTable) Mouse_evt.getSource();
                    Point point = Mouse_evt.getPoint();
                    int row = table.rowAtPoint(point);
                    if(Mouse_evt.getClickCount() == 1)
               
                {
                    txtTitulo.setText(tablaLibros.getValueAt(tablaLibros.getSelectedRow(), 1).toString());
                    txtEditorial.setText(tablaLibros.getValueAt(tablaLibros.getSelectedRow(), 2).toString());
                    txtAno.setText(tablaLibros.getValueAt(tablaLibros.getSelectedRow(), 3).toString());
                }
                }
        });
              //Con la siguiente instruccion se crea un evento con la clase MouseAdapter
        //que seleccionara el valor del registro seleccionado en el JTable y lo pondra en los campos en blanco
        tablaLibros1.addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent Mouse_evt)
                {
                    JTable table = (JTable) Mouse_evt.getSource();
                    Point point = Mouse_evt.getPoint();
                    int row = table.rowAtPoint(point);
                    if(Mouse_evt.getClickCount() == 1)
               
                {
                    txtTitulo1.setText(tablaLibros1.getValueAt(tablaLibros1.getSelectedRow(), 1).toString());
                    txtTitulo2.setText(tablaLibros1.getValueAt(tablaLibros1.getSelectedRow(), 2).toString());
                    txtTitulo3.setText(tablaLibros1.getValueAt(tablaLibros1.getSelectedRow(), 3).toString());
                    txtTitulo4.setText(tablaLibros1.getValueAt(tablaLibros1.getSelectedRow(), 4).toString());
                    txtTitulo5.setText(tablaLibros1.getValueAt(tablaLibros1.getSelectedRow(), 5).toString());
                }
                }
        });
              //Con la siguiente instruccion se crea un evento con la clase MouseAdapter
        //que seleccionara el valor del registro seleccionado en el JTable y lo pondra en los campos en blanco
        tablaLibros2.addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent Mouse_evt)
                {
                    JTable table = (JTable) Mouse_evt.getSource();
                    Point point = Mouse_evt.getPoint();
                    int row = table.rowAtPoint(point);
                    if(Mouse_evt.getClickCount() == 1)
                    {
                    txtTitulo6.setText(tablaLibros2.getValueAt(tablaLibros2.getSelectedRow(), 1).toString());
                    txtTitulo7.setText(tablaLibros2.getValueAt(tablaLibros2.getSelectedRow(), 2).toString());
                    txtTitulo8.setText(tablaLibros2.getValueAt(tablaLibros2.getSelectedRow(), 3).toString());
                    txtTitulo9.setText(tablaLibros2.getValueAt(tablaLibros2.getSelectedRow(), 4).toString());
                    txtTitulo10.setText(tablaLibros2.getValueAt(tablaLibros2.getSelectedRow(), 5).toString());                  
                   }
                }
             });
 
}
/**
    * Valida que los campos de libro no estén vacíos
    */
    private boolean validarLibro() {
        // Solo verificar que no estén vacíos
        if (txtTitulo.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "El título es obligatorio", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (txtEditorial.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "La editorial es obligatoria", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (txtAno.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "El año es obligatorio", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        return true;
    }
    /**
    * Valida que los campos de lector no estén vacíos y el email sea válido
    */
    private boolean validarLector() {
        if (txtTitulo1.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "El nombre es obligatorio", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (txtTitulo2.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "La dirección es obligatoria", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (txtTitulo3.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "El teléfono es obligatorio", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (txtTitulo4.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "La ciudad es obligatoria", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (txtTitulo5.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "El correo es obligatorio", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        // Validar formato de email
        if (!esEmailValido(txtTitulo5.getText().trim())) {
            JOptionPane.showMessageDialog(this, "El formato del correo electrónico no es válido\nEjemplo: usuario@itla.com", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        return true;
    }
    private boolean esEmailValido(String email) {
        // Patrón básico para email
        String patron = "^[a-zA-Z0-9_+&*-]+@[a-zA-Z0-9-]+\\.[a-zA-Z]{2,7}$";
        return email.matches(patron);
    }
    /**
     * Valida que los campos de préstamo no estén vacíos
     */
    private boolean validarPrestamo() {
        if (txtTitulo6.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "La fecha de préstamo es obligatoria", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (txtTitulo7.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "La fecha de regreso es obligatoria", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (txtTitulo9.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "El ID del libro es obligatorio", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (txtTitulo10.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "El ID del usuario es obligatorio", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        return true;
    }
    private boolean haySeleccion(JTable tabla) {
        if (tabla.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un registro", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
    /**
     * Pregunta al usuario si está seguro de eliminar
     */
    private boolean confirmarEliminacion() {
        int respuesta = JOptionPane.showConfirmDialog(
            this,
            "¿Está seguro que desea eliminar este registro?",
            "Confirmar",
            JOptionPane.YES_NO_OPTION
        );
        return respuesta == JOptionPane.YES_OPTION;
    }

//Se establece la imagen en el titulo
private void initComponentsOP() {
        ImageIcon icon = new ImageIcon(getClass().getResource("/sistemamodernolibioteca/icons/libro.png"));
        Image img = icon.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        lblTitulo.setIcon(new ImageIcon(img));
        
    }
        
    //Se realizan las validaciones de lugar para los campos


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        headerPanel = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        statsPanel = new javax.swing.JPanel();
        cardPrestamos = new javax.swing.JPanel();
        lblPrestamos = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cardTotalLibros = new javax.swing.JPanel();
        lblTotalLibros = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        cardLectores = new javax.swing.JPanel();
        lblLectores = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        panelLibros = new javax.swing.JPanel();
        panelIzquierdo = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaLibros = new javax.swing.JTable();
        panelBotones = new javax.swing.JPanel();
        btnGuardar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        panelBusqueda = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtBuscar = new java.awt.TextField();
        panelFormulario = new javax.swing.JPanel();
        panelTituloForm = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        panelCampos = new javax.swing.JPanel();
        filler5 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 25), new java.awt.Dimension(0, 25), new java.awt.Dimension(0, 25));
        jLabel6 = new javax.swing.JLabel();
        txtTitulo = new javax.swing.JTextField();
        filler3 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 25), new java.awt.Dimension(0, 25), new java.awt.Dimension(0, 25));
        jLabel7 = new javax.swing.JLabel();
        txtEditorial = new javax.swing.JTextField();
        filler4 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 25), new java.awt.Dimension(0, 25), new java.awt.Dimension(0, 25));
        jLabel8 = new javax.swing.JLabel();
        txtAno = new javax.swing.JTextField();
        panelLectores = new javax.swing.JPanel();
        panelIzquierdo1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaLibros1 = new javax.swing.JTable();
        panelBotones1 = new javax.swing.JPanel();
        btnGuardar1 = new javax.swing.JButton();
        btnActualizar1 = new javax.swing.JButton();
        btnEliminar1 = new javax.swing.JButton();
        btnLimpiar1 = new javax.swing.JButton();
        panelFormulario1 = new javax.swing.JPanel();
        panelTituloForm1 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        panelCampos1 = new javax.swing.JPanel();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 10), new java.awt.Dimension(0, 10), new java.awt.Dimension(0, 10));
        jLabel11 = new javax.swing.JLabel();
        txtTitulo1 = new javax.swing.JTextField();
        filler13 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 10), new java.awt.Dimension(0, 10), new java.awt.Dimension(0, 10));
        jLabel14 = new javax.swing.JLabel();
        txtTitulo2 = new javax.swing.JTextField();
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 10), new java.awt.Dimension(0, 10), new java.awt.Dimension(0, 10));
        jLabel15 = new javax.swing.JLabel();
        txtTitulo3 = new javax.swing.JTextField();
        filler9 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 10), new java.awt.Dimension(0, 10), new java.awt.Dimension(0, 10));
        jLabel16 = new javax.swing.JLabel();
        txtTitulo4 = new javax.swing.JTextField();
        filler10 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 10), new java.awt.Dimension(0, 10), new java.awt.Dimension(0, 10));
        jLabel17 = new javax.swing.JLabel();
        txtTitulo5 = new javax.swing.JTextField();
        filler11 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 10), new java.awt.Dimension(0, 10), new java.awt.Dimension(0, 10));
        filler12 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 10), new java.awt.Dimension(0, 10), new java.awt.Dimension(0, 10));
        panelPrestamos = new javax.swing.JPanel();
        panelFormulario2 = new javax.swing.JPanel();
        panelTituloForm2 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        panelCampos2 = new javax.swing.JPanel();
        filler6 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 10), new java.awt.Dimension(0, 10), new java.awt.Dimension(0, 10));
        jLabel13 = new javax.swing.JLabel();
        txtTitulo6 = new javax.swing.JTextField();
        filler14 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 10), new java.awt.Dimension(0, 10), new java.awt.Dimension(0, 10));
        jLabel18 = new javax.swing.JLabel();
        txtTitulo7 = new javax.swing.JTextField();
        filler7 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 10), new java.awt.Dimension(0, 10), new java.awt.Dimension(0, 10));
        jLabel19 = new javax.swing.JLabel();
        txtTitulo8 = new javax.swing.JTextField();
        filler15 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 10), new java.awt.Dimension(0, 10), new java.awt.Dimension(0, 10));
        jLabel20 = new javax.swing.JLabel();
        txtTitulo9 = new javax.swing.JTextField();
        filler16 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 10), new java.awt.Dimension(0, 10), new java.awt.Dimension(0, 10));
        jLabel21 = new javax.swing.JLabel();
        txtTitulo10 = new javax.swing.JTextField();
        filler17 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 10), new java.awt.Dimension(0, 10), new java.awt.Dimension(0, 10));
        filler18 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 10), new java.awt.Dimension(0, 10), new java.awt.Dimension(0, 10));
        panelIzquierdo2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaLibros2 = new javax.swing.JTable();
        panelBotones2 = new javax.swing.JPanel();
        btnGuardar2 = new javax.swing.JButton();
        btnActualizar2 = new javax.swing.JButton();
        btnEliminar2 = new javax.swing.JButton();
        btnLimpiar2 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema Moderno de Biblioteca");
        setLocation(new java.awt.Point(0, 0));
        setMinimumSize(new java.awt.Dimension(1200, 800));
        setSize(new java.awt.Dimension(1280, 720));

        headerPanel.setBackground(new java.awt.Color(51, 65, 85));
        headerPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        headerPanel.setPreferredSize(new java.awt.Dimension(1400, 180));
        headerPanel.setLayout(new java.awt.BorderLayout());

        lblTitulo.setBackground(new java.awt.Color(102, 102, 102));
        lblTitulo.setFont(new java.awt.Font("Montserrat", 1, 36)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistemamodernolibioteca/icons/libro.png"))); // NOI18N
        lblTitulo.setText(" Sistema de Gestion Bibliotecario");
        lblTitulo.setToolTipText("");
        headerPanel.add(lblTitulo, java.awt.BorderLayout.CENTER);

        statsPanel.setBackground(new java.awt.Color(51, 65, 85));

        cardPrestamos.setBackground(new java.awt.Color(248, 249, 250));
        cardPrestamos.setPreferredSize(new java.awt.Dimension(180, 100));
        cardPrestamos.setLayout(new java.awt.BorderLayout());

        lblPrestamos.setFont(new java.awt.Font("Montserrat", 1, 36)); // NOI18N
        lblPrestamos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPrestamos.setText("0");
        lblPrestamos.setAlignmentX(0.5F);
        lblPrestamos.setPreferredSize(new java.awt.Dimension(24, 35));
        cardPrestamos.add(lblPrestamos, java.awt.BorderLayout.CENTER);

        jLabel2.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Préstamos Activos");
        cardPrestamos.add(jLabel2, java.awt.BorderLayout.PAGE_END);

        statsPanel.add(cardPrestamos);

        cardTotalLibros.setBackground(new java.awt.Color(248, 249, 250));
        cardTotalLibros.setPreferredSize(new java.awt.Dimension(180, 100));
        cardTotalLibros.setLayout(new java.awt.BorderLayout());

        lblTotalLibros.setFont(new java.awt.Font("Montserrat", 1, 36)); // NOI18N
        lblTotalLibros.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTotalLibros.setText("0");
        lblTotalLibros.setAlignmentX(0.5F);
        cardTotalLibros.add(lblTotalLibros, java.awt.BorderLayout.CENTER);

        jLabel1.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Total Libros");
        jLabel1.setAlignmentX(0.5F);
        cardTotalLibros.add(jLabel1, java.awt.BorderLayout.PAGE_END);

        statsPanel.add(cardTotalLibros);

        cardLectores.setBackground(new java.awt.Color(248, 249, 250));
        cardLectores.setPreferredSize(new java.awt.Dimension(180, 100));
        cardLectores.setRequestFocusEnabled(false);
        cardLectores.setLayout(new java.awt.BorderLayout());

        lblLectores.setFont(new java.awt.Font("Montserrat", 1, 36)); // NOI18N
        lblLectores.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLectores.setText("0");
        cardLectores.add(lblLectores, java.awt.BorderLayout.CENTER);

        jLabel3.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Lectores Registrados");
        cardLectores.add(jLabel3, java.awt.BorderLayout.PAGE_END);

        statsPanel.add(cardLectores);

        headerPanel.add(statsPanel, java.awt.BorderLayout.PAGE_END);

        getContentPane().add(headerPanel, java.awt.BorderLayout.PAGE_START);

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setForeground(new java.awt.Color(31, 41, 55));
        jTabbedPane1.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N

        panelLibros.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        panelLibros.setLayout(new java.awt.BorderLayout());

        panelIzquierdo.setBackground(new java.awt.Color(255, 255, 255));
        panelIzquierdo.setPreferredSize(new java.awt.Dimension(800, 600));
        panelIzquierdo.setLayout(new java.awt.BorderLayout());

        jScrollPane1.setForeground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        tablaLibros.setForeground(new java.awt.Color(51, 51, 51));
        tablaLibros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Título", "Editorial", "Año"
            }
        ));
        tablaLibros.setFillsViewportHeight(true);
        tablaLibros.setGridColor(new java.awt.Color(255, 255, 255));
        tablaLibros.setPreferredSize(new java.awt.Dimension(300, 250));
        tablaLibros.setRowHeight(45);
        tablaLibros.setSelectionBackground(new java.awt.Color(51, 65, 85));
        jScrollPane1.setViewportView(tablaLibros);
        if (tablaLibros.getColumnModel().getColumnCount() > 0) {
            tablaLibros.getColumnModel().getColumn(1).setPreferredWidth(250);
        }

        panelIzquierdo.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        panelBotones.setBackground(new java.awt.Color(51, 65, 85));
        panelBotones.setPreferredSize(new java.awt.Dimension(800, 80));

        btnGuardar.setBackground(new java.awt.Color(34, 197, 94));
        btnGuardar.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardar.setText("GUARDAR ");
        btnGuardar.setFocusPainted(false);
        btnGuardar.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        btnGuardar.setMaximumSize(new java.awt.Dimension(100, 30));
        btnGuardar.setMinimumSize(new java.awt.Dimension(140, 40));
        btnGuardar.setPreferredSize(new java.awt.Dimension(120, 35));
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnActualizar.setBackground(new java.awt.Color(59, 130, 246));
        btnActualizar.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        btnActualizar.setForeground(new java.awt.Color(255, 255, 255));
        btnActualizar.setText("ACTUALIZAR ");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnEliminar.setBackground(new java.awt.Color(239, 68, 68));
        btnEliminar.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminar.setText("ELIMINAR ");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnLimpiar.setBackground(new java.awt.Color(107, 114, 128));
        btnLimpiar.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        btnLimpiar.setForeground(new java.awt.Color(255, 255, 255));
        btnLimpiar.setText("LIMPIAR");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBotonesLayout = new javax.swing.GroupLayout(panelBotones);
        panelBotones.setLayout(panelBotonesLayout);
        panelBotonesLayout.setHorizontalGroup(
            panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBotonesLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(82, 82, 82)
                .addComponent(btnActualizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
                .addComponent(btnEliminar)
                .addGap(106, 106, 106)
                .addComponent(btnLimpiar)
                .addGap(77, 77, 77))
        );
        panelBotonesLayout.setVerticalGroup(
            panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBotonesLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        panelIzquierdo.add(panelBotones, java.awt.BorderLayout.PAGE_END);

        panelBusqueda.setBackground(new java.awt.Color(255, 255, 255));
        panelBusqueda.setPreferredSize(new java.awt.Dimension(800, 60));

        jLabel4.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistemamodernolibioteca/icons/sear.png"))); // NOI18N
        jLabel4.setText("Buscar libros...");
        panelBusqueda.add(jLabel4);

        txtBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtBuscar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtBuscar.setPreferredSize(new java.awt.Dimension(450, 35));
        txtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarActionPerformed(evt);
            }
        });
        panelBusqueda.add(txtBuscar);
        txtBuscar.getAccessibleContext().setAccessibleDescription("");

        panelIzquierdo.add(panelBusqueda, java.awt.BorderLayout.PAGE_START);

        panelLibros.add(panelIzquierdo, java.awt.BorderLayout.LINE_START);

        panelFormulario.setBackground(new java.awt.Color(75, 192, 192));
        panelFormulario.setPreferredSize(new java.awt.Dimension(400, 600));
        panelFormulario.setLayout(new java.awt.BorderLayout());

        panelTituloForm.setBackground(new java.awt.Color(51, 65, 85));
        panelTituloForm.setPreferredSize(new java.awt.Dimension(676, 80));

        jLabel5.setFont(new java.awt.Font("Montserrat", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Datos del Libro");
        panelTituloForm.add(jLabel5);

        panelFormulario.add(panelTituloForm, java.awt.BorderLayout.PAGE_START);

        panelCampos.setBackground(new java.awt.Color(255, 255, 255));
        panelCampos.setLayout(new javax.swing.BoxLayout(panelCampos, javax.swing.BoxLayout.Y_AXIS));
        panelCampos.add(filler5);

        jLabel6.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("TÍTULO");
        jLabel6.setAlignmentX(0.5F);
        panelCampos.add(jLabel6);

        txtTitulo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtTitulo.setMaximumSize(new java.awt.Dimension(300, 35));
        txtTitulo.setMinimumSize(new java.awt.Dimension(200, 35));
        txtTitulo.setPreferredSize(new java.awt.Dimension(250, 35));
        panelCampos.add(txtTitulo);
        panelCampos.add(filler3);

        jLabel7.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("EDITORIAL");
        jLabel7.setAlignmentX(0.5F);
        panelCampos.add(jLabel7);

        txtEditorial.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtEditorial.setMaximumSize(new java.awt.Dimension(300, 35));
        txtEditorial.setMinimumSize(new java.awt.Dimension(200, 35));
        txtEditorial.setPreferredSize(new java.awt.Dimension(250, 35));
        panelCampos.add(txtEditorial);
        panelCampos.add(filler4);

        jLabel8.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("AÑO");
        jLabel8.setAlignmentX(0.5F);
        panelCampos.add(jLabel8);

        txtAno.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtAno.setMaximumSize(new java.awt.Dimension(300, 35));
        txtAno.setMinimumSize(new java.awt.Dimension(200, 35));
        txtAno.setName(""); // NOI18N
        txtAno.setPreferredSize(new java.awt.Dimension(250, 35));
        panelCampos.add(txtAno);

        panelFormulario.add(panelCampos, java.awt.BorderLayout.CENTER);

        panelLibros.add(panelFormulario, java.awt.BorderLayout.CENTER);

        jTabbedPane1.addTab("Gestión de Libros", panelLibros);

        panelLectores.setLayout(new java.awt.BorderLayout());

        panelIzquierdo1.setBackground(new java.awt.Color(255, 255, 255));
        panelIzquierdo1.setPreferredSize(new java.awt.Dimension(800, 600));
        panelIzquierdo1.setLayout(new java.awt.BorderLayout());

        jScrollPane2.setForeground(new java.awt.Color(255, 255, 255));
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        tablaLibros1.setForeground(new java.awt.Color(51, 51, 51));
        tablaLibros1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Direccion", "Telefono", "Ciudad", "Correo"
            }
        ));
        tablaLibros1.setFillsViewportHeight(true);
        tablaLibros1.setGridColor(new java.awt.Color(255, 255, 255));
        tablaLibros1.setPreferredSize(new java.awt.Dimension(300, 250));
        tablaLibros1.setRowHeight(45);
        tablaLibros1.setSelectionBackground(new java.awt.Color(51, 65, 85));
        jScrollPane2.setViewportView(tablaLibros1);
        if (tablaLibros1.getColumnModel().getColumnCount() > 0) {
            tablaLibros1.getColumnModel().getColumn(1).setPreferredWidth(250);
        }

        panelIzquierdo1.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        panelBotones1.setBackground(new java.awt.Color(51, 65, 85));
        panelBotones1.setPreferredSize(new java.awt.Dimension(800, 80));

        btnGuardar1.setBackground(new java.awt.Color(34, 197, 94));
        btnGuardar1.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        btnGuardar1.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardar1.setText("GUARDAR ");
        btnGuardar1.setFocusPainted(false);
        btnGuardar1.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        btnGuardar1.setMaximumSize(new java.awt.Dimension(100, 30));
        btnGuardar1.setMinimumSize(new java.awt.Dimension(140, 40));
        btnGuardar1.setPreferredSize(new java.awt.Dimension(120, 35));
        btnGuardar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardar1ActionPerformed(evt);
            }
        });

        btnActualizar1.setBackground(new java.awt.Color(59, 130, 246));
        btnActualizar1.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        btnActualizar1.setForeground(new java.awt.Color(255, 255, 255));
        btnActualizar1.setText("ACTUALIZAR ");
        btnActualizar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizar1ActionPerformed(evt);
            }
        });

        btnEliminar1.setBackground(new java.awt.Color(239, 68, 68));
        btnEliminar1.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        btnEliminar1.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminar1.setText("ELIMINAR ");
        btnEliminar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminar1ActionPerformed(evt);
            }
        });

        btnLimpiar1.setBackground(new java.awt.Color(107, 114, 128));
        btnLimpiar1.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        btnLimpiar1.setForeground(new java.awt.Color(255, 255, 255));
        btnLimpiar1.setText("LIMPIAR");
        btnLimpiar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiar1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBotones1Layout = new javax.swing.GroupLayout(panelBotones1);
        panelBotones1.setLayout(panelBotones1Layout);
        panelBotones1Layout.setHorizontalGroup(
            panelBotones1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBotones1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(btnGuardar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(btnActualizar1)
                .addGap(27, 27, 27)
                .addComponent(btnEliminar1)
                .addGap(34, 34, 34)
                .addComponent(btnLimpiar1)
                .addContainerGap(276, Short.MAX_VALUE))
        );
        panelBotones1Layout.setVerticalGroup(
            panelBotones1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBotones1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(panelBotones1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                    .addComponent(btnGuardar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnActualizar1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLimpiar1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        panelIzquierdo1.add(panelBotones1, java.awt.BorderLayout.PAGE_END);

        panelLectores.add(panelIzquierdo1, java.awt.BorderLayout.LINE_START);

        panelFormulario1.setBackground(new java.awt.Color(75, 192, 192));
        panelFormulario1.setPreferredSize(new java.awt.Dimension(400, 600));
        panelFormulario1.setLayout(new java.awt.BorderLayout());

        panelTituloForm1.setBackground(new java.awt.Color(51, 65, 85));
        panelTituloForm1.setPreferredSize(new java.awt.Dimension(676, 80));

        jLabel10.setFont(new java.awt.Font("Montserrat", 1, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Datos para usuario");
        panelTituloForm1.add(jLabel10);

        panelFormulario1.add(panelTituloForm1, java.awt.BorderLayout.PAGE_START);

        panelCampos1.setBackground(new java.awt.Color(255, 255, 255));
        panelCampos1.setLayout(new javax.swing.BoxLayout(panelCampos1, javax.swing.BoxLayout.Y_AXIS));
        panelCampos1.add(filler1);

        jLabel11.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Nombre");
        jLabel11.setAlignmentX(0.5F);
        panelCampos1.add(jLabel11);

        txtTitulo1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtTitulo1.setMaximumSize(new java.awt.Dimension(300, 30));
        txtTitulo1.setMinimumSize(new java.awt.Dimension(200, 30));
        txtTitulo1.setPreferredSize(new java.awt.Dimension(250, 30));
        txtTitulo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTitulo1ActionPerformed(evt);
            }
        });
        panelCampos1.add(txtTitulo1);
        panelCampos1.add(filler13);

        jLabel14.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Direccion");
        jLabel14.setAlignmentX(0.5F);
        panelCampos1.add(jLabel14);

        txtTitulo2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtTitulo2.setMaximumSize(new java.awt.Dimension(300, 30));
        txtTitulo2.setMinimumSize(new java.awt.Dimension(200, 30));
        txtTitulo2.setPreferredSize(new java.awt.Dimension(250, 30));
        panelCampos1.add(txtTitulo2);
        panelCampos1.add(filler2);

        jLabel15.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Telefono");
        jLabel15.setAlignmentX(0.5F);
        panelCampos1.add(jLabel15);

        txtTitulo3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtTitulo3.setMaximumSize(new java.awt.Dimension(300, 30));
        txtTitulo3.setMinimumSize(new java.awt.Dimension(200, 30));
        txtTitulo3.setPreferredSize(new java.awt.Dimension(250, 30));
        panelCampos1.add(txtTitulo3);
        panelCampos1.add(filler9);

        jLabel16.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Ciudad");
        jLabel16.setAlignmentX(0.5F);
        panelCampos1.add(jLabel16);

        txtTitulo4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtTitulo4.setMaximumSize(new java.awt.Dimension(300, 30));
        txtTitulo4.setMinimumSize(new java.awt.Dimension(200, 30));
        txtTitulo4.setPreferredSize(new java.awt.Dimension(250, 30));
        panelCampos1.add(txtTitulo4);
        panelCampos1.add(filler10);

        jLabel17.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Correo");
        jLabel17.setAlignmentX(0.5F);
        panelCampos1.add(jLabel17);

        txtTitulo5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtTitulo5.setMaximumSize(new java.awt.Dimension(300, 30));
        txtTitulo5.setMinimumSize(new java.awt.Dimension(200, 30));
        txtTitulo5.setPreferredSize(new java.awt.Dimension(250, 30));
        panelCampos1.add(txtTitulo5);
        panelCampos1.add(filler11);
        panelCampos1.add(filler12);

        panelFormulario1.add(panelCampos1, java.awt.BorderLayout.CENTER);

        panelLectores.add(panelFormulario1, java.awt.BorderLayout.CENTER);

        jTabbedPane1.addTab("Lectores", panelLectores);

        panelPrestamos.setLayout(new java.awt.BorderLayout());

        panelFormulario2.setBackground(new java.awt.Color(75, 192, 192));
        panelFormulario2.setPreferredSize(new java.awt.Dimension(400, 600));
        panelFormulario2.setLayout(new java.awt.BorderLayout());

        panelTituloForm2.setBackground(new java.awt.Color(51, 65, 85));
        panelTituloForm2.setPreferredSize(new java.awt.Dimension(676, 80));

        jLabel12.setFont(new java.awt.Font("Montserrat", 1, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Salidas");
        panelTituloForm2.add(jLabel12);

        panelFormulario2.add(panelTituloForm2, java.awt.BorderLayout.PAGE_START);

        panelCampos2.setBackground(new java.awt.Color(255, 255, 255));
        panelCampos2.setLayout(new javax.swing.BoxLayout(panelCampos2, javax.swing.BoxLayout.Y_AXIS));
        panelCampos2.add(filler6);

        jLabel13.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Fecha de Prestamo");
        jLabel13.setAlignmentX(0.5F);
        panelCampos2.add(jLabel13);

        txtTitulo6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtTitulo6.setMaximumSize(new java.awt.Dimension(300, 30));
        txtTitulo6.setMinimumSize(new java.awt.Dimension(200, 30));
        txtTitulo6.setPreferredSize(new java.awt.Dimension(250, 30));
        panelCampos2.add(txtTitulo6);
        panelCampos2.add(filler14);

        jLabel18.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("Fecha de Regreso");
        jLabel18.setAlignmentX(0.5F);
        panelCampos2.add(jLabel18);

        txtTitulo7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtTitulo7.setMaximumSize(new java.awt.Dimension(300, 30));
        txtTitulo7.setMinimumSize(new java.awt.Dimension(200, 30));
        txtTitulo7.setPreferredSize(new java.awt.Dimension(250, 30));
        panelCampos2.add(txtTitulo7);
        panelCampos2.add(filler7);

        jLabel19.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("Observacion");
        jLabel19.setAlignmentX(0.5F);
        panelCampos2.add(jLabel19);

        txtTitulo8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtTitulo8.setMaximumSize(new java.awt.Dimension(300, 30));
        txtTitulo8.setMinimumSize(new java.awt.Dimension(200, 30));
        txtTitulo8.setPreferredSize(new java.awt.Dimension(250, 30));
        panelCampos2.add(txtTitulo8);
        panelCampos2.add(filler15);

        jLabel20.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("FK_Libro");
        jLabel20.setAlignmentX(0.5F);
        panelCampos2.add(jLabel20);

        txtTitulo9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtTitulo9.setMaximumSize(new java.awt.Dimension(300, 30));
        txtTitulo9.setMinimumSize(new java.awt.Dimension(200, 30));
        txtTitulo9.setPreferredSize(new java.awt.Dimension(250, 30));
        panelCampos2.add(txtTitulo9);
        panelCampos2.add(filler16);

        jLabel21.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("FK_Usuario");
        jLabel21.setAlignmentX(0.5F);
        panelCampos2.add(jLabel21);

        txtTitulo10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtTitulo10.setMaximumSize(new java.awt.Dimension(300, 30));
        txtTitulo10.setMinimumSize(new java.awt.Dimension(200, 30));
        txtTitulo10.setPreferredSize(new java.awt.Dimension(250, 30));
        panelCampos2.add(txtTitulo10);
        panelCampos2.add(filler17);
        panelCampos2.add(filler18);

        panelFormulario2.add(panelCampos2, java.awt.BorderLayout.CENTER);

        panelPrestamos.add(panelFormulario2, java.awt.BorderLayout.CENTER);

        panelIzquierdo2.setBackground(new java.awt.Color(255, 255, 255));
        panelIzquierdo2.setPreferredSize(new java.awt.Dimension(800, 600));
        panelIzquierdo2.setLayout(new java.awt.BorderLayout());

        jScrollPane3.setForeground(new java.awt.Color(255, 255, 255));
        jScrollPane3.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        tablaLibros2.setForeground(new java.awt.Color(51, 51, 51));
        tablaLibros2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Fecha de Prestamo", "Fecha de Regreso", "Observacion", "FK_Libro", "FK_Usuario"
            }
        ));
        tablaLibros2.setFillsViewportHeight(true);
        tablaLibros2.setGridColor(new java.awt.Color(255, 255, 255));
        tablaLibros2.setPreferredSize(new java.awt.Dimension(300, 250));
        tablaLibros2.setRowHeight(45);
        tablaLibros2.setSelectionBackground(new java.awt.Color(51, 65, 85));
        jScrollPane3.setViewportView(tablaLibros2);
        if (tablaLibros2.getColumnModel().getColumnCount() > 0) {
            tablaLibros2.getColumnModel().getColumn(1).setPreferredWidth(250);
        }

        panelIzquierdo2.add(jScrollPane3, java.awt.BorderLayout.CENTER);

        panelBotones2.setBackground(new java.awt.Color(51, 65, 85));
        panelBotones2.setPreferredSize(new java.awt.Dimension(800, 80));

        btnGuardar2.setBackground(new java.awt.Color(34, 197, 94));
        btnGuardar2.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        btnGuardar2.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardar2.setText("GUARDAR ");
        btnGuardar2.setFocusPainted(false);
        btnGuardar2.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        btnGuardar2.setMaximumSize(new java.awt.Dimension(100, 30));
        btnGuardar2.setMinimumSize(new java.awt.Dimension(140, 40));
        btnGuardar2.setPreferredSize(new java.awt.Dimension(120, 35));
        btnGuardar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardar2ActionPerformed(evt);
            }
        });

        btnActualizar2.setBackground(new java.awt.Color(59, 130, 246));
        btnActualizar2.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        btnActualizar2.setForeground(new java.awt.Color(255, 255, 255));
        btnActualizar2.setText("ACTUALIZAR ");
        btnActualizar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizar2ActionPerformed(evt);
            }
        });

        btnEliminar2.setBackground(new java.awt.Color(239, 68, 68));
        btnEliminar2.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        btnEliminar2.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminar2.setText("ELIMINAR ");
        btnEliminar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminar2ActionPerformed(evt);
            }
        });

        btnLimpiar2.setBackground(new java.awt.Color(107, 114, 128));
        btnLimpiar2.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        btnLimpiar2.setForeground(new java.awt.Color(255, 255, 255));
        btnLimpiar2.setText("LIMPIAR");
        btnLimpiar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiar2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBotones2Layout = new javax.swing.GroupLayout(panelBotones2);
        panelBotones2.setLayout(panelBotones2Layout);
        panelBotones2Layout.setHorizontalGroup(
            panelBotones2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBotones2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(btnGuardar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(btnActualizar2)
                .addGap(27, 27, 27)
                .addComponent(btnEliminar2)
                .addGap(29, 29, 29)
                .addComponent(btnLimpiar2)
                .addContainerGap(281, Short.MAX_VALUE))
        );
        panelBotones2Layout.setVerticalGroup(
            panelBotones2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBotones2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(panelBotones2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                    .addComponent(btnGuardar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnActualizar2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLimpiar2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        panelIzquierdo2.add(panelBotones2, java.awt.BorderLayout.PAGE_END);

        panelPrestamos.add(panelIzquierdo2, java.awt.BorderLayout.LINE_START);

        jTabbedPane1.addTab("Préstamos", panelPrestamos);

        getContentPane().add(jTabbedPane1, java.awt.BorderLayout.CENTER);

        jMenu2.setText("Ayuda");

        jMenuItem2.setText("Acerca De");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuItem1.setText("Salir");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        //Se instancia la clase acerca que abrira al ser pulsada con un click y muestra una ventana 
        //nueva acerca de la informacion del sistema
        Acerca abrir = new Acerca();
        abrir.setVisible(true);
        abrir.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        //Al presionar este menu se sale del sistema
        System.exit(WIDTH);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void btnLimpiar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiar2ActionPerformed
        //Se limpian los campos
        txtTitulo6.setText("");
        txtTitulo7.setText("");
        txtTitulo8.setText("");
        txtTitulo9.setText("");
        txtTitulo10.setText("");

    }//GEN-LAST:event_btnLimpiar2ActionPerformed

    private void btnEliminar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminar2ActionPerformed
        //Con este boton se elimina registro de la base de datos llamando al metodo correspondiente para dicha accion
        String id_Salida = tablaLibros2.getValueAt(tablaLibros2.getSelectedRow(),0).toString();
        con.EliminaRegistro("id_salida", "salida", id_Salida);
        con.leerSalidas("salida", tablaLibros2);
    }//GEN-LAST:event_btnEliminar2ActionPerformed

    private void btnActualizar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizar2ActionPerformed
        //Con este boton se actualiza registro de la tabla indicada llamando al metodo actualizar
        String id_salida = tablaLibros2.getValueAt(tablaLibros2.getSelectedRow(), 0).toString();
        con.ActualizarSalida(txtTitulo6, txtTitulo7, txtTitulo8, txtTitulo9, txtTitulo10, id_salida);
        con.leerSalidas("salida", tablaLibros2);

    }//GEN-LAST:event_btnActualizar2ActionPerformed

    private void btnGuardar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardar2ActionPerformed
        //Con este boton se insertan los registros a la base de datos llamando al metodo correspondiente
        con.InsertarSalida(txtTitulo6, txtTitulo7, txtTitulo8, txtTitulo9, txtTitulo10);
        con.leerSalidas("salida", tablaLibros2);
    }//GEN-LAST:event_btnGuardar2ActionPerformed

    private void txtTitulo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTitulo1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTitulo1ActionPerformed

    private void btnLimpiar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiar1ActionPerformed
        //Se limpian los campos
        txtTitulo1.setText("");
        txtTitulo2.setText("");
        txtTitulo3.setText("");
        txtTitulo4.setText("");
        txtTitulo5.setText("");
    }//GEN-LAST:event_btnLimpiar1ActionPerformed

    private void btnEliminar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminar1ActionPerformed
        //Con este boton se elimina registro de la base de datos llamando al metodo correspondiente para dicha accion
        String idUsuario = tablaLibros1.getValueAt(tablaLibros1.getSelectedRow(), 0).toString();
        con.EliminaRegistro("id_usuario", "usuario", idUsuario);
        con.leerLectores("usuario", tablaLibros1);
    }//GEN-LAST:event_btnEliminar1ActionPerformed

    private void btnActualizar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizar1ActionPerformed
        //Con este boton se actualiza registro de la tabla indicada llamando al metodo actualizar
        String idUsuario = tablaLibros1.getValueAt(tablaLibros1.getSelectedRow(), 0).toString();
        con.ActualizarUsuario(txtTitulo1, txtTitulo2, txtTitulo3, txtTitulo4, txtTitulo5, idUsuario);
        con.leerLectores("usuario", tablaLibros1);

    }//GEN-LAST:event_btnActualizar1ActionPerformed

    private void btnGuardar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardar1ActionPerformed
        //Con este boton se insertan los registros a la base de datos llamando al metodo correspondiente
        con.InsertarUsuario(txtTitulo1, txtTitulo2, txtTitulo3, txtTitulo4, txtTitulo5);
        con.leerLectores("usuario", tablaLibros1);// TODO add your handling code here:
    }//GEN-LAST:event_btnGuardar1ActionPerformed

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
        //Con este boton se ejecuta un evento a la instancia metodo de la clase consulta dicho metodo es buscar en la base de datos
        //por titulo.
        Clases.consultas metodo = new Clases.consultas();
        txtBuscar.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                metodo.buscarEnBaseDeDatos(txtBuscar, tablaLibros);
            }
        });
    }//GEN-LAST:event_txtBuscarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        //Se limpian los campos
        txtTitulo.setText("");
        txtEditorial.setText("");
        txtAno.setText("");
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        if (haySeleccion(tablaLibros) && confirmarEliminacion()) {
        String id = tablaLibros.getValueAt(tablaLibros.getSelectedRow(), 0).toString();
        con.EliminaRegistro("id_libro", "libro", id);
        con.RellenaLaTablaConDatosMySQL("libro", tablaLibros);
        JOptionPane.showMessageDialog(this, "Libro eliminado correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
    }

    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        if (haySeleccion(tablaLibros) && validarLibro()) {
        String id = tablaLibros.getValueAt(tablaLibros.getSelectedRow(), 0).toString();
        con.ActualizarLibro(txtTitulo, txtEditorial, txtAno, id);
        con.RellenaLaTablaConDatosMySQL("libro", tablaLibros);
        JOptionPane.showMessageDialog(this, "Libro actualizado correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
    }
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if (validarLibro()) {
        con.InsertarLibro(txtTitulo, txtEditorial, txtAno);
        con.RellenaLaTablaConDatosMySQL("libro", tablaLibros);
        JOptionPane.showMessageDialog(this, "Libro guardado correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
    }
    }//GEN-LAST:event_btnGuardarActionPerformed
    /**
     * Solo permite números en el campo año (máximo 4 dígitos)
     */    
    private void txtAnoKeyTyped(java.awt.event.KeyEvent evt) {                                
    char c = evt.getKeyChar(); 
    
    if (!Character.isDigit(c)) {
        evt.consume(); // No permite que se escriba
    }
    
    if (txtAno.getText().length() >= 4) {
        evt.consume();
    }
    }
    /**
     * Solo permite números en teléfono y agrega guiones automáticamente
     */    
    private void txtTitulo3KeyTyped(java.awt.event.KeyEvent evt) {                                    
    // TODO add your handling code here:
        char c = evt.getKeyChar();
    // Permitir solo números
    if (!Character.isDigit(c)) {
        evt.consume();
        return;
    }

    // Obtener texto actual
    String texto = txtTitulo3.getText();

    // Limitar a 12 caracteres con formato XXX-XXX-XXXX
    if (texto.length() >= 12) {
        evt.consume();
        return;
    }

    // Insertar guiones automáticamente
    if (texto.length() == 3 || texto.length() == 7) {
        txtTitulo3.setText(texto + "-");
    }    
        
    }                                   

    
    /**
     * Solo permite caracteres válidos para email
     */
    private void txtTitulo5KeyTyped(java.awt.event.KeyEvent evt) {                                    
    char c = evt.getKeyChar();

    // Solo permitir letras, números, arroba, punto, guion y guion bajo
    if (!Character.isLetterOrDigit(c) && c != '@' && c != '.' && c != '-' && c != '_') {
        evt.consume(); // bloquea el carácter
        }
    }                                   

    
     /**
     * Solo permites numero para y guion para el formto de fecha
     */    
    private void txtTitulo6KeyTyped(java.awt.event.KeyEvent evt) {                                    
    char c = evt.getKeyChar();

    // Solo permitir números y '/'
    if (!Character.isDigit(c) && c != '-') {
        evt.consume(); // Bloquea cualquier otro carácter
    }

    // Opcional: limitar a 10 caracteres (ejemplo: 31/12/2025)
    if (txtTitulo6.getText().length() >= 10) {
        evt.consume();
    }
    }                                   

    
    /**
     * Solo permites numero para y guion para el formto de fecha
     */    
    private void txtTitulo7KeyTyped(java.awt.event.KeyEvent evt) {                                    
           char c = evt.getKeyChar();

    // Solo permitir números y '/'
    if (!Character.isDigit(c) && c != '-') {
        evt.consume(); // Bloquea cualquier otro carácter
    }

    // Limitar a 10 caracteres (DD/MM/AAAA)
    if (txtTitulo7.getText().length() >= 10) {
        evt.consume();
    }
    }                                   

        
    private void txtTitulo9KeyTyped(java.awt.event.KeyEvent evt) {                                    
        char c = evt.getKeyChar();

    // Solo permitir números
    if (!Character.isDigit(c)) {
        evt.consume(); // Bloquea cualquier otro carácter
    }

    // Opcional: limitar la longitud (por ejemplo 10 dígitos)
    if (txtTitulo9.getText().length() >= 10) {
        evt.consume();
    }
    }                                   

    
    
    private void txtTitulo10KeyTyped(java.awt.event.KeyEvent evt) {                                     
         char c = evt.getKeyChar();

    // Solo permitir números
    if (!Character.isDigit(c)) {
        evt.consume(); // Bloquea cualquier otro carácter
    }

    // Opcional: limitar la longitud (por ejemplo 10 dígitos)
    if (txtTitulo10.getText().length() >= 10) {
        evt.consume();
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
            java.util.logging.Logger.getLogger(ModernLibrarySystem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModernLibrarySystem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModernLibrarySystem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModernLibrarySystem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ModernLibrarySystem().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnActualizar1;
    private javax.swing.JButton btnActualizar2;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnEliminar1;
    private javax.swing.JButton btnEliminar2;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnGuardar1;
    private javax.swing.JButton btnGuardar2;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnLimpiar1;
    private javax.swing.JButton btnLimpiar2;
    private javax.swing.JPanel cardLectores;
    private javax.swing.JPanel cardPrestamos;
    private javax.swing.JPanel cardTotalLibros;
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler10;
    private javax.swing.Box.Filler filler11;
    private javax.swing.Box.Filler filler12;
    private javax.swing.Box.Filler filler13;
    private javax.swing.Box.Filler filler14;
    private javax.swing.Box.Filler filler15;
    private javax.swing.Box.Filler filler16;
    private javax.swing.Box.Filler filler17;
    private javax.swing.Box.Filler filler18;
    private javax.swing.Box.Filler filler2;
    private javax.swing.Box.Filler filler3;
    private javax.swing.Box.Filler filler4;
    private javax.swing.Box.Filler filler5;
    private javax.swing.Box.Filler filler6;
    private javax.swing.Box.Filler filler7;
    private javax.swing.Box.Filler filler9;
    private javax.swing.JPanel headerPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblLectores;
    private javax.swing.JLabel lblPrestamos;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblTotalLibros;
    private javax.swing.JPanel panelBotones;
    private javax.swing.JPanel panelBotones1;
    private javax.swing.JPanel panelBotones2;
    private javax.swing.JPanel panelBusqueda;
    private javax.swing.JPanel panelCampos;
    private javax.swing.JPanel panelCampos1;
    private javax.swing.JPanel panelCampos2;
    private javax.swing.JPanel panelFormulario;
    private javax.swing.JPanel panelFormulario1;
    private javax.swing.JPanel panelFormulario2;
    private javax.swing.JPanel panelIzquierdo;
    private javax.swing.JPanel panelIzquierdo1;
    private javax.swing.JPanel panelIzquierdo2;
    private javax.swing.JPanel panelLectores;
    private javax.swing.JPanel panelLibros;
    private javax.swing.JPanel panelPrestamos;
    private javax.swing.JPanel panelTituloForm;
    private javax.swing.JPanel panelTituloForm1;
    private javax.swing.JPanel panelTituloForm2;
    private javax.swing.JPanel statsPanel;
    private javax.swing.JTable tablaLibros;
    private javax.swing.JTable tablaLibros1;
    private javax.swing.JTable tablaLibros2;
    private javax.swing.JTextField txtAno;
    private java.awt.TextField txtBuscar;
    private javax.swing.JTextField txtEditorial;
    private javax.swing.JTextField txtTitulo;
    private javax.swing.JTextField txtTitulo1;
    private javax.swing.JTextField txtTitulo10;
    private javax.swing.JTextField txtTitulo2;
    private javax.swing.JTextField txtTitulo3;
    private javax.swing.JTextField txtTitulo4;
    private javax.swing.JTextField txtTitulo5;
    private javax.swing.JTextField txtTitulo6;
    private javax.swing.JTextField txtTitulo7;
    private javax.swing.JTextField txtTitulo8;
    private javax.swing.JTextField txtTitulo9;
    // End of variables declaration//GEN-END:variables
}
