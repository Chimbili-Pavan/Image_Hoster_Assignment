package ImageHoster.service;


import ImageHoster.model.Comment;
import ImageHoster.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

    // This method calls the repository method for uploading comments of the particular image
    public void uploadComments(Comment newcomment){
        commentRepository.uploadComments(newcomment);
    }

    // This method calls the respective repository method for getting the comments of the particular image
    public Comment getComments(Integer imageId){
      return commentRepository.getComments(imageId);
    }
}
