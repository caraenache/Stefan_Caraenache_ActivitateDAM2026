package com.example.s3_1;

public class ClasaDeElevi {
    private String denumire;
    private int nrMaxElevi;
    private boolean areProiector;
    private int nrBanci;
    private int etaj;

    public ClasaDeElevi(String denumire, int nrMaxElevi, boolean areProiector, int nrBanci, int etaj) {
        this.denumire = denumire;
        this.nrMaxElevi = nrMaxElevi;
        this.areProiector = areProiector;
        this.nrBanci = nrBanci;
        this.etaj = etaj;
    }

    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public int getNrMaxElevi() {
        return nrMaxElevi;
    }

    public void setNrMaxElevi(int nrMaxElevi) {
        this.nrMaxElevi = nrMaxElevi;
    }

    public boolean isAreProiector() {
        return areProiector;
    }

    public void setAreProiector(boolean areProiector) {
        this.areProiector = areProiector;
    }

    public int getNrBanci() {
        return nrBanci;
    }

    public void setNrBanci(int nrBanci) {
        this.nrBanci = nrBanci;
    }

    public int getEtaj() {
        return etaj;
    }

    public void setEtaj(int etaj) {
        this.etaj = etaj;
    }

    @Override
    public String toString() {
        return "clasa{" +
                "denumire='" + denumire + '\'' +
                ", nrMaxElevi=" + nrMaxElevi +
                ", areProiector=" + areProiector +
                ", nrBanci=" + nrBanci +
                ", etaj=" + etaj +
                '}';
    }
}
