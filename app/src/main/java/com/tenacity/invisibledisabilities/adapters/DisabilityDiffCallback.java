package com.tenacity.invisibledisabilities.adapters;

import androidx.recyclerview.widget.DiffUtil;

import com.tenacity.invisibledisabilities.data.Disability;

import java.util.List;

public class DisabilityDiffCallback extends DiffUtil.Callback {

    private final List<Disability> oldList;
    private final List<Disability> newList;

    public DisabilityDiffCallback(List<Disability> oldList, List<Disability> newList) {
        this.oldList = oldList;
        this.newList = newList;
    }


    @Override
    public int getOldListSize() {
        return this.oldList.size();
    }

    @Override
    public int getNewListSize() {
        return this.newList.size();
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        Disability oldPlant = oldList.get(oldItemPosition);
       Disability newPlant = newList.get(newItemPosition);
        return oldPlant.getDisabilityId () == newPlant.getDisabilityId();
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        Disability oldPlant = oldList.get(oldItemPosition);
       Disability newPlant = newList.get(newItemPosition);
        return oldPlant.equals(newPlant);
    }

}
