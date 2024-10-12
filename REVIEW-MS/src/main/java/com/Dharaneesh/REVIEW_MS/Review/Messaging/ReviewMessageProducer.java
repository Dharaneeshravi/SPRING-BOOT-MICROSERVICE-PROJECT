package com.Dharaneesh.REVIEW_MS.Review.Messaging;

import com.Dharaneesh.REVIEW_MS.Review.DTO.ReviewMessage;
import com.Dharaneesh.REVIEW_MS.Review.Review;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class ReviewMessageProducer {

    private final RabbitTemplate rabbitTemplate;

    public ReviewMessageProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(Review review)
    {
        ReviewMessage reviewMessage=new ReviewMessage();

        reviewMessage.setId(review.getId());
        reviewMessage.setTitle(review.getTitle());
        reviewMessage.setDescription(review.getDescription());
        reviewMessage.setRating(review.getRating());
        reviewMessage.setCompanyId(review.getCompanyId());
        rabbitTemplate.convertAndSend("companyRating",reviewMessage);
    }
}
