package com.example.cobarecyclerview;

import android.os.Parcel;
import android.os.Parcelable;

public class Mhs implements Parcelable {

    String nama ;
    String nim ;
    String nohp ;

    public Mhs(String nama, String nim, String nohp) {
        this.nama = nama;
        this.nim = nim;
        this.nohp = nohp;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getNohp() {
        return nohp;
    }

    public void setNohp(String nohp) {
        this.nohp = nohp;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.nohp);
        dest.writeString(this.nim);
        dest.writeString(this.nama);
    }

    public void readFromParcel(Parcel source) {
        this.nohp = source.readString();
        this.nim = source.readString();
        this.nama = source.readString();
    }

    protected Mhs(Parcel in) {
        this.nohp = in.readString();
        this.nim = in.readString();
        this.nama = in.readString();
    }

    public static final Creator<Mhs> CREATOR = new Creator<Mhs>() {
        @Override
        public Mhs createFromParcel(Parcel source) {
            return new Mhs(source);
        }

        @Override
        public Mhs[] newArray(int size) {
            return new Mhs[size];
        }
    };
}
