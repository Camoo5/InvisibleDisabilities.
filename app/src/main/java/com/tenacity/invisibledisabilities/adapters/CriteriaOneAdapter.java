package com.tenacity.invisibledisabilities.adapters;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.tenacity.invisibledisabilities.databinding.FragmentCriteriaOneBinding;
import com.tenacity.invisibledisabilities.ui.gallery.CriteriaOneFragmentDirections;


public class CriteriaOneAdapter extends ListAdapter <com.tenacity.invisibledisabilities.data.CriteriaOne, CriteriaOneAdapter.ViewHolder> {

    public CriteriaOneAdapter() {
        super ( new CriteriaOneDiffCallback ());
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder ( FragmentCriteriaOneBinding.inflate (
                LayoutInflater.from ( parent.getContext () ), parent, false ) );
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        com.tenacity.invisibledisabilities.data.CriteriaOne criteriaOne = getItem ( position );
        holder.bind ( createOnClickListener ( criteriaOne.getCriteriaoneId () ), criteriaOne );
        holder.itemView.setTag ( criteriaOne );
    }

    private View.OnClickListener createOnClickListener(String criteriaoneId) {
        return v -> Navigation.findNavController ( v ).navigate (
                CriteriaOneFragmentDirections.criteriaOneFragmentToCriteriaTwoFragment  (criteriaoneId ) );
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private final FragmentCriteriaOneBinding binding;

        ViewHolder(@NonNull FragmentCriteriaOneBinding binding) {
            super ( binding.getRoot () );
            this.binding = binding;
        }

        void bind(View.OnClickListener listener,   com.tenacity.invisibledisabilities.data.CriteriaOne item ) {
            binding.setClickListener(listener);
            binding.setCriteriaone ( item );
            binding.executePendingBindings();
        }
    }

    static class CriteriaOneDiffCallback extends DiffUtil.ItemCallback<com.tenacity.invisibledisabilities.data.CriteriaOne> {

        @Override
        public boolean areItemsTheSame(@NonNull com.tenacity.invisibledisabilities.data.CriteriaOne oldItem, @NonNull com.tenacity.invisibledisabilities.data.CriteriaOne newItem) {
            return oldItem.getCriteriaoneId ().equals(newItem.getCriteriaoneId ());
        }

        @SuppressLint("DiffUtilEquals")
        @Override
        public boolean areContentsTheSame(@NonNull com.tenacity.invisibledisabilities.data.CriteriaOne oldItem, @NonNull com.tenacity.invisibledisabilities.data.CriteriaOne newItem) {
            return oldItem == newItem;
        }
    }
}
