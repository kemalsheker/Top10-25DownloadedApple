package com.blackstart.top10download;

import android.util.Log;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.StringReader;
import java.util.ArrayList;

public class ParseSongs {
    private static final String TAG = "ParseSongs";
    private ArrayList<FieldEntry> songs;

    public ParseSongs() {
        this.songs = new ArrayList<FieldEntry>();
    }

    public ArrayList<FieldEntry> getSongs() {
        return songs;
    }

    public boolean parse(String xmlValue){
        boolean status = true;
        FieldEntry currentSong = null;
        boolean inField = false;
        String textValue = "";

        try{
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(true);
            XmlPullParser xpp = factory.newPullParser();
            xpp.setInput(new StringReader(xmlValue));
            int eventType = xpp.getEventType();
            while(eventType != XmlPullParser.END_DOCUMENT){
                String tagName = xpp.getName();
                switch (eventType){
                    case XmlPullParser.START_TAG:
                        Log.d(TAG, "parse:  Starting TAG" + tagName);
                        if("entry".equalsIgnoreCase(tagName)){
                            inField = true;
                            currentSong = new FieldEntry();
                        }

                    case XmlPullParser.TEXT:
                        textValue = xpp.getText();
                        break;

                    case XmlPullParser.END_TAG:
                        Log.d(TAG, "parse:  Ending TAG");
                        if(inField){
                            if("entry".equalsIgnoreCase(tagName)){
                                songs.add(currentSong);
                                inField = false;
                            }
                            else if("title".equalsIgnoreCase(tagName)){
                                currentSong.setTitle(textValue);

                            }
                            else if("artist".equalsIgnoreCase(tagName)){
                                currentSong.setArtist(textValue);

                            }
                            else if("rights".equalsIgnoreCase(tagName)){
                                currentSong.setRights(textValue);

                            }
                            else if("releasedate".equalsIgnoreCase(tagName)){
                                currentSong.setReleaseDate(textValue);

                            }
                            else if("image".equalsIgnoreCase(tagName)){
                                if(textValue.contains("60x60")){
                                    currentSong.setImageURL(textValue);
                                }
                            }
                        }

                    default:
                        // Do nothing

                }
                eventType = xpp.next();
            }
            for(FieldEntry song:songs){
                Log.d(TAG, "parse: ***********");
                Log.d(TAG, "parse: " + song.toString());
            }

        } catch (Exception e){
            status = false;
            e.printStackTrace();
        }

        return status;
    }
}
