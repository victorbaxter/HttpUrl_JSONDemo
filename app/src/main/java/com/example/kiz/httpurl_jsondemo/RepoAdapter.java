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
    private LayoutInflater mLayoutInflater;

    public RepoAdapter(Context context, List<Repo> repos) {
        mLayoutInflater = LayoutInflater.from(context);
        mRepos = repos;
    }

    @NonNull
    @Override
    public RepoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View bannerView = mLayoutInflater.inflate(R.layout.item_repo, parent, false);
        RepoViewHolder viewHolder = new RepoViewHolder(bannerView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RepoViewHolder holder, int position) {
        Repo repo = mRepos.get(position);
        holder.setContent(repo);
    }

    @Override
    public int getItemCount() {
        return mRepos.size();
    }

    static class RepoViewHolder extends RecyclerView.ViewHolder {

        private TextView mTextId;
        private TextView mTextNodeId;
        private TextView mTextName;
        private TextView mTextPrivate;
        private TextView mTextOwnerId;
        private TextView mTextHtmlUrl;
        private TextView mTextDescription;

        public RepoViewHolder(View itemView) {
            super(itemView);
            mTextId = itemView.findViewById(R.id.text_id);
            mTextNodeId = itemView.findViewById(R.id.text_node_id);
            mTextName = itemView.findViewById(R.id.text_name);
            mTextPrivate = itemView.findViewById(R.id.text_private);
            mTextOwnerId = itemView.findViewById(R.id.text_owner_id);
            mTextHtmlUrl = itemView.findViewById(R.id.text_html_url);
            mTextDescription = itemView.findViewById(R.id.text_description);
        }
        public void setContent(Repo repo){
            mTextId.setText(repo.getId());
            mTextNodeId.setText(repo.getNodeId());
            mTextName.setText(repo.getName());
            mTextPrivate.setText(repo.getPrivate());
            mTextOwnerId.setText(repo.getOwnerId());
            mTextHtmlUrl.setText(repo.getHtmlUrl());
            mTextDescription.setText(repo.getDescription());
        }
    }
}
