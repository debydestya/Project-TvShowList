package id.sch.smktelkom_mlg.privateassignment.xirpl206.tvshowlist.adapter;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import id.sch.smktelkom_mlg.privateassignment.xirpl206.tvshowlist.R;
import id.sch.smktelkom_mlg.privateassignment.xirpl206.tvshowlist.modul.Result;

public class AiringShowAdapter extends RecyclerView.Adapter<AiringShowAdapter.ViewHolder> {
    ArrayList<Result> list;
    AiringShowAdapter.IComingSoonAdapter mIComingSoonAdapter;
    Context context;


    public AiringShowAdapter(Context context, ArrayList<Result> list) {
        this.list = list;
        this.context = context;
        mIComingSoonAdapter = (AiringShowAdapter.IComingSoonAdapter) context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.airing_list, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(AiringShowAdapter.ViewHolder holder, int position) {
        Result result = list.get(position);
        holder.tvName.setText(result.original_name);
        holder.tvDesc.setText(result.overview);
        Glide.with(context)
                .load("http://image.tmdb.org/t/p/w500" + result.poster_path)
                .into(holder.iv_poster);
    }

    @Override
    public int getItemCount() {
        if (list != null)
            return list.size();
        return 0;
    }

    public interface IComingSoonAdapter {
        void showArticles(String original_title, String overview, String poster_path);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView iv_poster;
        TextView tvName;
        TextView tvDesc;

        public ViewHolder(View itemView) {
            super(itemView);
            iv_poster = (ImageView) itemView.findViewById(R.id.imageViewPoster);
            tvName = (TextView) itemView.findViewById(R.id.textViewName);
            tvDesc = (TextView) itemView.findViewById(R.id.textViewDesc);
        }
    }
}
