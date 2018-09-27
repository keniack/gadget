package com.smart.blind.gadget.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.smart.blind.gadget.model.Tag;
import com.smart.blind.gadget.service.TagService;

@Controller
public class TagController {

	private final TagService tagService;

	@Autowired
	public TagController(TagService tagService) {
		this.tagService = tagService;
	}

	@GetMapping("/tags")
	@ResponseBody
	public Page<Tag> getQuestions(Pageable pageable) {
		return tagService.findAll(pageable);
	}

	@PostMapping("/tags")
	@ResponseBody
	public Tag createQuestion(@Valid @RequestBody Tag tag) {
		return tagService.save(tag);
	}

	@PutMapping("/tags/{tagsId}")
	@ResponseBody
	public Tag updateTag(@PathVariable Long tagId, @Valid @RequestBody Tag tagRequest) {
		return tagService.updateTag(tagId,tagRequest);
	}

}
