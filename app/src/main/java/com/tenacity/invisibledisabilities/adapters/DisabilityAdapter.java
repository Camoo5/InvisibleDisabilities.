package com.tenacity.invisibledisabilities.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.tenacity.invisibledisabilities.R;
import com.tenacity.invisibledisabilities.data.Disability;
import com.tenacity.invisibledisabilities.databinding.ListItemDisabilityBinding;
import com.tenacity.invisibledisabilities.ui.gallery.DisabilityListFragmentDirections;

import java.util.List;

public class DisabilityAdapter extends RecyclerView.Adapter<DisabilityAdapter.ViewHolder>{
    private final List<Disability> disabilityList;
    private LayoutInflater layoutInflater;

    public DisabilityAdapter(List<Disability> disabilities) {
       disabilityList = disabilities;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(parent.getContext());
        }
        ListItemDisabilityBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.list_item_disability, parent, false);
        return new ViewHolder ( binding );
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
       Disability disability = disabilityList.get(position);
        holder.bind(disability, createClickListener(disability.getDisabilityId()));
    }

    private View.OnClickListener createClickListener(String disabilityId) {
        return view -> {
            DisabilityListFragmentDirections.ActionDisabilityListFragmentToDisabilityDetailFragment direction =
                    DisabilityListFragmentDirections.actionDisabilityListFragmentToDisabilityDetailFragment(disabilityId);
            Navigation.findNavController(view).navigate(direction);

        };
    }

    @Override
    public int getItemCount() {
        return disabilityList.size();
    }

    public void updateItems(List<Disability> disabilities) {
        final DisabilityDiffCallback diffCallback = new DisabilityDiffCallback(this.disabilityList, disabilities);
        final DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(diffCallback);

        disabilityList.clear();
        disabilityList.addAll(disabilities);
        diffResult.dispatchUpdatesTo(this);
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        ListItemDisabilityBinding binding;

        ViewHolder(@NonNull ListItemDisabilityBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bind(Disability disability, View.OnClickListener clickListener) {
            binding.setClickListener(clickListener);
            binding.setDisability(disability);
            binding.executePendingBindings();
        }
    }
}
