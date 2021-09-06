package com.example.fragment_you3_unit3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class FragmentAdapter extends RecyclerView.Adapter<FragmentViewHolder> {
    private List<ResponseModel> postModelList;
    public FragmentAdapter(List<ResponseModel> postModelList){
        this.postModelList = postModelList;
    }

    @NonNull
    @Override
    public FragmentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new FragmentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FragmentViewHolder holder, int position) {
        ResponseModel responseModel = postModelList.get(position);
        holder.setData(responseModel);

    }

    @Override
    public int getItemCount() {
        return postModelList.size();
    }
}
