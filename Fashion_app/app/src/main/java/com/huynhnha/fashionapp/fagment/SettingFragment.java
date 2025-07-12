package com.huynhnha.fashionapp.fagment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;

import com.huynhnha.fashionapp.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SettingFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SettingFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SettingFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SettingFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SettingFragment newInstance(String param1, String param2) {
        SettingFragment fragment = new SettingFragment();
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
        View view = inflater.inflate(R.layout.fragment_setting, container, false);

        // Ánh xạ view
        EditText edtEmail = view.findViewById(R.id.edtEmail);
        EditText edtPassword = view.findViewById(R.id.edtPassword);
        EditText edtPincode = view.findViewById(R.id.edtPincode);
        EditText edtAddress = view.findViewById(R.id.edtAddress);
        EditText edtCity = view.findViewById(R.id.edtCity);
        EditText edtState = view.findViewById(R.id.edtState);
        EditText edtCountry = view.findViewById(R.id.edtCountry);
        EditText edtBankAccount = view.findViewById(R.id.edtBankAccount);
        EditText edtHolderName = view.findViewById(R.id.edtHolderName);
        EditText edtIfsc = view.findViewById(R.id.edtIfsc);
        Button btnSave = view.findViewById(R.id.btnSave);

        // Load dữ liệu đã lưu (nếu có)
        android.content.SharedPreferences prefs = requireContext().getSharedPreferences("user_info", android.content.Context.MODE_PRIVATE);
        edtEmail.setText(prefs.getString("email", ""));
        edtPassword.setText(prefs.getString("password", ""));
        edtPincode.setText(prefs.getString("pincode", ""));
        edtAddress.setText(prefs.getString("address", ""));
        edtCity.setText(prefs.getString("city", ""));
        edtState.setText(prefs.getString("state", ""));
        edtCountry.setText(prefs.getString("country", ""));
        edtBankAccount.setText(prefs.getString("bank_account", ""));
        edtHolderName.setText(prefs.getString("holder_name", ""));
        edtIfsc.setText(prefs.getString("ifsc", ""));

        // Sự kiện lưu
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                android.content.SharedPreferences.Editor editor = prefs.edit();
                editor.putString("email", edtEmail.getText().toString());
                editor.putString("password", edtPassword.getText().toString());
                editor.putString("pincode", edtPincode.getText().toString());
                editor.putString("address", edtAddress.getText().toString());
                editor.putString("city", edtCity.getText().toString());
                editor.putString("state", edtState.getText().toString());
                editor.putString("country", edtCountry.getText().toString());
                editor.putString("bank_account", edtBankAccount.getText().toString());
                editor.putString("holder_name", edtHolderName.getText().toString());
                editor.putString("ifsc", edtIfsc.getText().toString());
                editor.apply();
                android.widget.Toast.makeText(getContext(), "Lưu thông tin thành công!", android.widget.Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}