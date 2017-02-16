package com.pandawork.mapper;

import com.pandawork.common.entity.Word;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 留言对应的Mapper
 * Created by Taoyongpan on 2016/11/14.
 */
public interface WordMapper {
    /**
     * 新增留言
     * @param word
     * @return
     * @throws Exception
     */
    public void newWord(@Param("word") Word word)throws Exception;

    /**
     * 根据ID删除留言信息
     * @param wid
     * @return
     * @throws Exception
     */
    public Boolean delWord(@Param("wid") int wid)throws Exception;

    /**
     * 根据博客ID列出留言
     * @param bid
     * @return
     * @throws Exception
     */
    public List<Word> queryByBid(@Param("bid") int bid)throws Exception;
}
