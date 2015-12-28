package com.pawan.buspricecomparison;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.CustomerViewHolder> {

    private List<Customer> customerList;

    public RecyclerViewAdapter(List<Customer> customerList) {
        this.customerList = customerList;
    }

    @Override
    public int getItemCount() {
        return customerList.size();
    }

    @Override
    public void onBindViewHolder(RecyclerViewAdapter.CustomerViewHolder holder, int position) {
        Customer customer = customerList.get(position);
        holder.customerId.setText(customer.getCustomerId());
        holder.customerName.setText(customer.getCustomerName());
        holder.customerPhoneNumber.setText(customer.getCustomerPhoneNumber());
    }
    @Override
    public RecyclerViewAdapter.CustomerViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).
                inflate(R.layout.row, viewGroup, false);
        return new CustomerViewHolder(itemView);
    }



    public static class CustomerViewHolder extends RecyclerView.ViewHolder {

        private TextView customerId;
        private TextView customerName;
        private TextView customerPhoneNumber;

        public CustomerViewHolder(View itemView) {
            super(itemView);
            customerId=(TextView)itemView.findViewById(R.id.tvCustomerId);
            customerName=(TextView)itemView.findViewById(R.id.tvCustomerName);
            customerPhoneNumber=(TextView)itemView.findViewById(R.id.tvCustomerPhoneNumber);
        }
    }
}
