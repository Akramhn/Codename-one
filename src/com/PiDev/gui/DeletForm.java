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
public class DeletForm extends Form{
    public DeletForm(Form previous){
     setTitle("de planning");
        setLayout(BoxLayout.y());
        TextField id =new TextField("", "planning id");
        
          Button btnAdd = new Button("Delet");
          btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
               if(id.getText()=="")
                    Dialog.show("erreur saisir", "", "ok",null);
                   else
               {
                if(ServiceActivite.getInstance().deletActivite(id.getAsInt(BASELINE)))
                {
                    Dialog.show("Success", "Activite Deleted", "ok",null);
                }
                else
                {
                    Dialog.show("Error", "Activite Error", "ok",null);
                }
               }
            }
          }); 
           getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, (evt) -> {
               previous.showBack();
           });
          
         
           addAll(id,btnAdd);
          
}
    
}
