package com.tenacity.invisibledisabilities.adapters;

import android.location.Criteria;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.tenacity.invisibledisabilities.data.Criterias;
import com.tenacity.invisibledisabilities.databinding.ListItemCriteriasBinding;

public class CriteriasAdapter extends ListAdapter <Criterias, CriteriasAdapter.ViewHolder> {

<Criterias {

        @Override
        public boolean areItemsTheSame(@NonNull Criteria soldItem, @NonNull    Criterias newItem) {
            return oldItem.getCriteriasId ().equals(newItem.getCriteriasId());
        }

        @Override
        public boolean areContentsTheSame(@NonNull Criterias oldItem, @NonNull    Criterias newItem) {
            return oldItem.equals ( newItem );
        }
    }

    public CriteriasAdapter() {
        super ( new CriteriasDiffCallback () );
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder ( ListItemCriteriasBinding.inflate (
                LayoutInflater.from ( parent.getContext () ), parent, false ) );
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Criterias criterias = getItem ( position );
        holder.bind ( createOnClickListener ( criterias.getCriteriasId () ), criterias );
        holder.itemView.setTag ( criterias );
    }

    private View.OnClickListener createOnClickListener(String criterias Id) {
        return v -> Navigation.findNavController ( v ).navigate (
                CriteriasFragmentDirections.actionDisabilityListFragmentToDisabilitytDetailFragment ( criteriasId ) );
    }

        static class ViewHolder extends RecyclerView.ViewHolder {
        private final ListItemCriteriasBinding binding;

        ViewHolder(@NonNull ListItemCriteriasBinding binding) {
            super ( binding.getRoot () );
            this.binding = binding;
        }

        void bind(View.OnClickListener listener, Criterias item) {
            binding.setClickListener ( listener );
            binding.setCriterias ( item );
            binding.executePendingBindings ();
        }
    }
static class CriteriasDiffCallback extends Item Callback




}


