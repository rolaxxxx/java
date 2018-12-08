package com.SimpsonsSoundboard213.rolandas.simpsonssoundboard;
import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.airpush.AirPush;
import com.airpush.injector.internal.IAirPushAdListener;
import com.airpush.injector.internal.IAirPushPreparedAd;
import com.airpush.injector.internal.ads.AirPushBannerView;
import com.airpush.injector.internal.ads.AirPushInterstitial;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.inmobi.ads.InMobiAdRequestStatus;
import com.inmobi.ads.InMobiInterstitial;

import java.util.Map;

public class MainActivity extends AppCompatActivity {
    Button bt, bt2, bt3, bt5, bt6, bt7, bt8, bt9, bt10,bt11,bt12, bt13, bt14, bt15, bt16,bt17,bt18, bt19,bt20;
    FloatingActionButton bt4;
    private MediaPlayer mp;
    boolean mCanShowAd;
    private InterstitialAd mInterstitialAd;
    private AdView mAdView;
    Context ctx;
    int index=0;
    int [] A=new int [10];
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((AirPushBannerView)findViewById(R.id.container)).show();

        AirPush.init(this, "1523972859310808298L", "390504");
        final AirPushInterstitial interstitial=new AirPushInterstitial(MainActivity.this);
        bt = (Button)findViewById(R.id.doup);
        bt.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                index++;
                if (mp != null) {
                    mp.stop();
                    mp.release();
                    mp = null;
                }
                if(index==10)
                {index = 0;
                    interstitial.setEventsListener(new IAirPushAdListener() {
                        @Override
                        public void onLoad(IAirPushPreparedAd ad) {
                            ad.show();
                        }

                        @Override
                        public void onError(Exception e) {

                        }
                    });
                    interstitial.load();
                }
                mp = MediaPlayer.create(MainActivity.this, R.raw.doup);

