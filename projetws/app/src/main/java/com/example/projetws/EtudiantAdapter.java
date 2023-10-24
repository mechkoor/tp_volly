package com.example.projetws;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.projetws.beans.Etudiant;

import java.util.List;



public class EtudiantAdapter extends ArrayAdapter<Etudiant> {

    private static class ViewHolder {
        TextView id;
        TextView nom;

        TextView ville;
        TextView sexe;
        ImageView image;
    }

    public EtudiantAdapter(@NonNull Context context, int resource, @NonNull List<Etudiant> etudiants) {
        super(context, resource, etudiants);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder holder;
        View item = convertView;

        if (item == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            item = inflater.inflate(R.layout.item, parent, false);

            holder = new ViewHolder();
            holder.id = item.findViewById(R.id.id);
            holder.nom = item.findViewById(R.id.nom);
            holder.image=item.findViewById(R.id.p1);

            holder.ville = item.findViewById(R.id.ville);
            holder.sexe = item.findViewById(R.id.sexe);

            item.setTag(holder);
        } else {
            holder = (ViewHolder) item.getTag();
        }

        Etudiant st = getItem(position);
        if (st != null) {
            holder.id.setText(String.valueOf(st.getId()));
            holder.nom.setText(st.getNom()+" "+st.getPrenom());
            holder.ville.setText(st.getVille());
            holder.sexe.setText(st.getSexe());

        }

        return item;
    }

}