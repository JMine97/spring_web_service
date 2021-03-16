package spring.spring_web_service.service.posts;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.spring_web_service.domain.posts.Posts;
import spring.spring_web_service.domain.posts.PostsRepository;
import spring.spring_web_service.web.dto.PostsResponseDto;
import spring.spring_web_service.web.dto.PostsSaveRequestDto;
import spring.spring_web_service.web.dto.PostsUpdateRequestDto;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto){
        return postsRepository.save(requestDto.toEntity()).
                getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException("There is no such post. id=" + id));
        posts.update(requestDto.getTitle(), requestDto.getContent());
        return id;
    }

    public PostsResponseDto findById(Long id) {
        Posts entity = postsRepository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException("There is no such post. id=" + id));
        return new PostsResponseDto(entity);
    }

//    @Transactional
//    public List<PostsListResponseDto> findAllDesc(){
//        return postsRepository.findAllDesc().stream()
//                .map(PostsSaveRequestDto::new)
//                .collect(Collectors.toList());
//    }
}
