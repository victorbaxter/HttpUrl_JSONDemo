package com.example.kiz.httpurl_jsondemo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class RepoAdapter extends RecyclerView.Adapter<RepoAdapter.RepoViewHolder> {

    private List<Repo> mRepos;
    LayoutInflater layoutInflater;

    public RepoAdapter(Context context, List<Repo> repos) {
        layoutInflater = LayoutInflater.from(context);
        mRepos = repos;
    }

    @NonNull
    @Override
    public RepoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View bannerView = layoutInflater.inflate(R.layout.item_repo, parent, false);
        RepoViewHolder viewHolder = new RepoViewHolder(bannerView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RepoViewHolder holder, int position) {
        Repo repo = mRepos.get(position);
        TextView text_id = holder.text_id;
        TextView text_node_id = holder.text_node_id;
        TextView text_name = holder.text_name;
        TextView text_private = holder.text_private;
        TextView text_owner_id = holder.text_owner_id;
        TextView text_html_url = holder.text_html_url;
        TextView text_description = holder.text_description;

        text_id.setText(repo.getId());
        text_node_id.setText(repo.getNodeId());
        text_name.setText(repo.getName());
        text_private.setText(repo.getPrivate());
        text_owner_id.setText(repo.getOwnerId());
        text_html_url.setText(repo.getHtmlUrl());
        text_description.setText(repo.getDescription());
    }

    @Override
    public int getItemCount() {
        return mRepos.size();
    }

    public class RepoViewHolder extends RecyclerView.ViewHolder {

        public TextView text_id;
        public TextView text_node_id;
        public TextView text_name;
        public TextView text_private;
        public TextView text_owner_id;
        public TextView text_html_url;
        public TextView text_description;

        public RepoViewHolder(View itemView) {
            super(itemView);
            text_id = itemView.findViewById(R.id.text_id);
            text_node_id = itemView.findViewById(R.id.text_node_id);
            text_name = itemView.findViewById(R.id.text_name);
            text_private = itemView.findViewById(R.id.text_private);
            text_owner_id = itemView.findViewById(R.id.text_owner_id);
            text_html_url = itemView.findViewById(R.id.text_html_url);
            text_description = itemView.findViewById(R.id.text_description);
        }
    }
}
