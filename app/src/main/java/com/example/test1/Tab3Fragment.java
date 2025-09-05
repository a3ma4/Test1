package com.example.test1;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Tab3Fragment extends Fragment {

    public Tab3Fragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab3, container, false);
        TextView textView = view.findViewById(R.id.textViewTab3);
        textView.setText("محتوى التاب الثالثة");
        return view;
    }
}
