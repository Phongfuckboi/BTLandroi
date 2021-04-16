package com.example.orderfood.CustumAdapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.FragmentManager;

import com.example.orderfood.DAO.bananDAO;
import com.example.orderfood.DAO.chitethoadonDAO;
import com.example.orderfood.DAO.thucdonDAO;
import com.example.orderfood.DTO.bananDTO;
import com.example.orderfood.DTO.thucdonDTO;
import com.example.orderfood.MainActivity;
import com.example.orderfood.R;

import java.util.List;

public class AdapterHienThiBanAn extends BaseAdapter implements  View.OnClickListener{



    private final Context context;
    private final int layout;
    private Viewholder viewhoder;
    private final List<bananDTO> banAnDTOList;

    private final bananDAO bananDAO;
    private  final chitethoadonDAO chitethoadonDAO;
    private final thucdonDAO thucdonDAO;

    private final FragmentManager fragmentManager;


//    private ViewHolderBanAn viewHolderBanAn;

    public AdapterHienThiBanAn(Context context, int layout, List<bananDTO> banAnDTOList, com.example.orderfood.DAO.bananDAO bananDAO, com.example.orderfood.DAO.chitethoadonDAO chitethoadonDAO, com.example.orderfood.DAO.thucdonDAO thucdonDAO, FragmentManager fragmentManager) {
        this.context = context;
        this.layout = layout;
        this.banAnDTOList = banAnDTOList;
        this.bananDAO =new  bananDAO(context);
        this.chitethoadonDAO = new chitethoadonDAO(context);
        this.thucdonDAO = new thucdonDAO(context);
        this.fragmentManager = ((MainActivity)context).getSupportFragmentManager();
    }

    @Override
    public int getCount() {
        return banAnDTOList.size();
    }

    @Override
    public Object getItem(int position) {
        return banAnDTOList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return banAnDTOList.get(position).getIdban();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        View view=convertView;
        if(view==null)
        {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            viewhoder = new Viewholder();
            view = inflater.inflate(R.layout.custom_lauout_banan, parent, false);
            viewhoder.imBanAn = view.findViewById(R.id.imBanAn);
            viewhoder.imGoiMon = view.findViewById(R.id.imGoiMon);
            viewhoder.imThanhToan = view.findViewById(R.id.imThanhToan);
            viewhoder.imAnButton = view.findViewById(R.id.imAnButton);
            viewhoder.txtTenBanAn = view.findViewById(R.id.txtTenBanAn);

            view.setTag(view);
        }

        else {
            viewhoder= (Viewholder) view.getTag();
        }
        //lấy tất cả thuộc tính đc chọn có bằng true hay không
        if (banAnDTOList.get(position).isDuocChon())
            HienThiButton();
        else
            AnButton(false);
        // position tương ứng với mỗi giá trị khi gridview tạo ra
        bananDTO banAnDTO = banAnDTOList.get(position);

        String kttinhtrang = bananDAO.LayTinhTrangBan(banAnDTO.getIdban());
        if (kttinhtrang.equals("true"))
            viewhoder.imBanAn.setImageResource(R.drawable.ic_sharp_fastfood_24);
        else
            viewhoder.imBanAn.setImageResource(R.drawable.ic_baseline_monetization_on_24);

        viewhoder.txtTenBanAn.setText(banAnDTO.getTenban());
        viewhoder.imBanAn.setTag(position);

        viewhoder.imBanAn.setOnClickListener(this);
        viewhoder.imGoiMon.setOnClickListener(this);
        viewhoder.imThanhToan.setOnClickListener(this);
        viewhoder.imAnButton.setOnClickListener(this);

        return view;
    }
    @SuppressLint({"NonConstantResourceId", "SimpleDateFormat"})
    @Override
    public void onClick(View v) {
        int id=v.getId();
        int idban=banAnDTOList.get((int)viewhoder.imBanAn.getTag()).getIdban();
        viewhoder=(Viewholder)  ((View)v.getParent()).getTag();
        switch (id) {
            case R.id.imBanAn:
                banAnDTOList.get((int) v.getTag()).setDuocChon(true);
                HienThiButton();
                break;
            case R.id.imGoiMon:
                break;
        }



        }

    public class Viewholder
    {
        ImageView imBanAn, imGoiMon, imThanhToan, imAnButton;
        TextView txtTenBanAn;
    }
    private void HienThiButton(){
        viewhoder.imGoiMon.setVisibility(View.VISIBLE);
        viewhoder.imThanhToan.setVisibility(View.VISIBLE);
        viewhoder.imAnButton.setVisibility(View.VISIBLE);

        Animation animation = AnimationUtils.loadAnimation(context, R.anim.hieuung_hienthi_button_banan);
        viewhoder.imGoiMon.startAnimation(animation);
        viewhoder.imThanhToan.startAnimation(animation);
        viewhoder.imAnButton.startAnimation(animation);
    }
    private void AnButton(boolean hieuung){
        if (hieuung){
            Animation animation = AnimationUtils.loadAnimation(context, R.anim.hieuung_anbutton_banan);
            viewhoder.imGoiMon.startAnimation(animation);
            viewhoder.imThanhToan.startAnimation(animation);
            viewhoder.imAnButton.startAnimation(animation);
        }

        viewhoder.imGoiMon.setVisibility(View.INVISIBLE);
        viewhoder.imThanhToan.setVisibility(View.INVISIBLE);
        viewhoder.imAnButton.setVisibility(View.INVISIBLE);
    }

}
