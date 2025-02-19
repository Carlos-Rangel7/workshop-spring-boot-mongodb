package com.carlosrangel.workshopmongo.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carlosrangel.workshopmongo.domain.Post;
import com.carlosrangel.workshopmongo.repository.PostRepository;
import com.carlosrangel.workshopmongo.service.exception.ObjectNotFoundException;

@Service
public class PostService {
	
	@Autowired
	private PostRepository postRepository;

	
	public Post findById(String id) {
		Optional<Post> post = postRepository.findById(id);
		return post.orElseThrow(() -> new ObjectNotFoundException("Id não enconrtado"));
	}
	
	
	public List<Post> findByTitle(String text) {
		return postRepository.searchTitle(text);
	}
	public List<Post> fullsearch(String text, Date minDate, Date maxDate) {
		maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
		return postRepository.fullSearch(text, minDate, maxDate);
	}
	
}
