package com.edu.recyclerviewdatabase;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class WordsAdapter extends RecyclerView.Adapter<WordsAdapter.ViewHolder> {

    Context context;
    List<Word> words;
    RecyclerView recyclerView;
    final View.OnClickListener onClickListener = new myOnClickListener();

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView textView;
        public CardView cardView;
        public CheckBox checkBox;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView);
            cardView = itemView.findViewById(R.id.cartView);
            checkBox = itemView.findViewById(R.id.checkBox);
        }
    }

    //конструктор адаптера
    public WordsAdapter(Context context, List<Word> words, RecyclerView recyclerView) {
        this.context = context;
        this.words = words;
        this.recyclerView = recyclerView;
    }

    @NonNull
    @Override
    //передача значений полям класса
    //создает новый объект ViewHolder всякий раз, когда RecyclerView нуждается в этом
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.word, parent, false);
        view.setOnClickListener(onClickListener);
        return new ViewHolder(view);
    }

    @Override
    //принимает объект ViewHolder и устанавливает необходимые данные для соответствующей строки во view-компоненте
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Word word = words.get(position);
        holder.textView.setText(word.getText());
        holder.checkBox.setChecked(word.getFav());
        //is_bought
        holder.cardView.setCardBackgroundColor(0xffff4a4a);
    }

    @Override
    public int getItemCount() {
        return words.size();
    }


    private static class myOnClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
        }
    }
}
