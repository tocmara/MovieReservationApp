package com.example.project.controller;

import com.example.project.dto.Room;
import com.example.project.service.RoomService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class RoomController {

    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @PostMapping("/room")
    public Room create(@RequestBody Room room){
        return roomService.createRoom(room);
    }

    @GetMapping("/room")
    public List<Room> findAll(){
        return roomService.findAll();
    }

    @DeleteMapping("/room/{roomId}")
    public void delete(@PathVariable int roomId){
        roomService.delete(roomId);
    }
}
