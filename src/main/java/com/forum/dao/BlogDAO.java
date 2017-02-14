package com.forum.dao;
import java.util.List;
import com.forum.model.Blog;

public interface BlogDAO 
{
	
	public void addBlog(Blog blog);
	public void updateBlog(Blog blog);
	public void deleteBlog(Blog blog);
	public Blog getBlogByBlogId(long blogId);
	public List<Blog> listBlogs();
	public List<Blog> listNewBlogs();
	public List<Blog> listApprovedBlogs();

}
