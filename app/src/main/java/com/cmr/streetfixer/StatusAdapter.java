package com.cmr.streetfixer;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class StatusAdapter extends RecyclerView.Adapter<StatusAdapter.StatusViewHolder> {

	private final List<StatusItem> statusList;

	public StatusAdapter(List<StatusItem> statusList) {
		this.statusList = statusList;
	}

	@NonNull
	@Override
	public StatusViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
		View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_status, parent, false);
		return new StatusViewHolder(view);
	}

	@Override
	public void onBindViewHolder(@NonNull StatusViewHolder holder, int position) {
		StatusItem statusItem = statusList.get(position);

		holder.tvSNo.setText(String.valueOf(position + 1));
		holder.tvProblem.setText(statusItem.getProblem());
		holder.tvStatus.setText(statusItem.getStatus());
	}

	@Override
	public int getItemCount() {
		return statusList.size();
	}

	static class StatusViewHolder extends RecyclerView.ViewHolder {
		TextView tvSNo;
		TextView tvProblem;
		TextView tvStatus;

		public StatusViewHolder(@NonNull View itemView) {
			super(itemView);

			tvSNo = itemView.findViewById(R.id.tvSNo);
			tvProblem = itemView.findViewById(R.id.tvProblem);
			tvStatus = itemView.findViewById(R.id.tvStatus);
		}
	}
}
