package com.pandawork.service;

import com.pandawork.common.entity.Word;
import com.pandawork.core.common.exception.SSException;

import java.util.List;

/**
 * 留言功能对应的service层
 * Created by Taoyongpan on 2016/11/14.
 */
public interface WordService {
    /**
     * 增加留言信息
     * @param word
     * @throws SSException
     */
    public void newWord(Word word)throws SSException;

    /**
     * 删除留言信息
     * @param wid
     * @return
     * @throws SSException
     */
    public Boolean delWord(int wid)throws SSException;

    /**
     * 根据博客ID列出留言信息
     * @param bid
     * @return
     * @throws SSException
     */
    public List<Word> queryByBid(int bid)throws SSException;
}
