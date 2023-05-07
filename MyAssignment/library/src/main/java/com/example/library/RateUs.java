package com.example.library;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

import com.google.android.material.button.MaterialButton;

public class RateUs implements Strings {

    private static float userRating = 0;

    public static void Rate(
            final Activity activity, final int color/*, CallBack_Rating callBack_rating*/)
    {
        Rate(activity,"","","","","","",
                color/*, callBack_rating */);
    }

    public static void Rate(
            final Activity activity, final String title, final String secondTitle, final String rateUsText,
            final String clickHerText, final String maybeLaterText, final String thanksForFeedbackText,
            final int mainColor/*, CallBack_Rating callBack_userRating*/)
    {
        //initial the dialog text

        final String mainTitle = (title != null && !title.equals("")) ? title: DEFAULT_TITLE;
        final String secondT = (secondTitle != null && !secondTitle.equals("")) ? secondTitle: DEFAULT_SECOND_TITLE;
        final String rateUs = (rateUsText != null && !rateUsText.equals("")) ? rateUsText: DEFAULT_RATING_BTN;
       // final String clickHere = (clickHerText != null && !clickHerText.equals("")) ? clickHerText: DEFAULT_CLICK_HERE_BTN;
        final String mayBeLater = (maybeLaterText != null && !maybeLaterText.equals("")) ? maybeLaterText: DEFAULT_MAYBE_LATER_BTN;
        final String thankYou = (thanksForFeedbackText != null && !thanksForFeedbackText.equals("")) ? thanksForFeedbackText: DEFAULT_THANKS_FOR_RATING_US;


        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(activity);
        LayoutInflater inflater = activity.getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.rate_us_dialog, null);
        dialogBuilder.setView(dialogView);
        final AlertDialog alertDialog = dialogBuilder.create();
        alertDialog.setCancelable(false);
        alertDialog.setCanceledOnTouchOutside(false);


       // final RelativeLayout back_LAY = dialogView.findViewById(R.id.back_LAY);
        final Button rate_now_BTN = dialogView.findViewById(R.id.rate_now_BTN);
        final Button maybe_later_BTN = dialogView.findViewById(R.id.maybe_later_BTN);
        //final Button alert_BTN_stop = dialogView.findViewById(R.id.alert_BTN_stop);
        final TextView title_LBL = dialogView.findViewById(R.id.title_LBL);
        final TextView second_title_LBL = dialogView.findViewById(R.id.second_title_LBL);
        final RatingBar rating_bar_RB = dialogView.findViewById(R.id.rating_bar_RB);
        final View primary_color_VIEW = dialogView.findViewById(R.id.primary_color_VIEW);
        final ImageView emoji_IMG = dialogView.findViewById(R.id.emoji_IMG);


        if(mainColor != 0){
            primary_color_VIEW.setBackgroundColor(mainColor);
        }


        title_LBL.setText(mainTitle);
        second_title_LBL.setText(secondT);

        rate_now_BTN.setText(rateUs);
        maybe_later_BTN.setText(mayBeLater);

        rating_bar_RB.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean b) {

                if(rating <= 1){
                    emoji_IMG.setImageResource(R.drawable.one_stars_emoji);
                } else if (rating <= 2) {
                    emoji_IMG.setImageResource(R.drawable.two_stars_emoji);
                }else if (rating <= 3){
                    emoji_IMG.setImageResource(R.drawable.three_stars_emoji);
                } else if (rating <= 4) {
                    emoji_IMG.setImageResource(R.drawable.four_stars_emoji);
                } else if (rating <=5) {
                    emoji_IMG.setImageResource(R.drawable.five_stars_emoji);
                }

                userRating = rating;

                rate_now_BTN.setEnabled(true);
                rate_now_BTN.setText(userRating + "/5\n" + rateUs);
            }

        });


        maybe_later_BTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.dismiss();
            }
        });
        rate_now_BTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.dismiss();
                Toast.makeText(activity, thankYou, Toast.LENGTH_SHORT).show();

            }
        });

        alertDialog.show();

    }
}
