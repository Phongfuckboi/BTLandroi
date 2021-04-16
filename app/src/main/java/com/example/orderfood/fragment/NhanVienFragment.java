package com.example.orderfood.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.orderfood.MainActivity;
import com.example.orderfood.R;


public class NhanVienFragment extends Fragment {



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_nhanvien, container, false);
        ((MainActivity)getActivity()).getSupportActionBar().setTitle("Nhân viên");
        return root;
    }
}