package com.immranderson.flexyrecycleradapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractBaseRecyclerAdapter extends RecyclerView.Adapter<FlexHolder> {

    private List<FlexState> pHolderDataList = new ArrayList<>();
    private Map<String, FlexState> holderDataTags = new HashMap<>();
    private Map<Integer, FlexState> holderDataRef = new HashMap<>();


    public void addViewData(@NonNull FlexState holderData) {

        pHolderDataList.add(holderData);
        holderDataRef.put(holderData.getType(), holderData);

    }

    public void addViewDataCollection(@NonNull Collection<? extends FlexState> holderData) {

        for (FlexState vhd : holderData) {

            pHolderDataList.add(vhd);
            holderDataRef.put(vhd.getType(), vhd);

        }

    }

    public void addViewDataAtPosition(@NonNull FlexState holderData, int position) {

        pHolderDataList.add(position, holderData);
        holderDataRef.put(holderData.getType(), holderData);

    }

    public List<FlexState> getViewDataList() {

        return pHolderDataList;

    }

    @Override
    public int getItemViewType(int position) {

        return pHolderDataList.get(position).getType();

    }

    @Override
    public FlexHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return holderDataRef.get(viewType).createViewHolder(parent);

    }

    @Override
    @SuppressWarnings("unchecked")
    public void onBindViewHolder(FlexHolder holder, int position) {

        holder.bindData(pHolderDataList.get(position));

    }

    @Override
    public int getItemCount() {

        return pHolderDataList.size();

    }
}