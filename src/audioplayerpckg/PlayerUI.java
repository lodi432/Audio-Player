/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package audioplayerpckg;

import java.io.File;
import javax.swing.DefaultListModel;
import java.util.ArrayList;
import javazoom.jlgui.basicplayer.BasicPlayer;

/**
 *
 * @author domagoj
 */
public class PlayerUI extends javax.swing.JFrame {

    PlayList1 pl = new PlayList1();

    ArrayList updateList = new ArrayList();
    BasicPlayer player = new BasicPlayer();
//   javazoom.jl.player.Player player;
    File simpantican;

    /**
     * Creates new form PlayerUI
     */
    public PlayerUI() {
        initComponents();
    }

    void updateList() {
        updateList = pl.getListSong();
        DefaultListModel model = new DefaultListModel();
        for (int i = 0; i < updateList.size(); i++) {
            int j = 1 + 1;
            model.add(i, j + " ovo " + ((File) updateList.get(i)).getName());
        }
        jList_plejlist.setModel(model);
    }

    //kontrole
    void add() {
        pl.add(this);
        updateList();
    }

    void remove() {
        try {
            int tamoneki = jList_plejlist.getLeadSelectionIndex();
            pl.ls.remove(tamoneki);
            updateList();
        } catch (Exception e) {

        }

    }

    void up() {
        try {
            int s1 = jList_plejlist.getLeadSelectionIndex();
            simpantican = (File) pl.ls.get(s1);
            pl.ls.remove(s1);
            pl.ls.add(s1 - 1, simpantican);
            updateList();
            jList_plejlist.setSelectedIndex(s1 - 1);
        } catch (Exception e) {

        }
    }

    void down() {
        try {
            int s1 = jList_plejlist.getLeadSelectionIndex();
            simpantican = (File) pl.ls.get(s1);
            pl.ls.remove(s1);
            pl.ls.add(s1 + 1, simpantican);
            updateList();
            jList_plejlist.setSelectedIndex(s1 + 1);
        } catch (Exception e) {

        }
    }

    void open() {
        pl.openPls(this);
        updateList();
    }

    void save() {
        pl.saveAsPlaylist(this);
        updateList();
    }

    File play1;
    static int a = 0;

    void playme() {
        if (a == 0) {
          
            
            try {

                int p1 = jList_plejlist.getSelectedIndex();
                play1 = (File) this.updateList.get(p1);

                player.open(new File(play1.getAbsolutePath()));

                a = 1;
                player.play();

            } catch (Exception e) {
                System.out.println("Problem playing file");

            }

            new Thread() {
                @Override
                public void run() {
                    try {

                        player.play();

                    } catch (Exception e) {

                    }

                }

            }.start();
        } else {

            a = 0;
            playme();
        }
    
        }
    
    boolean clicked = false;

    void pauza(){
        
         if (a != 0) {
            try {

                int p1 = jList_plejlist.getSelectedIndex();
                play1 = (File) this.updateList.get(p1);

                player.open(new File(play1.getAbsolutePath()));
                player.pause();

                a = 1;

            } catch (Exception e) {
                System.out.println("Problem playing file");
//                System.out.println(e);

            }

            new Thread() {
                @Override
                public void run() {
                    try {

                        player.pause();
                        player.resume();

                    } catch (Exception e) {

                    }

                }

            }.start();
        } else {
//            player.close();
            a = 0;
            playme();
        }
    }

    void stopiraj() {
        if (a != 0) {
            try {

                player.stop();

            } catch (Exception e) {
                System.out.println("Problem playing file");
//                System.out.println(e);

            }

            new Thread() {
                @Override
                public void run() {
                    try {
                        player.stop();
                    } catch (Exception e) {
                    }
                }

            }.start();
        } else {
            a = 0;
        }
    }
    
    
    void nastavi (){
        
         if (a == 0) {
            try {

                player.resume();

            } catch (Exception e) {
                System.out.println("Problem playing file");
//                System.out.println(e);

            }

            new Thread() {
                @Override
                public void run() {
                    try {
                        player.resume();
                    } catch (Exception e) {
                    }
                }

            }.start();
        } else {
            a = 0;
        }
        
    
    }
    
    
    
    
    
    File sa;

    void next() {
        if (a == 0) {
            try {
                int s1 = jList_plejlist.getSelectedIndex() + 1;
                sa = (File) this.pl.ls.get(s1);
                player.open(new File(sa.getAbsolutePath()));
                player.play();
                a = 1;
                jList_plejlist.setSelectedIndex(s1);
            } catch (Exception e) {
                System.out.println("Problem playing file");
                System.out.println(e);
            }

            new Thread() {
                @Override
                public void run() {
                    try {
                        player.play();

                    } catch (Exception e) {
                    }
                }
            }.start();
        } else {
//        player.close();
            a = 0;
            next();
        }

    }

