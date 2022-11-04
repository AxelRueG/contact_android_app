package com.example.mycontacts.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mycontacts.R;
import com.example.mycontacts.databinding.ItemContactListBinding;
import com.example.mycontacts.models.ContactModel;

import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ViewHolder> {

    private List<ContactModel> contacts;
    private Context context;

    public ContactAdapter(List<ContactModel> contacts, Context context) {
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
        ContactModel contact = contacts.get(position);
        holder.binding.contactName.setText(contact.name);
        holder.binding.contactNumber.setText(contact.number);
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ItemContactListBinding binding;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = ItemContactListBinding.bind(itemView);
        }
    }
}
