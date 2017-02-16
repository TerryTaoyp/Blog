package com.pandawork.service.impl;

import com.pandawork.common.entity.Word;
import com.pandawork.common.utils.NFException;
import com.pandawork.core.common.exception.SSException;
import com.pandawork.core.common.log.LogClerk;
import com.pandawork.core.common.util.Assert;
import com.pandawork.core.framework.dao.CommonDao;
import com.pandawork.mapper.WordMapper;
import com.pandawork.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 留言信息的service实现层
 * Created by Taoyongpan on 2016/11/14.
 */
@Service("wordService")
public class WordServiceImpl implements WordService {
    @Autowired
    WordMapper wordMapper;
    @Autowired
    protected CommonDao commonDao;


    /**
     *留言增加
     * @param word
     * @throws SSException
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {SSException.class, Exception.class, RuntimeException.class})
    public void newWord(Word word)throws SSException{
        if(Assert.isNull(word)){
            return;
        }
        Assert.lessOrEqualZero(word.getBid(), NFException.UpwdNotNull);
        Assert.isNotNull(word.getUname(),NFException.UpwdNotNull);
        Assert.isNotNull(word.getWcontant(),NFException.UpwdNotNull);
        try{
            wordMapper.newWord(word);
        }catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(NFException.SystemException, e);
        }
    }

    /**
     * 根据ID删除留言
     * @param wid
     * @return
     * @throws SSException
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {SSException.class, Exception.class, RuntimeException.class})
    public Boolean delWord(int wid)throws SSException{
        if (Assert.lessOrEqualZero(wid))
        {
            return false;
        }
        try{
            return wordMapper.delWord(wid);
        }catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(NFException.SystemException, e);
        }
    }

    /**
     * 根据博客ID列出留言信息
     * @param bid
     * @return
     * @throws SSException
     */
    @Override
    public List<Word> queryByBid(int bid)throws SSException{
        if(Assert.lessOrEqualZero(bid))
        {
            return null;
        }
        try{
            return wordMapper.queryByBid(bid);
        }catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(NFException.SystemException, e);
        }
    }
}
