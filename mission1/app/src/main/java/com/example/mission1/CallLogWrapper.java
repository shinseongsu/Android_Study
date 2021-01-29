package com.example.mission1;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class CallLogWrapper {
    public ImageView personImageView;
    public TextView nameView;
    public TextView dateView;
    public ImageView dialerImageView;
    public CallLogWrapper(View root){
        personImageView=root.findViewById(R.id.main_item_person);
        nameView=root.findViewById(R.id.main_item_name);
        dateView=root.findViewById(R.id.main_item_date);
        dialerImageView=root.findViewById(R.id.main_item_dialer);
    }
}
