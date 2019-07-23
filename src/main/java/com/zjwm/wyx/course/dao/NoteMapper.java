package com.zjwm.wyx.course.dao;

import com.zjwm.wyx.course.entity.Note;
import com.zjwm.wyx.utils.BaseDao;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 职位
 * 
 * @author czx
 * @email object_czx@163.com
 * @date 2017-10-23 21:23:54
 */
@Mapper
public interface NoteMapper extends BaseDao<Note> {
	//用户所有笔记
	List<Note> queryNotesByUid(@Param("uid") Integer uid);
	//用户每个课程的所有笔记
	List<Note> queryNotesByUidAndCid(@Param("uid") Integer uid, @Param("clid") Integer cid);
	int queryCount(int uid, int clid);
	//笔记视频
	Note queryVideo(int cid);
}
