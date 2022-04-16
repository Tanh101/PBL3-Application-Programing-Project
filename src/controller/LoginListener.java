/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import view.Admin;
import view.Login;
import view.Main;

/**
 *
 * @author ADMIN
 */
public class LoginListener implements ActionListener, MouseListener {
    private Main main;
    private Login log;
    static int count = 0;

    public LoginListener(Login aThis) {
        this.log = aThis;
    }
   
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Đăng Nhập")){
            String value = log.getJboxChoose().getSelectedItem().toString();
//            System.out.println("Hello");
            if(value.equals("Quản Trị Viên")){
                String passText = new String(log.getJpass().getPassword());
                if(log.getJtxtAccount().getText().compareTo("lyvantanh1001") == 0 && 
                        passText.compareTo("lyvantanh2002") == 0){
                    System.out.println("Hello");
                    log.setVisible(false);
                    new Admin().setVisible(true);
                }
            }
        }
         
    }
     @Override
    public void mouseClicked(MouseEvent e) {
        count++;
        for(int i = 0; i < count; i++)
        if(i % 2 == 0){
            log.getJpass().setEchoChar((char)0);
        }
        else{
            log.getJpass().setEchoChar('*');
        }
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    
}
