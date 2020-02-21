package f_mendez07.blogspot.com.ciclodevida;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class ContactoAdapter extends RecyclerView.Adapter<ContactoAdapter.ContactoViewHolder> {

    ArrayList<Contacto> contactos;
    Activity activity;

    public ContactoAdapter(ArrayList<Contacto>contactos, Activity activity){
        this.contactos = contactos;
        this.activity = activity;
    }

    //infla el layout y lo pasa el viewholder para que el obtenga cada elemento de tipo view
    @NonNull
    @Override
    public ContactoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //inflamos la vista desde el xml
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_contacto,parent,false);
        return new ContactoViewHolder(v);
    }

    //asocia cada alemento de la lista con cada view y se personaliza
    @Override
    public void onBindViewHolder(@NonNull final ContactoViewHolder holder, final int position) {
        final Contacto contacto = contactos.get(position);
        holder.imgFotoCv.setImageResource(contacto.getFoto());
        holder.tvNombreCv.setText(contacto.getNombre());
        holder.tvTelefonoCv.setText(contacto.getTelefono());
        holder.tvEmailCv.setText(contacto.getEmail());

        holder.imgFotoCv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity,contacto.getNombre(),Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(activity,DetallesContacto.class);
                intent.putExtra(activity.getResources().getString(R.string.pFoto),contacto.getFoto());
                intent.putExtra(activity.getResources().getString(R.string.pNombre),contacto.getNombre());
                intent.putExtra(activity.getResources().getString(R.string.pTelefono),contacto.getTelefono());
                intent.putExtra(activity.getResources().getString(R.string.pEmail),contacto.getEmail());
                activity.startActivity(intent);
            }
        });



    }

    @Override
    public int getItemCount() { //cantidad de elementos que contiene mi lista
        return contactos.size();
    }

    //clase anidada viewHolder
    public static class ContactoViewHolder extends RecyclerView.ViewHolder{
        //declaramos todas las vistas de mi cardView
        private ImageView imgFotoCv;
        private TextView tvNombreCv;
        private TextView tvTelefonoCv;
        private TextView tvEmailCv;

        public ContactoViewHolder(@NonNull View itemView) {
            super(itemView);
            //asociamos el objeto con su respectivo view
            imgFotoCv    = itemView.findViewById(R.id.imgFotoCv);
            tvNombreCv   = itemView.findViewById(R.id.tvNombreCv);
            tvTelefonoCv = itemView.findViewById(R.id.tvTelefonoCv);
            tvEmailCv    = itemView.findViewById(R.id.tvEmailCv);
        }



    }

}
