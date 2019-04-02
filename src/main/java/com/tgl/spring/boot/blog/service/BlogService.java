package com.tgl.spring.boot.blog.service;

import com.tgl.spring.boot.blog.entity.Blog;
import com.tgl.spring.boot.blog.entity.Catalog;
import com.tgl.spring.boot.blog.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Blog 服务接口.
 */
public interface BlogService {
	/**
	 * 保存Blog
	 * @param blog
	 * @return
	 */
	Blog saveBlog(Blog blog);

	/**
	 * 删除Blog
	 * @param id
	 * @return
	 */
	void removeBlog(Long id);
	
	/**
	 * 根据id获取Blog
	 * @param id
	 * @return
	 */
	Blog getBlogById(Long id);
	
	/**
	 * 根据用户名进行分页模糊查询（最新）
	 * @param user
	 * @return
	 */
	Page<Blog> listBlogsByTitleLike(User user, String title, Pageable pageable);
 
	/**
	 * 根据用户名进行分页模糊查询（最热）
	 * @param user
	 * @return
	 */
	Page<Blog> listBlogsByTitleLikeAndSort(User user, String title, Pageable pageable);

	/**
	 * 阅读量递增
	 * @param id
	 */
	void readingIncrease(Long id);

	/**
	 * 发表评论
	 * @param blogId
	 * @param commentContent
	 * @return
	 */
	Blog createComment(Long blogId, String commentContent);

	/**
	 * 删除评论
	 * @param blogId
	 * @param commentId
	 * @return
	 */
	void removeComment(Long blogId, Long commentId);

	/**
	 * 点赞
	 * @param blogId
	 * @return
	 */
	Blog createVote(Long blogId);

	/**
	 * 取消点赞
	 * @param blogId
	 * @param voteId
	 * @return
	 */
	void removeVote(Long blogId, Long voteId);

	/**
	 * 根据分类查询
	 * @param catalog
	 * @param pageable
	 * @return
	 */
	Page<Blog> listBlogsByCatalog(Catalog catalog, Pageable pageable);
}
