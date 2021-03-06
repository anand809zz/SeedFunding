package com.example.seedfunding.StartupAdapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.seedfunding.InvestorAdapter.investorNotificationAdapter;
import com.example.seedfunding.InvestorModel.InvestorNotificationModel;
import com.example.seedfunding.R;
import com.example.seedfunding.ShowInvestorProfileFromNotificationActivity;
import com.example.seedfunding.ShowStartupProfileFromNotificationActivity;
import com.example.seedfunding.StartupModel.StartupNotificationModel;

import java.util.List;

public class startupNotificationAdapter extends RecyclerView.Adapter<startupNotificationAdapter.ViewHolder> {
    private Context mContext;
    private List<StartupNotificationModel> startupNotificationModel;

    public startupNotificationAdapter(Context mContext, List<StartupNotificationModel> startupNotificationModel) {
        this.mContext = mContext;
        this.startupNotificationModel = startupNotificationModel;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.startup_notification_card, viewGroup, false);
        return new startupNotificationAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        final StartupNotificationModel Model=startupNotificationModel.get(i);
        viewHolder.startup_notification_msg.setText(Model.getMessage());

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              //  Intent intent=new Intent(mContext, ShowStartupProfileFromNotificationActivity.class); ulta result
             //   intent.putExtra("currentInvestorReceiverId",Model.getReceiver());
              //  mContext.startActivity(intent);

                Intent intent=new Intent(mContext, ShowInvestorProfileFromNotificationActivity.class);
                 intent.putExtra("currentInvestorReceiverId",Model.getSender());
                 mContext.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return startupNotificationModel.size();
    }


    public class ViewHolder extends  RecyclerView.ViewHolder{
        TextView startup_notification_msg;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            startup_notification_msg=itemView.findViewById(R.id.startup_notification_msg);
        }
    }
}

