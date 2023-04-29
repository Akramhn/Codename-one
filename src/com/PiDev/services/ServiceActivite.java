/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.PiDev.services;

import com.PiDev.entities.Activiter;
import com.PiDev.utils.Statics;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.Log;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.l10n.ParseException;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Image;
import com.codename1.ui.List;
import com.codename1.ui.events.ActionListener;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;



/**
 *
 * @author hadjn
 */
public class ServiceActivite {
    public ConnectionRequest req;
       public ArrayList<Activiter> plannings;
    private static ServiceActivite instance=null;
    public boolean resultOK;
    public Image qrCodeImage = null;
    public ServiceActivite()
    {
        req=new ConnectionRequest();
        
    }

    public static ServiceActivite getInstance() {
        if(instance==null)
            instance=new ServiceActivite();
        return instance;
    }
    public boolean addActivite(Activiter activite)
    {
        String url=Statics.BASE_URL+"addJson";
        req.setUrl(url);
        req.setPost(false);
        req.addArgument("titre", activite.getTitre());
        req.addArgument("date_debut", activite.getDate_debut()+""); 
        req.addArgument("date_fin", activite.getDate_fin()+"");
         req.addArgument("ref_categ",1+"");
          req.addArgument("id_user",5+"");
         
        
        
        req.addResponseListener(new ActionListener<NetworkEvent>()
        {
            @Override
            public void actionPerformed(NetworkEvent evt) {
              resultOK=req.getResponseCode()==200;
              req.removeResponseListener(this);
            }
            
        }
        );
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }
    
    
    
     public boolean updateActivite(Activiter activite)
    {
        String url=Statics.BASE_URL+"updateJson"+"/"+activite.getId();
        req.setUrl(url);
        req.setPost(false);
        req.addArgument("titre", activite.getTitre());
        req.addArgument("date_debut", activite.getDate_debut()+""); 
        req.addArgument("date_fin", activite.getDate_fin()+"");
         req.addArgument("ref_categ",1+"");
          req.addArgument("id_user",5+"");
         
        
        
        req.addResponseListener(new ActionListener<NetworkEvent>()
        {
            @Override
            public void actionPerformed(NetworkEvent evt) {
              resultOK=req.getResponseCode()==200;
              req.removeResponseListener(this);
            }
            
        }
        );
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }
     
     
     
      public boolean deletActivite(int id)
    {
        String url=Statics.BASE_URL+"deletJson"+"/"+id;
        req.setUrl(url);
        req.setPost(false);
       
         
        
        
        req.addResponseListener(new ActionListener<NetworkEvent>()
        {
            @Override
            public void actionPerformed(NetworkEvent evt) {
              resultOK=req.getResponseCode()==200;
              req.removeResponseListener(this);
            }
            
        }
        );
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }
    
    
       public Image getQRCode(int id) {
    String url = Statics.BASE_URL + "qrjson" + "/" + id;
    req.setUrl(url);
    req.setPost(false);

    

    req.addResponseListener((NetworkEvent evt) -> {
        try {
            JSONParser parser = new JSONParser();
            Map<String, Object> responseData = parser.parseJSON(new InputStreamReader(new ByteArrayInputStream(req.getResponseData()), "UTF-8"));
            String dataUri = (String) responseData.get("dataUri");

            // Create EncodedImage from dataUri and convert it to Image
            EncodedImage image = EncodedImage.createFromImage(Image.createImage(dataUri), false);
          byte[] imageData = image.getImageData();
              qrCodeImage = Image.createImage(imageData, 0, imageData.length);
             
        } catch (IOException ex) {
            Log.e(ex);
        }
    });
    
    NetworkManager.getInstance().addToQueueAndWait(req);
    return qrCodeImage;
}

      
      
      
    
    public ArrayList<Activiter> getAllTasks() {
        String url = Statics.BASE_URL + "displayJson";
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                try {
                    plannings = parseActivite(new String(req.getResponseData()));
                } catch (ParseException ex) {
                    System.out.println(ex.getMessage());
                }
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return plannings;
    }

    private ArrayList<Activiter> parseActivite(String jsonText) throws ParseException {
        try
        {
        plannings=new ArrayList<>();
        JSONParser j=new JSONParser();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Map<String,Object> ActiviteListJson=j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
       java.util.List<Map<String, Object>> list = (java.util.List<Map<String, Object>>) ActiviteListJson.get("root");
            
       for (Map<String, Object> obj : list){
            
            
            String titre= obj.get("titre").toString();
             
            
            
            Activiter a=new Activiter(titre);
            plannings.add(a);
         }
        
    }catch(IOException ex){
            System.out.println(ex.getMessage());
}
    
    return plannings;
    
}
}
