package jiguobin.example.com.oshipin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.squareup.picasso.Picasso;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

public class MainActivity extends AppCompatActivity {

    MyJCVideoPlayerStandard myJCVideoPlayerStandard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myJCVideoPlayerStandard = (MyJCVideoPlayerStandard) findViewById(R.id.jc_video);
        myJCVideoPlayerStandard.setUp("http://video.jiecao.fm/11/23/xu/%E5%A6%B9%E5%A6%B9.mp4"
                , JCVideoPlayerStandard.SCREEN_LAYOUT_NORMAL, "嫂子快长大");
        Picasso.with(this)
                .load("http://img4.jiecaojingxuan.com/2016/11/23/1bb2ebbe-140d-4e2e-abd2-9e7e564f71ac.png@!640_360")
                .into(myJCVideoPlayerStandard.thumbImageView);
    }

    @Override
    public void onBackPressed() {
        if (JCVideoPlayer.backPress()) {
            return;
        }
        super.onBackPressed();
    }

    @Override
    protected void onPause() {
        super.onPause();
        JCVideoPlayer.releaseAllVideos();
    }

    public void list(View view) {
        startActivity(new Intent(MainActivity.this,ListViewNormalActivity.class));
    }
}
