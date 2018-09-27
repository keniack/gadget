package com.smart.blind.gadget.service.impl;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.smart.blind.gadget.dao.TagDao;
import com.smart.blind.gadget.exception.ResourceNotFoundException;
import com.smart.blind.gadget.model.Tag;
import com.smart.blind.gadget.service.TagService;

@Service(value = "tagService")
public class TagServiceImpl implements TagService {

	private final TagDao tagDao;

	@Autowired
	public TagServiceImpl(TagDao tagDao) {
		this.tagDao = tagDao;
	}

	@Override
	public Page<Tag> findAll(Pageable pageable) {
		return tagDao.findAll(pageable);
	}

	@Override
	public Tag save(@Valid Tag tag) {
		return tagDao.save(tag);
	}

	@Override
	public Tag findById(Long tagId) {
		return tagDao.findById(tagId).get();
	}

	@Override
	public Tag updateTag(Long tagId, Tag tagRequest) {
		return tagDao.findById(tagId).map(tag -> {
			tag.setName(tagRequest.getName());
			return tagDao.save(tag);
		}).orElseThrow(() -> new ResourceNotFoundException("Tag not found with id " + tagId));
	}

}
