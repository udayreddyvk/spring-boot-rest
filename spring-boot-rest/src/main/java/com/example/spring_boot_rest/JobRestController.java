package com.example.spring_boot_rest;

import com.example.spring_boot_rest.model.JobPost;
import com.example.spring_boot_rest.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import jakarta.annotation.PostConstruct;

import java.util.List;

@RestController
//@CrossOrigin(origins = "http://localhost:3000)
public class JobRestController {

    @Autowired
    private JobService service;

    @GetMapping("jobPosts")
    @ResponseBody
    public List<JobPost> getAllJobs(){
        return service.getAllJobs();
    }

    @GetMapping("jobPost/{postId}")
    public JobPost getJob(@PathVariable("postId") int postId){
        return service.getJob(postId);
    }

    @PostMapping("jobPost")
    public void addJob(@RequestBody JobPost jobPost){
        service.addJob(jobPost);
    }

//    @GetMapping("jobPosts/keyword/{keyword}")
//    public List<JobPost> searchByKeyword(@PathVariable("keyword") String keyword){
//        return service.search(keyword);
//    }

    @GetMapping("/load")
    @ResponseBody
    public String loadData(){
        System.out.println("Load endpoint hit!");
        service.load();

        return "success";
    }
}
