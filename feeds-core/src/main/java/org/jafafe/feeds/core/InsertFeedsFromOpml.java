package org.jafafe.feeds.core;

import com.rometools.opml.feed.opml.Opml;
import com.rometools.opml.feed.opml.Outline;
import com.rometools.rome.io.FeedException;
import com.rometools.rome.io.WireFeedInput;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ricamarq on 04-03-2017.
 */
public class InsertFeedsFromOpml implements InsertFeeds {

    private Map<String,List<String>> feedsList;

    @Override
    public void read(Path file) {

        WireFeedInput input = new WireFeedInput();
        try {
            Opml feed = (Opml) input.build( file.toFile() );
            List<Outline> outlines = feed.getOutlines();
            if( outlines.isEmpty() ) {
                throw new ExceptionOpmlRead("No feeds Found!");
            }

            feedsList = new HashMap<>();
            for (Outline outline : outlines) {
                List<Outline> children = outline.getChildren();
                List<String> feeds = new ArrayList<>();
                for (Outline child : children) {
                    feeds.add( child.getHtmlUrl() );
                }

                feedsList.put(outline.getTitle(),feeds);
            }

        } catch (IOException | FeedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insert() {

    }

}