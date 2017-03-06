package org.jafafe.feeds.core;

import java.nio.file.Paths;

/**
 * Created by ricamarq on 05-03-2017.
 */
public class InsertFeedsFromOpmlTest {

    private InsertFeedsFromOpml insertFeedsFromOpml;

    @org.junit.Before
    public void setUp() throws Exception {

    }

    @org.junit.After
    public void tearDown() throws Exception {

    }

    @org.junit.Test(expected = ExceptionOpmlRead.class)
    public void read_empty_opml_exception() throws Exception {
        insertFeedsFromOpml = new InsertFeedsFromOpml();
        insertFeedsFromOpml.read( Paths.get( this.getClass().getResource("/opml_empty.opml").toURI().getPath() ) );
    }

    @org.junit.Test
    public void insert() throws Exception {

    }

}