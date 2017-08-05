package com.angel_fere.mascotas.presentador;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import com.angel_fere.mascotas.IRecyclerViewFragmentView;
import com.angel_fere.mascotas.Mascotas;
import com.angel_fere.mascotas.db.ConstructorMascotas;
import com.angel_fere.mascotas.mascotasAdaptador;

import java.util.ArrayList;

/**
 * Created by Angel_Fere on 02/08/2017.
 */

public class RecyclerViewFragmentPresenter implements IRecyclerViewFragmentPresenter {

    private IRecyclerViewFragmentView iRecyclerViewFragmentView;
    private Context context;
    private ConstructorMascotas constructorMascotas;
    private ArrayList<Mascotas> mascotas;



    public RecyclerViewFragmentPresenter(IRecyclerViewFragmentView iRecyclerViewFragmentView, Context context){
        this.iRecyclerViewFragmentView = iRecyclerViewFragmentView;
        this.context = context;
        obtenerMascotasBaseDatos();
    }

    @Override
    public void obtenerMascotasBaseDatos() {
        constructorMascotas =  new ConstructorMascotas(context);
        mascotas =constructorMascotas.obtenerDatos();
        mostrarMascotasRV();
    }

    @Override
    public void mostrarMascotasRV() {
        iRecyclerViewFragmentView.inicializarAdaptadorRV(iRecyclerViewFragmentView.crearAdaptador(mascotas));
        iRecyclerViewFragmentView.generarLinearLayoutVertical();
    }
}
