package org.xproce.portfolio.metier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.xproce.portfolio.dao.entities.Comment;
import org.xproce.portfolio.dao.repositories.CommentRepository;

@Service
public class CommentManagerImp implements CommentManager {

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public Comment addComment(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public Page<Comment> getAllComments(int page, int size) {
        return commentRepository.findAll(PageRequest.of(page, size));
    }

    @Override
    public Comment getCommentById(Long id) {
        return commentRepository.findById(id).orElse(null);
    }

    @Override
    public Comment updateComment(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public boolean deleteComment(Long id) {
        try {
            commentRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
