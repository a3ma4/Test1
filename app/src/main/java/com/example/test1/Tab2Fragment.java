package com.example.test1;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Tab2Fragment extends Fragment {

    public Tab2Fragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab2, container, false);
        TextView textView = view.findViewById(R.id.textViewTab2);
        textView.setText("محتوى التاب الثانية");
        return view;
    }
}
