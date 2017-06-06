package com.immranderson.flexyrecycleradapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractBaseRecyclerAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    private List<BaseHolderModel> pHolderDataList = new ArrayList<>();
    private Map<String, BaseHolderModel> holderDataTags = new HashMap<>();
    private Map<Integer, BaseHolderModel> holderDataRef = new HashMap<>();


    public void addViewData(@NonNull BaseHolderModel holderData) {

        pHolderDataList.add(holderData);
        holderDataRef.put(holderData.getType(), holderData);

    }

    public void addViewDataCollection(@NonNull Collection<? extends BaseHolderModel> holderData) {

        for (BaseHolderModel vhd : holderData) {

            pHolderDataList.add(vhd);
            holderDataRef.put(vhd.getType(), vhd);

        }

    }

    public void addViewDataAtPosition(@NonNull BaseHolderModel holderData, int position) {

        pHolderDataList.add(position, holderData);
        holderDataRef.put(holderData.getType(), holderData);

    }

    public List<BaseHolderModel> getViewDataList() {

        return pHolderDataList;

    }

    @Override
    public int getItemViewType(int position) {

        return pHolderDataList.get(position).getType();

    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return holderDataRef.get(viewType).createViewHolder(parent);

    }

    @Override
    @SuppressWarnings("unchecked")
    public void onBindViewHolder(BaseViewHolder holder, int position) {

        holder.bindData(pHolderDataList.get(position));

    }

    @Override
    public int getItemCount() {

        return pHolderDataList.size();

    }
}