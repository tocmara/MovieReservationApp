package com.example.project.service;


import com.example.project.dto.Room;
import com.example.project.model.RoomModel;
import com.example.project.repository.RoomRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {

    private final RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public Room createRoom(Room room)
    {
        RoomModel roomModel = convertToRoomModel(room); // convertim dto in model
        RoomModel savedRoomModel = roomRepository.save(roomModel);//salvam modelul in DB
        Room createdRoom = convertToRoom(savedRoomModel);// convertim modelul in dto

        return createdRoom;

    }
    public List<Room> findAll()
    {
        return roomRepository.findAll()
                .stream()
                .map(this::convertToRoom)
                .toList();
    }
    public void delete(int roomId)
    {
        roomRepository.deleteById(roomId);
    }



    private RoomModel convertToRoomModel(Room room)
    {
        RoomModel roomModel = new RoomModel();

        roomModel.setName(room.getName());
        roomModel.setCapacity(room.getCapacity());

        return roomModel;

    }

    private Room convertToRoom(RoomModel roomModel)
    {
        Room room = new Room();
        room.setName(roomModel.getName());
        room.setCapacity(roomModel.getCapacity());

        return room;
    }
}
