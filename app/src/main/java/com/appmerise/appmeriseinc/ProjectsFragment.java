
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
public class ProjectsFragment extends Fragment {

WebView wv_Projects;
    public ProjectsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
View v =inflater.inflate(R.layout.fragment_projects, container, false);
        wv_Projects = (WebView) v.findViewById(R.id.webview_Projects);
        wv_Projects.loadUrl("http://appmerise.com/index.php/projects/");
        //http://appmerise.com/index.php/projects/

        // Enable Javascript
        WebSettings webSettings = wv_Projects.getSettings();
        webSettings.setJavaScriptEnabled(true);
        wv_Projects.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);

        // Force links and redirects to open in the WebView instead of in a browser
       wv_Projects.setWebViewClient(new WebViewClient());
        wv_Projects.setWebViewClient(new WebViewClient(){

            @Override
            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error){
                handler.proceed();
            }
        });
        return v;
    }

}
