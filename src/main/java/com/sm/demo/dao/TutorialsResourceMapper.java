package com.sm.demo.dao;

import com.sm.demo.domain.TutorialsResource;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
public interface TutorialsResourceMapper {
    public List<TutorialsResource> queryLearnResouceList(Map<String,Object> map);
    
    public TutorialsResource selectTutorialsById(@Param("id") int id);
    public TutorialsResource selectTutorialsByName(@Param("name") String name);
    
    public Integer updateDtoTutorialsById(@Param("id") String id,@Param("name") String name);
//    public TutorialsResource updateTutorialsByDto(@Param("tutorials") TutorialsResource tutorialsResource);
    
    public Integer deleteDtoTutorialsById(@Param("id") int id);
    public Integer insertDtoTutorialsById(@Param("id") int id,@Param("description") String description,@Param("published") int published,@Param("title") String title);
    
    
}