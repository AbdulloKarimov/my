package com.demotxt.myapp.myapplication.model;

/**
 * Created by Aws on 11/03/2018.
 */

public class Job {

    private String Bewerber_Kontakt ;
    private String Bundesland;
    private String Einsatzort;
    private String Stelle_Aktiv_bis;

    private String Anscheiben_zur_Stelle ;
    private String Bezeichnung_der_Stelle;
    private String Logo;

    private String E_Mail;
    private String street;
    private String anspreshpartner;
    private String umzeit;

    private String abteilung;

    public String getBewerber_Kontakt() {
        return Bewerber_Kontakt;
    }

    public void setBewerber_Kontakt(String bewerber_Kontakt) {
        Bewerber_Kontakt = bewerber_Kontakt;
    }

    public String getBundesland() {
        return Bundesland;
    }

    public void setBundesland(String bundesland) {
        Bundesland = bundesland;
    }

    public String getEinsatzort() {
        return Einsatzort;
    }

    public void setEinsatzort(String einsatzort) {
        Einsatzort = einsatzort;
    }

    public String getStelle_Aktiv_bis() {
        return Stelle_Aktiv_bis;
    }

    public void setStelle_Aktiv_bis(String stelle_Aktiv_bis) {
        Stelle_Aktiv_bis = stelle_Aktiv_bis;
    }

    public String getAnscheiben_zur_Stelle() {
        return Anscheiben_zur_Stelle;
    }

    public void setAnscheiben_zur_Stelle(String anscheiben_zur_Stelle) {
        Anscheiben_zur_Stelle = anscheiben_zur_Stelle;
    }

    public String getBezeichnung_der_Stelle() {
        return Bezeichnung_der_Stelle;
    }

    public void setBezeichnung_der_Stelle(String bezeichnung_der_Stelle) {
        Bezeichnung_der_Stelle = bezeichnung_der_Stelle;
    }

    public String getLogo() {
        return Logo;
    }

    public void setLogo(String logo) {
        Logo = logo;
    }

    public String getE_Mail() {
        return E_Mail;
    }

    public void setE_Mail(String e_Mail) {
        E_Mail = e_Mail;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getAnspreshpartner() {
        return anspreshpartner;
    }

    public void setAnspreshpartner(String anspreshpartner) {
        this.anspreshpartner = anspreshpartner;
    }

    public String getUmzeit() {
        return umzeit;
    }

    public void setUmzeit(String umzeit) {
        this.umzeit = umzeit;
    }

    public String getAbteilung() {
        return abteilung;
    }

    public void setAbteilung(String abteilung) {
        this.abteilung = abteilung;
    }

    public Job() {

    }

    public Job(String bewerber_Kontakt, String bundesland, String einsatzort, String stelle_Aktiv_bis, String anscheiben_zur_Stelle, String bezeichnung_der_Stelle, String logo, String e_Mail, String street, String anspreshpartner, String umzeit, String abteilung) {
        Bewerber_Kontakt = bewerber_Kontakt;
        Bundesland = bundesland;
        Einsatzort = einsatzort;
        Stelle_Aktiv_bis = stelle_Aktiv_bis;
        Anscheiben_zur_Stelle = anscheiben_zur_Stelle;
        Bezeichnung_der_Stelle = bezeichnung_der_Stelle;
        Logo = logo;
        E_Mail = e_Mail;
        this.street = street;
        this.anspreshpartner = anspreshpartner;
        this.umzeit = umzeit;
        this.abteilung = abteilung;
    }
}
