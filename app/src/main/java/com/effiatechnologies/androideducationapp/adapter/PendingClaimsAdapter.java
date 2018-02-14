package com.effiatechnologies.androideducationapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.effiatechnologies.androideducationapp.model.PendingClaimsModel;
import com.effiatechnologies.androideducationapp.R;

import java.util.List;

/**
 * Created by Administrator on 06-12-2016.
 */

public class PendingClaimsAdapter extends RecyclerView.Adapter<PendingClaimsAdapter.ItemViewHolder> {

    private static final String TAG = "pendingclaims_adapter";
    private List<PendingClaimsModel> mDataItemsList;
    private Context mContext;
    private Intent claimsIntent;

    public PendingClaimsAdapter() {
    }

    public PendingClaimsAdapter(Context context, List<PendingClaimsModel> mDataItemsList) {

        this.mDataItemsList = mDataItemsList;
        this.mContext = context;

    }


    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemLayoutView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.test_claims, parent, false);

        return new ItemViewHolder(itemLayoutView);

    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        PendingClaimsModel searchResponseModel = mDataItemsList.get(position);
        Log.d(TAG, searchResponseModel + "");
        holder.tvClaimId.setText(mDataItemsList.get(position).getRoleName());
       // holder.tvClaimId.setText(searchResponseModel.getRoleCode());
    }


    @Override
    public int getItemCount() {
        return mDataItemsList.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        CardView result;
        TextView tvClaimId;
        TextView tvClaimDate;

        public ItemViewHolder(View itemView) {
            super(itemView);
            result = (CardView) itemView.findViewById(R.id.card_view);
            tvClaimId = (TextView) itemView.findViewById(R.id.tv_ClaimId);

          /*  tvClaimId.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Log.d(TAG, "inside claimidclick");
                    String claimid = tvClaimId.getText().toString();
                    String claimdate = tvClaimDate.getText().toString();
                    Log.d(TAG, claimid + " :: claim id");
                    Log.d(TAG, claimdate + "  :: claim date");
                    claimsIntent = new Intent(mContext, ClaimsDetailsActivity.class);
                    claimsIntent.putExtra("claimId", claimid);
                    claimsIntent.putExtra("claimDate", claimdate);
                    claimsIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
                    mContext.startActivity(claimsIntent);
                    Log.d(TAG, "moving to claimsdetailsAnctivity");
                    //((Activity)mContext).finish();


                }
            });*/
        }
    }
}
