package com.diploma.master.demo.controller;

import com.diploma.master.demo.model.Announcement;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/announcement")
public class AnnouncementController {

    @PostMapping("/create")
    public void createAnnouncement(@RequestBody Announcement announcement){

    }

    @PostMapping("/edit/{announcementId}")
    public void editAnnouncement(@PathVariable Integer announcementId){

    }

    @PostMapping("/remove/{announcementId}")
    public void removeAnnouncement(@PathVariable Integer announcementId){

    }

    @GetMapping("/get/{announcementId}")
    public void getAnnouncementById(@PathVariable Integer announcementId){

    }
}
