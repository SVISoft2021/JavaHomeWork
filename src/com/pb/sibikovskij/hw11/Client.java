package com.pb.sibikovskij.hw11;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.*;
import java.time.*;
import java.util.Date;

public class Client {
    private String NameCl;
    private LocalDate BirthCl;
    private String[] PhoneCl;
    private String AdresCl;
    private LocalDateTime EditCl;

    public Client() {    }

    public Client(String nameCl, LocalDate birthCl, String[] phoneCl, String adresCl, LocalDateTime editCl) {
        NameCl = nameCl;
        BirthCl = birthCl;
        PhoneCl = phoneCl;
        AdresCl = adresCl;
        EditCl = editCl;
    }

    public String getNameCl() {
        return NameCl;
    }

    public void setNameCl(String nameCl) {
        NameCl = nameCl;
    }

    public LocalDate getBirthCl() {
        return BirthCl;
    }

    public String BirthClT() {
        //return String.format("%td/%tm/%tY", BirthCl,BirthCl,BirthCl);
        return BirthCl.toString();
    }


    public void setBirthCl(LocalDate birthCl) {
        BirthCl = birthCl;
    }

    public String[] getPhoneCl() {
        return PhoneCl;
    }

    public String PhoneClTxt(String[] PhoneClTmp) {
       String PhoneClTxtList = "";
       if (PhoneClTmp.length > 0) {
        PhoneClTxtList = PhoneClTmp[0];
       }

       for (int i = 1; i < PhoneClTmp.length-1; i++) {
          if (PhoneClTmp[i] != null) {
              PhoneClTxtList = PhoneClTxtList + ", " + PhoneClTmp[i];
          }
       }
        if (PhoneClTxtList != "") {
            PhoneClTxtList = "[" + PhoneClTxtList + "]";
        }
        return PhoneClTxtList;
    }

    public void setPhoneCl(String[] phoneCl) {
        PhoneCl = phoneCl;
    }

    public String getAdresCl() {
        return AdresCl;
    }

    public void setAdresCl(String adresCl) {
        AdresCl = adresCl;
    }

    public LocalDateTime getEditCl() {
        return EditCl;
    }

    public void setEditCl(LocalDateTime editCl) {
        EditCl = editCl;
    }



    @Override
    public String toString() {
        return "\nАбонент {" +
                "ім'я - " + NameCl +
                //", дата народження - " + String.format("%td/%tm/%tY", BirthCl,BirthCl,BirthCl) +
                ", дата народження - " + BirthCl +
                //", контакти - " + Arrays.toString(PhoneCl) +
                ", контакти - " + PhoneClTxt(PhoneCl) +
                ", адреса - " + AdresCl +
                ", модифікація - " + EditCl.toString() +
        "}";
    }
}
