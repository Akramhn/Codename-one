/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.PiDev.gui;

import com.codename1.ui.Button;
import com.codename1.ui.Form;
import com.codename1.ui.layouts.BoxLayout;

/**
 *
 * @author hadjn
 */
public class HomeForm extends Form {
    
    public HomeForm() {
        setTitle("Gestion planning");
        setLayout(BoxLayout.y());
        Button btnAdd=new Button("Add Planning");
        Button btnDelet=new Button("Delet Planning");
        Button btnshow=new Button("Show Plannings");
        Button btnupdate=new Button("Update Planning");
          Button btnqr=new Button("qr Planning");
        btnAdd.addActionListener((evt) -> { new AddForm(this).show();
        });
        btnDelet.addActionListener((evt) -> {new DeletForm(this).show();
        });
        btnupdate.addActionListener((evt) -> {new UpdateForm((this)).show();
        });
        btnshow.addActionListener((evt) -> {new ShowFrom(this).show();
        });
        btnqr.addActionListener((evt) -> {new Qrcode(this).show();
        });
        add(btnAdd);
        add(btnupdate);
        add(btnDelet);
        add(btnshow);
        add(btnqr);
        
        
    }
    
}