                mp.start();

            }
        });


        bt2 = (Button)findViewById(R.id.flander1);
        bt2.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                index++;
                if (mp != null) {
                    mp.stop();
                    mp.release();
                    mp = null;
                }
                Log.d("tag", "indexas dabar yra " + index);
                 mp = MediaPlayer.create(MainActivity.this, R.raw.ned1);

                mp.start();
                if(index==10)
                {index = 0;
                    interstitial.setEventsListener(new IAirPushAdListener() {
                        @Override
                        public void onLoad(IAirPushPreparedAd ad) {
                            ad.show();
                        }

                        @Override
                        public void onError(Exception e) {

                        }
                    });
                    interstitial.load();
                }

            }
        });


        bt3 = (Button)findViewById(R.id.marge3);
        bt3.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                index++;
                if (mp != null) {
                    mp.stop();
                    mp.release();
                    mp = null;
                }
                 mp = MediaPlayer.create(MainActivity.this, R.raw.marge1);

                    mp.start();
                if(index==10)
                {index = 0;
                    interstitial.setEventsListener(new IAirPushAdListener() {
                        @Override
                        public void onLoad(IAirPushPreparedAd ad) {
                            ad.show();
                        }

                        @Override
                        public void onError(Exception e) {

                        }
                    });
                    interstitial.load();
                }

                }


        });

        bt4 = (FloatingActionButton)findViewById(R.id.stop);
        bt4.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                if (mp != null) {
                    mp.stop();
                    mp.release();
                    mp = null;
                }
            }
        });

        bt5 = (Button)findViewById(R.id.apu1);
        bt5.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                index++;
                if (mp != null) {
                    mp.stop();
                    mp.release();
                    mp = null;
                }
                mp = MediaPlayer.create(MainActivity.this, R.raw.apu1);

                mp.start();
                if(index==10)
                {index = 0;
                    interstitial.setEventsListener(new IAirPushAdListener() {
                        @Override
                        public void onLoad(IAirPushPreparedAd ad) {
                            ad.show();
                        }

                        @Override
                        public void onError(Exception e) {

                        }
                    });
                    interstitial.load();
                }

            }


        });

        bt6 = (Button)findViewById(R.id.marge1);
        bt6.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                index++;
                if (mp != null) {
                    mp.stop();
                    mp.release();
                    mp = null;
                }
                mp = MediaPlayer.create(MainActivity.this, R.raw.nelson1);

                mp.start();
                if(index==10)
                {index = 0;
                    interstitial.setEventsListener(new IAirPushAdListener() {
                        @Override
                        public void onLoad(IAirPushPreparedAd ad) {
                            ad.show();
                        }

                        @Override
                        public void onError(Exception e) {

                        }
                    });
                    interstitial.load();
                }

            }


        });

        bt7 = (Button)findViewById(R.id.marge4);
        bt7.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                index++;
                if (mp != null) {
                    mp.stop();
                    mp.release();
                    mp = null;
                }
                mp = MediaPlayer.create(MainActivity.this, R.raw.mrburns1);

                mp.start();
                if(index==10)
                {index = 0;
                    interstitial.setEventsListener(new IAirPushAdListener() {
                        @Override
                        public void onLoad(IAirPushPreparedAd ad) {
                            ad.show();
                        }

                        @Override
                        public void onError(Exception e) {

                        }
                    });
                    interstitial.load();
                }

            }


        });

        bt8 = (Button)findViewById(R.id.marge5);
        bt8.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                index++;
                if (mp != null) {
                    mp.stop();
                    mp.release();
                    mp = null;
                }
                mp = MediaPlayer.create(MainActivity.this, R.raw.smithers1);

                mp.start();

                if(index==10)
                {index = 0;
                    interstitial.setEventsListener(new IAirPushAdListener() {
                        @Override
                        public void onLoad(IAirPushPreparedAd ad) {
                            ad.show();
                        }

                        @Override
                        public void onError(Exception e) {

                        }
                    });
                    interstitial.load();
                }
            }


        });

        bt9 = (Button)findViewById(R.id.marge6);
        bt9.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                index++;
                if (mp != null) {
                    mp.stop();
                    mp.release();
                    mp = null;
                }
                mp = MediaPlayer.create(MainActivity.this, R.raw.dumbsvilehomer);

                mp.start();
                if(index==10)
                {index = 0;
                    interstitial.setEventsListener(new IAirPushAdListener() {
                        @Override
                        public void onLoad(IAirPushPreparedAd ad) {
                            ad.show();
                        }

                        @Override
                        public void onError(Exception e) {

                        }
                    });
                    interstitial.load();
                }

            }


        });

        bt10 = (Button)findViewById(R.id.marge7);
        bt10.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                index++;
                if (mp != null) {
                    mp.stop();
                    mp.release();
                    mp = null;
                }
                mp = MediaPlayer.create(MainActivity.this, R.raw.apuparty);

                mp.start();
                if(index==10)
                {index = 0;
                    interstitial.setEventsListener(new IAirPushAdListener() {
                        @Override
                        public void onLoad(IAirPushPreparedAd ad) {
                            ad.show();
                        }

                        @Override
                        public void onError(Exception e) {

                        }
                    });
                    interstitial.load();
                }

            }


        });

        bt11 = (Button)findViewById(R.id.marge8);
        bt11.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                index++;
                if (mp != null) {
                    mp.stop();
                    mp.release();
                    mp = null;
                }
                mp = MediaPlayer.create(MainActivity.this, R.raw.homernobeer);

                mp.start();
                if(index==10)
                {index = 0;
                    interstitial.setEventsListener(new IAirPushAdListener() {
                        @Override
                        public void onLoad(IAirPushPreparedAd ad) {
                            ad.show();
                        }

                        @Override
                        public void onError(Exception e) {

                        }
                    });
                    interstitial.load();
                }

            }


        });

        bt12 = (Button)findViewById(R.id.marge9);
        bt12.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                index++;
                if (mp != null) {
                    mp.stop();
                    mp.release();
                    mp = null;
                }
                mp = MediaPlayer.create(MainActivity.this, R.raw.homersticks);

                mp.start();
                if(index==10)
                {index = 0;
                    interstitial.setEventsListener(new IAirPushAdListener() {
                        @Override
                        public void onLoad(IAirPushPreparedAd ad) {
                            ad.show();
                        }

                        @Override
                        public void onError(Exception e) {

                        }
                    });
                    interstitial.load();
                }

            }


        });

        bt13 = (Button)findViewById(R.id.marge10);
        bt13.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                index++;
                if (mp != null) {
                    mp.stop();
                    mp.release();
                    mp = null;
                }
                mp = MediaPlayer.create(MainActivity.this, R.raw.homercrime);

                mp.start();
                if(index==10)
                {index = 0;
                    interstitial.setEventsListener(new IAirPushAdListener() {
                        @Override
                        public void onLoad(IAirPushPreparedAd ad) {
                            ad.show();
                        }

                        @Override
                        public void onError(Exception e) {

                        }
                    });
                    interstitial.load();
                }

            }
        });
        bt14 = (Button)findViewById(R.id.marge11);
        bt14.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                index++;
                if (mp != null) {
                    mp.stop();
                    mp.release();
                    mp = null;
                }
                mp = MediaPlayer.create(MainActivity.this, R.raw.mmmcandy);

                mp.start();
                if(index==10)
                {index = 0;
                    interstitial.setEventsListener(new IAirPushAdListener() {
                        @Override
                        public void onLoad(IAirPushPreparedAd ad) {
                            ad.show();
                        }

                        @Override
                        public void onError(Exception e) {

                        }
                    });
                    interstitial.load();
                }

            }


        });
        bt15 = (Button)findViewById(R.id.marge12);
        bt15.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                index++;
                if (mp != null) {
                    mp.stop();
                    mp.release();
                    mp = null;
                }
                mp = MediaPlayer.create(MainActivity.this, R.raw.mmmforbidendonat);

                mp.start();
                if(index==10)
                {index = 0;
                    interstitial.setEventsListener(new IAirPushAdListener() {
                        @Override
                        public void onLoad(IAirPushPreparedAd ad) {
                            ad.show();
                        }

                        @Override
                        public void onError(Exception e) {

                        }
                    });
                    interstitial.load();
                }

            }


        });
        bt16 = (Button)findViewById(R.id.marge13);
        bt16.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                index++;
                if (mp != null) {
                    mp.stop();
                    mp.release();
                    mp = null;
                }
                mp = MediaPlayer.create(MainActivity.this, R.raw.mmmmarge);

                mp.start();
                if(index==10)
                {index = 0;
                    interstitial.setEventsListener(new IAirPushAdListener() {
                        @Override
                        public void onLoad(IAirPushPreparedAd ad) {
                            ad.show();
                        }

                        @Override
                        public void onError(Exception e) {

                        }
                    });
                    interstitial.load();
                }

            }


        });
        bt17 = (Button)findViewById(R.id.marge14);
        bt17.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                index++;
                if (mp != null) {
                    mp.stop();
                    mp.release();
                    mp = null;
                }
                mp = MediaPlayer.create(MainActivity.this, R.raw.bartprank1);

                mp.start();
                if(index==10)
                {index = 0;
                    interstitial.setEventsListener(new IAirPushAdListener() {
                        @Override
                        public void onLoad(IAirPushPreparedAd ad) {
                            ad.show();
                        }

                        @Override
                        public void onError(Exception e) {

                        }
                    });
                    interstitial.load();
                }

            }


        });
        bt18 = (Button)findViewById(R.id.marge15);
        bt18.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                index++;
                if (mp != null) {
                    mp.stop();
                    mp.release();
                    mp = null;
                }
                mp = MediaPlayer.create(MainActivity.this, R.raw.bartprank2);

                mp.start();
                if(index==10)
                {index = 0;
                    interstitial.setEventsListener(new IAirPushAdListener() {
                        @Override
                        public void onLoad(IAirPushPreparedAd ad) {
                            ad.show();
                        }

                        @Override
                        public void onError(Exception e) {

                        }
                    });
                    interstitial.load();
                }

            }


        });
        bt19 = (Button)findViewById(R.id.marge17);
        bt19.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                index++;
                if (mp != null) {
                    mp.stop();
                    mp.release();
                    mp = null;
                }
                mp = MediaPlayer.create(MainActivity.this, R.raw.bartprank3);

                mp.start();
                if(index==10)
                {index = 0;
                    interstitial.setEventsListener(new IAirPushAdListener() {
                        @Override
                        public void onLoad(IAirPushPreparedAd ad) {
                            ad.show();
                        }

                        @Override
                        public void onError(Exception e) {

                        }
                    });
                    interstitial.load();
                }

            }


        });
        bt20 = (Button)findViewById(R.id.marge18);
        bt20.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                index++;
                if (mp != null) {
                    mp.stop();
                    mp.release();
                    mp = null;
                }
                mp = MediaPlayer.create(MainActivity.this, R.raw.bartprank4);

                mp.start();
                if(index==10)
                {index = 0;
                    interstitial.setEventsListener(new IAirPushAdListener() {
                        @Override
                        public void onLoad(IAirPushPreparedAd ad) {
                            ad.show();
                        }

                        @Override
                        public void onError(Exception e) {

                        }
                    });
                    interstitial.load();
                }

            }


        });


    }

}
