/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.PiDev.entities;

import java.util.Date;

/**
 *
 * @author hadjn
 */
public class Activiter {
    private int id;
    private String titre;
    private Date date_debut;
    private Date date_fin;
    private int id_user;
    private int ref_categ;

    public Activiter(String titre, Date date_debut, Date date_fin, int id_user, int ref_categ) {
        this.titre = titre;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.id_user = id_user;
        this.ref_categ = ref_categ;
    }

    public Activiter(String titre) {
        this.titre = titre;
    }

    public Activiter(int id, String titre, int id_user, int ref_categ) {
        this.id = id;
        this.titre = titre;
        this.id_user = id_user;
        this.ref_categ = ref_categ;
    }

    public Activiter(int id, String titre, Date date_debut, Date date_fin, int id_user, int ref_categ) {
        this.id = id;
        this.titre = titre;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.id_user = id_user;
        this.ref_categ = ref_categ;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public Date getDate_debut() {
        return date_debut;
    }

    public void setDate_debut(Date date_debut) {
        this.date_debut = date_debut;
    }

    public Date getDate_fin() {
        return date_fin;
    }

    public void setDate_fin(Date date_fin) {
        this.date_fin = date_fin;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getRef_categ() {
        return ref_categ;
    }

    public void setRef_categ(int ref_categ) {
        this.ref_categ = ref_categ;
    }

    @Override
    public String toString() {
        return "Activiter{" + "titre=" + titre + ", date_debut=" + date_debut + ", date_fin=" + date_fin + ", id_user=" + id_user + ", ref_categ=" + ref_categ + '}';
    }
    
    
}
