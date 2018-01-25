package cockatoo.enjizen.myapplicationtemplate.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerSupportFragment;

import cockatoo.enjizen.myapplicationtemplate.R;
import cockatoo.enjizen.myapplicationtemplate.constanst.Config;
import cockatoo.enjizen.myapplicationtemplate.util.LogUtil;
import cockatoo.enjizen.myapplicationtemplate.util.ToastUtil;

/**
 * A simple {@link Fragment} subclass.
 */
public class YoutubeFragment extends Fragment {

    public final static String VIDEO_KEY = "video key";

    public YoutubeFragment() {
        // Required empty public constructor
    }

    public static YoutubeFragment newInstance(String videoId){
        YoutubeFragment fragment= new YoutubeFragment();
        Bundle args = new Bundle();
        args.putString(VIDEO_KEY,videoId);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_youtube, container, false);

        YouTubePlayerSupportFragment youTubePlayerSupportFragment = YouTubePlayerSupportFragment.newInstance();

        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        transaction.add(R.id.youtube_fragment, youTubePlayerSupportFragment).commit();

        youTubePlayerSupportFragment.initialize(Config.YOUTUBE_API_KEY,
                new YouTubePlayer.OnInitializedListener() {
                    @Override
                    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean wasRestored) {
                        if (!wasRestored) {
                            youTubePlayer.setPlayerStyle(YouTubePlayer.PlayerStyle.DEFAULT);
                            youTubePlayer.loadVideo(getArguments().getString(VIDEO_KEY));
                            youTubePlayer.play();
                        }
                    }

                    @Override
                    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
                        // YouTube error
                        String errorMessage = youTubeInitializationResult.toString();
                        ToastUtil.getInstance().toastLong(getContext(),errorMessage);
                        LogUtil.getInstance().d("errorMessage:", errorMessage);
                    }
                });

        return view;
    }

}
