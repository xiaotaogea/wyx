package com.zjwm.wyx.course.service;

import com.zjwm.wyx.course.entity.Note;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户
 * 
 * @author Andy
 * @email andyeasons@163.com
 * @date 2017-10-23 21:23:54
 */
public interface NoteService {

	List<Note> queryNotesByUid(@Param("uid") Integer uid);
	List<Note> queryNotesByUidAndCid(@Param("uid") Integer uid, @Param("clid") Integer cid);
	int queryCount(int uid, int clid);
}
