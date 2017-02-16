package com.pandawork.test;

import com.pandawork.service.WordService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Taoyongpan on 2016/11/15.
 */
public class WordServiceTest extends AbstractTestCase {
    @Autowired
    WordService wordService;
    @Test
    public void testQueryByBid()throws Exception{
        System.out.println(wordService.queryByBid(12));
    }
}
