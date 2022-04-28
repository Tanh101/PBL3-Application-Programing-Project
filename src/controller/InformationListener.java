/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.Information;
import view.Login;
import view.Main;

/**
 *
 * @author ADMIN
 */
public class InforListener implements ActionListener {
    private Main main;
    private Information infor;

    public InforListener(Main aThis) {
        this.main = aThis;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Giới Thiệu")){
            main.setVisible(false);
            new Information().setVisible(true);
        }
    }
    
}
