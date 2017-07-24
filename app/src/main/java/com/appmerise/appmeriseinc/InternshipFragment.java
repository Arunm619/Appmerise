
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
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class InternshipFragment extends Fragment {

WebView wv_Internship;
    public InternshipFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_internship, container, false);
        wv_Internship = (WebView) v.findViewById(R.id.webview_Internship);
        wv_Internship.loadUrl("http://appmerise.com/index.php/internships/");
        //http://appmerise.com/index.php/projects/
        wv_Internship.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);

        // Enable Javascript
        WebSettings webSettings = wv_Internship.getSettings();
        webSettings.setJavaScriptEnabled(true);

        // Force links and redirects to open in the WebView instead of in a browser

        wv_Internship.setWebViewClient(new WebViewClient());
wv_Internship.setWebViewClient(new WebViewClient(){
    @Override
    public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error){
        handler.proceed();
    }
});
        return v;
    }


}
