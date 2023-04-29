/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.PiDev.gui;

import com.PiDev.services.ServiceActivite;
import com.PiDev.utils.Statics;
import com.codename1.components.ImageViewer;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Button;
import static com.codename1.ui.Component.BASELINE;
import com.codename1.ui.Dialog;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;

/**
 *
 * @author hadjn
 */
public class Qrcode extends Form{
  public Qrcode(Form previous) {
    setTitle("de planning");
    setLayout(BoxLayout.y());
    TextField id = new TextField("", "planning id");

    Button btnAdd = new Button("generate");
    btnAdd.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent evt) {
        Image qrCodeImage = ServiceActivite.getInstance().getQRCode(id.getAsInt(BASELINE));
       
            ImageViewer viewer = new ImageViewer(qrCodeImage);
            Form form = new Form("QR Code");
            form.setLayout(new BorderLayout());
            form.add(BorderLayout.CENTER, viewer);
            form.show();
        
    }
});


    getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, evt -> {
        previous.showBack();
    });

    addAll(id, btnAdd);
}


    
}
