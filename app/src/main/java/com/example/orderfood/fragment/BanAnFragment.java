package com.example.orderfood.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.orderfood.DAO.bananDAO;
import com.example.orderfood.DTO.bananDTO;
import com.example.orderfood.MainActivity;
import com.example.orderfood.R;
import com.example.orderfood.thembanactiv;

import java.util.List;


public class BanAnFragment extends Fragment {

    public static int RESQUEST_CODE_THEM = 111;
    public static int RESQUEST_CODE_SUA = 16;
    private GridView gvHienThiBanAn;
    private List<bananDTO> banAnDTOList;
    private bananDAO banAnDAO;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_banan, container, false);

        setHasOptionsMenu(true);


        ((MainActivity)getActivity()).getSupportActionBar().setTitle("Bàn ăn");
        gvHienThiBanAn = root.findViewById(R.id.gvHienBanAn);
        banAnDAO.LayTatCaBanAn();
        return root;
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);

        inflater.inflate(R.menu.option_menu_banan,menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.home_menu:
                Toast.makeText(getActivity(), "Click menu", Toast.LENGTH_SHORT).show();
                break;
            case R.id.them_ban:

                    Intent iThemBanAn = new Intent(getActivity(), thembanactiv.class);
                    startActivityForResult(iThemBanAn, RESQUEST_CODE_THEM);

        }
        return true;
    }
}

