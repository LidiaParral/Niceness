package com.limi.niceness.rvAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.limi.niceness.R;
import com.limi.niceness.model.Chat;

import java.util.ArrayList;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.MessageVH>{
        public static  final int MSG_TYPE_LEFT = 0;
        public static  final int MSG_TYPE_RIGHT = 1;

        private Chat chat;
        private Context mContext;
        private ArrayList<Chat> mChat;
        private String imageurl;

        FirebaseUser fuser;

    public MessageAdapter(Context mContext, ArrayList<Chat> mChat, String imageurl) {
        this.mContext = mContext;
        this.mChat = mChat;
        this.imageurl = imageurl;
    }

    @NonNull
    @Override
    public MessageVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == MSG_TYPE_RIGHT) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.chat_item_user, parent, false);
            MessageVH mvh = new MessageVH(view);
            return mvh;
        } else {
            View view = LayoutInflater.from(mContext).inflate(R.layout.chat_item_user2, parent, false);
            MessageVH mvh = new MessageVH(view);
            return mvh;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull MessageVH holder, int position) {
        holder.bindPersona(mChat.get(position));

        if (position == mChat.size()-1){
            if (chat.isVisto()){
                holder.txt_seen.setText("Leído");
            }else{
                holder.txt_seen.setText("Recibido");
            }

        } else{
            holder.txt_seen.setVisibility(View.GONE);
        }


    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public  class MessageVH extends RecyclerView.ViewHolder{

        public TextView show_message;
        public ImageView profile_image;
        public TextView txt_seen;

        public MessageVH(View itemView) {
            super(itemView);

            show_message = itemView.findViewById(R.id.show_message);
            profile_image = itemView.findViewById(R.id.profile_image);
            txt_seen = itemView.findViewById(R.id.txt_seen);
        }

        public void bindPersona(Chat chat) {
            show_message.setText(chat.getMessage());

            if (imageurl.equals("default")){
                profile_image.setImageResource(R.mipmap.ic_launcher);
            } else {
                Glide.with(mContext).load(imageurl).into(profile_image);
            }
        }
    }
    @Override
    public int getItemViewType(int position) {
        fuser = FirebaseAuth.getInstance().getCurrentUser();
        if (mChat.get(position).getEnviado().equals(fuser.getUid())){
            return MSG_TYPE_RIGHT;
        } else {
            return MSG_TYPE_LEFT;
        }
    }

}
