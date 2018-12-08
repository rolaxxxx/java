package com.delta.activities;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.net.Uri;
import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class FirstActivity extends Activity {

    int id;


    Map cards= new HashMap();
    Map combs=new HashMap();
    Deck deck=new Deck();
    Players players=new Players();
    Flop flop=new Flop();

    HandChecker h1=new HandChecker();
    int check=0;

    int check2=-5;
    int []hands= new int[6];
    int []ishand= new int [6];
    ImageView [] t1= new ImageView[9];
    ArrayList<Integer> x = new ArrayList<Integer>();
   private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
    }
    public void Mainmenu(View v){
        Intent tutorialPage = new Intent (this, SecondActivity.class);
        startActivity(tutorialPage);
    }
    public int counterp(String A[], String  B)
    {

        int counter=0;
        for(int i=4;i<9;i++)
        {
            Log.d("tagas, "  + B," "+ A[i] );

            if(B == A[i])
            {
                counter++;
            }

        }
        return counter;
    }
    public void onClickBtn(View v) {
        TextView th= (TextView) findViewById(R.id.winner);
        cards.put("2C", "c2_of_clubs");
        cards.put("2D", "c2_of_diamonds");
        cards.put("2H", "c2_of_hearts");
        cards.put("2S", "c2_of_spades");

        cards.put("3C", "c3_of_clubs");
        cards.put("3D", "c3_of_diamonds");
        cards.put("3H", "c3_of_clubs");
        cards.put("3S", "c3_of_spades");

        cards.put("4C", "c4_of_clubs");
        cards.put("4D", "c4_of_diamonds");
        cards.put("4H", "c4_of_hearts");
        cards.put("4S", "c4_of_spades");

        cards.put("5C", "c5_of_clubs");
        cards.put("5D", "c5_of_diamonds");
        cards.put("5H", "c5_of_hearts");
        cards.put("5S", "c5_of_spades");

        cards.put("6C", "c6_of_clubs");
        cards.put("6D", "c6_of_diamonds");
        cards.put("6H", "c6_of_hearts");
        cards.put("6S", "c6_of_spades");

        cards.put("7C", "c7_of_clubs");
        cards.put("7D", "c7_of_diamonds");
        cards.put("7H", "c7_of_hearts");
        cards.put("7S", "c7_of_spades");

        cards.put("8C", "c8_of_clubs");
        cards.put("8D", "c8_of_diamonds");
        cards.put("8H", "c8_of_hearts");
        cards.put("8S", "c8_of_spades");

        cards.put("9C", "c9_of_clubs");
        cards.put("9D", "c9_of_diamonds");
        cards.put("9H", "c9_of_hearts");
        cards.put("9S", "c9_of_spades");

        cards.put("TC", "c10_of_clubs");
        cards.put("TD", "c10_of_diamonds");
        cards.put("TH", "c10_of_hearts");
        cards.put("TS", "c10_of_spades");

        cards.put("JC", "jack_of_clubs");
        cards.put("JD", "jack_of_diamonds");
        cards.put("JH", "jack_of_hearts");
        cards.put("JS", "jack_of_spades");

        cards.put("QC", "queen_of_clubs");
        cards.put("QD", "queen_of_diamonds");
        cards.put("QH", "queen_of_hearts");
        cards.put("QS", "queen_of_spades");

        cards.put("KC", "king_of_clubs");
        cards.put("KD", "king_of_diamonds");
        cards.put("KH", "king_of_hearts");
        cards.put("KS", "king_of_spades");

        cards.put("AC", "ace_of_clubs");
        cards.put("AD", "ace_of_diamonds");
        cards.put("AH", "ace_of_hearts");
        cards.put("AS", "ace_of_spades");

        combs.put("20", "four of a kind");
        combs.put("19", "full house");
        combs.put("16", "flush");
        combs.put("13", "three of a kind");
        combs.put("10", "one pair");
        combs.put("0", "no hand");

        if (check == 0) {
            for (int i = 0; i < 52; i++) {
                deck.deckFaces[i] = deck.faces[i % 13];
                deck.deckSuits[i] = deck.suits[i / 13];
                // cout << deck.deckOfCardsfaces[i] << deck.deckOfCardsSuits[i] << endl;

            }

            for (int i = 0; i < 52; i++) {
                x.add(i);
            }
            check++;
        }


            if(check2==-5) {
                Collections.shuffle(x);

                for (int i = 0; i < 4; i++) {
                    players.playerCardsFaces[i] = deck.deckFaces[x.get(i)];
                    players.playerCardsSuits[i] = deck.deckSuits[x.get(i)];
                }
                int index55 = 4;
                for (int i = 4; i < index55 + 5; i++) {
                    flop.flopCardsFaces[i] = deck.deckFaces[x.get(i)];
                    flop.flopCardsSuits[i] = deck.deckSuits[x.get(i)];
                    //  cout << flop.flopfaces[i] << flop.flopsuits[i]<< "  ";
                }





                for (int i = 0; i < 4; i++) {
                    players.wholeCardsplayers[i] = players.playerCardsFaces[i] + players.playerCardsSuits[i];
                }
                for (int i = 4; i < index55 + 5; i++) {
                    flop.wholeCard[i] = flop.flopCardsFaces[i] + flop.flopCardsSuits[i];
                }


                t1[0] = (ImageView) findViewById(R.id.imageView22);
                id = getResources().getIdentifier("com.delta.activities:drawable/" + cards.get(players.wholeCardsplayers[0]), null, null);
                t1[0].setImageResource(id);


                t1[1] = (ImageView) findViewById(R.id.imageView23);
                id = getResources().getIdentifier("com.delta.activities:drawable/" + cards.get(players.wholeCardsplayers[1]), null, null);
                t1[1].setImageResource(id);




                // check2++;

            }
            if(check2==-4) {
                t1[4] = (ImageView) findViewById(R.id.imageView9);
                id = getResources().getIdentifier("com.delta.activities:drawable/" + cards.get(flop.wholeCard[4]), null, null);
                t1[4].setImageResource(id);

                t1[5] = (ImageView) findViewById(R.id.imageView12);
                id = getResources().getIdentifier("com.delta.activities:drawable/" + cards.get(flop.wholeCard[5]), null, null);
                t1[5].setImageResource(id);

                t1[6] = (ImageView) findViewById(R.id.imageView13);
                id = getResources().getIdentifier("com.delta.activities:drawable/" + cards.get(flop.wholeCard[6]), null, null);
                t1[6].setImageResource(id);

            }

            if(check2==-3) {
                t1[7] = (ImageView) findViewById(R.id.imageView14);
                id = getResources().getIdentifier("com.delta.activities:drawable/" + cards.get(flop.wholeCard[7]), null, null);
                t1[7].setImageResource(id);
            }



                if(check2==-2) {
                    t1[8] = (ImageView) findViewById(R.id.imageView15);
                    id = getResources().getIdentifier("com.delta.activities:drawable/" + cards.get(flop.wholeCard[8]), null, null);
                    t1[8].setImageResource(id);
                }
                if(check2==-1)
                {
                    t1[2] = (ImageView) findViewById(R.id.imageView24);
                    id = getResources().getIdentifier("com.delta.activities:drawable/" + cards.get(players.wholeCardsplayers[2]), null, null);
                    t1[2].setImageResource(id);


                    t1[3] = (ImageView) findViewById(R.id.imageView25);
                    id = getResources().getIdentifier("com.delta.activities:drawable/" + cards.get(players.wholeCardsplayers[3]), null, null);
                    t1[3].setImageResource(id);
                }
                if(check2==0)
                {
                    Arrays.fill(hands, 0);
                    Arrays.fill(ishand, 0);
                    int counter=0;
                    int counter2=0;
                    for(int i=0;i<4;i+=2)
                    {
                        if(players.playerCardsFaces[i]==players.playerCardsFaces[i+1]&&ishand[i]==0)
                        {
                           // Log.d("lolo "+ players.playerCardsFaces[i], );
                            counter= counterp(flop.flopCardsFaces, players.playerCardsFaces[i]);
                            counter+=2;

                            if(counter==4)
                            {
                                hands[i]=20;
                                ishand[i]=1;
                            }

                        }
                        else if(players.playerCardsFaces[i]!=players.playerCardsFaces[i+1]&&ishand[i]==0)
                        {
                            counter= counterp(flop.flopCardsFaces, players.playerCardsFaces[i]);
                            counter2= counterp(flop.flopCardsFaces, players.playerCardsFaces[i+1]);
                            counter++;
                            counter2++;
                            if(counter==4||counter2==4)
                            {
                                hands[i]=20;

                                ishand[i]=1;
                            }

                        }
                        if(players.playerCardsFaces[i]==players.playerCardsFaces[i+1]&&ishand[i]==0)
                        {
                            counter= counterp(flop.flopCardsFaces, players.playerCardsFaces[i]);
                            counter+=1;

                            int fh=0;

                            if(counter==3)
                            {
                                for(int x=4;x<9;x++)
                                {
                                    for (int k=4;k<9;k++)
                                    {
                                        counter2=counterp(flop.flopCardsFaces,flop.flopCardsFaces[k]);
                                        if (counter2==2&&flop.flopCardsFaces[k]!=players.playerCardsFaces[i])
                                        {
                                            fh=1;
                                            break;
                                        }
                                    }
                                }
                            }
                            else if (fh==0)
                            {
                                counter= counterp(flop.flopCardsFaces, players.playerCardsFaces[i]);
                                counter+=2;
                                for(int x=4;x<9;x++)
                                {
                                    for(int k=4;k<9;k++)
                                    {
                                        counter2=counterp(flop.flopCardsFaces,flop.flopCardsFaces[k]);
                                        if (counter2==3&&flop.flopCardsFaces[k]!=players.playerCardsFaces[i])
                                        {
                                            fh=1;
                                            break;
                                        }
                                    }
                                }
                            }
                            if(fh==1)
                            {

                                hands[i]=19;
                                ishand[i]=1;
                            }

                        }
                        /*else if(players.playerCardsFaces[i]!=players.playerCardsFaces[i+1]&&ishand[i]==0)
                        {
                            counter= counterp(flop.flopCardsFaces, players.playerCardsFaces[i]);
                            counter2= counterp(flop.flopCardsFaces, players.playerCardsFaces[i+1]);
                            counter++;
                            counter2++;
                            if(counter==4||counter2==4)
                            {
                                hands[i]=19;
                                ishand[i]=1;
                            }
                        }
                        */
                        if(players.playerCardsSuits[i]==players.playerCardsSuits[i+1]&&ishand[i]==0)
                        {

                            counter= counterp(flop.flopCardsSuits, players.playerCardsSuits[i]);
                            counter+=2;
                            // Log.d("counter",Integer.toString(counter));

                            if(counter==5)
                            {
                                hands[i]=16;

                                ishand[i]=1;
                            }

                        }
                        else if(players.playerCardsSuits[i]!=players.playerCardsSuits[i+1]&&ishand[i]==0)
                        {
                            counter= counterp(flop.flopCardsSuits, players.playerCardsSuits[i]);
                            counter2= counterp(flop.flopCardsSuits, players.playerCardsSuits[i+1]);
                            counter++;
                            counter2++;
                            //Log.d("counter",Integer.toString(counter));
                            if(counter==5||counter2==5)
                            {
                                hands[i]=16;

                                ishand[i]=1;
                            }

                        }
                        if(players.playerCardsFaces[i]==players.playerCardsFaces[i+1]&&ishand[i]==0)
                        {

                            counter= counterp(flop.flopCardsFaces, players.playerCardsFaces[i]);
                            counter+=2;
                           // Log.d("counter",Integer.toString(counter));

                            if(counter==3)
                            {
                                hands[i]=13;

                                ishand[i]=1;
                            }

                        }
                        else if(players.playerCardsFaces[i]!=players.playerCardsFaces[i+1]&&ishand[i]==0)
                        {
                            counter= counterp(flop.flopCardsFaces, players.playerCardsFaces[i]);
                            counter2= counterp(flop.flopCardsFaces, players.playerCardsFaces[i+1]);
                            counter++;
                            counter2++;
                            //Log.d("counter",Integer.toString(counter));
                            if(counter==3||counter2==3)
                            {
                                hands[i]=13;

                                ishand[i]=1;
                            }

                        }
                        if(players.playerCardsFaces[i]==players.playerCardsFaces[i+1]&&ishand[i]==0)
                        {


                            counter+=2;
                            // Log.d("counter",Integer.toString(counter));

                            if(counter==2)
                            {
                                hands[i]=10;

                                ishand[i]=1;
                            }

                        }
                        else if(players.playerCardsFaces[i]!=players.playerCardsFaces[i+1]&&ishand[i]==0)
                        {
                            counter= counterp(flop.flopCardsFaces, players.playerCardsFaces[i]);
                            counter2= counterp(flop.flopCardsFaces, players.playerCardsFaces[i+1]);
                            counter++;
                            counter2++;
                            //Log.d("counter",Integer.toString(counter));
                            if(counter==2||counter2==2)
                            {
                                hands[i]=10;

                                ishand[i]=1;
                            }

                        }



                    }

                    if(hands[0]>hands[2])
                    {
                        th.setText("player 1 wins with " + combs.get(Integer.toString(hands[0])));
                    }
                    else if (hands[0]<hands[2])
                    {
                        th.setText("player 2 wins with " + combs.get(Integer.toString(hands[2])));
                    }
                    else if(hands[0]==hands[2])
                    {
                        th.setText("both players have  " + combs.get(Integer.toString(hands[0])));
                    }


                }
                if(check2==1) {
                    id = getResources().getIdentifier("com.delta.activities:drawable/placeholder123" , null, null);
                    for (int i = 0; i < 9; i++) {
                        t1[i].setImageResource(id);
                    }
                    th.setText("");
                    check2=-6;
                }
        check2++;



    }





    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.first, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
