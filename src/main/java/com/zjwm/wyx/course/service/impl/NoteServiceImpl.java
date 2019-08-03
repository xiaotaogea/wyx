package com.zjwm.wyx.course.service.impl;

import com.zjwm.wyx.course.dao.NoteMapper;
import com.zjwm.wyx.course.entity.Note;
import com.zjwm.wyx.course.service.NoteService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;



@Service("noteService")
public class NoteServiceImpl implements NoteService {
	@Resource
	private NoteMapper noteMapper;

	@Override
	public List<Note> queryNotesByUid(Integer uid) {
		// TODO Auto-generated method stub
		return noteMapper.queryNotesByUid(uid);
	}

	@Override
	public int queryCount(int uid, int clid) {
		// TODO Auto-generated method stub
		return noteMapper.queryCount(uid, clid);
	}

	@Override
	public List<Note> queryNotesByUidAndCid(Integer uid, Integer cid) {
		// TODO Auto-generated method stub
		return noteMapper.queryNotesByUidAndCid(uid, cid);
	}


}
