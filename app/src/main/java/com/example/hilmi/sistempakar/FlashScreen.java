package com.example.hilmi.sistempakar;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.hilmi.sistempakar.db.SessionHelper;
import com.example.hilmi.sistempakar.helpers.SQLiteHelper;
import com.example.hilmi.sistempakar.models.Gejala;
import com.example.hilmi.sistempakar.models.Keputusan;
import com.example.hilmi.sistempakar.models.Penyakit;

public class FlashScreen extends AppCompatActivity {

    private int waktu_flash = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.flash_screen);

        if (SessionHelper.getInstance(this).getAppFirstTime()) {
            SQLiteHelper.getInstance(this).addPenyakit(new Penyakit("P01", "Penyakit SNOT CORZYA", "kasih obat nata"));
            SQLiteHelper.getInstance(this).addPenyakit(new Penyakit("P02", "Penyakit Berak Diare", "kasih makan"));
            SQLiteHelper.getInstance(this).addPenyakit(new Penyakit("P03", "Penyakit Berak Kapur", "kasih makanan 2"));
            SQLiteHelper.getInstance(this).addPenyakit(new Penyakit("P04", "Penyakit Nyilet Atau Kurus", "kasih obat gemuk"));
            SQLiteHelper.getInstance(this).addPenyakit(new Penyakit("P05", "Penyakit Egg Binding", "kasih sangkar luas"));
            SQLiteHelper.getInstance(this).addPenyakit(new Penyakit("P06", "Penyakit Bulu", "mandikan dengan shampo"));
            SQLiteHelper.getInstance(this).addPenyakit(new Penyakit("P07", "Penyakit Ganguan Pernafasan", "mata"));


            //table gejala
            SQLiteHelper.getInstance(this).addGejala(new Gejala("G01", "Mata mengeluarkan cairan"));
            SQLiteHelper.getInstance(this).addGejala(new Gejala("G02", "kelopak bagian mata membengkak"));
            SQLiteHelper.getInstance(this).addGejala(new Gejala("G03", "terlihat mengantuk mengantuk"));
            SQLiteHelper.getInstance(this).addGejala(new Gejala("G04", "kotoran cair"));
            SQLiteHelper.getInstance(this).addGejala(new Gejala("G05", "kotoran putih seperti kapur"));
            SQLiteHelper.getInstance(this).addGejala(new Gejala("G06", "kotoran seperti cacing"));
            SQLiteHelper.getInstance(this).addGejala(new Gejala("G07", "tulang dada tipis menonjol"));
            SQLiteHelper.getInstance(this).addGejala(new Gejala("G08", "perut terlihat membesar"));
            SQLiteHelper.getInstance(this).addGejala(new Gejala("G09", "pembengkakan kloaka atau anus"));
            SQLiteHelper.getInstance(this).addGejala(new Gejala("G10", "warna bulu terlihat rusak"));
            SQLiteHelper.getInstance(this).addGejala(new Gejala("G11", "bulu menggembang"));
            SQLiteHelper.getInstance(this).addGejala(new Gejala("G12", "hidung sering mengeluarkan cairan"));
            SQLiteHelper.getInstance(this).addGejala(new Gejala("G13", "kaki membengkak"));
            SQLiteHelper.getInstance(this).addGejala(new Gejala("G14", "nafas tersedat-sedat"));


            //isi table keputusan
            SQLiteHelper.getInstance(this).addKeputusan(new Keputusan("P01", "G2, G4, G11"));
            SQLiteHelper.getInstance(this).addKeputusan(new Keputusan("P02", "G4, G10"));
            SQLiteHelper.getInstance(this).addKeputusan(new Keputusan("P03", "G3, G5, G9"));
            SQLiteHelper.getInstance(this).addKeputusan(new Keputusan("P04", "G3, G6, G9"));
            SQLiteHelper.getInstance(this).addKeputusan(new Keputusan("P05", "G7, G8, G10"));
            SQLiteHelper.getInstance(this).addKeputusan(new Keputusan("P06", "G9, G10"));
            SQLiteHelper.getInstance(this).addKeputusan(new Keputusan("P07", "G3, G11, G14"));
            SQLiteHelper.getInstance(this).addKeputusan(new Keputusan("P08", "G10, G12"));

            SessionHelper.getInstance(this).setAppFirstTime(false);
        }


        //handler
        new Handler().postDelayed(new Runnable() {
                                      @Override
                                      public void run() {

                                          //setelah loading maka akan langsung berpindah ke home activity
                                          Intent home = new Intent(FlashScreen.this, Index.class);
                                          startActivity(home);
                                          finish();

                                      }
                                  },

                waktu_flash);

    }
}