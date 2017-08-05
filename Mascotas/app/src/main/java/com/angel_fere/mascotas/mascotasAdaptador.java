package com.angel_fere.mascotas;

import android.app.Activity;
import android.provider.ContactsContract;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.angel_fere.mascotas.db.ConstructorMascotas;

import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by Angel_Fere on 20/07/2017.
 */

public class mascotasAdaptador extends RecyclerView.Adapter<mascotasAdaptador.MascotasViewHolder> {

    ArrayList<Mascotas> mascotas;
    Activity activity;

    public mascotasAdaptador (ArrayList<Mascotas> mascotas, Activity activity){
        this.mascotas = mascotas;
        this.activity = activity;
    }


    @Override
    public MascotasViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascotas,parent,false);
        return new MascotasViewHolder(v);



    }


    @Override
    public void onBindViewHolder(final MascotasViewHolder mascotasViewHolder, int position) {
        final Mascotas m = mascotas.get(position);
        mascotasViewHolder.imgMascotas.setImageResource(m.getFoto());
        mascotasViewHolder.tvNombre.setText(m.getNombre());
        mascotasViewHolder.tvLikes.setText(String.valueOf(m.getLikes()));


      mascotasViewHolder.btnHuesito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int like;
                like = m.getLikes();
                m.setLikes(like+1);
                Toast.makeText(activity,"Like", Toast.LENGTH_SHORT ).show();
                ConstructorMascotas constructorMascotas = new ConstructorMascotas(activity);
                constructorMascotas.darLikeMascotas(m);
                mascotasViewHolder.tvLikes.setText(String.valueOf(m.getLikes()));

            }
        });


    }
    public int getItemCount(){
        return mascotas.size();
    }


    public static class MascotasViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgMascotas;
        private TextView  tvNombre;
        private TextView tvLikes;
        private ImageView btnHuesito;

        public MascotasViewHolder(View itemView) {
            super(itemView);

            imgMascotas = (ImageView)itemView.findViewById(R.id.imgMascota);
            tvNombre = (TextView) itemView.findViewById(R.id.tvNombre);
            tvLikes = (TextView) itemView.findViewById(R.id.tvLikes);
            btnHuesito = (ImageView)itemView.findViewById(R.id.btnHuesito);
        }
    }

}