    void previous() {
        if (a == 0) {
            try {
                int s1 = jList_plejlist.getSelectedIndex() - 1;
                sa = (File) this.pl.ls.get(s1);
                player.open(new File(sa.getAbsolutePath()));
                player.play();
                a = 1;
                jList_plejlist.setSelectedIndex(s1);
            } catch (Exception e) {
                System.out.println("Problem playing file");
                System.out.println(e);
            }

            new Thread() {
                @Override
                public void run() {
                    try {
                        player.play();

                    } catch (Exception e) {
                    }
                }
            }.start();
        } else {
//        player.close();
            a = 0;
            previous();
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

        btn_upP = new javax.swing.JButton();
        btn_DownP = new javax.swing.JButton();
        btn_addP = new javax.swing.JButton();
        btn_openP = new javax.swing.JButton();
        btn_removeP = new javax.swing.JButton();
        btn_SaveP = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList_plejlist = new javax.swing.JList<>();
        btnPlayme = new javax.swing.JButton();
        btnPause = new javax.swing.JButton();
        btn_stopme = new javax.swing.JButton();
        btnPrevious = new javax.swing.JButton();
        btn_nextt = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btn_upP.setText("UP");
        btn_upP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_upPActionPerformed(evt);
            }
        });

        btn_DownP.setText("DOWN");
        btn_DownP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_DownPActionPerformed(evt);
            }
        });

        btn_addP.setText("ADD");
        btn_addP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addPActionPerformed(evt);
            }
        });

        btn_openP.setText("OPEN");
        btn_openP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_openPActionPerformed(evt);
            }
        });

        btn_removeP.setText("REMOVE");
        btn_removeP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_removePActionPerformed(evt);
            }
        });

        btn_SaveP.setText("SAVE");
        btn_SaveP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SavePActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(jList_plejlist);

        btnPlayme.setText("PLAY");
        btnPlayme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlaymeActionPerformed(evt);
            }
        });

        btnPause.setText("II");
        btnPause.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPauseActionPerformed(evt);
            }
        });

        btn_stopme.setText("STOP");
        btn_stopme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_stopmeActionPerformed(evt);
            }
        });

        btnPrevious.setText("<");
        btnPrevious.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreviousActionPerformed(evt);
            }
        });

        btn_nextt.setText(">");
        btn_nextt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nexttActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 847, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btn_addP, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btn_removeP, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(44, 44, 44)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btn_upP, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btn_DownP, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btn_SaveP, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btn_openP, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(118, 118, 118)
                        .addComponent(btnPause, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(btnPrevious, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(btnPlayme, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(btn_nextt, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(btn_stopme, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(56, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_addP, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_upP, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_openP, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_removeP, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_DownP, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_SaveP, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(96, 96, 96)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPlayme, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPause, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_stopme, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPrevious, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_nextt, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(66, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_openPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_openPActionPerformed
        open();
    }//GEN-LAST:event_btn_openPActionPerformed

    private void btn_addPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addPActionPerformed
        add();
    }//GEN-LAST:event_btn_addPActionPerformed

    private void btn_removePActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_removePActionPerformed
        remove();
    }//GEN-LAST:event_btn_removePActionPerformed

    private void btnPlaymeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlaymeActionPerformed
        playme();
    }//GEN-LAST:event_btnPlaymeActionPerformed

    private void btn_upPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_upPActionPerformed
        up();
    }//GEN-LAST:event_btn_upPActionPerformed

    private void btn_DownPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_DownPActionPerformed
        down();
    }//GEN-LAST:event_btn_DownPActionPerformed

    private void btn_SavePActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SavePActionPerformed
        save();
    }//GEN-LAST:event_btn_SavePActionPerformed

    private void btnPreviousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreviousActionPerformed
        previous();
    }//GEN-LAST:event_btnPreviousActionPerformed

    private void btn_nexttActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nexttActionPerformed
        next();
    }//GEN-LAST:event_btn_nexttActionPerformed

    private void btn_stopmeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_stopmeActionPerformed
        stopiraj();
    }//GEN-LAST:event_btn_stopmeActionPerformed

    private void btnPauseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPauseActionPerformed
     if (!clicked) {
         pauza();
         btnPause.setText(">");
     }else{
         nastavi();
         btnPause.setText("II");
     }
      
    }//GEN-LAST:event_btnPauseActionPerformed

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
            java.util.logging.Logger.getLogger(PlayerUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PlayerUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PlayerUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PlayerUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PlayerUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPause;
    private javax.swing.JButton btnPlayme;
    private javax.swing.JButton btnPrevious;
    private javax.swing.JButton btn_DownP;
    private javax.swing.JButton btn_SaveP;
    private javax.swing.JButton btn_addP;
    private javax.swing.JButton btn_nextt;
    private javax.swing.JButton btn_openP;
    private javax.swing.JButton btn_removeP;
    private javax.swing.JButton btn_stopme;
    private javax.swing.JButton btn_upP;
    private javax.swing.JList<String> jList_plejlist;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    private DefaultListModel DefaultListModel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
