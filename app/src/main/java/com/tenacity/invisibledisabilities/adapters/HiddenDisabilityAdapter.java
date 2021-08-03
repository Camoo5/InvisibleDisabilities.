
package com.tenacity.invisibledisabilities.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.tenacity.invisibledisabilities.R;
import com.tenacity.invisibledisabilities.data.DisabilityAndHiddenDisabilities;
import com.tenacity.invisibledisabilities.ui.gallery.HiddenDisabilityFragmentDirections;
import com.tenacity.invisibledisabilities.ui.viewmodels.DisabilityAndHiddenDisabilitiesViewModel;
import com.tenacity.invisibledisabilities.databinding.ListItemHiddenDisabilityBinding;

import java.util.Objects;


public class HiddenDisabilityAdapter extends ListAdapter<DisabilityAndHiddenDisabilities, HiddenDisabilityAdapter.ViewHolder> {

    public HiddenDisabilityAdapter() {
        super ( new HiddenDisabilityDiffCallback () );
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder ( DataBindingUtil.inflate (
                LayoutInflater.from ( parent.getContext () ),
                R.layout.list_item_hidden_disability, parent, false ) );
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        DisabilityAndHiddenDisabilities hiddenDisabilities = getItem ( position );
        holder.itemView.setTag ( hiddenDisabilities );
        holder.bind ( createOnClickListener ( hiddenDisabilities.getDisability ().getDisabilityId () ), hiddenDisabilities );
    }

    private View.OnClickListener createOnClickListener(String disabilityId) {
        return v -> Navigation.findNavController ( v ).navigate (
                HiddenDisabilityFragmentDirections.actionHiddenDisabilityFragmentToDisabilityDetailFragment ( disabilityId ) );
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private final ListItemHiddenDisabilityBinding binding;


        public ViewHolder(@NonNull ListItemHiddenDisabilityBinding binding) {
            super ( binding.getRoot () );
            this.binding = binding;
        }

        void bind(View.OnClickListener listener, DisabilityAndHiddenDisabilities disabilities) {
            this.binding.setClickListener ( listener );
            this.binding.setViewModel ( new DisabilityAndHiddenDisabilitiesViewModel ( disabilities ) );
            this.binding.executePendingBindings ();

        }
    }

    static class HiddenDisabilityDiffCallback extends DiffUtil.ItemCallback <DisabilityAndHiddenDisabilities> {

        @Override
        public boolean areItemsTheSame(@NonNull DisabilityAndHiddenDisabilities oldItem,
                                       @NonNull DisabilityAndHiddenDisabilities newItem) {
            return oldItem.getDisability ().getDisabilityId ().equals ( newItem.getDisability ().getDisabilityId () );
        }

        @Override
        public boolean areContentsTheSame(@NonNull DisabilityAndHiddenDisabilities oldItem,
                                          @NonNull DisabilityAndHiddenDisabilities newItem) {
            return Objects.equals ( oldItem, newItem );
        }
    }

}
