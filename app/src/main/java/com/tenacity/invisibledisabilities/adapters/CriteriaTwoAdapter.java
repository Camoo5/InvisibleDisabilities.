package com.tenacity.invisibledisabilities.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.tenacity.invisibledisabilities.data.CriteriaTwo;
import com.tenacity.invisibledisabilities.databinding.FragmentCriteriaTwoBinding;
import com.tenacity.invisibledisabilities.ui.gallery.CriteriaTwoFragmentDirections;


public class CriteriaTwoAdapter extends ListAdapter <com.tenacity.invisibledisabilities.data.CriteriaTwo, CriteriaTwoAdapter.ViewHolder> {

    public CriteriaTwoAdapter() {
        super ( new CriteriaTwoDiffCallback ());
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder ( FragmentCriteriaTwoBinding.inflate (
                LayoutInflater.from ( parent.getContext () ), parent, false ) );
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        com.tenacity.invisibledisabilities.data.CriteriaTwo criteriaTwo = getItem ( position );
        holder.bind ( createOnClickListener ( criteriaTwo.getCriteriatwoId () ), criteriaTwo );
        holder.itemView.setTag ( criteriaTwo);
    }

    private View.OnClickListener createOnClickListener(String criteriatwoId) {
        return v -> Navigation.findNavController ( v ).navigate (
                CriteriaTwoFragmentDirections.criteriaTwoFragmentToSubConsiderationsFragment (criteriatwoId ) );
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private final FragmentCriteriaTwoBinding binding;

        ViewHolder(@NonNull FragmentCriteriaTwoBinding binding) {
            super ( binding.getRoot () );
            this.binding = binding;
        }

        void bind(View.OnClickListener listener,   com.tenacity.invisibledisabilities.data.CriteriaTwo item ) {
            binding.setClickListener(listener);
            binding.setCriteriatwo ( item );
            binding.executePendingBindings();
        }
    }

    static class CriteriaTwoDiffCallback extends DiffUtil.ItemCallback<CriteriaTwo> {

        @Override
        public boolean areItemsTheSame(@NonNull CriteriaTwo oldItem, @NonNull CriteriaTwo newItem) {
            return oldItem.getCriteriatwoId ().equals(newItem.getCriteriatwoId ());
        }


        @Override
        public boolean areContentsTheSame(@NonNull CriteriaTwo oldItem, @NonNull CriteriaTwo newItem) {
            return oldItem.equals ( newItem );
        }
    }
}

