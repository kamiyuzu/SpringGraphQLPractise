package graphql.querys;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;

import graphql.beans.Post;
import graphql.persistence.PostsRepository;

@Service
public class PostsQuerys implements GraphQLQueryResolver {

	@Autowired
	private final PostsRepository postsRepository;
	
	public PostsQuerys(PostsRepository postsRepository) {
		this.postsRepository = postsRepository;
	}
	
	public Iterable<Post> getPosts() {
		return this.postsRepository.findAll();
	}
	
	public Optional<Post> getPostsId(Integer id) {
		return this.postsRepository.findById(id);
	}
	
}
