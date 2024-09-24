/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import com.mysql.cj.jdbc.PreparedStatementWrapper;
import com.mysql.cj.protocol.Resultset;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;
import model.DatabaseCon;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

/**
 *
 * @author HP
 */
public class VManageBook extends javax.swing.JFrame {

    /**
     * Creates new form VManageBook
     */
    int edition,price,stock,book_id;
    String name,publisher;
    DefaultTableModel model;
    
    public VManageBook() {
        initComponents();
        setBooktable();
        incrementBookID();
    }
    private static Connection con;
    public void setBooktable(){
        try {
            String path = "jdbc:mysql://localhost/library_management";
            con=DriverManager.getConnection(path, "root", "");
            //Statement st= DatabaseCon.createDBConnection().createStatement();
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery("select*from book");
            
            while (rs.next()) {
                int bookid = rs.getInt("book_id");
                String name=rs.getString("name");
                int edition=rs.getInt("edition");
                String publisher=rs.getString("publisher");
                int price=rs.getInt("price");
                int stock=rs.getInt("stock");
                
                Object[] obj ={bookid,name,edition,publisher,price,stock};
                model=(DefaultTableModel)table_manage_book.getModel();
                model.addRow(obj);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void clearTable(){
        DefaultTableModel model=(DefaultTableModel) table_manage_book.getModel();
        model.setRowCount(0);
    }
    private void incrementBookID() {
        try {
            //Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/library_management", "root", "");
            Connection con=DatabaseCon.createDBConnection();
            // Query the database to get the next book ID
            String query = "SELECT MAX(book_id) + 1 FROM book";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int nextBookId = resultSet.getInt(1);
                //nextBookId++;
                lbl_bookid.setText(Integer.toString(nextBookId));
            }

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    public boolean addbook(){
        boolean isAdded=false;
        //book_id=Integer.parseInt(lbl_bid.getText());
        name=txt_bname.getText();
        edition=Integer.parseInt(txt_b_edition.getText());
        publisher=txt_publisher.getText();
        price=Integer.parseInt(txt_price.getText());
        stock=Integer.parseInt(txt_stock.getText());
        
        try {
            Connection con=DatabaseCon.createDBConnection();
            //String quary="insert into book values(?,?,?,?,?,?)";
            //PreparedStatement pst=con.prepareStatement(quary);
            String query = "INSERT INTO book (name, edition, publisher, price, stock) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement pst = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            //pst.setInt(1, book_id);
            pst.setString(1, name);
            pst.setInt(2, edition);
            pst.setString(3, publisher);
            pst.setInt(4, price);
            pst.setInt(5, stock);
            int rowCount=pst.executeUpdate();
            if(rowCount>0){
                ResultSet generatedKeys = pst.getGeneratedKeys();
            if (generatedKeys.next()) {
                book_id = generatedKeys.getInt(1);
                lbl_bookid.setText(Integer.toString(book_id)); // Update the label with the generated book ID
            }
                isAdded=true;
            }
            else{
                isAdded=false;
            }
                
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isAdded;
    }
    
    /*public void exeption(){
        String bname = txt_bname.getText().trim();
        if (bname.isEmpty()||publisher.isEmpty())
                {
                    lbl_error.setText("cannot be null or cant use numbers");
                }
        else{
            lbl_error.setText("");
        }
    }*/
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btn_back = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lbl_bid = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lbl_bname = new javax.swing.JLabel();
        txt_bname = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        lbl_b_edition = new javax.swing.JLabel();
        txt_b_edition = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        lbl_publisher = new javax.swing.JLabel();
        txt_publisher = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        lbl_price = new javax.swing.JLabel();
        txt_price = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        lbl_stock = new javax.swing.JLabel();
        txt_stock = new javax.swing.JTextField();
        btn_delete = new javax.swing.JButton();
        btn_add = new javax.swing.JButton();
        btn_update = new javax.swing.JButton();
        lbl_bookid = new javax.swing.JLabel();
        lbl_error = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_manage_book = new rojeru_san.complementos.RSTableMetro();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 153, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_back.setBackground(new java.awt.Color(204, 0, 51));
        btn_back.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        btn_back.setText("<< Back");
        btn_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_backActionPerformed(evt);
            }
        });
        jPanel1.add(btn_back, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 110, 30));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("Manage Book");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 60, 140, 30));

        lbl_bid.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_bid.setForeground(new java.awt.Color(255, 255, 255));
        lbl_bid.setText("Book ID");
        jPanel1.add(lbl_bid, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 130, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-book-stack-60.png"))); // NOI18N
        jLabel2.setText("jLabel2");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 60, 50));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-address-book-50.png"))); // NOI18N
        jLabel3.setText("jLabel2");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 50, 50));

        lbl_bname.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_bname.setForeground(new java.awt.Color(255, 255, 255));
        lbl_bname.setText("Book Name");
        jPanel1.add(lbl_bname, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 210, -1, -1));

        txt_bname.setBackground(new java.awt.Color(0, 153, 204));
        txt_bname.setForeground(new java.awt.Color(0, 102, 102));
        txt_bname.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        txt_bname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_bnameKeyReleased(evt);
            }
        });
        jPanel1.add(txt_bname, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 240, 240, 20));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-versions-48.png"))); // NOI18N
        jLabel4.setText("jLabel2");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 50, 50));

        lbl_b_edition.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_b_edition.setForeground(new java.awt.Color(255, 255, 255));
        lbl_b_edition.setText("Edition");
        jPanel1.add(lbl_b_edition, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 290, -1, -1));

        txt_b_edition.setBackground(new java.awt.Color(0, 153, 204));
        txt_b_edition.setForeground(new java.awt.Color(0, 102, 102));
        txt_b_edition.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        jPanel1.add(txt_b_edition, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 320, 240, 20));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-product-hunt-60.png"))); // NOI18N
        jLabel5.setText("jLabel2");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, 60, 50));

        lbl_publisher.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_publisher.setForeground(new java.awt.Color(255, 255, 255));
        lbl_publisher.setText("Publisher");
        jPanel1.add(lbl_publisher, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 360, -1, -1));

        txt_publisher.setBackground(new java.awt.Color(0, 153, 204));
        txt_publisher.setForeground(new java.awt.Color(0, 102, 102));
        txt_publisher.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        jPanel1.add(txt_publisher, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 390, 240, 20));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-price-50.png"))); // NOI18N
        jLabel6.setText("jLabel2");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 430, 60, 50));

        lbl_price.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_price.setForeground(new java.awt.Color(255, 255, 255));
        lbl_price.setText("Price");
        jPanel1.add(lbl_price, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 430, -1, -1));

        txt_price.setBackground(new java.awt.Color(0, 153, 204));
        txt_price.setForeground(new java.awt.Color(0, 102, 102));
        txt_price.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        jPanel1.add(txt_price, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 460, 240, 20));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-sell-stock-48.png"))); // NOI18N
        jLabel7.setText("jLabel2");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 500, 60, 50));

        lbl_stock.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_stock.setForeground(new java.awt.Color(255, 255, 255));
        lbl_stock.setText("Stock");
        jPanel1.add(lbl_stock, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 500, -1, -1));

        txt_stock.setBackground(new java.awt.Color(0, 153, 204));
        txt_stock.setForeground(new java.awt.Color(0, 102, 102));
        txt_stock.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        jPanel1.add(txt_stock, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 530, 240, 20));

        btn_delete.setBackground(new java.awt.Color(204, 0, 0));
        btn_delete.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_delete.setForeground(new java.awt.Color(255, 255, 255));
        btn_delete.setText("Delete");
        jPanel1.add(btn_delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 610, 80, 30));

        btn_add.setBackground(new java.awt.Color(204, 0, 0));
        btn_add.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_add.setForeground(new java.awt.Color(255, 255, 255));
        btn_add.setText("ADD");
        btn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addActionPerformed(evt);
            }
        });
        jPanel1.add(btn_add, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 610, 90, 30));

        btn_update.setBackground(new java.awt.Color(204, 0, 0));
        btn_update.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_update.setForeground(new java.awt.Color(255, 255, 255));
        btn_update.setText("Update");
        jPanel1.add(btn_update, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 610, 80, 30));

        lbl_bookid.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_bookid.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        jPanel1.add(lbl_bookid, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 160, 230, 20));
        jPanel1.add(lbl_error, new org.netbeans.lib.awtextra.AbsoluteConstraints(68, 90, 270, 20));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 680));

        jPanel2.setBackground(new java.awt.Color(204, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        table_manage_book.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Book Name", "Edition", "Publisher", "Price", "Stock"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(table_manage_book);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 660, 160));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 0, 690, 680));

        setSize(new java.awt.Dimension(1103, 691));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_backActionPerformed
       VHome home=new VHome();
       home.setVisible(true);
       dispose();
    }//GEN-LAST:event_btn_backActionPerformed

    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed
        // TODO add your handling code here:
        String bname = txt_bname.getText().trim();
        if (bname.isEmpty()||publisher.isEmpty())
                {
                    JOptionPane.showMessageDialog(this, "cannot be null or number");
                }
        else{
        if(addbook()==true){
            JOptionPane.showMessageDialog(this, "book added succesfully");
            clearTable();
            setBooktable();
        }
        else{
            JOptionPane.showMessageDialog(this, "book not added");
        }
        }
    }//GEN-LAST:event_btn_addActionPerformed

    private void txt_bnameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_bnameKeyReleased
        // TODO add your handling code here:
       
    }//GEN-LAST:event_txt_bnameKeyReleased

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
            java.util.logging.Logger.getLogger(VManageBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VManageBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VManageBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VManageBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VManageBook().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_add;
    private javax.swing.JButton btn_back;
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_update;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_b_edition;
    private javax.swing.JLabel lbl_bid;
    private javax.swing.JLabel lbl_bname;
    private javax.swing.JLabel lbl_bookid;
    private javax.swing.JLabel lbl_error;
    private javax.swing.JLabel lbl_price;
    private javax.swing.JLabel lbl_publisher;
    private javax.swing.JLabel lbl_stock;
    private rojeru_san.complementos.RSTableMetro table_manage_book;
    private javax.swing.JTextField txt_b_edition;
    private javax.swing.JTextField txt_bname;
    private javax.swing.JTextField txt_price;
    private javax.swing.JTextField txt_publisher;
    private javax.swing.JTextField txt_stock;
    // End of variables declaration//GEN-END:variables
}