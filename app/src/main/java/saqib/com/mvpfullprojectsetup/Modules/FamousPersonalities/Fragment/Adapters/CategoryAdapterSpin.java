package saqib.com.mvpfullprojectsetup.Modules.FamousPersonalities.Fragment.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import saqib.com.mvpfullprojectsetup.R;

/**
 * Created by data.
 */

public class CategoryAdapterSpin extends RecyclerView.Adapter<CategoryAdapterSpin.MyViewHolder> {

    private Context context;

    public CategoryAdapterSpin(Context context, List<String> list) {
        this.context = context;
        this.list = list;
    }

    private List<String> list;

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_category_adapter_spinner, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.title.setText(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.tv_spin_item);
        }
    }
}
