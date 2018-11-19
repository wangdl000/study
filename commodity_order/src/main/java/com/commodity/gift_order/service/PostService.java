package com.commodity.gift_order.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.commodity.entity.custom.dto.Post;


@Service
public class PostService {

	public List<Post> findAll(){

		List<Post> aa = new ArrayList<Post>();
		Post post = new Post();
		post.setId(123);
		post.setTitle("title 123");
		post.setContent("content 123");
		post.setDeleted(false);
		post.setCreationDatetime(new Date());
		post.setModificationDatetime(new Date());

		return aa;
	}
}
