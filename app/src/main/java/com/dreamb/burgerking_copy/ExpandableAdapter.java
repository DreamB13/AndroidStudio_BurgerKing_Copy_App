package com.dreamb.burgerking_copy;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ExpandableAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<ParentItem> parentItems;
    private List<Boolean> expandedStates;

    public ExpandableAdapter(List<ParentItem> parentItems) {
        this.parentItems = parentItems;
        // Initialize all groups as collapsed
        this.expandedStates = new ArrayList<>();
        for (int i = 0; i < parentItems.size(); i++) {
            expandedStates.add(false);
        }
    }

    @Override
    public int getItemViewType(int position) {
        int currentIndex = 0;
        for (int i = 0; i < parentItems.size(); i++) {
            if (currentIndex == position) return 0; // Parent item
            currentIndex++;
            if (expandedStates.get(i)) {
                if (position < currentIndex + parentItems.get(i).getChildTexts().size()) {
                    return 1; // Child item
                }
                currentIndex += parentItems.get(i).getChildTexts().size();
            }
        }
        throw new IllegalStateException("Invalid position");
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == 0) { // Parent view
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(android.R.layout.simple_list_item_1, parent, false);
            return new ParentViewHolder(view);
        } else { // Child view
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(android.R.layout.simple_list_item_2, parent, false);
            return new ChildViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        int currentIndex = 0;
        for (int i = 0; i < parentItems.size(); i++) {
            if (currentIndex == position) {
                ParentViewHolder parentHolder = (ParentViewHolder) holder;
                parentHolder.bind(parentItems.get(i), i);
                return;
            }
            currentIndex++;
            if (expandedStates.get(i)) {
                if (position < currentIndex + parentItems.get(i).getChildTexts().size()) {
                    ChildViewHolder childHolder = (ChildViewHolder) holder;
                    childHolder.bind(parentItems.get(i).getChildTexts().get(position - currentIndex));
                    return;
                }
                currentIndex += parentItems.get(i).getChildTexts().size();
            }
        }
    }

    @Override
    public int getItemCount() {
        int count = parentItems.size();
        for (int i = 0; i < parentItems.size(); i++) {
            if (expandedStates.get(i)) {
                count += parentItems.get(i).getChildTexts().size();
            }
        }
        return count;
    }

    class ParentViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;

        ParentViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(android.R.id.text1);
            itemView.setOnClickListener(v -> {
                int position = getAdapterPosition();
                expandedStates.set(position / 2, !expandedStates.get(position / 2));
                notifyDataSetChanged();
            });
        }

        void bind(ParentItem parentItem, int position) {
            textView.setText(parentItem.getParentText());
        }
    }

    class ChildViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;

        ChildViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(android.R.id.text1);
        }

        void bind(String childText) {
            textView.setText(childText);
        }
    }
}
