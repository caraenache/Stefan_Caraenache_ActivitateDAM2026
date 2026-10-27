package com.example.s3_1;

import android.os.Parcel;
import android.os.Parcelable;

public class ClasaDeElevi implements Parcelable {
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

    public ClasaDeElevi(int nrBanci, boolean areProiector, int etaj) {
        this.denumire = "Necunoscuta";
        this.nrMaxElevi = 0;
        this.areProiector = areProiector;
        this.nrBanci = nrBanci;
        this.etaj = etaj;
    }

    protected ClasaDeElevi(Parcel in) {
        denumire = in.readString();
        nrMaxElevi = in.readInt();
        areProiector = in.readByte() != 0;
        nrBanci = in.readInt();
        etaj = in.readInt();
    }

    public static final Creator<ClasaDeElevi> CREATOR = new Creator<ClasaDeElevi>() {
        @Override
        public ClasaDeElevi createFromParcel(Parcel in) {
            return new ClasaDeElevi(in);
        }

        @Override
        public ClasaDeElevi[] newArray(int size) {
            return new ClasaDeElevi[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(denumire);
        dest.writeInt(nrMaxElevi);
        dest.writeByte((byte) (areProiector ? 1 : 0));
        dest.writeInt(nrBanci);
        dest.writeInt(etaj);
    }

    public String getDenumire() { return denumire; }
    public void setDenumire(String denumire) { this.denumire = denumire; }

    public int getNrMaxElevi() { return nrMaxElevi; }
    public void setNrMaxElevi(int nrMaxElevi) { this.nrMaxElevi = nrMaxElevi; }

    public boolean isAreProiector() { return areProiector; }
    public void setAreProiector(boolean areProiector) { this.areProiector = areProiector; }

    public int getNrBanci() { return nrBanci; }
    public void setNrBanci(int nrBanci) { this.nrBanci = nrBanci; }

    public int getEtaj() { return etaj; }
    public void setEtaj(int etaj) { this.etaj = etaj; }

    @Override
    public String toString() {
        return "ClasaDeElevi{" +
                "denumire='" + denumire + '\'' +
                ", nrMaxElevi=" + nrMaxElevi +
                ", areProiector=" + areProiector +
                ", nrBanci=" + nrBanci +
                ", etaj=" + etaj +
                '}';
    }
}