package com.huynhnha.fashionapp.fagment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.huynhnha.fashionapp.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ShopFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ShopFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ShopFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ShopFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ShopFragment newInstance(String param1, String param2) {
        ShopFragment fragment = new ShopFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_shop, container, false);

        // Bắt sự kiện click cho nút quay lại
        View imgBack = view.findViewById(R.id.imgBack);
        if (imgBack != null) {
            imgBack.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    requireActivity().getSupportFragmentManager().popBackStack();
                }
            });
        }

        // Lưu lại view để sử dụng trong updateProductDetailUI
        this.rootView = view;
        updateProductDetailUI();

        // Thêm chức năng thêm vào giỏ hàng
        android.widget.Button btnAddToCart = view.findViewById(R.id.btnAddToCart);
        btnAddToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                android.content.SharedPreferences detailPrefs = requireContext().getSharedPreferences("shop_detail", android.content.Context.MODE_PRIVATE);
                String tenSanPham = detailPrefs.getString("tenSanPham", "NIke Sneakers");
                String moTa = detailPrefs.getString("moTa", "Vision Alta Men’s Shoes Size (All Colours)");
                String gia = detailPrefs.getString("gia", "200.000 đ");
                String hinh = detailPrefs.getString("hinh", "zntrt");
                String item = tenSanPham + "|" + moTa + "|" + gia + "|" + hinh;

                android.content.SharedPreferences prefs = requireContext().getSharedPreferences("cart", android.content.Context.MODE_PRIVATE);
                java.util.Set<String> cart = new java.util.HashSet<>(prefs.getStringSet("cart_items", new java.util.HashSet<>()));
                cart.add(item);
                prefs.edit().putStringSet("cart_items", cart).apply();

                android.widget.Toast.makeText(getContext(), "Đã thêm vào giỏ hàng!", android.widget.Toast.LENGTH_SHORT).show();

                // Sau khi thêm, nếu SearchFragment đang hiển thị thì cập nhật UI ngay
                androidx.fragment.app.FragmentManager fm = requireActivity().getSupportFragmentManager();
                java.util.List<androidx.fragment.app.Fragment> fragments = fm.getFragments();
                for (androidx.fragment.app.Fragment fragment : fragments) {
                    if (fragment instanceof com.huynhnha.fashionapp.fagment.SearchFragment) {
                        if (fragment.isVisible() && fragment instanceof CartUpdateListener) {
                            ((CartUpdateListener) fragment).onCartUpdated();
                        }
                    }
                }
            }
        });
        return view;
    }

    private View rootView;

    @Override
    public void onResume() {
        super.onResume();
        updateProductDetailUI();
    }

    private void updateProductDetailUI() {
        if (rootView == null) return;
        android.content.SharedPreferences detailPrefs = requireContext().getSharedPreferences("shop_detail", android.content.Context.MODE_PRIVATE);
        String tenSanPham = detailPrefs.getString("tenSanPham", "NIke Sneakers");
        String moTa = detailPrefs.getString("moTa", "Vision Alta Men’s Shoes Size (All Colours)");
        String gia = detailPrefs.getString("gia", "200.000 đ");
        String hinh = detailPrefs.getString("hinh", "zntrt");

        android.widget.TextView tvTen = rootView.findViewById(R.id.tvTenSanPham);
        android.widget.TextView tvMoTa = rootView.findViewById(R.id.tvMoTaSanPham);
        android.widget.TextView tvGia = rootView.findViewById(R.id.tvGiaSanPham);
        android.widget.ImageView imgSanPham = rootView.findViewById(R.id.imgSanPham);
        if (tvTen != null) tvTen.setText(tenSanPham);
        if (tvMoTa != null) tvMoTa.setText(moTa);
        if (tvGia != null) tvGia.setText(gia);
        if (imgSanPham != null) {
            if (hinh != null && (hinh.startsWith("http://") || hinh.startsWith("https://"))) {
                // Nếu là link ảnh, dùng Glide
                com.bumptech.glide.Glide.with(requireContext()).load(hinh).into(imgSanPham);
            } else {
                int imgRes = getResources().getIdentifier(hinh, "drawable", requireContext().getPackageName());
                if (imgRes != 0) imgSanPham.setImageResource(imgRes);
                else imgSanPham.setImageResource(android.R.drawable.ic_menu_gallery);
            }
        }
    }

}