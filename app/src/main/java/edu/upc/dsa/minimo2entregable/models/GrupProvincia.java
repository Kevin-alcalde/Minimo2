package edu.upc.dsa.minimo2entregable.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class GrupProvincia implements Serializable {

    @SerializedName("provincia_codi")
    @Expose
    private String provinciaCodi;
    @SerializedName("provincia_nom")
    @Expose
    private String provinciaNom;

    public String getProvinciaCodi() {
        return provinciaCodi;
    }

    public void setProvinciaCodi(String provinciaCodi) {
        this.provinciaCodi = provinciaCodi;
    }

    public String getProvinciaNom() {
        return provinciaNom;
    }

    public void setProvinciaNom(String provinciaNom) {
        this.provinciaNom = provinciaNom;
    }

}
