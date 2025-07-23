package com.huynhnha.fashionapp.fagment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.huynhnha.fashionapp.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SearchFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SearchFragment extends Fragment implements CartUpdateListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SearchFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SearchFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SearchFragment newInstance(String param1, String param2) {
        SearchFragment fragment = new SearchFragment();
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

    private android.widget.LinearLayout cartListLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_search, container, false);
        cartListLayout = view.findViewById(R.id.cartListLayout);
        updateCartUI();
        android.widget.Button btnBuy = view.findViewById(R.id.btnBuy);
        btnBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Xoá sạch giỏ hàng
                android.content.SharedPreferences prefs = requireContext().getSharedPreferences("cart", android.content.Context.MODE_PRIVATE);
                prefs.edit().remove("cart_items").apply();
                updateCartUI();
                try {
                    android.content.Intent intent = new android.content.Intent(getActivity(), com.huynhnha.fashionapp.OrderSuccessActivity.class);
                    startActivity(intent);
                } catch (Exception e) {
                    android.widget.Toast.makeText(getContext(), "Mua hàng thành công!", android.widget.Toast.LENGTH_LONG).show();
                }
            }
        });

        // Đã loại bỏ nút xóa 2 sản phẩm mặc định, vì không còn sản phẩm mặc định trong giỏ hàng.
        return view;
    }

    @Override
    public void onCartUpdated() {
        if (cartListLayout != null) {
            updateCartUI();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        updateCartUI();
    }

    // Hàm cập nhật UI giỏ hàng, có thể gọi từ bên ngoài
    public void updateCartUI() {
        if (cartListLayout == null) return;
        android.content.SharedPreferences prefs = requireContext().getSharedPreferences("cart", android.content.Context.MODE_PRIVATE);
        java.util.Set<String> cart = prefs.getStringSet("cart_items", new java.util.HashSet<>());
        cartListLayout.removeAllViews();
        if (cart.size() == 0) {
            android.widget.TextView txtEmpty = new android.widget.TextView(getContext());
            txtEmpty.setText("Chưa có sản phẩm nào trong giỏ hàng.");
            txtEmpty.setTextColor(0xFF888888);
            txtEmpty.setTextSize(16);
            cartListLayout.addView(txtEmpty);
        } else {
            double tongTienTatCa = 0;
            for (String item : cart) {
                // Định dạng: tenSanPham|moTa|gia|hinh|soLuong
                String[] parts = item.split("\\|");
                String tenSanPham = parts.length > 0 ? parts[0] : "";
                String moTa = parts.length > 1 ? parts[1] : "";
                String gia = parts.length > 2 ? parts[2] : "";
                String hinh = parts.length > 3 ? parts[3] : "";
                int soLuong = 1;
                if (parts.length > 4) {
                    try { soLuong = Integer.parseInt(parts[4]); } catch (Exception ignore) {}
                }

                // Tạo CardView cho từng sản phẩm
                androidx.cardview.widget.CardView card = new androidx.cardview.widget.CardView(getContext());
                card.setCardElevation(6);
                card.setRadius(18);
                android.widget.LinearLayout.LayoutParams cardParams = new android.widget.LinearLayout.LayoutParams(
                        android.widget.LinearLayout.LayoutParams.MATCH_PARENT,
                        android.widget.LinearLayout.LayoutParams.WRAP_CONTENT);
                cardParams.setMargins(0, 0, 0, 20);
                card.setLayoutParams(cardParams);
                card.setUseCompatPadding(true);

                android.widget.LinearLayout row = new android.widget.LinearLayout(getContext());
                row.setOrientation(android.widget.LinearLayout.HORIZONTAL);
                row.setPadding(18, 18, 18, 18);
                row.setBackgroundColor(0xFFFFFFFF);

                int imgRes = getResources().getIdentifier(hinh, "drawable", requireContext().getPackageName());
                android.widget.ImageView img = new android.widget.ImageView(getContext());
                img.setImageResource(imgRes);
                android.widget.LinearLayout.LayoutParams imgParams = new android.widget.LinearLayout.LayoutParams(120, 120);
                imgParams.setMargins(0, 0, 18, 0);
                img.setLayoutParams(imgParams);
                img.setScaleType(android.widget.ImageView.ScaleType.CENTER_CROP);
                row.addView(img);

                android.widget.LinearLayout info = new android.widget.LinearLayout(getContext());
                info.setOrientation(android.widget.LinearLayout.VERTICAL);
                info.setLayoutParams(new android.widget.LinearLayout.LayoutParams(
                        android.widget.LinearLayout.LayoutParams.MATCH_PARENT,
                        android.widget.LinearLayout.LayoutParams.WRAP_CONTENT, 1f));

                android.widget.TextView tvName = new android.widget.TextView(getContext());
                tvName.setText(tenSanPham);
                tvName.setTypeface(null, android.graphics.Typeface.BOLD);
                tvName.setTextSize(15);
                tvName.setTextColor(0xFF222222);
                info.addView(tvName);

                android.widget.TextView tvDesc = new android.widget.TextView(getContext());
                tvDesc.setText(moTa);
                tvDesc.setTextSize(13);
                tvDesc.setTextColor(0xFF888888);
                info.addView(tvDesc);

                android.widget.TextView tvPrice = new android.widget.TextView(getContext());
                // Giá gốc
                double giaGoc = 0;
                try {
                    giaGoc = Double.parseDouble(gia.replaceAll("[^0-9.]", ""));
                } catch (Exception ignore) {}
                // Giá tổng
                double tongGia = giaGoc * soLuong;
                tvPrice.setText("Giá: " + gia + " x " + soLuong + " = " + String.format("%.0f đ", tongGia));
                tongTienTatCa += tongGia;
                tvPrice.setTextColor(0xFFC53232);
                tvPrice.setTextSize(15);
                info.addView(tvPrice);

                // Tăng giảm số lượng
                android.widget.LinearLayout qtyLayout = new android.widget.LinearLayout(getContext());
                qtyLayout.setOrientation(android.widget.LinearLayout.HORIZONTAL);
                qtyLayout.setPadding(0, 12, 0, 0);
                android.widget.Button btnMinus = new android.widget.Button(getContext());
                btnMinus.setText("-");
                btnMinus.setLayoutParams(new android.widget.LinearLayout.LayoutParams(90, 90));
                android.widget.TextView tvQty = new android.widget.TextView(getContext());
                tvQty.setText(String.valueOf(soLuong));
                tvQty.setTextSize(17);
                tvQty.setTextColor(0xFF333333);
                tvQty.setPadding(18,0,18,0);
                android.widget.Button btnPlus = new android.widget.Button(getContext());
                btnPlus.setText("+");
                btnPlus.setLayoutParams(new android.widget.LinearLayout.LayoutParams(90, 90));
                qtyLayout.addView(btnMinus);
                qtyLayout.addView(tvQty);
                qtyLayout.addView(btnPlus);
                info.addView(qtyLayout);

                // Sự kiện tăng giảm số lượng
                final int soLuongCopy = soLuong;
                btnMinus.setOnClickListener(new android.view.View.OnClickListener() {
                    @Override
                    public void onClick(android.view.View v) {
                        if (soLuongCopy > 1) {
                            capNhatSoLuongCart(item, soLuongCopy-1);
                        }
                    }
                });
                final int soLuongCopyPlus = soLuong;
                btnPlus.setOnClickListener(new android.view.View.OnClickListener() {
                    @Override
                    public void onClick(android.view.View v) {
                        capNhatSoLuongCart(item, soLuongCopyPlus+1);
                    }
                });

                row.addView(info);

                // Thêm nút XÓA
                android.widget.Button btnRemove = new android.widget.Button(getContext());
                btnRemove.setText("XÓA");
                btnRemove.setBackgroundColor(0xFFFA1010);
                btnRemove.setTextColor(0xFFFFFFFF);
                android.widget.LinearLayout.LayoutParams btnParams = new android.widget.LinearLayout.LayoutParams(
                        android.widget.LinearLayout.LayoutParams.WRAP_CONTENT,
                        android.widget.LinearLayout.LayoutParams.WRAP_CONTENT);
                btnParams.setMargins(18, 0, 0, 0);
                btnRemove.setLayoutParams(btnParams);
                row.addView(btnRemove);

                // Xử lý sự kiện xóa sản phẩm
                String itemKey = item;
                btnRemove.setOnClickListener(new android.view.View.OnClickListener() {
                    @Override
                    public void onClick(android.view.View v) {
                        android.content.SharedPreferences prefs = requireContext().getSharedPreferences("cart", android.content.Context.MODE_PRIVATE);
                        java.util.Set<String> cart = new java.util.HashSet<>(prefs.getStringSet("cart_items", new java.util.HashSet<String>()));
                        cart.remove(itemKey);
                        prefs.edit().putStringSet("cart_items", cart).apply();
                        updateCartUI();
                    }
                });

                card.addView(row);
                cartListLayout.addView(card);
            }
            // Hiển thị tổng tiền dưới cùng
            android.widget.TextView tvTongTien = new android.widget.TextView(getContext());
            tvTongTien.setText("Tổng tiền: " + String.format("%.0f đ", tongTienTatCa));
            tvTongTien.setTextColor(0xFF222222);
            tvTongTien.setTextSize(18);
            tvTongTien.setPadding(0, 32, 0, 24);
            tvTongTien.setTypeface(null, android.graphics.Typeface.BOLD);
            cartListLayout.addView(tvTongTien);
        }
    }
    // Hàm cập nhật số lượng sản phẩm trong cart
    private void capNhatSoLuongCart(String item, int soLuongMoi) {
        android.content.SharedPreferences prefs = requireContext().getSharedPreferences("cart", android.content.Context.MODE_PRIVATE);
        java.util.Set<String> cart = new java.util.HashSet<>(prefs.getStringSet("cart_items", new java.util.HashSet<String>()));
        cart.remove(item);
        String[] parts = item.split("\\|");
        if (parts.length >= 4) {
            String newItem = parts[0] + "|" + parts[1] + "|" + parts[2] + "|" + parts[3] + "|" + soLuongMoi;
            cart.add(newItem);
        }
        prefs.edit().putStringSet("cart_items", cart).apply();
        updateCartUI();
    }
}