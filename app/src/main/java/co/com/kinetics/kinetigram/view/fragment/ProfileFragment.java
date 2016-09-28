package co.com.kinetics.kinetigram.view.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import co.com.kinetics.kinetigram.R;
import co.com.kinetics.kinetigram.adaptaer.PictureAdapterRecyclerView;
import co.com.kinetics.kinetigram.model.Picture;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {


    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        showToolbar("",false, view);
        RecyclerView picturesRecycler = (RecyclerView) view.findViewById(R.id.pictureProfileRecycler) ;

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        picturesRecycler.setLayoutManager(linearLayoutManager);


        PictureAdapterRecyclerView pictureAdapterRecyclerView =
                new PictureAdapterRecyclerView(buidPictures(), R.layout.cardview_picture, getActivity());
        picturesRecycler.setAdapter(pictureAdapterRecyclerView);
        return view;
    }

    public ArrayList<Picture> buidPictures(){
        ArrayList<Picture> pictures = new ArrayList<>();
        pictures.add(new Picture("http://s17.postimg.org/fsz98d9wv/screenshot.jpg", "Jonathan Salazar", "4 días", "3 Me gusta" ));
        pictures.add(new Picture("http://s15.postimg.org/saufueziz/10956598_335372623335541_1580263147_n.jpg", "Andrés Toro", "2 días", "10 Me gusta"));
        pictures.add(new Picture("http://s10.postimg.org/r7zjmhs0p/10895301_388316724626799_745164202_n.jpg", "Ricardo Butrago", "1 días", "25 Me gusta"));
        return pictures;
    }

    public void showToolbar(String tittle, boolean upButton, View view){
        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(tittle);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);
    }

}
