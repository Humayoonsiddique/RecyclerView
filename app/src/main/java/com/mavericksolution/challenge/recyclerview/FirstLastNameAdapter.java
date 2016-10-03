package com.mavericksolution.challenge.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;

public class FirstLastNameAdapter extends RecyclerView.Adapter<FirstLastNameAdapter.MyViewHolder> {

    private List<String>                            lastNameFirstNameList;

    /**********************************************************************************************/

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
        }
    }

    /**********************************************************************************************/



    public FirstLastNameAdapter(List<String> _lastNameFirstNameList) {
        this.lastNameFirstNameList = _lastNameFirstNameList;
    }

    /**********************************************************************************************/

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.lastnamefirstname_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    /**********************************************************************************************/


    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        String lastAndFirst_Name = lastNameFirstNameList.get(position);
        holder.title.setText(lastAndFirst_Name);
    }

    /**********************************************************************************************/

    @Override
    public int getItemCount() {
        return lastNameFirstNameList.size();
    }

    /**********************************************************************************************/

}
