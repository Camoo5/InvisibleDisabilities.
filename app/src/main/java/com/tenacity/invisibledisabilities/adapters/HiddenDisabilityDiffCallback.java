package com.tenacity.invisibledisabilities.adapters;

import androidx.recyclerview.widget.DiffUtil;

import com.tenacity.invisibledisabilities.data.DisabilityAndHiddenDisabilities;

import java.util.List;

public class HiddenDisabilityDiffCallback extends DiffUtil.Callback {

    private List<DisabilityAndHiddenDisabilities> oldList;
    private List<DisabilityAndHiddenDisabilities> newList;

    public HiddenDisabilityDiffCallback(List<DisabilityAndHiddenDisabilities> oldList, List<DisabilityAndHiddenDisabilities> newList) {
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
        DisabilityAndHiddenDisabilities oldDisability = oldList.get(oldItemPosition);
        DisabilityAndHiddenDisabilities newDisability = newList.get(newItemPosition);
        return oldDisability.getDisability().getDisabilityId() == newDisability.getDisability().getDisabilityId();
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        DisabilityAndHiddenDisabilities oldDisability= oldList.get(oldItemPosition);
        DisabilityAndHiddenDisabilities newDisability = newList.get(newItemPosition);
        return oldDisability.equals(newDisability);
    }


}
