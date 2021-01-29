package com.example.mission1;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.content.res.ResourcesCompat;

import java.util.ArrayList;

public class CallLogAdapter extends ArrayAdapter<CallLogVO> {
    Context context;
    int resId;
    ArrayList<CallLogVO> datas;
    public CallLogAdapter(Context context, int resId, ArrayList<CallLogVO> datas){
        super(context, resId);
        this.context=context;
        this.resId=resId;
        this.datas=datas;
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null){
            LayoutInflater inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(resId, null);
            CallLogWrapper wrapper=new CallLogWrapper(convertView);
            convertView.setTag(wrapper);
        }
        CallLogWrapper wrapper=(CallLogWrapper)convertView.getTag();

        ImageView personImageView=wrapper.personImageView;
        TextView nameView=wrapper.nameView;
        TextView dateView=wrapper.dateView;
        ImageView diralerImageView=wrapper.dialerImageView;

        final CallLogVO vo=datas.get(position);

        nameView.setText(vo.name);
        dateView.setText(vo.date);

        if(vo.photo != null && vo.photo.equals("yes")){
            personImageView.setImageDrawable(ResourcesCompat.getDrawable(context.getResources(),
                    R.drawable.hong, null));
        }else {
            personImageView.setImageDrawable(ResourcesCompat.getDrawable(context.getResources(),
                    R.drawable.ic_person, null));
        }
        if(vo.phone != null && !vo.equals("")){
            diralerImageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent();
                    intent.setAction(Intent.ACTION_CALL);
                    intent.setData(Uri.parse("tel:"+vo.phone));
                    context.startActivity(intent);
                }
            });
        }
        return convertView;
    }
}
