package com.example.mycontacts.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mycontacts.R;
import com.example.mycontacts.config.Operations;
import com.example.mycontacts.databinding.ItemContactListBinding;
import com.example.mycontacts.models.Contact;
import com.example.mycontacts.views.FormContact;

import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ViewHolder> {

    private List<Contact> contacts;
    private Context context;

    public ContactAdapter(List<Contact> contacts, Context context) {
        this.contacts = contacts;
        this.context = context;
    }

    @NonNull
    @Override
    public ContactAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_contact_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactAdapter.ViewHolder holder, int position) {
        Contact contact = contacts.get(position);
        holder.binding.contactName.setText(contact.name);
        holder.binding.contactNumber.setText(contact.number);
        holder.binding.contactEmail.setText(contact.email);
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public ItemContactListBinding binding;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = ItemContactListBinding.bind(itemView);
            binding.getRoot().setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int position = this.getAdapterPosition();
            Intent intent = new Intent(view.getContext(), FormContact.class);
            intent.putExtra("operation", Operations.UPDATE);
            intent.putExtra("id",contacts.get(position).id);
            view.getContext().startActivity(intent);
        }
    }
}
