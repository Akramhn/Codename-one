/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.PiDev.gui;

import com.PiDev.entities.Activiter;
import com.PiDev.services.ServiceActivite;
import com.codename1.ui.CheckBox;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BoxLayout;
import java.util.ArrayList;

/**
 *
 * @author hadjn
 */
public class ShowFrom extends Form {
    public ShowFrom(Form previous) {
    setTitle("List planning");
    setLayout(BoxLayout.y());

    getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, (evt) -> {
        previous.showBack();
    });

    ArrayList<Activiter> plannings = ServiceActivite.getInstance().getAllTasks();
    System.out.println("Got " + plannings.size() + " plannings:");
    for (Activiter a : plannings) {
        System.out.println("  " + a.getId() + ": " + a.getTitre());
        CheckBox cbAct = new CheckBox(a.getTitre());
        add(cbAct);
    }
}

}
