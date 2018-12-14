/** 
 * This Mini-Project about to take a photo with Idol you like
 * Mini-project for 010123131 Software Development Practice I
 * 
 * Code by 6001012630021  Chanakan  Thimkham
 *         6001012620076  Chaninat  Boonsiri 
 * 
 * GitHub : https://github.com/Chalol/Photo-Booth-with-JAVA

 **/


import com.googlecode.javacv.cpp.opencv_core.IplImage;
import com.googlecode.javacv.cpp.opencv_highgui;
import com.googlecode.javacv.cpp.opencv_highgui.CvCapture;
import java.awt.Component;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.tree.DefaultMutableTreeNode;
import project.Project;
import project.payment_frame;
import static com.googlecode.javacv.cpp.opencv_core.cvFlip;
import java.awt.Color;
import javax.swing.JTabbedPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeCellRenderer;





public class projectGUI extends javax.swing.JFrame {
    memberdata memberdata;
    customerdata customerdata;
    String key;
    String name;
    String email;
    String address;
    private Icon icon;
    private ImageIcon imageIcon;
    private JTree tree2;
    private Object tree;
    private int index;

    /**
     * Creates new form projectGUI
     */
    public projectGUI() {
        initComponents();
    }


    private void selectboxValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_selectboxValueChanged

    }//GEN-LAST:event_selectboxValueChanged

    
    private void selectboxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_selectboxMouseClicked
        
        DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) selectbox.getSelectionPath().getLastPathComponent();
        key = selectedNode.getUserObject().toString();
        ImageIcon a = new ImageIcon(memberdata.main(key,0));
        picture.setText("");
        picture.setIcon(a);
        jLabel6.setText(memberdata.main(key,1));
    
    }//GEN-LAST:event_selectboxMouseClicked

    private void pictureInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_pictureInputMethodTextChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_pictureInputMethodTextChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        String border = jLabel6.getText().toString();
        ImageIcon icon = new ImageIcon(memberdata.main(key,2));
        Thread webcam;
        webcam = new Thread() {
            public void run() {

                CvCapture capture = opencv_highgui.cvCreateCameraCapture(0);
                IplImage grabbedImage = opencv_highgui.cvQueryFrame(capture);

               jLabel5.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 498,icon));
                while ((grabbedImage = opencv_highgui.cvQueryFrame(capture)) != null) {
                        Image image = grabbedImage.getBufferedImage();
                        jLabel5.setIcon(new ImageIcon(image));

                        try {
                            Thread.sleep(80);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Project.class.getName()).log(Level.SEVERE, null, ex);
                        }

                       }
                }
        };
        webcam.start();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        try {
            SaveScreenShot(jLabel5,"finalpic.png");
            
        } catch (Exception ex) {
            Logger.getLogger(projectGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        ImageIcon finalpic = new ImageIcon("C:\\Users\\chanakanT\\Documents\\work\\Software\\Project\\Project\\finalpic.png");
        Image refinalpic = finalpic.getImage().getScaledInstance(374, 300, Image.SCALE_DEFAULT);
        finalpic  = new ImageIcon(refinalpic);
        jLabel7.setIcon(finalpic);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
       
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void buy_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buy_btActionPerformed
        projectGUI.this.setVisible(false);
        name = jTextField4.getText().toString();
        address = jTextField3.getText().toString();
        email = jTextField2.getText().toString();
        customerdata.main(name,email,address);
        payment_frame s =new payment_frame();
        s.setVisible(true);
    }//GEN-LAST:event_buy_btActionPerformed

    public static BufferedImage getScreenShot(Component component){
        
       BufferedImage image = new BufferedImage(component.getWidth(),component.getHeight(),BufferedImage.TYPE_INT_RGB);
       component.paint(image.getGraphics());
        return image;
    }
   public static void SaveScreenShot(Component component,String filename) throws Exception{
       
       BufferedImage img = getScreenShot(component);
       ImageIO.write(img, "png", new File(filename));
     
   }
   
    
