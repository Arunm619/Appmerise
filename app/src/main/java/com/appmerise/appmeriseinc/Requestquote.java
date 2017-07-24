
/*
* Copyrights (R) Arun sudharsan 2017
* Developer name: Arun sudharsan
* Developed App: Appmerise Inc
* Date: 24/07/17
* */
package com.appmerise.appmeriseinc;


import android.net.http.SslError;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.SslErrorHandler;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;


/**
 * A simple {@link Fragment} subclass.
 */
public class Requestquote extends Fragment {

    WebView wvrq;

    public Requestquote() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,

                             Bundle savedInstanceState) {
      View v=inflater.inflate(R.layout.fragment_requestquote, container, false);

        wvrq = (WebView) v.findViewById(R.id.webview_Requestaquote);
        wvrq.loadUrl("http://appmerise.com/index.php/request-a-quote/");
        //http://appmerise.com/index.php/projects/

        // Enable Javascript
        WebSettings webSettings = wvrq.getSettings();
        webSettings.setJavaScriptEnabled(true);
        wvrq.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);

        // Force links and redirects to open in the WebView instead of in a browser
        wvrq.setWebViewClient(new WebViewClient());
        wvrq.setWebViewClient(new WebViewClient(){

            @Override
            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error){
                handler.proceed();
            }
        });


        // Inflate the layout for this fragment
        return v;
    }

}
