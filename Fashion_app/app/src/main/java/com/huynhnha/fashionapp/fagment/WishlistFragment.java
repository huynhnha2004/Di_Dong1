package com.huynhnha.fashionapp.fagment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.huynhnha.fashionapp.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link WishlistFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class WishlistFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public WishlistFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment WishlistFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static WishlistFragment newInstance(String param1, String param2) {
        WishlistFragment fragment = new WishlistFragment();
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
        View view = inflater.inflate(R.layout.fragment_wishlist, container, false);

        // Tìm EditText, nút tìm kiếm và danh sách sản phẩm
        android.widget.EditText edtSearch = view.findViewById(R.id.edtSearchWishlist);
        android.widget.ImageView btnSearch = view.findViewById(R.id.btnSearchWishlist);
        android.widget.LinearLayout productList = view.findViewById(R.id.productListWishlist);

        if (btnSearch != null && edtSearch != null && productList != null) {
            btnSearch.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String keyword = edtSearch.getText().toString().trim().toLowerCase();
                    for (int i = 0; i < productList.getChildCount(); i++) {
                        View productCard = productList.getChildAt(i);
                        android.widget.TextView tvName = productCard.findViewById(R.id.tvProductNameWishlist);
                        if (tvName != null) {
                            String name = tvName.getText().toString().toLowerCase();
                            if (name.contains(keyword)) {
                                productCard.setVisibility(View.VISIBLE);
                            } else {
                                productCard.setVisibility(View.GONE);
                            }
                        }
                    }
                }
            });
        }

        // Sản phẩm 1 (Black Dress)
        View btnAddToCart1 = view.findViewById(R.id.btnAddToCart1);
        if (btnAddToCart1 != null) {
            btnAddToCart1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    addToCart("Black Dress", "Solid Black Dress for Women, Sexy Chain Shorts Ladi...", "200.000 đ", "nett");
                }
            });
        }
        // Xem chi tiết sản phẩm 1
        View btnDetail1 = view.findViewById(R.id.btnDetail1);
        if (btnDetail1 != null) {
            btnDetail1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Bundle bundle = new Bundle();
                    bundle.putString("tenSanPham", "Black Dress");
                    bundle.putString("moTa", "Solid Black Dress for Women, Sexy Chain Shorts Ladi...");
                    bundle.putString("gia", "200.000 đ");
                    bundle.putString("hinh", "nett");
                    androidx.viewpager2.widget.ViewPager2 pager2 = requireActivity().findViewById(R.id.viewpager2);
android.content.SharedPreferences prefs = requireActivity().getSharedPreferences("shop_detail", android.content.Context.MODE_PRIVATE);
prefs.edit()
    .putString("tenSanPham", bundle.getString("tenSanPham"))
    .putString("moTa", bundle.getString("moTa"))
    .putString("gia", bundle.getString("gia"))
    .putString("hinh", bundle.getString("hinh"))
    .apply();
if (pager2 != null) {
    pager2.setCurrentItem(2, true); // Chuyển sang tab Shop (index 1)
}
                }
            });
        }
        // Sản phẩm 2 (Pink Embroide...)
        View btnAddToCart2 = view.findViewById(R.id.btnAddToCart2);
        if (btnAddToCart2 != null) {
            btnAddToCart2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    addToCart("Pink Embroide...", "EARTHEN Rose Pink Embroidered Tiered Max...", "200.000 đ", "grilt");
                }
            });
        }
        // Xem chi tiết sản phẩm 2
        View btnDetail2 = view.findViewById(R.id.btnDetail2);
        if (btnDetail2 != null) {
            btnDetail2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Bundle bundle = new Bundle();
                    bundle.putString("tenSanPham", "Pink Embroide...");
                    bundle.putString("moTa", "EARTHEN Rose Pink Embroidered Tiered Max...");
                    bundle.putString("gia", "200.000 đ");
                    bundle.putString("hinh", "grilt");
                    androidx.viewpager2.widget.ViewPager2 pager2 = requireActivity().findViewById(R.id.viewpager2);
android.content.SharedPreferences prefs = requireActivity().getSharedPreferences("shop_detail", android.content.Context.MODE_PRIVATE);
prefs.edit()
    .putString("tenSanPham", bundle.getString("tenSanPham"))
    .putString("moTa", bundle.getString("moTa"))
    .putString("gia", bundle.getString("gia"))
    .putString("hinh", bundle.getString("hinh"))
    .apply();
if (pager2 != null) {
    pager2.setCurrentItem(2, true); // Chuyển sang tab Shop (index 1)
}
                }
            });
        }
        // Sản phẩm 3 (Flare Dress)
        View btnAddToCart3 = view.findViewById(R.id.btnAddToCart3);
        if (btnAddToCart3 != null) {
            btnAddToCart3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    addToCart("Flare Dress", "Antheaa Black and Rust Orange Floral Print Tiered Midi F...", "200.000 đ", "flass");
                }
            });
        }
        // Xem chi tiết sản phẩm 3
        View btnDetail3 = view.findViewById(R.id.btnDetail3);
        if (btnDetail3 != null) {
            btnDetail3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Bundle bundle = new Bundle();
                    bundle.putString("tenSanPham", "Flare Dress");
                    bundle.putString("moTa", "Antheaa Black and Rust Orange Floral Print Tiered Midi F...");
                    bundle.putString("gia", "200.000 đ");
                    bundle.putString("hinh", "flass");
                    androidx.viewpager2.widget.ViewPager2 pager2 = requireActivity().findViewById(R.id.viewpager2);
android.content.SharedPreferences prefs = requireActivity().getSharedPreferences("shop_detail", android.content.Context.MODE_PRIVATE);
prefs.edit()
    .putString("tenSanPham", bundle.getString("tenSanPham"))
    .putString("moTa", bundle.getString("moTa"))
    .putString("gia", bundle.getString("gia"))
    .putString("hinh", bundle.getString("hinh"))
    .apply();
if (pager2 != null) {
    pager2.setCurrentItem(2, true); // Chuyển sang tab Shop (index 1)
}
                }
            });
        }
        // Sản phẩm 4 (denim dress - hoter)
        View btnAddToCart4 = view.findViewById(R.id.btnAddToCart4);
        if (btnAddToCart4 != null) {
            btnAddToCart4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    addToCart("denim dress", "Blue cotton denim dress Look 2 Printed cotton dr...", "200.000 đ", "hoter");
                }
            });
        }
        // Xem chi tiết sản phẩm 4
        View btnDetail4 = view.findViewById(R.id.btnDetail4);
        if (btnDetail4 != null) {
            btnDetail4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Bundle bundle = new Bundle();
                    bundle.putString("tenSanPham", "denim dress");
                    bundle.putString("moTa", "Blue cotton denim dress Look 2 Printed cotton dr...");
                    bundle.putString("gia", "200.000 đ");
                    bundle.putString("hinh", "hoter");
                    androidx.viewpager2.widget.ViewPager2 pager2 = requireActivity().findViewById(R.id.viewpager2);
android.content.SharedPreferences prefs = requireActivity().getSharedPreferences("shop_detail", android.content.Context.MODE_PRIVATE);
prefs.edit()
    .putString("tenSanPham", bundle.getString("tenSanPham"))
    .putString("moTa", bundle.getString("moTa"))
    .putString("gia", bundle.getString("gia"))
    .putString("hinh", bundle.getString("hinh"))
    .apply();
if (pager2 != null) {
    pager2.setCurrentItem(2, true); // Chuyển sang tab Shop (index 1)
}
                }
            });
        }
        // Sản phẩm 5 (Jordan Stay)
        View btnAddToCart5 = view.findViewById(R.id.btnAddToCart5);
        if (btnAddToCart5 != null) {
            btnAddToCart5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    addToCart("Jordan Stay", "The classic Air Jordan 12 to create a shoe that's fres...", "200.000 đ", "ao1");
                }
            });
        }
        // Xem chi tiết sản phẩm 5
        View btnDetail5 = view.findViewById(R.id.btnDetail5);
        if (btnDetail5 != null) {
            btnDetail5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Bundle bundle = new Bundle();
                    bundle.putString("tenSanPham", "Jordan Stay");
                    bundle.putString("moTa", "The classic Air Jordan 12 to create a shoe that's fres...");
                    bundle.putString("gia", "200.000 đ");
                    bundle.putString("hinh", "ao1");
                    androidx.viewpager2.widget.ViewPager2 pager2 = requireActivity().findViewById(R.id.viewpager2);
android.content.SharedPreferences prefs = requireActivity().getSharedPreferences("shop_detail", android.content.Context.MODE_PRIVATE);
prefs.edit()
    .putString("tenSanPham", bundle.getString("tenSanPham"))
    .putString("moTa", bundle.getString("moTa"))
    .putString("gia", bundle.getString("gia"))
    .putString("hinh", bundle.getString("hinh"))
    .apply();
if (pager2 != null) {
    pager2.setCurrentItem(2, true); // Chuyển sang tab Shop (index 1)
}
                }
            });
        }
        // Sản phẩm 6 (denim dress - ao3)
        View btnAddToCart6 = view.findViewById(R.id.btnAddToCart6);
        if (btnAddToCart6 != null) {
            btnAddToCart6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    addToCart("denim dress", "6 GB RAM | 64 GB ROM | Expandable Upto 256..", "200.000 đ", "ao3");
                }
            });
        }
        // Xem chi tiết sản phẩm 6
        View btnDetail6 = view.findViewById(R.id.btnDetail6);
        if (btnDetail6 != null) {
            btnDetail6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Bundle bundle = new Bundle();
                    bundle.putString("tenSanPham", "denim dress");
                    bundle.putString("moTa", "6 GB RAM | 64 GB ROM | Expandable Upto 256..");
                    bundle.putString("gia", "200.000 đ");
                    bundle.putString("hinh", "ao3");
                    androidx.viewpager2.widget.ViewPager2 pager2 = requireActivity().findViewById(R.id.viewpager2);
android.content.SharedPreferences prefs = requireActivity().getSharedPreferences("shop_detail", android.content.Context.MODE_PRIVATE);
prefs.edit()
    .putString("tenSanPham", bundle.getString("tenSanPham"))
    .putString("moTa", bundle.getString("moTa"))
    .putString("gia", bundle.getString("gia"))
    .putString("hinh", bundle.getString("hinh"))
    .apply();
if (pager2 != null) {
    pager2.setCurrentItem(2, true); // Chuyển sang tab Shop (index 1)
}
                }
            });
        }
        // Sản phẩm 7 (Sony PS4)
        View btnAddToCart7 = view.findViewById(R.id.btnAddToCart7);
        if (btnAddToCart7 != null) {
            btnAddToCart7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    addToCart("Sony PS4", "Sony PS4 Console, 1TB Slim with 3 Games: Gran Turis...", "200.000 đ", "ao4");
                }
            });
        }
        // Xem chi tiết sản phẩm 7
        View btnDetail7 = view.findViewById(R.id.btnDetail7);
        if (btnDetail7 != null) {
            btnDetail7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Bundle bundle = new Bundle();
                    bundle.putString("tenSanPham", "Sony PS4");
                    bundle.putString("moTa", "Sony PS4 Console, 1TB Slim with 3 Games: Gran Turis...");
                    bundle.putString("gia", "200.000 đ");
                    bundle.putString("hinh", "ao4");
                    androidx.viewpager2.widget.ViewPager2 pager2 = requireActivity().findViewById(R.id.viewpager2);
android.content.SharedPreferences prefs = requireActivity().getSharedPreferences("shop_detail", android.content.Context.MODE_PRIVATE);
prefs.edit()
    .putString("tenSanPham", bundle.getString("tenSanPham"))
    .putString("moTa", bundle.getString("moTa"))
    .putString("gia", bundle.getString("gia"))
    .putString("hinh", bundle.getString("hinh"))
    .apply();
if (pager2 != null) {
    pager2.setCurrentItem(2, true); // Chuyển sang tab Shop (index 1)
}
                }
            });
        }
        // Sản phẩm 8 (Black Jacket 12...)
        View btnAddToCart8 = view.findViewById(R.id.btnAddToCart8);
        if (btnAddToCart8 != null) {
            btnAddToCart8.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    addToCart("Black Jacket 12...", "This warm and comfortable jacket is great for learni...", "200.000 đ", "ao5");
                }
            });
        }
        // Xem chi tiết sản phẩm 8
        View btnDetail8 = view.findViewById(R.id.btnDetail8);
        if (btnDetail8 != null) {
            btnDetail8.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Bundle bundle = new Bundle();
                    bundle.putString("tenSanPham", "Black Jacket 12...");
                    bundle.putString("moTa", "This warm and comfortable jacket is great for learni...");
                    bundle.putString("gia", "200.000 đ");
                    bundle.putString("hinh", "ao5");
                    androidx.viewpager2.widget.ViewPager2 pager2 = requireActivity().findViewById(R.id.viewpager2);
android.content.SharedPreferences prefs = requireActivity().getSharedPreferences("shop_detail", android.content.Context.MODE_PRIVATE);
prefs.edit()
    .putString("tenSanPham", bundle.getString("tenSanPham"))
    .putString("moTa", bundle.getString("moTa"))
    .putString("gia", bundle.getString("gia"))
    .putString("hinh", bundle.getString("hinh"))
    .apply();
if (pager2 != null) {
    pager2.setCurrentItem(2, true); // Chuyển sang tab Shop (index 1)
}
                }
            });
        }
        // Sản phẩm 9 (D7200 Digital C...)
        View btnAddToCart9 = view.findViewById(R.id.btnAddToCart9);
        if (btnAddToCart9 != null) {
            btnAddToCart9.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    addToCart("D7200 Digital C...", "D7200 Digital Camera (Nikon) In New Area...", "200.000 đ", "ao1");
                }
            });
        }
        // Xem chi tiết sản phẩm 9
        View btnDetail9 = view.findViewById(R.id.btnDetail9);
        if (btnDetail9 != null) {
            btnDetail9.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Bundle bundle = new Bundle();
                    bundle.putString("tenSanPham", "D7200 Digital C...");
                    bundle.putString("moTa", "D7200 Digital Camera (Nikon) In New Area...");
                    bundle.putString("gia", "200.000 đ");
                    bundle.putString("hinh", "ao1");
                    androidx.viewpager2.widget.ViewPager2 pager2 = requireActivity().findViewById(R.id.viewpager2);
android.content.SharedPreferences prefs = requireActivity().getSharedPreferences("shop_detail", android.content.Context.MODE_PRIVATE);
prefs.edit()
    .putString("tenSanPham", bundle.getString("tenSanPham"))
    .putString("moTa", bundle.getString("moTa"))
    .putString("gia", bundle.getString("gia"))
    .putString("hinh", bundle.getString("hinh"))
    .apply();
if (pager2 != null) {
    pager2.setCurrentItem(2, true); // Chuyển sang tab Shop (index 1)
}
                }
            });
        }
        // Sản phẩm 10 (Black Jacket 12... - ao3)
        View btnAddToCart10 = view.findViewById(R.id.btnAddToCart10);
        if (btnAddToCart10 != null) {
            btnAddToCart10.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    addToCart("Black Jacket 12...", "This warm and comfortable jacket is great for learni...", "200.000 đ", "ao3");
                }
            });
        }
        // Xem chi tiết sản phẩm 10
        View btnDetail10 = view.findViewById(R.id.btnDetail10);
        if (btnDetail10 != null) {
            btnDetail10.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Bundle bundle = new Bundle();
                    bundle.putString("tenSanPham", "Black Jacket 12...");
                    bundle.putString("moTa", "This warm and comfortable jacket is great for learni...");
                    bundle.putString("gia", "200.000 đ");
                    bundle.putString("hinh", "ao3");
                    androidx.viewpager2.widget.ViewPager2 pager2 = requireActivity().findViewById(R.id.viewpager2);
android.content.SharedPreferences prefs = requireActivity().getSharedPreferences("shop_detail", android.content.Context.MODE_PRIVATE);
prefs.edit()
    .putString("tenSanPham", bundle.getString("tenSanPham"))
    .putString("moTa", bundle.getString("moTa"))
    .putString("gia", bundle.getString("gia"))
    .putString("hinh", bundle.getString("hinh"))
    .apply();
if (pager2 != null) {
    pager2.setCurrentItem(2, true); // Chuyển sang tab Shop (index 1)
}
                }
            });
        }
        return view;
    }

    private void addToCart(String tenSanPham, String moTa, String gia, String hinh) {
        String item = tenSanPham + "|" + moTa + "|" + gia + "|" + hinh;
        android.content.SharedPreferences prefs = requireContext().getSharedPreferences("cart", android.content.Context.MODE_PRIVATE);
        java.util.Set<String> cart = new java.util.HashSet<>(prefs.getStringSet("cart_items", new java.util.HashSet<String>()));
        cart.add(item);
        prefs.edit().putStringSet("cart_items", cart).apply();
        // Sau khi thêm, nếu SearchFragment đang hiển thị thì cập nhật UI ngay
        androidx.fragment.app.FragmentManager fm = requireActivity().getSupportFragmentManager();
        java.util.List<androidx.fragment.app.Fragment> fragments = fm.getFragments();
        for (androidx.fragment.app.Fragment fragment : fragments) {
            if (fragment instanceof com.huynhnha.fashionapp.fagment.SearchFragment) {
                if (fragment.isVisible() && fragment instanceof com.huynhnha.fashionapp.fagment.CartUpdateListener) {
                    ((com.huynhnha.fashionapp.fagment.CartUpdateListener) fragment).onCartUpdated();
                }
            }
        }
        android.widget.Toast.makeText(getContext(), "Đã thêm vào giỏ hàng!", android.widget.Toast.LENGTH_SHORT).show();
    }
}