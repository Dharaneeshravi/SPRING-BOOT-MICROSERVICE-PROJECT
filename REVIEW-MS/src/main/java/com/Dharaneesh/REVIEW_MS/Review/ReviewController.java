package com.Dharaneesh.REVIEW_MS.Review;

import com.Dharaneesh.REVIEW_MS.Review.Messaging.ReviewMessageProducer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/review")
public class ReviewController {

    private final ReviewService reviewService;
    private final ReviewMessageProducer reviewMessageProducer;

    public ReviewController(ReviewService reviewService,ReviewMessageProducer reviewMessageProducer) {
        this.reviewService = reviewService;
        this.reviewMessageProducer=reviewMessageProducer;
    }

    @GetMapping
    public ResponseEntity<List<Review>> getReview(@RequestParam Long companyId)
    {
        return new ResponseEntity<>(reviewService.getReview(companyId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> createReview(@RequestBody Review review, @RequestParam Long companyId)
    {

        boolean res=reviewService.createReview(review,companyId);

        if(res)
        {
            reviewMessageProducer.sendMessage(review);
            return new ResponseEntity<>("CREATED SUCCESS",HttpStatus.CREATED);
        }
        else
        {
            return new ResponseEntity<>("NOT_FOUND",HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{reviewId}")
    public ResponseEntity<Review> getReviewById(@PathVariable Long reviewId)
    {
        Review review=reviewService.getReviewById(reviewId);

        if(review!=null)
        {
            return new ResponseEntity<>(review,HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{reviewId}")
    public ResponseEntity<String> updateReviewById(@PathVariable Long reviewId,@RequestBody Review review)
    {
        boolean res=reviewService.updateReviewById(reviewId,review);

        if(res)
        {
            return new ResponseEntity<>("UPDATE SUCCESS",HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>("NOT_FOUND",HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{reviewId}")
    public ResponseEntity<String> deleteReviewById(@PathVariable Long reviewId)
    {
        boolean res=reviewService.deleteReviewById(reviewId);

        if(res)
        {
            return new ResponseEntity<>("DELETED SUCCESS",HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>("NOT_FOUND",HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/averageRating")
    public Double getAverageRating(@RequestParam Long companyId)
    {
       List<Review> reviews=reviewService.getReview(companyId);

       return reviews.stream().mapToDouble(Review::getRating).average().orElse(0.0);
    }
}
