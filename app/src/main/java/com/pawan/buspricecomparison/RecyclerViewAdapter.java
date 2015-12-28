package com.pawan.buspricecomparison;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.BusViewHolder> {

    private List<BusDetails> busDetailsList;

    public RecyclerViewAdapter(List<BusDetails> busDetailsList) {
        this.busDetailsList = busDetailsList;
    }

    @Override
    public int getItemCount() {
        return busDetailsList.size();
    }

    @Override
    public void onBindViewHolder(RecyclerViewAdapter.BusViewHolder holder, int position) {
        BusDetails busDetails= busDetailsList.get(position);
        holder.busTravellerName.setText(busDetails.getBusCompanyName());
        holder.busTiming.setText(busDetails.getArrivalTime()+"-"+busDetails.getReachingTime());

        holder.paytmDealer.setText(busDetails.getPaytmDealer());
        holder.paytmPrice.setText(busDetails.getPaytmFare()+"");

        holder.redbusDealer.setText(busDetails.getRedBusDealer());
        holder.redbusPrice.setText(busDetails.getRedBusFare()+"");

        holder.makemytripDealer.setText(busDetails.getMakeMyTripDealer());
        holder.makemytripPrice.setText(busDetails.getMakeMyTripFare()+"");

    }
    @Override
    public RecyclerViewAdapter.BusViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).
                inflate(R.layout.row, viewGroup, false);
        return new BusViewHolder(itemView);
    }



    public static class BusViewHolder extends RecyclerView.ViewHolder {

        private TextView busTravellerName;
        private TextView busTiming;
        private TextView paytmDealer;
        private TextView paytmPrice;
        private TextView redbusDealer;
        private TextView redbusPrice;
        private TextView makemytripDealer;
        private TextView makemytripPrice;

        public BusViewHolder(View itemView) {
            super(itemView);
            busTravellerName=(TextView)itemView.findViewById(R.id.tv_bus_traveller_name);
            busTiming=(TextView)itemView.findViewById(R.id.tv_bus_timing);
            paytmDealer=(TextView)itemView.findViewById(R.id.tv_paytm_dealer);
            paytmPrice=(TextView)itemView.findViewById(R.id.tv_paytm_price);
            redbusDealer=(TextView)itemView.findViewById(R.id.tv_redbus_dealer);
            redbusPrice=(TextView)itemView.findViewById(R.id.tv_redbus_price);
            makemytripDealer=(TextView)itemView.findViewById(R.id.tv_makemytrip_dealer);
            makemytripPrice=(TextView)itemView.findViewById(R.id.tv_makemytrip_price);
            //  arrivalTime=(TextView)itemView.findViewById(R.id.tvArrivalTime);
        }
    }
}
