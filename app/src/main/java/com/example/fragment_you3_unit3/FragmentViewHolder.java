package com.example.fragment_you3_unit3;

import android.media.Image;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

public class FragmentViewHolder extends RecyclerView.ViewHolder {
    private TextView tvName;
    private TextView tvLogin;
    private ImageView img;
    public FragmentViewHolder(@NonNull View itemView) {
        super(itemView);
        initView(itemView);
    }

    private void initView(View itemView) {
        tvName = itemView.findViewById(R.id.Name);
       tvLogin = itemView.findViewById(R.id.Login);
       img = itemView.findViewById(R.id.img);
    }
    public void setData(ResponseModel responseModel){
        tvName.setText(responseModel.getName());
        tvLogin.setText(responseModel.getOwner().getLogin());

      //  img.setImageResource(responseModel.);
        if(responseModel.getOwner().getAvatarUrl()!=null){
            Glide.with(img).load(responseModel.getOwner().getAvatarUrl()).into(img);
        }

    }
}
