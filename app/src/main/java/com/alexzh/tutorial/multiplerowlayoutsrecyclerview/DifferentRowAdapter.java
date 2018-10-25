package com.alexzh.tutorial.multiplerowlayoutsrecyclerview;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.alexzh.tutorial.multiplerowlayoutsrecyclerview.dummy.model.CityEvent;

import java.util.List;

import static com.alexzh.tutorial.multiplerowlayoutsrecyclerview.dummy.model.CityEvent.CITY_TYPE;
import static com.alexzh.tutorial.multiplerowlayoutsrecyclerview.dummy.model.CityEvent.EVENT_TYPE;

public class DifferentRowAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<CityEvent> mList;
    private Context context;

    public DifferentRowAdapter(List<CityEvent> list, Context context) {
        this.mList = list;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;

        switch (viewType) {
            case CITY_TYPE:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_city, parent, false);
                return new CityViewHolder(view);
            case EVENT_TYPE:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_event, parent, false);
                return new EventViewHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        final CityEvent object = mList.get(position);
        holder.setIsRecyclable(false);

        if (object != null) {
            switch (object.getType()) {
                case CITY_TYPE:
                    ((CityViewHolder) holder).mTitle.setText(object.getName());
                    break;
                case EVENT_TYPE:
                    ((EventViewHolder) holder).mTitle.setText(object.getName());
                    ((EventViewHolder) holder).mDescription.setText(object.getDescription());

                    (holder).setIsRecyclable(false);

                    ((EventViewHolder)holder).radioGroup.setOnCheckedChangeListener(null);



                    /*((EventViewHolder)holder).radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(RadioGroup group, int checkedId) {

                            int pos = group.getCheckedRadioButtonId();
                            if(((EventViewHolder) holder).rbYes.isChecked()) {
                                object.setYes(true);
                                ((EventViewHolder) holder).rbYes.setChecked(true);
                                //object.setYes(true);
                                mList.get(pos).setYes(true);

                                Log.v("Yes","Checked");
                            } else {
                                object.setYes(false);
                                ((EventViewHolder) holder).rbYes.setChecked(false);
                            }

                            if(((EventViewHolder) holder).rbNo.isChecked()){
                                object.setNo(true);
                                Log.v("No","Checked");
                                mList.get(pos).setNo(true);
                                ((EventViewHolder) holder).rbNo.setChecked(true);
                            } else {
                                object.setNo(false);
                                ((EventViewHolder) holder).rbNo.setChecked(false);
                            }

                            *//*if(object.getYes() == true){
                                ((EventViewHolder) holder).rbYes.setChecked(true);
                            } else {
                                ((EventViewHolder) holder).rbYes.setChecked(false);
                            }

                            if(object.getNo() == true){
                                ((EventViewHolder) holder).rbNo.setChecked(true);
                            } else {
                                ((EventViewHolder) holder).rbNo.setChecked(false);
                            }*//*


                            //notifyDataSetChanged();

                            Log.e("Name = ", " " + object.getName());
                            Log.e("Description = ", " " + object.getDescription());
                            Log.e("Type = ", " " + object.getType());
                            Log.e("Yes = ", " " + object.getYes());
                            Log.e("No = "," " + object.getNo());
                            Toast.makeText(DifferentRowAdapter.this.context, "Radio Button Clicked : " + group.getCheckedRadioButtonId(),
                                    Toast.LENGTH_LONG).show();
                        }
                    });*/

                    //break;
            }
        }
    }

    @Override
    public int getItemCount() {
        if (mList == null)
            return 0;
        return mList.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        if (mList != null) {
            CityEvent object = mList.get(position);
            if (object != null) {
                return object.getType();
            }
        }
        return 0;
    }

    public static class CityViewHolder extends RecyclerView.ViewHolder {
        private TextView mTitle;

        public CityViewHolder(View itemView) {
            super(itemView);
            mTitle = (TextView) itemView.findViewById(R.id.titleTextView);
        }
    }

    public class EventViewHolder extends RecyclerView.ViewHolder {
        private TextView mTitle;
        private TextView mDescription;
        private RadioGroup radioGroup;
        RadioButton rbYes, rbNo;

        public EventViewHolder(View itemView) {
            super(itemView);
            this.setIsRecyclable(false);
            mTitle = (TextView) itemView.findViewById(R.id.titleTextView);
            mDescription = (TextView) itemView.findViewById(R.id.descriptionTextView);
            radioGroup = (RadioGroup)itemView.findViewById(R.id.radioGroup1);

            rbYes = new RadioButton(DifferentRowAdapter.this.context);
            rbNo = new RadioButton(DifferentRowAdapter.this.context);

            rbYes.setText("Yes");
            rbNo.setText("No");
            rbYes.setTextColor(Color.BLACK);
            rbNo.setTextColor(Color.BLACK);
            radioGroup.addView(rbYes, 0);
            radioGroup.addView(rbNo, 1);

        }
    }

    /*public int getItemViewType(int position) {
        return position;
    }*/
}