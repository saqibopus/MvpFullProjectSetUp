package saqib.com.mvpfullprojectsetup.Modules.FamousPersonalities.Fragment.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
import java.util.List;
import saqib.com.mvpfullprojectsetup.Modules.FamousPersonalities.Fragment.Model.FamousPersonModel;
import saqib.com.mvpfullprojectsetup.R;

/**
 * Created by data.
 */

public class FamousPersonCategoryAdapter extends RecyclerView.Adapter<FamousPersonCategoryAdapter.MyViewHolder> {

    private Context context;

    public FamousPersonCategoryAdapter(Context context, List<FamousPersonModel> list) {
        this.context = context;
        this.list = list;
    }

    private List<FamousPersonModel> list;

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_cat_famous_person_adapter, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        FamousPersonModel data =list.get(position);
        holder.tvName.setText(data.getName());
        Picasso.get()
                .load(data.getImage())
                .fit()
                .placeholder(R.drawable.ic_download)
                .error(R.drawable.ic_download)
                .into(holder.imgImage);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView tvName;
        public ImageView imgImage;

        public MyViewHolder(View view) {
            super(view);
            tvName = (TextView) view.findViewById(R.id.tv_name);
            imgImage = (ImageView) view.findViewById(R.id.img_image);
        }
    }
    public void addMore(List<FamousPersonModel> list){
        list.addAll(list);
    }
    public void notifyManually(){
            notifyDataSetChanged();
    }
}
