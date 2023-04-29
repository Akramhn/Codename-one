/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.PiDev.gui;

import com.PiDev.entities.Activiter;
import com.PiDev.services.ServiceActivite;
import com.codename1.ui.Button;
import com.codename1.ui.CheckBox;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.spinner.Picker;

/**
 *
 * @author hadjn
 */
public class UpdateForm extends Form {
    public  UpdateForm(Form previous){
    
     setTitle("Add planning");
        setLayout(BoxLayout.y());
        TextField tfTitre =new TextField("", "planning title");
         TextField id =new TextField("", "planning id");
      
         Picker date_deb= new Picker();
          Picker date_f= new Picker();
          CheckBox cbCateg=new CheckBox("golf");
          Button btnAdd = new Button("Add");
          btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                Activiter activite=new Activiter(id.getAsInt(BASELINE),tfTitre.getText(), date_deb.getDate(), date_f.getDate(), 1, 5);
                if(ServiceActivite.getInstance().updateActivite(activite))
                {
                    Dialog.show("Success", "Activite Added", "ok",null);
                }
                else
                {
                    Dialog.show("Error", "Activite Error", "ok",null);
                }
            }
          }); 
           getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, (evt) -> {
               previous.showBack();
           });
           addAll(id,tfTitre,date_deb,date_f,cbCateg,btnAdd);
          
    
}
    
}
