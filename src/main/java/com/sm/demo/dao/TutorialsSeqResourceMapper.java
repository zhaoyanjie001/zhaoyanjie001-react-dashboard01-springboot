package com.sm.demo.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.sm.demo.domain.TutorialsSeqResource;
import com.sm.demo.models.TutorialsQueryByIdReq;
public interface TutorialsSeqResourceMapper {
    
    public TutorialsSeqResource getTutorialsSeq();
    public TutorialsSeqResource updateTutorialsSeq(@Param("seq") int seq);
    
}