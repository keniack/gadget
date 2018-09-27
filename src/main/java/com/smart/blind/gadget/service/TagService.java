package com.smart.blind.gadget.service;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.smart.blind.gadget.model.Tag;

public interface TagService {

	Page<Tag> findAll(Pageable pageable);

	Tag save(@Valid Tag tag);

	Tag findById(Long tagId);

	Tag updateTag(Long tagId, @Valid Tag tagRequest);

}
