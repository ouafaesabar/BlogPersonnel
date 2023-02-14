package io.novelis.demo.controller;

import io.novelis.demo.service.CommentService;
import io.novelis.demo.service.DTO.ArticleDTO;
import io.novelis.demo.service.DTO.CommentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @GetMapping("/comments")
    public ResponseEntity<List<CommentDTO>> getComments (){
        List<CommentDTO> result = commentService.findAll();
        return ResponseEntity.ok(result);
    }


    @GetMapping("/comments/{id}")
    public ResponseEntity<CommentDTO> getComment (@PathVariable long id){
        CommentDTO result = commentService.findOneById(id);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/comment")
    public ResponseEntity<CommentDTO> createComment (@RequestBody CommentDTO commentDTO){
        CommentDTO result = commentService.saveComment(commentDTO);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/updateComment")
    public ResponseEntity<CommentDTO> updateComment (@RequestBody CommentDTO commentDTO){
        CommentDTO result = commentService.updateComment(commentDTO);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/deleteComment/{id}")
    public void deleteComment (@PathVariable long id){
        commentService.deleteComment(id);
    }
}
