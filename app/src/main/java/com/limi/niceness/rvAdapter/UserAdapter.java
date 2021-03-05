package com.limi.niceness.rvAdapter;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.limi.niceness.MessageActivity;
import com.limi.niceness.R;
import com.limi.niceness.model.Chat;
import com.limi.niceness.model.User;

import java.util.ArrayList;

public class UserAdapter extends  RecyclerView.Adapter<UserAdapter.UserVH> {
    private Context mContext;
    private ArrayList<User> mUsers;
    private boolean ischat;

    String theLastMessage;

    public UserAdapter(Context mContext, ArrayList<User> mUsers, boolean ischat) {
        this.mContext = mContext;
        this.mUsers = mUsers;
        this.ischat = ischat;
    }

    @NonNull
    @Override
    public UserVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull UserVH holder, int position) {

        final User user = mUsers.get(position);
        holder.username.setText(user.getUsername());
        if (user.getImageURL().equals("default")){
            holder.img_perfil.setImageResource(R.mipmap.ic_launcher);
        } else {
            Glide.with(mContext).load(user.getImageURL()).into(holder.img_perfil);
        }

        if (ischat){
            ultimoMsg(user.getId(), holder.msg_ultimo);
        } else {
            holder.msg_ultimo.setVisibility(View.GONE);
        }

        if (ischat){
            if (user.getEstado().equals("online")){
                holder.img_on.setVisibility(View.VISIBLE);
                holder.img_off.setVisibility(View.GONE);
            } else {
                holder.img_on.setVisibility(View.GONE);
                holder.img_off.setVisibility(View.VISIBLE);
            }
        } else {
            holder.img_on.setVisibility(View.GONE);
            holder.img_off.setVisibility(View.GONE);
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, MessageActivity.class);
                intent.putExtra("userid", user.getId());
                mContext.startActivity(intent);
            }
        });
    }

    private void ultimoMsg(final String userId, final TextView msg_ultimo) {
        theLastMessage = "default";
        final FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Chats");

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()){
                    Chat chat = snapshot.getValue(Chat.class);
                    if (firebaseUser != null && chat != null) {
                        if (chat.getRecibido().equals(firebaseUser.getUid()) && chat.getEnviado().equals(userId) ||
                                chat.getRecibido().equals(userId) && chat.getEnviado().equals(firebaseUser.getUid())) {
                            theLastMessage = chat.getMessage();
                        }
                    }
                }

                switch (theLastMessage){
                    case  "default":
                        msg_ultimo.setText("No Message");
                        break;

                    default:
                        msg_ultimo.setText(theLastMessage);
                        break;
                }

                theLastMessage = "default";
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return mUsers.size();
    }
    public class UserVH extends RecyclerView.ViewHolder{

        public TextView username;
        public ImageView img_perfil;
        private ImageView img_on;
        private ImageView img_off;
        private TextView msg_ultimo;

        public UserVH(@NonNull View itemView) {
            super(itemView);

            username = itemView.findViewById(R.id.username);
            img_perfil = itemView.findViewById(R.id.profile_image);
            img_on = itemView.findViewById(R.id.img_on);
            img_off = itemView.findViewById(R.id.img_off);
            msg_ultimo = itemView.findViewById(R.id.last_msg);

        }

    }

}
