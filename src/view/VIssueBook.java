/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;
import com.mysql.cj.protocol.Resultset;
import com.mysql.cj.xdevapi.PreparableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
//import com.sun.jdi.connect.spi.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.accessibility.AccessibleRole;
import javax.swing.JOptionPane;
import model.DatabaseCon;
/**
 *
 * @author HP
 */
public class VIssueBook extends javax.swing.JFrame {

/**
     * Creates new form VIssueBook
     */
        public VIssueBook() {
        initComponents();
        showDate();
    }
    
    public void showDate(){
        Date d =new Date();
        SimpleDateFormat s= new SimpleDateFormat("yyyy-MM-dd");
        String date=s.format(d);
        lbl_issueDate.setText(date);
    
    }
    //private static Connection con;
    public void getBookdetails(){
        int bookid=Integer.parseInt(txt_bookid.getText());
        try {
            Connection con=DatabaseCon.createDBConnection();
            PreparedStatement pst=con.prepareStatement("select*from book where book_id=?");
            pst.setInt(1, bookid);
            ResultSet rs = pst.executeQuery();
            
            if(rs.next()){
                lbl_book_id.setText(rs.getString("book_id"));
                labl_bookname.setText(rs.getString("name"));
                lbl_edition.setText(rs.getString("edition"));
                lbl_publisher.setText(rs.getString("publisher"));
                lbl_price.setText(rs.getString("price"));
                lbl_stock.setText(rs.getString("stock"));
            }
            else{
                lbl_error.setText("!!!! Invalid book ID or Student ID");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void getStudentdetails(){
        int studentid=Integer.parseInt(txt_studentid.getText());
        try {
            Connection con=DatabaseCon.createDBConnection();
            PreparedStatement pst=con.prepareStatement("select*from student where student_id=?");
            pst.setInt(1, studentid);
            ResultSet rs = pst.executeQuery();
            
            if(rs.next()){
                lbl_studentid.setText(rs.getString("student_id"));
                lbl_studentname.setText(rs.getString("name"));
                lbl_fathersname.setText(rs.getString("fathers_name"));
                lbl_course.setText(rs.getString("course"));
                lbl_branch.setText(rs.getString("branch"));
                lbl_year.setText(rs.getString("year"));
                lbl_semester.setText(rs.getString("semister"));
                
            }
            else{
                lbl_error.setText("!!!! Invalid book ID or Student ID");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public boolean issueBook(){
        boolean isIssued=false;
        int bookid=Integer.parseInt(txt_bookid.getText());
        String bname=labl_bookname.getText();
        String publisher=lbl_publisher.getText();
        int studentid=Integer.parseInt(txt_studentid.getText());
        String sname=lbl_studentname.getText();
        String fname=lbl_fathersname.getText();
        String course=lbl_course.getText();
        String branch=lbl_branch.getText();
        //String issueDate=lbl_issueDate.getText();
        String issueDateText = lbl_issueDate.getText();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date issueDate = null;

        try {
            issueDate = sdf.parse(issueDateText);
        } catch (ParseException e) {
            e.printStackTrace(); // Handle parsing exception
        }
        
        try {
            Connection con=DatabaseCon.createDBConnection();
            String quary="insert into issue(book_id,b_name,publisher,stu_id,s_name,f_name,course,branch,doi)values(?,?,?,?,?,?,?,?,?)";
            PreparedStatement pst=con.prepareStatement(quary);
            pst.setInt(1, bookid);
            pst.setString(2, bname);
            pst.setString(3, publisher);
            pst.setInt(4, studentid);
            pst.setString(5, sname);
            pst.setString(6, fname);
            pst.setString(7, course);
            pst.setString(8, branch);
            pst.setDate(9, new java.sql.Date(issueDate.getTime()));
            int rowCount=pst.executeUpdate();
            
            if(rowCount>0){
                isIssued=true;
            }
            else{
                isIssued=false;
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }

        return isIssued;
    }
    
    public void updateBookcount(){
        int bookid=Integer.parseInt(txt_bookid.getText());
        try {
            Connection con=DatabaseCon.createDBConnection();
            String quary="update book set stock=stock-1 where book_id=?";
            PreparedStatement pst=con.prepareStatement(quary);
            pst.setInt(1, bookid);
            int rowCount=pst.executeUpdate();
            if(rowCount>0){
                int count=Integer.parseInt(lbl_stock.getText());
                lbl_stock.setText(Integer.toString(count-1));
                JOptionPane.showMessageDialog(this, "book count updated");
            }
            else{
                JOptionPane.showMessageDialog(this, "cant update stock");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
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
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lbl_semester = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lbl_studentid = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lbl_studentname = new javax.swing.JLabel();
        lbl_fathersname = new javax.swing.JLabel();
        lbl_course = new javax.swing.JLabel();
        lbl_branch = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        lbl_year = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btn_back1 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        lbl_stock = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        lbl_book_id = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        labl_bookname = new javax.swing.JLabel();
        lbl_edition = new javax.swing.JLabel();
        lbl_publisher = new javax.swing.JLabel();
        lbl_price = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        txt_studentid = new javax.swing.JTextField();
        txt_bookid = new javax.swing.JTextField();
        btn_issuebook = new javax.swing.JButton();
        lbl_issueDate = new javax.swing.JLabel();
        lbl_error = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(102, 102, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Semester  :");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 490, -1, -1));

        lbl_semester.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbl_semester.setForeground(new java.awt.Color(0, 0, 0));
        jPanel2.add(lbl_semester, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 490, 210, 30));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Student Name  :");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Fathers Name  :");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Course  :");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Branch  :");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, -1, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Student ID :");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, -1, -1));

        lbl_studentid.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbl_studentid.setForeground(new java.awt.Color(0, 0, 0));
        jPanel2.add(lbl_studentid, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 200, 210, 30));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 200, 210, 30));

        lbl_studentname.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbl_studentname.setForeground(new java.awt.Color(0, 0, 0));
        jPanel2.add(lbl_studentname, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 250, 210, 30));

        lbl_fathersname.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbl_fathersname.setForeground(new java.awt.Color(0, 0, 0));
        jPanel2.add(lbl_fathersname, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 300, 210, 30));

        lbl_course.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbl_course.setForeground(new java.awt.Color(0, 0, 0));
        jPanel2.add(lbl_course, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 350, 210, 30));

        lbl_branch.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbl_branch.setForeground(new java.awt.Color(0, 0, 0));
        jPanel2.add(lbl_branch, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 400, 210, 30));

        jLabel29.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("Year  :");
        jPanel2.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 450, -1, -1));

        lbl_year.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbl_year.setForeground(new java.awt.Color(0, 0, 0));
        jPanel2.add(lbl_year, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 450, 210, 30));

        jLabel32.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-student-50.png"))); // NOI18N
        jLabel32.setText("Student Details");
        jLabel32.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(255, 255, 255)));
        jPanel2.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, 240, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 0, 390, 700));

        jPanel3.setBackground(new java.awt.Color(255, 51, 51));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_back1.setBackground(new java.awt.Color(102, 102, 255));
        btn_back1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_back1.setForeground(new java.awt.Color(255, 255, 255));
        btn_back1.setText("<< Back");
        btn_back1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_back1ActionPerformed(evt);
            }
        });
        jPanel3.add(btn_back1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-book-50.png"))); // NOI18N
        jLabel8.setText("Book Details");
        jLabel8.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(255, 255, 255)));
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, 220, -1));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Stock  :");
        jPanel3.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 450, -1, -1));

        lbl_stock.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbl_stock.setForeground(new java.awt.Color(0, 0, 0));
        jPanel3.add(lbl_stock, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 450, 210, 30));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Book Name  :");
        jPanel3.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, -1, -1));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Edition  :");
        jPanel3.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, -1, -1));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Book Publisher  :");
        jPanel3.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, -1, -1));

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Price  :");
        jPanel3.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, -1, -1));

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Book ID  :");
        jPanel3.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, -1, -1));

        lbl_book_id.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbl_book_id.setForeground(new java.awt.Color(0, 0, 0));
        jPanel3.add(lbl_book_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 200, 210, 30));

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 200, 210, 30));

        labl_bookname.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        labl_bookname.setForeground(new java.awt.Color(0, 0, 0));
        jPanel3.add(labl_bookname, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 250, 210, 30));

        lbl_edition.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbl_edition.setForeground(new java.awt.Color(0, 0, 0));
        jPanel3.add(lbl_edition, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 300, 210, 30));

        lbl_publisher.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbl_publisher.setForeground(new java.awt.Color(0, 0, 0));
        jPanel3.add(lbl_publisher, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 350, 210, 30));

        lbl_price.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbl_price.setForeground(new java.awt.Color(0, 0, 0));
        jPanel3.add(lbl_price, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 400, 210, 30));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 390, 700));

        jLabel31.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-student-50.png"))); // NOI18N
        jLabel31.setText("Student Details");
        jLabel31.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(255, 255, 255)));
        jPanel1.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, 240, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 51));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-books-64.png"))); // NOI18N
        jLabel1.setText("Issue Book");
        jLabel1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(255, 0, 0)));
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 70, 240, 70));

        jLabel33.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 51, 51));
        jLabel33.setText("Issue Date  :");
        jPanel1.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 310, -1, -1));

        jLabel34.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 51, 51));
        jLabel34.setText("Book ID  :");
        jPanel1.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 200, -1, -1));

        jLabel35.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(255, 51, 51));
        jLabel35.setText("Student ID  :");
        jPanel1.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 250, -1, 40));

        txt_studentid.setBackground(new java.awt.Color(255, 255, 255));
        txt_studentid.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txt_studentid.setForeground(new java.awt.Color(255, 51, 51));
        txt_studentid.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(255, 51, 51)));
        txt_studentid.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_studentidFocusLost(evt);
            }
        });
        jPanel1.add(txt_studentid, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 250, 230, -1));

        txt_bookid.setBackground(new java.awt.Color(255, 255, 255));
        txt_bookid.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txt_bookid.setForeground(new java.awt.Color(255, 51, 51));
        txt_bookid.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(255, 51, 51)));
        txt_bookid.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_bookidFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_bookidFocusLost(evt);
            }
        });
        jPanel1.add(txt_bookid, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 190, 230, 30));

        btn_issuebook.setBackground(new java.awt.Color(255, 51, 51));
        btn_issuebook.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_issuebook.setForeground(new java.awt.Color(255, 255, 255));
        btn_issuebook.setText("Issue Book");
        btn_issuebook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_issuebookActionPerformed(evt);
            }
        });
        jPanel1.add(btn_issuebook, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 440, 180, 40));

        lbl_issueDate.setBackground(new java.awt.Color(255, 255, 255));
        lbl_issueDate.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbl_issueDate.setForeground(new java.awt.Color(0, 0, 0));
        lbl_issueDate.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 51, 51)));
        jPanel1.add(lbl_issueDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 310, 230, 20));

        lbl_error.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbl_error.setForeground(new java.awt.Color(204, 0, 0));
        jPanel1.add(lbl_error, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 360, 290, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1240, 690));

        setSize(new java.awt.Dimension(1258, 667));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_back1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_back1ActionPerformed
        VHome home=new VHome();
       home.setVisible(true);
       dispose();
    }//GEN-LAST:event_btn_back1ActionPerformed

    private void txt_bookidFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_bookidFocusLost
        // TODO add your handling code here:
        if(!txt_bookid.getText().equals("")){
        getBookdetails();}
    }//GEN-LAST:event_txt_bookidFocusLost

    private void txt_bookidFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_bookidFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_bookidFocusGained

    private void txt_studentidFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_studentidFocusLost
        // TODO add your handling code here:
        if(!txt_studentid.getText().equals("")){
        getStudentdetails();}
    }//GEN-LAST:event_txt_studentidFocusLost

    private void btn_issuebookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_issuebookActionPerformed
        // TODO add your handling code here:
        if(issueBook()==true){
            JOptionPane.showMessageDialog(this, "book issued succesfully");
            updateBookcount();
        }
        else{
            JOptionPane.showMessageDialog(this, "cant issue the book");
        }
        
    }//GEN-LAST:event_btn_issuebookActionPerformed

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
            java.util.logging.Logger.getLogger(VIssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VIssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VIssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VIssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VIssueBook().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_back1;
    private javax.swing.JButton btn_issuebook;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel labl_bookname;
    private javax.swing.JLabel lbl_book_id;
    private javax.swing.JLabel lbl_branch;
    private javax.swing.JLabel lbl_course;
    private javax.swing.JLabel lbl_edition;
    private javax.swing.JLabel lbl_error;
    private javax.swing.JLabel lbl_fathersname;
    private javax.swing.JLabel lbl_issueDate;
    private javax.swing.JLabel lbl_price;
    private javax.swing.JLabel lbl_publisher;
    private javax.swing.JLabel lbl_semester;
    private javax.swing.JLabel lbl_stock;
    private javax.swing.JLabel lbl_studentid;
    private javax.swing.JLabel lbl_studentname;
    private javax.swing.JLabel lbl_year;
    private javax.swing.JTextField txt_bookid;
    private javax.swing.JTextField txt_studentid;
    // End of variables declaration//GEN-END:variables
}
