package com.example.HindiNews.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.example.HindiNews.R;
import com.example.HindiNews.WebViewController;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FoxNewsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SkyNewsFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SkyNewsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FoxNewsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FoxNewsFragment newInstance(String param1, String param2) {
        FoxNewsFragment fragment = new FoxNewsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_fox_news, container, false);

        WebView webView= view.findViewById(R.id.fox);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("https://www.amarujala.com/");
        webView.setWebViewClient(new WebViewController());

        webView.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if(event.getAction()== KeyEvent.ACTION_DOWN)
                    if(keyCode==KeyEvent.KEYCODE_BACK){
                        if(webView!=null){
                            if(webView.canGoBack()){
                                webView.goBack();
                            }
                            else{
                                getActivity().onBackPressed();
                            }
                        }
                    }


                return true;
            }
        });


        return view;
    }
}