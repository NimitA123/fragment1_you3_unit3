package com.example.fragment_you3_unit3;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class BlankFragment extends Fragment {
    private RecyclerView recyclerView;
    private TextView tvName;
    private TextView tvLogin;
    private ImageView img;
    private Button btnCallApi;
    private EditText SearchBox;
    private List<ResponseModel> postModelList;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        buildData();
    }
    private void buildData() {

    }

    private void initView(View view) {
        recyclerView = view.findViewById(R.id.rvRecycleView);

        SearchBox = view.findViewById(R.id.SearchBox);
        btnCallApi  = view.findViewById(R.id.btnCallApi);
        btnCallApi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callApi();
            }
        });
    }

    private void callApi() {
        ApiService apiService = Network.getInstance().create(ApiService.class);
        String  postId = SearchBox.getText().toString();
        apiService.getUser(postId).enqueue(new Callback<List<ResponseModel>>() {
            @Override
            public void onResponse(Call<List<ResponseModel>> call, Response<List<ResponseModel>> response) {
                if(response.body()!=null){
                    postModelList = response.body();
                    Toast.makeText(getContext(), "We are Pass", Toast.LENGTH_LONG).show();
                    setRecycleView();
                }

            }

            @Override
            public void onFailure(Call<List<ResponseModel>> call, Throwable t) {
                Toast.makeText(getContext(), "We are failed", Toast.LENGTH_LONG).show();

            }
        });

    }

    private void setRecycleView() {
        FragmentAdapter postAdapter = new FragmentAdapter(postModelList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setAdapter(postAdapter);
        recyclerView.setLayoutManager(linearLayoutManager);
    }
}