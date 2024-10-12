package com.Dharaneesh.COMPANY_MS.Company.Message;

import com.Dharaneesh.COMPANY_MS.Company.CompanyService;
import com.Dharaneesh.COMPANY_MS.Company.DTO.ReviewMessage;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class ReviewMessageConcumer {

    private final CompanyService companyService;

    public ReviewMessageConcumer(CompanyService companyService) {
        this.companyService = companyService;
    }

    @RabbitListener(queues = "companyRating")
    public void consumeMessage(ReviewMessage reviewMessage)
    {
         companyService.updateCompanyRating(reviewMessage);
    }
}
