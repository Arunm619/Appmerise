
/*
* Copyrights (R) Arun sudharsan 2017
* Developer name: Arun sudharsan
* Developed App: Appmerise Inc
* Date: 24/07/17
* */
package com.appmerise.appmeriseinc;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;


/**
 * A simple {@link Fragment} subclass.
 */
public class OffersFragment extends Fragment {
    int secretcode, randomNum, minimum, maximum;
    Button claim;
    Button copycode;
    TextView code;
    CardView Offerclaim;
    CardView offerclaimed;

    public OffersFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {


        View v = inflater.inflate(R.layout.fragment_offers, container, false);
        code = (TextView) v.findViewById(R.id.textcode);
        copycode = (Button) v.findViewById(R.id.btn_copycode);
        claim = (Button) v.findViewById(R.id.btn_offersActivity);
        Offerclaim = (CardView) v.findViewById(R.id.cv_offers);
        offerclaimed = (CardView) v.findViewById(R.id.cv_offersclaimed);

        offerclaimed.setVisibility(View.GONE);

        minimum = 10000;
        maximum = 50000;
        randomNum = minimum + (int) (Math.random() * maximum);
        secretcode = randomNum;
        SharedPreferences prefs = PreferenceManager
                .getDefaultSharedPreferences(getActivity());
        if (!prefs.getBoolean("firstTime", false)) {

            SharedPreferences.Editor editor = prefs.edit();
            editor.putBoolean("firstTime", true);
            editor.commit();



        copycode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClipboardManager clipboard = (ClipboardManager) getActivity().getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("the value", Integer.toString(secretcode));
                clipboard.setPrimaryClip(clip);
                Toast.makeText(getActivity(), "Successfully Copied to clipboard...", Toast.LENGTH_SHORT).show();
            }
        });


        claim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //startActivity(new Intent(this,OffersActivity));

                new AlertDialog.Builder(getActivity())
                        .setTitle("Want to Claim the code?")
                        .setMessage("Share the App with three of your friends...")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                for (int i = 0; i < 3; i++) {
                                    sharetowhatsapp();


                                }
                                offerclaimed.setVisibility(View.VISIBLE);
                                Offerclaim.setVisibility(View.GONE);


                            }
                        }).setNegativeButton("No", null).show();


            }
        });

        } else {
            offerclaimed.setVisibility(View.GONE);
            Offerclaim.setVisibility(View.VISIBLE);
claim.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Toast.makeText(getActivity(), "Already claimed! ", Toast.LENGTH_LONG).show();

    }
});


        }
        return v;
    }

    private void sharetowhatsapp() {
        PackageManager pm = getActivity().getPackageManager();
        try {
            PackageInfo info = pm.getPackageInfo("com.whatsapp",
                    PackageManager.GET_META_DATA);


            Intent sendIntent = new Intent();
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.putExtra(Intent.EXTRA_TEXT, "This is my text to send.");
            sendIntent.setType("text/plain");
            sendIntent.setPackage("com.whatsapp");
            startActivity(sendIntent);


        } catch (PackageManager.NameNotFoundException e) {
            Toast.makeText(getActivity(), "WhatsApp not Installed Die Bitch", Toast.LENGTH_SHORT)
                    .show();
        }

    }

}
