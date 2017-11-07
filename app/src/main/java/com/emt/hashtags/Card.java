package com.emt.hashtags;

import android.content.Context;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mindorks.placeholderview.SwipePlaceHolderView;
import com.mindorks.placeholderview.annotations.Layout;
import com.mindorks.placeholderview.annotations.Resolve;
import com.mindorks.placeholderview.annotations.View;
import com.mindorks.placeholderview.annotations.swipe.SwipeCancelState;
import com.mindorks.placeholderview.annotations.swipe.SwipeIn;
import com.mindorks.placeholderview.annotations.swipe.SwipeInState;
import com.mindorks.placeholderview.annotations.swipe.SwipeOut;
import com.mindorks.placeholderview.annotations.swipe.SwipeOutState;

/**
 * Created by Mehdi on 28/10/2017.
 */

@Layout(R.layout.card)
public class Card {

    @View(R.id.profileImageView)
    private ImageView profileImageView;

    @View(R.id.postImage)
    private ImageView postImageView;

    @View(R.id.nameTxt)
    private TextView nameTxt;

    @View(R.id.dateTxt)
    private TextView dateTxt;

    @View(R.id.contentTxt)
    private TextView contentTxt;

    private Profile mProfile;
    private Context mContext;
    private SwipePlaceHolderView mSwipeView;

    @View(R.id.img_bookmark_action)
    private ImageView bookmarkAction;


    public Card(Context context, Profile profile, SwipePlaceHolderView swipeView) {
        mContext = context;
        mProfile = profile;
        mSwipeView = swipeView;
    }

    @Resolve
    private void onResolved(){
        Glide.with(mContext).load(mProfile.getUser().getImageUrl()).into(profileImageView);
        Glide.with(mContext).load(mProfile.getImage()).into(postImageView);
        nameTxt.setText(mProfile.getUser().getName());
        dateTxt.setText(mProfile.getDate());
        contentTxt.setText(mProfile.getContent());
        if(mProfile.isSaved()){
            bookmarkAction.setImageResource(R.drawable.ic_bookmark_black_24dp);
        }else{
            bookmarkAction.setImageResource(R.drawable.ic_bookmark_border_black_24dp);
        }
    }

    @SwipeOut
    private void onSwipedOut(){
        Log.d("EVENT", "onSwipedOut");
        mSwipeView.addView(this);
    }

    @SwipeCancelState
    private void onSwipeCancelState(){
        Log.d("EVENT", "onSwipeCancelState");
    }

    @SwipeIn
    private void onSwipeIn(){
        Log.d("EVENT", "onSwipedIn");
    }

    @SwipeInState
    private void onSwipeInState(){
        Log.d("EVENT", "onSwipeInState");
    }

    @SwipeOutState
    private void onSwipeOutState(){
        Log.d("EVENT", "onSwipeOutState");
    }
}