package spring.spring_web_service.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.spring_web_service.service.posts.PostsService;
import spring.spring_web_service.web.dto.PostsResponseDto;
import spring.spring_web_service.web.dto.PostsSaveRequestDto;
import spring.spring_web_service.web.dto.PostsUpdateRequestDto;

@RequiredArgsConstructor
@RestController
public class PostsApiController {

    private final PostsService postsService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto){
        return postsService.save(requestDto);
    }
}
